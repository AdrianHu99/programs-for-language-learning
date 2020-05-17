package mashibing.dayOne;

public class Synchronized3OnThis {
    private int count = 10;

    public void m() {
        synchronized (this) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }

    // Same as m()
    public synchronized void n() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }
}
