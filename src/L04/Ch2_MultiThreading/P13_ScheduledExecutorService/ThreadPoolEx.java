package L04.Ch2_MultiThreading.P13_ScheduledExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolEx {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(1);

//        for (int i = 0; i < 10; i++) {
//             scheduledExecutorService.execute(new RunnableImpl());
//        }

//        //Начать выполнение задания через 3 секунды
//        scheduledExecutorService.schedule(new RunnableImpl(), 3, TimeUnit.SECONDS);

        //Начать выполнение задания через 3 секунды
        // и далее повторять выполнение через каждую секунду (после начала выполнения предыщущего задания)
        scheduledExecutorService.scheduleAtFixedRate(new RunnableImpl(), 3 ,1, TimeUnit.SECONDS);

        //Начать выполнение задания через 3 секунды
        // и далее повторять выполнение через каждую секунду (после окончания выполнения предыщущего задания)
        scheduledExecutorService.scheduleWithFixedDelay(new RunnableImpl(), 3, 1, TimeUnit.SECONDS);

        Thread.sleep(5000);
        scheduledExecutorService.shutdown();
    }
}

class RunnableImpl implements Runnable{
    @Override
    public void run() {
        try {
            System.out.println("Thread name: " + Thread.currentThread().getName() + " begins work");
            Thread.sleep(500);
            System.out.println("Thread name: " + Thread.currentThread().getName() + " ends work");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}