package biliwwj.ch4_join;

import java.util.stream.IntStream;

public class ThreadJoin3 {
    public static void main(String[] args) throws InterruptedException {
        long l1 = System.currentTimeMillis();
        Thread t1 = new Thread(new Sleeper("M1", 1_000L));
        Thread t2 = new Thread(new Sleeper("M2", 5_000L));
        Thread t3 = new Thread(new Sleeper("M3", 3_000L));
        t1.start();
        t2.start();
        t3.start();

        // Without join(), main will always finish first
        t1.join();
        t2.join();
        t3.join();

        long l2 = System.currentTimeMillis();
        System.out.printf("Start time is [%s], and finish time is [%s] %n", l1, l2);

    }

    static class Sleeper implements Runnable{
        private String name;
        private long sleepTime;

        public Sleeper(String name, long sleepTime) {
            this.name = name;
            this.sleepTime = sleepTime;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(sleepTime);
                System.out.printf("%s just finishes and timestamp is [%s] %n", name, System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
