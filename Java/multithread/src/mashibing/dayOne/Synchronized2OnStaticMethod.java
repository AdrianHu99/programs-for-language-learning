package mashibing.dayOne;

public class Synchronized2OnStaticMethod {
    private static int count = 10;

    public static void m() {
        synchronized (Synchronized2OnStaticMethod.class) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }

    // Same as m()
    public synchronized static void n() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }
}
