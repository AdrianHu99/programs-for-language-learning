package mashibing.dayTwo;

import java.util.concurrent.TimeUnit;

public class T04SingletonLazyGranularLock {
    private static T04SingletonLazyGranularLock INSTANCE;

    private T04SingletonLazyGranularLock() {

    }

    public static T04SingletonLazyGranularLock getInstance() {
        if (INSTANCE == null) {
            // It's not thread safe, the 2nd block could wait there and finally
            // go in to create another object instead of reusing the one created by 1st thread
            synchronized (T04SingletonLazyGranularLock.class) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new T04SingletonLazyGranularLock();
            }

            /*synchronized (T04SingletonLazyGranularLock.class) {
                // Double check to make sure we only create object if it's not created before
                if (INSTANCE == null) {
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new T04SingletonLazyGranularLock();
                }
            }*/
        }
        return INSTANCE;

    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(() ->{
                System.out.println(T04SingletonLazyGranularLock.getInstance().hashCode());

            }).start();
        }
    }
}
