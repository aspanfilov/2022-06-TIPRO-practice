package L04.Ch2_MultiThreading.P15_Semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    //Semaphore - это синхронизатор, позволяющий ограни чить доступ к какому-то ресурсу.
    //В конструктор Semaphore нужно передавать количество потоково,
    // которым Semaphore будет разрешать одновременно использовать этот ресурс.

    public static void main(String[] args) {
        Semaphore callBox = new Semaphore(2);

        new Person("Ivan", callBox);
        new Person("Petr", callBox);
        new Person("Sidr", callBox);
        new Person("Oleg", callBox);
        new Person("Gogi", callBox);


    }
}

class Person extends Thread{
    private final String name;
    private final Semaphore callbox;

    Person(String name, Semaphore callbox) {
        this.name = name;
        this.callbox = callbox;

        this.start();
    }

    @Override
    public void run() {

        try {
            System.out.println(name + " ждет...");
            //Увеличить count семафора на 1 ИЛИ при достижении лимита, Заблокировать читающий поток, пока ресурс не станет доступным.
            callbox.acquire();
            System.out.println(name + " пользуется телефоном");
            sleep(2000);
            System.out.println(name + " завершил звонок");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            //Уменьшить count семафора на 1 и разблокировать
            callbox.release();
        }
    }
}