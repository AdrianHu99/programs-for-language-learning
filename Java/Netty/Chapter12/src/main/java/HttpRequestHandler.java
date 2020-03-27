import io.netty.channel.*;
import io.netty.handler.codec.http.*;
import io.netty.handler.ssl.SslHandler;
import io.netty.handler.stream.ChunkedNioFile;

import java.io.File;
import java.io.RandomAccessFile;
import java.net.URISyntaxException;
import java.net.URL;

public class HttpRequestHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
    private final String wsUri;
    private static final File INDEX;

    public HttpRequestHandler(String wsUri) {
        this.wsUri = wsUri;
    }

    static {
        URL location = HttpRequestHandler.class
                .getProtectionDomain()
                .getCodeSource()
                .getLocation();

        try {
            String path = location.toURI() + "index.html";
            path = !path.contains("file:") ? path : path.substring(5);
            INDEX = new File(path);
        } catch (URISyntaxException e) {
            throw new IllegalStateException("Unable to locate index.html", e);
        }
    }



    @Override
    protected void channelRead0(ChannelHandlerContext context, FullHttpRequest request) throws Exception {
        if (wsUri.equalsIgnoreCase(request.getUri())) {
            // If websocket upgrade is requested, increments the reference count by retain()
            // and passes it to the next ChannelInboundHandler
            context.fireChannelRead(request.retain());
        } else {
            if (HttpHeaders.is100ContinueExpected(request)) {
                send100Continue(context);
            }
            // Read index.html
            RandomAccessFile file = new RandomAccessFile(INDEX, "r");
            HttpResponse response = new DefaultHttpResponse(
                    request.getProtocolVersion(), HttpResponseStatus.OK);
            response.headers().set(HttpHeaders.Names.CONTENT_TYPE,
                    "text/html; charset=UTF-8");
            boolean keepAlive = HttpHeaders.isKeepAlive(request);
            if (keepAlive) {
                response.headers().set(HttpHeaders.Names.CONTENT_LENGTH, file.length());
                response.headers().set(HttpHeaders.Names.CONNECTION, HttpHeaders.Values.KEEP_ALIVE);
            }
            context.write(response);
            if (context.pipeline().get(SslHandler.class) == null) {
                // Store contents in index.html
                // Utilize zero-copy to perform transmission
                context.write(new DefaultFileRegion(file.getChannel(), 0, file.length()));
            } else {
                context.write(new ChunkedNioFile(file.getChannel()));
            }
            // Write and flush the lastHttpContent to the client
            ChannelFuture future = context.writeAndFlush(LastHttpContent.EMPTY_LAST_CONTENT);
            if (!keepAlive) {
                future.addListener(ChannelFutureListener.CLOSE);
            }
        }
    }

    private static void send100Continue(ChannelHandlerContext context) {
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.CONTINUE);
        context.writeAndFlush(response);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext context, Throwable cause) throws Exception {
        cause.printStackTrace();
        context.close();
    }
}
