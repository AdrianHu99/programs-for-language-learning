import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class OldMultiThread {

    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);

        ScheduledFuture<?> future = executor.schedule(
                new Runnable() {
                    public void run() {
                        System.out.println("3 seconds later");
                    }
                }, 3, TimeUnit.SECONDS);

        executor.shutdown();
    }
}
