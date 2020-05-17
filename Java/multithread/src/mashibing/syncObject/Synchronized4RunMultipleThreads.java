package mashibing.syncObject;

public class Synchronized4RunMultipleThreads implements Runnable{
    private int count = 10;

    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count is changed to " + count);
    }

    public static void main(String[] args) {
        Synchronized4RunMultipleThreads t = new Synchronized4RunMultipleThreads();
        for (int i = 0; i < 5; i++) {
            new Thread(t, "THREAD" + i).start();
        }
    }
}
