import com.sun.security.ntlm.Server;
import io.netty.channel.ServerChannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class PlainNioServer {
    public void server(int port) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        ServerSocket serverSocket = serverSocketChannel.socket();
        InetSocketAddress address = new InetSocketAddress(port);
        // Binds the server to the selected port
        serverSocket.bind(address);
        // Opens the selector for handling channels
        Selector selector = Selector.open();
        // Register the serverSocket with the selector to accept connections
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        final ByteBuffer message = ByteBuffer.wrap("Hi!\r\n".getBytes());
        for (; ; ) {
            try {
                // Wait for new events to process; blocks until the next incoming event
                selector.select();
            } catch (IOException ex) {
                ex.printStackTrace();
                // Handle exception
                break;
            }
            // Obtain all selectionKey instances that received events
            Set<SelectionKey> readyKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = readyKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();
                try {
                    // Check if the event is a new connection ready to be accepted
                    if (key.isAcceptable()) {
                        ServerSocketChannel server = (ServerSocketChannel) key.channel();
                        SocketChannel client = server.accept();
                        client.configureBlocking(false);
                        client.register(selector, SelectionKey.OP_WRITE | SelectionKey.OP_READ, message.duplicate());
                        System.out.println("Accepted connection from: " + client);
                    }
                    // Check if the socket is ready to write data
                    if (key.isWritable()) {
                        SocketChannel client = (SocketChannel) key.channel();
                        ByteBuffer buffer = (ByteBuffer) key.attachment();
                        while (buffer.hasRemaining()) {
                            // Write data to the connected client
                            if (client.write(buffer) == 0) {
                                break;
                            }
                        }
                        client.close();
                    }
                } catch (IOException ex) {
                    key.cancel();
                    try {
                        key.channel().close();
                    } catch (IOException e) {
                        // ignore on close
                    }
                }
            }
        }

    }
}
