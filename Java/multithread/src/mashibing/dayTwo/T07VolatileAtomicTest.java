package mashibing.dayTwo;

import java.util.ArrayList;
import java.util.List;

public class T07VolatileAtomicTest {
    volatile int count = 0;
    // if we don't add synchronized, thread 1 bump count from 0 to 1, thread 2 and 3 both read this as 1, and bump that as 2
    // so we miss one increment
    /*synchronized*/ void m() {
        System.out.println(Thread.currentThread().getName() + " starts...");
        for (int i = 0; i < 10000; i++) {
            count++;
        }
        System.out.println(Thread.currentThread().getName() + " ends...");
    }

    public static void main(String[] args) {
        T07VolatileAtomicTest t = new T07VolatileAtomicTest();

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(t::m, "thread-" + i));
        }

        threads.forEach(o -> {o.start();});

        threads.forEach(o -> {
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(t.count);

    }
}
