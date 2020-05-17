package mashibing.syncObject;

public class Synchronized5WIthNonSynchronizedMethods {
    public synchronized void m1() {
        System.out.println(Thread.currentThread().getName() + " m1 starts...");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m1 ends...");
    }

    public void m2() {
        System.out.println(Thread.currentThread().getName() + " m2 starts...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m2 ends...");

    }

    public static void main(String[] args) {
        Synchronized5WIthNonSynchronizedMethods t = new Synchronized5WIthNonSynchronizedMethods();

        new Thread(t::m1, "m1").start();
        new Thread(t::m2, "m2").start();
    }
}
