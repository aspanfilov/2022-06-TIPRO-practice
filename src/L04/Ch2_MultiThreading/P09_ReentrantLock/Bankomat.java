package L04.Ch2_MultiThreading.P09_ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bankomat {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        new Employee("Ivan", lock);
        new Employee("Petr", lock);
        new Employee("Sidr", lock);
        new Employee("Gogi", lock);
        new Employee("Egor", lock);

    }

}

class Employee extends Thread {
    String name;
    private Lock lock;

    public Employee(String name, Lock lock) {
        this.name = name;
        this.lock = lock;
        this.start();
    }

    @Override
    public void run() {
        if(lock.tryLock()) {
            try {
//            System.out.println(name + " ждет...");
//            lock.lock();
                System.out.println(name + " пользуется банкоматом");
                Thread.sleep(2000);
                System.out.println(name + " завершил свои дела");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println(name + " не хочет ждать в очереди");
        }

    }
}