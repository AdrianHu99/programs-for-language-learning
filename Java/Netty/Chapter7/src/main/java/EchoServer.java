import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

public class EchoServer {
    // Bootstrap the server
    private static int port = 9999;

    public EchoServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws InterruptedException {
        // Set the port value
        new EchoServer(port).start();
    }

    private void start() throws InterruptedException {
        final EchoServerHandler echoServerHandler = new EchoServerHandler();
        EventLoopGroup parentGroup = new NioEventLoopGroup(1);
        EventLoopGroup childGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(parentGroup, childGroup)
                    .channel(NioServerSocketChannel.class) // Specify the use of NIO transport channel
                    .localAddress(new InetSocketAddress(port)) // point to specific port
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel socketChannel) {
                            // Add an echoServerHandler to the channel's ChannelPipeline
                            // server handler is @Shareable so we can always use the same one
                            socketChannel.pipeline().addLast(echoServerHandler);
                        }
                    });
            // Binds the server asynchronously, sync() waits for the bind to complete
            ChannelFuture channelFuture = serverBootstrap.bind().sync();
            // Get the CloseFuture of the channel and blocks the current thread until it's complete
            channelFuture.channel().closeFuture().sync();
        } finally {
            // Shuts down the eventLoopGroup, release all resources
            childGroup.shutdownGracefully().sync();
        }
    }
}
