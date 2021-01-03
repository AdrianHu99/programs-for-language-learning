package nio.groupChat;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

public class GroupChatServer {
    // define attributes
    private Selector selector;
    private ServerSocketChannel listenChannel;
    private static final int PORT = 6667;

    // constructor
    // initialization
    public GroupChatServer() {
        try {
            // get the selector
            selector = Selector.open();
            // open the channel
            listenChannel = ServerSocketChannel.open();
            // bind the port
            listenChannel.socket().bind(new InetSocketAddress(PORT));
            // set up non blocking mode
            listenChannel.configureBlocking(false);
            // register the listener to the selector
            listenChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    // monitor
    public void listen() {
        try {
            while (true) {
                // no timeout
                int count = selector.select();
                if (count > 0) { // there is an event to process
                    // traverse to get selectionKey collection
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        // get the key
                        SelectionKey key = iterator.next();

                        // ACCEPT event
                        if (key.isAcceptable()) {
                            SocketChannel socketChannel = listenChannel.accept();

                            socketChannel.configureBlocking(false);
                            // register the sc to the selector
                            socketChannel.register(selector, SelectionKey.OP_READ);
                            // notify
                            System.out.println(socketChannel.getRemoteAddress() + " is online");
                        }
                        if (key.isReadable()) { // the channel is readable now
                            // process read
                            readData(key);
                        }

                        // remove current key, in case the same event gets reprocessed
                        iterator.remove();
                    }
                } else {
                    System.out.println("Waiting for connection...");
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {

        }
    }

    // read message from the client
    private void readData(SelectionKey key) {
        // define a socketChannel
        SocketChannel channel = null;
        try {
            // get the channel
            channel = (SocketChannel) key.channel();
            // create the buffer
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            int count = channel.read(buffer);
            // react based on count
            if (count > 0) {
                // convert data to string and print it out
                String msg = new String(buffer.array());
                // output the msg
                System.out.println("From client: " + msg);

                // forward the msg to other clients
                forwardMessage(msg, channel);
            }
        } catch (IOException e) {
            try {
                System.out.println(channel.getRemoteAddress() + "is offline now...");
                // cancel the registration
                key.cancel();
                // close the channel
                channel.close();
            } catch (IOException ex) {
                ex.printStackTrace();

            }

        }
    }

    // forward msg to other clients
    // Note: self excluded
    private void forwardMessage(String message, SocketChannel selfChannel) throws IOException {
        System.out.println("Server is forwarding msg...");
        // traverse all registered keys on selector, self excluded
        for (SelectionKey key : selector.keys()) {
            // get the channel by the key
            Channel channel = key.channel();
            // TODO is channel socketChannel for sure?
            if (channel instanceof SocketChannel && channel != selfChannel) {
                // convert msg to buffer
                ByteBuffer buffer = ByteBuffer.wrap(message.getBytes(StandardCharsets.UTF_8));
                // write to the other clients' channel
                ((SocketChannel) channel).write(buffer);
            }
        }
    }

    public static void main(String[] args) {
        GroupChatServer server = new GroupChatServer();
        server.listen();
    }
}
