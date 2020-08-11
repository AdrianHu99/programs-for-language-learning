package biliwwj.ch4_join;

import java.util.stream.IntStream;

public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread t0 = new Thread(() -> {
            IntStream.range(1, 1000).forEach(i -> System.out.println(Thread.currentThread().getName() + " -> " + i));
        }, "T0");
        t0.start();
        // By using join(), main will wait until t0 finishes
        t0.join();

        IntStream.range(1, 1000).forEach(i -> System.out.println(Thread.currentThread().getName() + " -> " + i));

    }
}
