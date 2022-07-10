package L04.Ch2_MultiThreading.P04_Volatile.VolatileTest2;

import java.io.IOException;
import java.util.Scanner;

public class VolatileManager {

    private final Copier copier;

    public VolatileManager(Copier copier) {
        this.copier = copier;
    }

    public void copy(String filePath, String destinationFolderPath) {

        Thread copyThread = new CopyThread(this.copier, filePath, destinationFolderPath);
        Thread cancelThread = new CancelThread((Cancelable) copier);
        cancelThread.setDaemon(true);

        copyThread.start();
        cancelThread.start();
    }
}

class CopyThread extends Thread {
    private final Copier copier;
    private final String filePath;
    private final String destinationFolderPath;

    CopyThread(Copier copier, String filePath, String destinationFolderPath) {
        this.copier = copier;
        this.filePath = filePath;
        this.destinationFolderPath = destinationFolderPath;
    }


    @Override
    public void run() {
        try {
            System.out.println("Начинается копирование...");
            if (copier.copy(filePath, destinationFolderPath)) {
                System.out.println("Копирование успешно завершено.");
            } else {
                System.out.println("Копирование отменено.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class CancelThread extends Thread {
    private final Cancelable cancelable;
    private final Scanner scanner;

    CancelThread(Cancelable cancelable) {
        this.cancelable = cancelable;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
        String cancelCommand = "";
        while (!cancelCommand.equalsIgnoreCase("q")) {
            cancelCommand = scanner.nextLine();
        }
        this.cancelable.cancel();
    }
}

