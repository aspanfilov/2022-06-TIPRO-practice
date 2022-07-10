package L04.Ch2_MultiThreading.P20_ConcurrentHashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapEx {
    public static void main(String[] args) throws InterruptedException {
        //ConcurrentHashMap - имлементирует интерфейс ConcurrentMap, который происходит от интерфейса Map
        //ConcurrentHashMap - любое количество потоков может читать элементы не блокируя его
        //ConcurrentHashMap - при изменении блокируетя только бакет, в котором происходит изменение (а не вся коллекция)
        //ConcurrentHashMap - нельзя использовать null для key или value

//        Map<Integer, String> map = new HashMap<>();
        Map<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "Ivan");
        map.put(2, "Petr");
        map.put(3, "Sidr");
        map.put(4, "Egor");
        map.put(5, "Oleg");

        System.out.println(map);

        Runnable runnable1 = () -> {
            Iterator<Integer> iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                try {
                    Thread.sleep(100);
                    Integer i = iterator.next();
                    System.out.println(i + ": " + map.get(i));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable runnable2 = () -> {
            try {
                Thread.sleep(300);
                map.put(6, "Lena");
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
        System.out.println(map);

    }
}
