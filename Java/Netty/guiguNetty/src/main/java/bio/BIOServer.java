package bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BIOServer {

    public static void main(String[] args) throws IOException {
        /**
         * 1. create a thread pool
         * 2. if there is a client connecting, create a thread and serve it
         */

        ExecutorService threadPool = Executors.newCachedThreadPool();

        // connect to it via telnet (telnet 127.0.0.1 6666)
        ServerSocket serverSocket = new ServerSocket(6666);

        System.out.println("server is running");

        while (true) {

            // monitor, listen and wait for client to connect
            // TODO it's blocking if there is no client connect
            System.out.println("Thread info, id=" + Thread.currentThread().getId() + " name=" + Thread.currentThread().getName());
            System.out.println("waiting for a client...");
            final Socket socket = serverSocket.accept();
            System.out.println("connecting to a client");

            // create a thread and do communication
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    handler(socket);
                }
            });
        }
    }


    public static void handler(Socket socket) {
        try {
            System.out.println("Thread info, id=" + Thread.currentThread().getId() + " name=" + Thread.currentThread().getName());
            byte[] bytes = new byte[1024];

            InputStream inputStream = socket.getInputStream();
            while (true) {
                System.out.println("Thread info, id=" + Thread.currentThread().getId() + " name=" + Thread.currentThread().getName());
                // TODO it's blocking if there is nothing new as input
                System.out.println("read....");
                int read = inputStream.read(bytes);
                if (read != -1) {
                    System.out.println(new String(bytes, 0, read));
                } else {
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}
