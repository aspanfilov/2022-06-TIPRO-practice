package L04.Ch2_MultiThreading.P04_Volatile;

import javax.swing.*;

public class Test extends Thread{

    //Переменная будет храниться только в основной памяти (не будет кэшироваться для потоков)
    //Используется только когда 1 поток изменяет переменную, а остальные только читают
//    volatile boolean b = true;

    Control control;

    public Test(Control control) {
        this.control = control;
    }


    public void run() {
        long counter = 0;
        while (control.getB()) {
            counter++;
        }
        System.out.println("Loop is finished. couter = " + counter);
    }

    public static void main(String[] args) throws InterruptedException {
        Control control = new Control();
        Test testThread = new Test(control);
        testThread.start();
        Thread.sleep(3000);
        System.out.println("After 3 seconds it is time to wake up!");
//        testThread.b = false;
        control.setB(false);
        testThread.join();
        System.out.println("End of program");

    }
}
