package mashibing;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureLearn {
    public static void main(String[] args) throws Exception {
        MyTask task1 = new MyTask("task1", 3, true);
        MyTask task2 = new MyTask("task2", 4, true);
        MyTask task3 = new MyTask("task3", 1, false);

        CompletableFuture f1 = CompletableFuture.supplyAsync(() -> task1.call())
                .thenAccept((result) -> callback(result));
        CompletableFuture f2 = CompletableFuture.supplyAsync(() -> task2.call())
                .thenAccept((result) -> callback(result));
        CompletableFuture f3 = CompletableFuture.supplyAsync(() -> task3.call())
                .thenAccept((result) -> callback(result));

        System.in.read();
    }

    private static void callback(Boolean result) {
        if (false == result) {
            System.exit(0);
        }
    }

    private static class MyTask {
        private String name;
        private int timeSecond;
        private boolean ret;

        public MyTask(String name, int timeSecond, boolean ret) {
            this.name = name;
            this.timeSecond = timeSecond;
            this.ret = ret;
        }

        private boolean call() {
            try {
                Thread.sleep(timeSecond);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println(name + " task callback");
            return ret;
        }
    }
}
