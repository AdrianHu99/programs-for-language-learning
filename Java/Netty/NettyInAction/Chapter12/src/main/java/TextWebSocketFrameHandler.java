import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;

/**
 * TextWebSocketFrameHandler has a small set of responsibilities
 * When handshake with new client has completed successfully, it notifies all clients
 * then add the new channel to the channelGroup
 * If a frame is received, it calls retain() on it to increase the reference count and transmit it to the channelGroup so that all connected webSocketChannels
 * will receive it
 */
public class TextWebSocketFrameHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private final ChannelGroup group;

    public TextWebSocketFrameHandler(ChannelGroup group) {
        this.group = group;
    }

    @Override
    // Handle custom events
    public void userEventTriggered(ChannelHandlerContext context, Object event) throws Exception {
        if (event == WebSocketServerProtocolHandler.ServerHandshakeStateEvent.HANDSHAKE_COMPLETE) {
            // If handshake is successful, remove the request Handler because there is no
            // further HTTP messages will be received
            context.pipeline().remove(HttpRequestHandler.class);
            // Notify all webSocket clients that new client has connected
            group.writeAndFlush(new TextWebSocketFrame("Client " + context.channel() + " joined"));
            // Add the new channel to the group so it will receive all messages
            group.add(context.channel());
        } else {
            super.userEventTriggered(context, event);
        }
    }

    @Override
    protected void channelRead0(ChannelHandlerContext context, TextWebSocketFrame message) throws Exception {
        // Increase the reference count of the message and writes it to
        // all connected clients in the ChannelGroup
        group.writeAndFlush(message.retain());
    }
}
