package mashibing;

import java.util.concurrent.*;

public class CallableLearn {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> c = new Callable() {
            @Override
            public Object call() throws Exception {
                return "Hello world";
            }
        };

        ExecutorService service = Executors.newCachedThreadPool();
        Future<String> future = service.submit(c);

        // get() is still blocking
        System.out.println(future.get());
        service.shutdown();

    }
}
