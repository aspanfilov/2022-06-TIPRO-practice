package L04.Ch2_MultiThreading.P06_Synchronized;

public class SyncBetweenObjects {
    static final Object lock = new Object();

    public static void main(String[] args) {
        Thread threadMobile = new Thread(new RunnableMobile());
        Thread threadSkype = new Thread(new RunnableSkype());
        Thread threadTelegram = new Thread(new RunnableTelegram());
        threadMobile.start();
        threadSkype.start();
        threadTelegram.start();
    }

    void mobileCall() {
        synchronized (lock) {
            System.out.println("Calling from object: " + this);
            System.out.println("Mobile call starts");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Mobile call ends");
        }
    }
    synchronized void skypeCall() {
        synchronized (lock) {
            System.out.println("Calling from object: " + this);
            System.out.println("Skype call starts");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Skype call ends");
        }
    }
    synchronized void telegramCall() {
        synchronized (lock) {
            System.out.println("Calling from object: " + this);
            System.out.println("Telegram call starts");
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Telegram call ends");
        }
    }
}

class RunnableMobile implements Runnable{
    @Override
    public void run() {
        var testObject = new SyncBetweenObjects();
        testObject.mobileCall();
    }
}
class RunnableSkype implements Runnable{
    @Override
    public void run() {
        var testObject = new SyncBetweenObjects();
        testObject.skypeCall();
    }
}
class RunnableTelegram implements Runnable{
    @Override
    public void run() {
        var testObject = new SyncBetweenObjects();
        testObject.telegramCall();
    }
}