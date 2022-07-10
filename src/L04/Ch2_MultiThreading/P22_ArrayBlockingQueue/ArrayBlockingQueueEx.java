package L04.Ch2_MultiThreading.P22_ArrayBlockingQueue;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockingQueueEx {
    public static void main(String[] args) {
        //ArrayBlockingQueue - потокобезопасная очередь с ограниченным размером
        //ArrayBlockingQueue - используется когда
        // * одни потоки - добавляют элементы в конец очереди
        // * другие потоки - забирают элементы из начала очереди

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(4);

        new Thread(() -> {
            int i = 0;
            while (true) {
                try {
                    i++;
                    queue.put(i);
                    System.out.println("Продусер добавил: " + i + " " + queue);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    Integer i = queue.take();
                    System.out.println("Консумер забрал: " + i + " " + queue);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        System.out.println(queue);

    }
}
