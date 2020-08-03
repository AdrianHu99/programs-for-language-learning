package mashibing;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureJoinVsGet {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            int i = 1 / 0;
            return 100;
        });

        /*
        Exception in thread "main" java.util.concurrent.CompletionException: java.lang.ArithmeticException: / by zero
        at java.base/java.util.concurrent.CompletableFuture.encodeThrowable(CompletableFuture.java:314)
        at java.base/java.util.concurrent.CompletableFuture.completeThrowable(CompletableFuture.java:319)
        at java.base/java.util.concurrent.CompletableFuture$AsyncSupply.run(CompletableFuture.java:1702)
        at java.base/java.util.concurrent.CompletableFuture$AsyncSupply.exec(CompletableFuture.java:1692)
        at java.base/java.util.concurrent.ForkJoinTask.doExec(ForkJoinTask.java:290)
        at java.base/java.util.concurrent.ForkJoinPool$WorkQueue.topLevelExec(ForkJoinPool.java:1020)
        at java.base/java.util.concurrent.ForkJoinPool.scan(ForkJoinPool.java:1656)
        at java.base/java.util.concurrent.ForkJoinPool.runWorker(ForkJoinPool.java:1594)
        at java.base/java.util.concurrent.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:177)
        Caused by: java.lang.ArithmeticException: / by zero
        at CompletableFutureJoinVsGet.lambda$main$0(CompletableFutureJoinVsGet.java:7)
        at java.base/java.util.concurrent.CompletableFuture$AsyncSupply.run(CompletableFuture.java:1700)
        ... 6 more
         */
        //future.join();

        /*
        Exception in thread "main" java.util.concurrent.ExecutionException: java.lang.ArithmeticException: / by zero
            at java.base/java.util.concurrent.CompletableFuture.reportGet(CompletableFuture.java:395)
            at java.base/java.util.concurrent.CompletableFuture.get(CompletableFuture.java:1999)
            at CompletableFutureJoinVsGet.main(CompletableFutureJoinVsGet.java:32)
        Caused by: java.lang.ArithmeticException: / by zero
            at CompletableFutureJoinVsGet.lambda$main$0(CompletableFutureJoinVsGet.java:7)
            at java.base/java.util.concurrent.CompletableFuture$AsyncSupply.run(CompletableFuture.java:1700)
            at java.base/java.util.concurrent.CompletableFuture$AsyncSupply.exec(CompletableFuture.java:1692)
            at java.base/java.util.concurrent.ForkJoinTask.doExec(ForkJoinTask.java:290)
            at java.base/java.util.concurrent.ForkJoinPool$WorkQueue.topLevelExec(ForkJoinPool.java:1020)
            at java.base/java.util.concurrent.ForkJoinPool.scan(ForkJoinPool.java:1656)
            at java.base/java.util.concurrent.ForkJoinPool.runWorker(ForkJoinPool.java:1594)
            at java.base/java.util.concurrent.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:177)
         */
        future.get();
    }
}
