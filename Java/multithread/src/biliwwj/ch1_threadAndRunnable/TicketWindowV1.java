package biliwwj.ch1_threadAndRunnable;

public class TicketWindowV1 extends Thread {

    private String name;

    private static final int MAX = 50;

    private static int index = 1;

    public TicketWindowV1(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (index < MAX) {
            System.out.println(this.name + " window is serving " + (index++) + "th request");
        }
    }
}
