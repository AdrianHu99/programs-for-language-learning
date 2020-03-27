import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.group.ChannelGroup;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

public class ChatServerInitializer extends ChannelInitializer<Channel> {
    private final ChannelGroup group;

    public ChatServerInitializer(ChannelGroup group) {
        this.group = group;
    }

    @Override
    protected void initChannel(Channel channel) throws Exception {
        ChannelPipeline pipeline = channel.pipeline();
        // Decodes bytes to HttpRequest, HttpContent, and lastHttpContent
        // Encodes HttpRequest, HttpContent, and lastHttpContent to bytes
        // Note: when this upgrades to webSocket, encoder and decoder will be replaced
        // by WebSocketFrameDecoder and WebSocketFrameEncoder
        pipeline.addLast(new HttpServerCodec());
        // Write the contents of a file
        pipeline.addLast(new ChunkedWriteHandler());
        // Aggregates an HttpMessage and its following HttpContents
        // into a single FullHttpRequest or FullHttpResponse
        // With this installed, the next handler will receive only full Http requests
        pipeline.addLast(new HttpObjectAggregator(64 * 1024));
        // Handles FullHttpRequests (those not sent to a /ws URI)
        pipeline.addLast(new HttpRequestHandler("/ws"));
        // Handle the webSocket upgrade handshake, PingWebSocketFrames,
        // PongWebSocketFrames and CloseWebSocketFrames
        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
        // Handles textWebSocketFrames and handshakecompletion events
        pipeline.addLast(new TextWebSocketFrameHandler(group));
    }
}
