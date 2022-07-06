package L04.Ch2_MultiThreading.P12_ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolEx {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ExecutorService executorServiceSingle = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {
            executorService.execute(new RunnableImpl());
//            executorServiceSingle.execute(new RunnableImpl());
        }
        executorService.shutdown();

        executorService.awaitTermination(3, TimeUnit.SECONDS); //Основной поток ждет либо конца работы ExecutorService, либо указанного времени
        System.out.println("Main thread ends");
    }
}

class RunnableImpl implements Runnable{
    @Override
    public void run() {
        try {
            System.out.println("Thread name: " + Thread.currentThread().getName() + " begins work");
            Thread.sleep(2000);
            System.out.println("Thread name: " + Thread.currentThread().getName() + " ends work");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}