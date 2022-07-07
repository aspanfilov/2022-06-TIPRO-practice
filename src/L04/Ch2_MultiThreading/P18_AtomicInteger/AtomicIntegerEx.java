package L04.Ch2_MultiThreading.P18_AtomicInteger;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerEx {

    static AtomicInteger counter = new AtomicInteger();
    public /*synchronized*/ static void increment() {
        counter.incrementAndGet();
//        counter.getAndIncrement();
//        counter.addAndGet(34);
//        counter.getAndAdd(34);
//        counter.decrementAndGet();
//        counter.getAndDecrement();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new MyRunnable());
        Thread thread2 = new Thread(new MyRunnable());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(counter);
    }

}

class MyRunnable implements Runnable{

    @Override
    public void run() {
        for(int i = 0; i < 100_000; i++) {
            AtomicIntegerEx.increment();
        }
    }
}
