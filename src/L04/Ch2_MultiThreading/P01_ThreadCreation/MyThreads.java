package L04.Ch2_MultiThreading.P01_ThreadCreation;

public class MyThreads {
    public static void main(String[] args) {
        //Способы реализации своих потоков:

        //Класс наследуемый от Thread
        var myThread_ExtendsThread = new MyThreadExtendsThread();
        myThread_ExtendsThread.start();

        //Класс реализующий интерфейс Runnable
        var myThread_ImplementsRunnable = new Thread(new MyThreadImplementsRunnable());
        myThread_ImplementsRunnable.start();

        //Анонимный класс реализующий интерфейс Runnable
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 2000; i < 3000; i++) {
                    System.out.println(i);
                }
            }
        }).start();

        //Анонимный класс реализующий интерфейс Runnable в виде лямбды
        new Thread(() -> {
            for(int i = 3000; i < 4000; i++) {
                System.out.println(i);
            }
        }).start();

    }

}

class MyThreadExtendsThread extends Thread {
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }
}

class MyThreadImplementsRunnable implements Runnable {
    public void run() {
        for (int i = 1000; i < 2000; i++) {
            System.out.println(i);
        }
    }
}


