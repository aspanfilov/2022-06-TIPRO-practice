package L04.Ch2_MultiThreading.P06_Synchronized;

public class SyncOnClass extends Thread{
    static int counter = 0;

    private  /* synchronized */ static void increment() {
        synchronized (SyncOnClass.class) {
            counter++;
        }
    }

    @Override
    public void run() {
        for(int i = 0; i < 1_000_000; i++) {
            increment();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new SyncOnClass();
        Thread thread2 = new SyncOnClass();
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(counter);
    }

}
