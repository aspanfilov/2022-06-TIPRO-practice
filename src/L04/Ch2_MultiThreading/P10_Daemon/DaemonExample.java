package L04.Ch2_MultiThreading.P10_Daemon;

public class DaemonExample {
    public static void main(String[] args) {
        System.out.println("Main thread starts");

        UserThread userThread = new UserThread();
        userThread.setName("user_thread");

        // Потоки демоны живут пока работают обычные потоки.
        // Когда все обычные потоки заканчивают работу, демоны будут прекращены автоматическки
        DaemonThread daemonThread = new DaemonThread();
        daemonThread.setName("daemon_thread");
        daemonThread.setDaemon(true);

        userThread.start();
        daemonThread.start();

        System.out.println("Main thread ends");
    }
}

class UserThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is daemon: " + isDaemon());
        try {
            for (char i = 'A'; i <= 'J'; i++) {
                sleep(300);
                System.out.println(i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class DaemonThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is daemon: " + isDaemon());
        try {
            for (int i = 1; i <= 1000; i++) {
                sleep(100);
                System.out.println(i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
