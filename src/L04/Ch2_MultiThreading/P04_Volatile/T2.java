package L04.Ch2_MultiThreading.P04_Volatile;

import java.util.Scanner;

public class T2 extends Thread {

    //Переменная будет храниться только в основной памяти (не будет кэшироваться для потоков)
    //Используется только когда 1 поток изменяет переменную, а остальные только читают
    volatile boolean b = true;

    public void run() {
        long counter = 0;
        while (b) {
            counter++;
            if (counter % 1_000_000_000 == 0) {
                System.out.print(counter);
            }

        }
        System.out.println("Loop is finished. couter = " + counter);
    }

    public static void main(String[] args) throws InterruptedException {
        T2 testThread = new T2();
        testThread.start();
//        Thread.sleep(5000);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input q");
        String command = "";
        while (!command.equalsIgnoreCase("q")) {
            command = scanner.nextLine();
        }
        if (command.equalsIgnoreCase("q")) {
            testThread.b = false;
        }
        testThread.join();
        System.out.println("End of program");

    }
}