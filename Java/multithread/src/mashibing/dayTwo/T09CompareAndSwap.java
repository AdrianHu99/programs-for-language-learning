package mashibing.dayTwo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/*
Anything starting with Atomic, it use CAS to guarantee the atomicity

CAS is CPU level operation, which won't be interrupted

One thing we can't prevent here is ABA problem (count was changed to 2 and then to 1 by other threads)
To prevent that, add version number

AtomicStampedReference
 */
public class T09CompareAndSwap {
    AtomicInteger count = new AtomicInteger(0);

    void m() {
        for (int i = 0; i < 100; i++) {
            count.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        T09CompareAndSwap t = new T09CompareAndSwap();

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(t::m, "thread-" + i));
        }

        threads.forEach(o -> o.start());

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
