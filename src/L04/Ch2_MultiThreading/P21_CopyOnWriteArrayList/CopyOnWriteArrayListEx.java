package L04.Ch2_MultiThreading.P21_CopyOnWriteArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListEx {
    public static void main(String[] args) throws InterruptedException {
        //CopyOnWriteArrayList - имплементирует интерфейс List
        //CopyOnWriteArrayList - следует использовать когда нужно обеспечить потокобезопасность и
        //  * небольшое кол-во операций на изменение элементов
        //  * большое кол-во операций на чтение элементов

//        List<String> list = new ArrayList<>();
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("Ivan");
        list.add("Petr");
        list.add("Sidr");
        list.add("Oleg");
        list.add("Egor");

        System.out.println("Было: " + list);

        Runnable runnable1 = () -> {
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                try {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + ": " + iterator.next());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable runnable2 = () -> {
            try {
                Thread.sleep(200);
                //Создалась новая копия list
                list.remove(4);
                //Создалась новая копия list
                list.add("Lena");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("Стало: " + list);
    }
}
