package nio.groupChat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Scanner;

public class GroupChatClient {
    // define the attributes
    private final String HOST = "127.0.0.1"; // server address
    private final int PORT = 6667; // server port
    private Selector selector;
    private SocketChannel socketChannel;
    private String username;

    // constructor and initialization
    public GroupChatClient() {
        try {
            selector = Selector.open();
            // connect
            socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", PORT));
            // set up non blocking
            socketChannel.configureBlocking(false);
            // register channel to the selector
            socketChannel.register(selector, SelectionKey.OP_READ);
            // get user name
            username = socketChannel.getLocalAddress().toString().substring(1);
            System.out.println(username + " is ok...");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // send info to server
    public void sendInfo(String info) {
        info = username + " says: " + info;

        try {
            socketChannel.write(ByteBuffer.wrap(info.getBytes(StandardCharsets.UTF_8)));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // read info from server
    public void readInfo() {
        try {
            // no timeout
            int count = selector.select();
            if (count > 0) {
                Iterator<SelectionKey> iterator = selector.keys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    if (key.isReadable()) {
                        SocketChannel channel = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        channel.read(buffer);
                        String message = new String(buffer.array());
                        System.out.println(username + " received: " + message);
                    }
                    // TODO why it's not needed?
                    //iterator.remove();
                }
                // prevent duplicating event processing
                // TODO why outside the while?
                //iterator.remove();
            } else {
                System.out.println("no available channels");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // start client
        GroupChatClient chatClient = new GroupChatClient();
        // start a thread
        new Thread() {
            public void run() {
                while (true) {
                    chatClient.readInfo();
                    try {
                        Thread.currentThread().sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            chatClient.sendInfo(s);
        }
    }
}
