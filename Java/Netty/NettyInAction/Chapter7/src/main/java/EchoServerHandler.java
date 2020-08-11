import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

@ChannelHandler.Sharable
public class EchoServerHandler extends ChannelInboundHandlerAdapter { // Indicates that a channelHandler can be safely shared by multiple channels

    @Override
    public void channelRead(ChannelHandlerContext context, Object message) {
        ByteBuf in = (ByteBuf)message;
        System.out.println("Server received: " + in.toString(CharsetUtil.UTF_8));
        // Writes the received message to the sender without flushing the outbound messages
        context.write(in);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext context) throws Exception {
        // Flush the pending messages to the remote peer and close the channel
        context.writeAndFlush(Unpooled.EMPTY_BUFFER)
            .addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext context, Throwable cause) throws Exception {
        // Log the stack trace of the error and close the context
        cause.printStackTrace();
        context.close();
    }
    
}
