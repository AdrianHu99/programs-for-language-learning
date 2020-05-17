package mashibing.dayTwo;

import java.util.concurrent.TimeUnit;
/*
What volatile does:
1. 保证线程可见性
2. 禁止指令重排序
	- DCL 单例
	- Double Check Lock

 */
public class T00Volatile {

    /*volatile*/ boolean running = true;

    void m() {
        System.out.println("m starts");
        while (running) {

        }

        System.out.println("m ends;");
    }

    public static void main(String[] args) {
        T00Volatile t = new T00Volatile();
        new Thread(t::m, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.running = false;
    }
}
