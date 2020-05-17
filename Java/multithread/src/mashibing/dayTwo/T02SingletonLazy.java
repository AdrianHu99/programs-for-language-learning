package mashibing.dayTwo;

/*
Lazy loading, but not thread safe
 */
public class T02SingletonLazy {
    private static T02SingletonLazy INSTANCE;

    private T02SingletonLazy() {

    }

    public static T02SingletonLazy getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new T02SingletonLazy();
        }
        return INSTANCE;

    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(() ->{
                System.out.println(T02SingletonLazy.getInstance().hashCode());

            }).start();
        }
    }
}
