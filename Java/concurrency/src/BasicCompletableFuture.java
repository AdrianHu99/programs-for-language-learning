import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public class BasicCompletableFuture {
    public static CompletableFuture<Integer> compute() {
        final CompletableFuture<Integer> future = new CompletableFuture<>();
        return future;
    }

    public static void main(String[] args) throws IOException {
        final CompletableFuture<Integer> future = compute();
        class Client extends Thread {
            CompletableFuture<Integer> future;

            Client(String threadName, CompletableFuture<Integer> future) {
                super(threadName);
                this.future = future;
            }

            @Override
            public void run() {
                try {
                    System.out.println(this.getName() + ": " + future.get());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }

        new Client("Client1", future).start();
        new Client("Client2", future).start();
        System.out.println("waiting");
        // Use 100 as the result of get()
        future.complete(100);
        // Throw exception if the future is not completed
        future.completeExceptionally(new Exception());
        System.in.read();
    }
}
