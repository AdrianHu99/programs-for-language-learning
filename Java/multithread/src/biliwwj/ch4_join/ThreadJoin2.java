package biliwwj.ch4_join;

import java.util.Optional;
import java.util.stream.IntStream;

public class ThreadJoin2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t0 = new Thread(() -> {
            IntStream.range(1, 100).forEach(i -> System.out.println(Thread.currentThread().getName() + " -> " + i));
        }, "T0");
        Thread t1 = new Thread(() -> {
            IntStream.range(1, 100).forEach(i -> System.out.println(Thread.currentThread().getName() + " -> " + i));
        }, "T1");
        t0.start();
        t1.start();
        // By using join(), main will wait until t0 and t1 both finishes
        // But t1 will not wait until t0 finishes
        t0.join();
        t1.join();

        Optional.of("Both t0 and t1 finishes").ifPresent(System.out::println);
        IntStream.range(1, 100).forEach(i -> System.out.println(Thread.currentThread().getName() + " -> " + i));

        // For some cases, you will want main to not die
        // Thread.currentThread().join();

    }
}
