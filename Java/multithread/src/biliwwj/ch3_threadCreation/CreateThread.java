package biliwwj.ch3_threadCreation;

import java.util.Arrays;

public class CreateThread {
    public static void main(String[] args) {
        // If we don't put threadGroup to init the thread, it will share the same threadGroup with main
        Thread t = new Thread() {
            @Override
            public void run() {
                // Sleep for 1 second in case it finishes before we print its info
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        System.out.println("Current thread name is " + Thread.currentThread().getName());
        System.out.println("Current thread group name is " + Thread.currentThread().getThreadGroup().getName());

        t.start();
        System.out.println("New thread's name is " + t.getThreadGroup());
        System.out.println("New thread's thread group name is " + t.getThreadGroup().getName());
        // It's 3, instead of 2 (main and t)
        System.out.println("Current thread group's active count is " + t.getThreadGroup().activeCount());

        ThreadGroup tg = Thread.currentThread().getThreadGroup();

        Thread[] threads = new Thread[3];
        tg.enumerate(threads);
        /*
        Thread[main,5,main]
        Thread[Monitor Ctrl-Break,5,main]
        Thread[Thread-0,5,main]
         */
        /*for (Thread thread : threads) {
            System.out.println(thread);
        }*/
        Arrays.asList(threads).forEach(System.out::println);
    }
}
