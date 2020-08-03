package biliwwj.ch1_threadAndRunnable;

/*
    Use Runnable to separate common part and modifiable part
 */
public class TicketWindowV2 implements Runnable {

    private static final int MAX = 50;

    private static volatile int index = 1;

    @Override
    public void run() {
        synchronized (this) {
            while (index <= MAX) {
                System.out.println(Thread.currentThread() + " window is serving " + (index++) + "th request");
            }
        }
    }
}
