package mashibing.dayTwo;

/*
An easy singleton implementation.
The only thing is no matter it's being used or not, initialization is already done
 */
public class T01Singleton {
    private static final T01Singleton INSTANCE = new T01Singleton();

    private T01Singleton() {

    }

    public static T01Singleton getInstance() {
        return INSTANCE;
    }

    public static void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        T01Singleton t1 = T01Singleton.getInstance();
        T01Singleton t2 = T01Singleton.getInstance();

        System.out.println(t1 == t2);

    }
}
