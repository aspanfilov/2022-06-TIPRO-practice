package L04.Ch2_MultiThreading.P04_Volatile;

public class Test extends Thread{

    //Переменная будет храниться только в основной памяти (не будет кэшироваться для потоков)
    //Используется только когда 1 поток изменяет переменную, а остальные только читают
    volatile boolean b = true;

    public void run() {
        long counter = 0;
        while (b) {
            counter++;
        }
        System.out.println("Loop is finished. couter = " + counter);
    }

    public static void main(String[] args) throws InterruptedException {
        Test testThread = new Test();
        testThread.start();
        Thread.sleep(3000);
        System.out.println("After 3 seconds it is time to wake up!");
        testThread.b = false;
        testThread.join();
        System.out.println("End of program");

    }
}
