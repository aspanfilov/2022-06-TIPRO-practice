package L04.Ch2_MultiThreading.P19_SynchCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchCollectionEx1 {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> source = new ArrayList<>();
        for (int i = 0; i < 5000; i++) {
            source.add(i);
        }

        //Для обычного листа - многопоточное добавление элементов ведет себя непредсказуемо
//        List<Integer> target = new ArrayList<>();

        //Синхронизированный лист - всегда корректно отрабатывает многопоточное добавление элементов
        List<Integer> target = Collections.synchronizedList(new ArrayList<>());

        Runnable runnable = () -> {
            target.addAll(source);
        };

        System.out.println(source);
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(target);



    }
}
