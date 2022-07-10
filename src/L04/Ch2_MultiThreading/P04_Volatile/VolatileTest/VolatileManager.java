package L04.Ch2_MultiThreading.P04_Volatile.VolatileTest;

import java.util.Scanner;

public class VolatileManager {
    private final Copier copier;

    public VolatileManager(Copier copier) {
        this.copier = copier;
    }

    public void test() {
        Thread threadInc = new ThreadInc(copier);
        Thread threadStop = new ThreadStop((Cancelable) copier);
        threadStop.setDaemon(true);

        threadInc.start();
        threadStop.start();
    }
}

class ThreadInc extends Thread{

    private final Copier copier;

    public ThreadInc(Copier copier) {
        this.copier = copier;
    }

    @Override
    public void run() {
        this.copier.inc();
    }
}

class ThreadStop extends Thread{

    private final Cancelable cancelable;

    ThreadStop(Cancelable cancelable) {
        this.cancelable = cancelable;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String command = "";
        while (!command.equalsIgnoreCase("q")) {
            command = scanner.nextLine();
        }
        this.cancelable.cancel();
    }

}

