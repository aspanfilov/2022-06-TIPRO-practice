package L04.Ch2_MultiThreading.P06_Synchronized;

public class SyncOnObject {
    //Монитор существует только у Класса или Объекта

    public static void main(String[] args) {
        MyRunnableImplementation runnable = new MyRunnableImplementation();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();
    }

}

class Counter{
    static int counter = 0;
}

class MyRunnableImplementation implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i < 3; i++) {
            increment();
        }
    }
    private /* synchronized */ void increment() {
        doAnyWork();
        synchronized (this) {
            Counter.counter++;
            System.out.print(Counter.counter + " ");
        }
    }
    private void doAnyWork() {
        System.out.println("any text");
    }
}
