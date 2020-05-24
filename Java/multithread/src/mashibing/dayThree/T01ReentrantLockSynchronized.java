package mashibing.dayThree;

import java.util.concurrent.TimeUnit;

/*
if m1 get the lock of the class, we should also be able to run m2 while m1 is holding the lock
 */
public class T01ReentrantLockSynchronized {
    synchronized void m1() {
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
            if (i == 2) {
                m2();
            }
        }
    }

    synchronized void m2() {
        System.out.println("m2...");
    }

    public static void main(String[] args) {
        T01ReentrantLockSynchronized rl = new T01ReentrantLockSynchronized();
        new Thread(rl::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(rl::m2).start();
    }
}
