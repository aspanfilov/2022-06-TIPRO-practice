package L04.Ch2_MultiThreading.P02_SetNameGetName;

public class Test {
    public static void main(String[] args) {
        var myThread1 = new MyThread();
        System.out.println("Name of myThread = " + myThread1.getName() +
                "; Priority of myThread = " + myThread1.getPriority());

        var myThread2 = new MyThread();
        System.out.println("Name of myThread = " + myThread2.getName() +
                "; Priority of myThread = " + myThread2.getPriority());

        var myThread3 = new MyThread();
        myThread3.setName("my_thread");
        myThread3.setPriority(Thread.MAX_PRIORITY); //1..10
        System.out.println("Name of myThread = " + myThread3.getName() +
                "; Priority of myThread = " + myThread3.getPriority());
        System.out.println();
        /////////////////////////////////////////////////////////////////////

        System.out.println("Main thread. Thread name = " + Thread.currentThread().getName());

        //Метод run - выполнит содержимое потока в текущем потоке
        new Thread(() -> {
            System.out.println("Method run. Thread name = " + Thread.currentThread().getName());
        }).run();

        //Метод start - выполнит содержимое потока в новом потоке
        new Thread(() -> {
            System.out.println("Method start. Thread name = " + Thread.currentThread().getName());
        }).start();
    }
}

class MyThread extends Thread{
    public void run() {
        System.out.println("hello");
    }
}
