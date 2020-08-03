package biliwwj.ch1_threadAndRunnable;

public class BankV2 {

    public static void main(String[] args) {
        TicketWindowV2 ticketWindow = new TicketWindowV2();

        Thread t1 = new Thread(ticketWindow, "One");
        Thread t2 = new Thread(ticketWindow, "Two");
        Thread t3 = new Thread(ticketWindow, "Three");

        t1.start();
        t2.start();
        t3.start();

    }
}
