package L04.Ch2_MultiThreading.P09_ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Example {
    public static void main(String[] args) {

        Call call = new Call();
        Thread threadMobile = new Thread(call::mobileCall);
        Thread threadSkype = new Thread(call::skypeCall);
        Thread threadTelegram = new Thread(call::telegramCall);
        threadMobile.start();
        threadSkype.start();
        threadTelegram.start();
    }
}

class Call{
    private Lock lock = new ReentrantLock();

    void mobileCall() {
        lock.lock(); //Открываем лок
        try {
            System.out.println("Mobile call starts");
            Thread.sleep(3000);
            System.out.println("Mobile call ends");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock(); //Обязательно нужно закрывать лок в блоке finally
        }
    }

    void skypeCall() {
        lock.lock();
        try {
            System.out.println("Skype call starts");
            Thread.sleep(5000);
            System.out.println("Skype call ends");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void telegramCall() {
        lock.lock();
        try {
            System.out.println("Telegram call starts");
            Thread.sleep(7000);
            System.out.println("Telegram call ends");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
