package L04.Ch2_MultiThreading.P04_Volatile.VolatileTest;

public class Main {
    public static void main(String[] args) {
        Copier copier = new CopierImpl(false);
        VolatileManager volatileManager = new VolatileManager(copier);
        volatileManager.test();
    }
}
