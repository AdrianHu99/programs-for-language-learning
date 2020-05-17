package mashibing.dayOne;

import java.util.concurrent.TimeUnit;

public class Synchronized7ReentrantLock {
    synchronized void m1() {
        System.out.println("m1 starts");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m2();
        System.out.println("m1 ends");
    }

    synchronized void m2() {
        System.out.println("m2 starts");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2 ends");
    }

    public static void main(String[] args) {
        new Synchronized7ReentrantLock().m1();
    }
}
