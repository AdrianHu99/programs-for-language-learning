import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BasicFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Future
        ExecutorService service = Executors.newFixedThreadPool(10);
        Future<Integer> future = service.submit(() -> {
            // long time async calculation
            // ...
            // return the result
            return 100;
        });
        while(!future.isDone()) {
            System.out.println("I am waiting");
        }
        System.out.println(future.get());
    }
}
