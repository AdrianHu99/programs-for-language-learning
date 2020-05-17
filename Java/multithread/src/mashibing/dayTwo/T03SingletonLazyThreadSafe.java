package mashibing.dayTwo;

import java.util.concurrent.TimeUnit;

/*
thread safe, but lock scope is too big
 */
public class T03SingletonLazyThreadSafe {
    private static T03SingletonLazyThreadSafe INSTANCE;

    private T03SingletonLazyThreadSafe() {

    }

    public static synchronized T03SingletonLazyThreadSafe getInstance() {
        if (INSTANCE == null) {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new T03SingletonLazyThreadSafe();
        }
        return INSTANCE;

    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(() ->{
                System.out.println(T03SingletonLazyThreadSafe.getInstance().hashCode());

            }).start();
        }
    }
}
