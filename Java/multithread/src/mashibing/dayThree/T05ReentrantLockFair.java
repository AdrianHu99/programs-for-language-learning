package mashibing.dayThree;

import mashibing.dayTwo.T05SingletonVolatileOrder;

import java.util.concurrent.locks.ReentrantLock;

public class T05ReentrantLockFair extends Thread{
    private static ReentrantLock lock = new ReentrantLock(true);

    public void run() {
        for (int i = 0; i < 100; i++) {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " get the lock");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        T05ReentrantLockFair rl = new T05ReentrantLockFair();

        Thread t1 = new Thread(rl);
        Thread t2 = new Thread(rl);
        t1.start();
        t2.start();
    }
}
