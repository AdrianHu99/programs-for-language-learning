package mashibing.dayTwo;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class T10AtomicVsSyncVsLongAdder {
    static AtomicLong count1 = new AtomicLong(0L);
    static long count2 = 0L;
    static LongAdder count3 = new LongAdder();

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10000];

        for (int i = 0; i < threads.length; i++) {
            threads[i] =
                    new Thread(() -> {
                        for (int k = 0; k < 1000000; k++) {
                            count1.incrementAndGet();
                        }
                    });
        }

        long start = System.currentTimeMillis();

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }

        long end = System.currentTimeMillis();

        System.out.println("Atomic: " + count1.get() + " time " + (end-start));

        //---------------------------------
        Object lock = new Object();

        for (int i = 0; i < threads.length; i++) {
            threads[i] =
                    new Thread(() -> {
                        for (int k = 0; k < 1000000; k++) {
                            synchronized (lock) {
                                count2++;
                            }
                        }
                    });
        }

        start = System.currentTimeMillis();

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }

        end = System.currentTimeMillis();

        System.out.println("Sync: " + count1.get() + " time " + (end-start));

        //--------------------------------\
        for (int i = 0; i < threads.length; i++) {
            threads[i] =
                    new Thread(() -> {
                        for (int k = 0; k < 1000000; k++) {
                            count3.increment();
                        }
                    });
        }

        start = System.currentTimeMillis();

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }

        end = System.currentTimeMillis();

        System.out.println("LongAdder: " + count1.get() + " time " + (end-start));
    }
}
