package biliwwj.ch1_threadAndRunnable;

public class BankV1 {

    public static void main(String[] args) {
        TicketWindowV1 th1 = new TicketWindowV1("One");
        TicketWindowV1 th2 = new TicketWindowV1("Two");
        TicketWindowV1 th3 = new TicketWindowV1("Three");

        th1.start();
        th2.start();
        th3.start();
    }


}
