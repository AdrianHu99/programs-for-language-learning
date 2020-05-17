package mashibing.dayTwo;

import java.util.concurrent.TimeUnit;

public class T05SingletonVolatileOrder {
    // it's hard to reproduce, but we need volatile to avoid this situation:
    // the object has been initialized but not assigned to the correct value because of the order
    private static /*volatile*/ T05SingletonVolatileOrder INSTANCE;

    private T05SingletonVolatileOrder() {

    }

    public static T05SingletonVolatileOrder getInstance() {
        if (INSTANCE == null) {

            synchronized (T05SingletonVolatileOrder.class) {
                // Double check to make sure we only create object if it's not created before
                if (INSTANCE == null) {
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new T05SingletonVolatileOrder();
                }
            }
        }
        return INSTANCE;

    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(() ->{
                System.out.println(T05SingletonVolatileOrder.getInstance().hashCode());

            }).start();
        }
    }
}
