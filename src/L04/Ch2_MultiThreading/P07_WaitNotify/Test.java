package L04.Ch2_MultiThreading.P07_WaitNotify;

public class Test {
    public static void main(String[] args) {
        Market market = new Market();
        Producer producer = new Producer(market);
        Consumer consumer = new Consumer(market);
        Thread threadProd = new Thread(producer);
        Thread threadCons = new Thread(consumer);
        threadProd.start();
        threadCons.start();
    }
}

class Market {
    public static final Object lock = new Object();
//    wait() & notify() должны вызываться на том же объекте на котором устанавливается synchronized
//    wait() - освобождает монитор
//    notify() - не освобождает монитор

    private int breadCount = 0;

    public /*synchronized*/ void getBread() {
        synchronized (lock) {
            while (breadCount < 1) {
                try {
//                this.wait();
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            breadCount--;
            System.out.println("Потребитель купил 1 хлеб");
            System.out.println("Кол-во хлеба в магазине = " + breadCount);
//        this.notify();
            lock.notify();
        }
    }

    public /*synchronized*/ void putBread() {
        synchronized (lock){
            while (breadCount >= 5) {
                try {
//                    this.wait();
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            breadCount++;
            System.out.println("Производитель добавил на витрину 1 хлеб");
            System.out.println("Кол-во хлеба в магазине = " + breadCount);
//            this.notify();
            lock.notify();
        }
    }
}

class Producer implements Runnable {
    Market market;

    Producer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            this.market.putBread();
        }
    }
}

class Consumer implements Runnable {
    Market market;

    Consumer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            this.market.getBread();
        }
    }
}
