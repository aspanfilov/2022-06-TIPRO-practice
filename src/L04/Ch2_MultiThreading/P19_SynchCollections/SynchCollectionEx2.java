package L04.Ch2_MultiThreading.P19_SynchCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SynchCollectionEx2 {
    public static void main(String[] args) throws InterruptedException {

        List<Integer> source = new ArrayList<>();
        for (int i = 0; i < 5000; i++) {
            source.add(i);
        }

        //Синхронизированный лист - всегда корректно отрабатывает многопоточное добавление элементов
        List<Integer> target = Collections.synchronizedList(source);

        //Пока этот поток перебирает интератор, другой поток не должен модицифировать коллекцию.
        Runnable runnable1 = () -> {
            synchronized (target) {
                Iterator<Integer> iterator = target.iterator();
                while (iterator.hasNext()) {
                    System.out.println(iterator.next());
                }
            }
        };

        //Поток пытается удалить элемент из коллекции, который перебирается в другом потоке
        Runnable runnable2 = () -> {
            target.remove(10);
        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(target);
    }
}
