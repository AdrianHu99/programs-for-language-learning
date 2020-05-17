package mashibing.dayOne;

import java.util.concurrent.TimeUnit;

public class Synchronized8Exception {
    int count = 0;
    public synchronized void m() {
        System.out.println(Thread.currentThread().getName() + " starts...");
        while (true) {
            count++;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (count == 5) {
                int i = 1 / 0;
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Synchronized8Exception t = new Synchronized8Exception();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                t.m();
            }
        };
        new Thread(r, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // if there is an exception thrown from t1 and not properly handled, t2 will get a chance to run
        new Thread(r, "t2").start();
    }
}
