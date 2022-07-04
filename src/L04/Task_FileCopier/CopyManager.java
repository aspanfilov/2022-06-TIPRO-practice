package L04.Task_FileCopier;

import java.io.IOException;
import java.util.Scanner;

public class CopyManager {

    private final Copier copier;
    private final int pollingTime;

    public CopyManager(Copier copier, int pollingTime) {
        this.copier = copier;
        this.pollingTime = pollingTime;
    }

    public void copy(String filePath, String destinationFolderPath) {

        Thread copyThread = new CopyThread(this.copier, filePath, destinationFolderPath);
        Thread progressThread = new ProgressThread((Progressable) this.copier, this.pollingTime);
        progressThread.setDaemon(true);
        Thread cancelWaitingThread = new CancelThread((Cancelable) this.copier);
        cancelWaitingThread.setDaemon(true);

        copyThread.start();
        progressThread.start();
        cancelWaitingThread.start();

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

class ProgressThread extends Thread {
    private final Progressable progressable;
    private final int pollingTime;

    ProgressThread(Progressable progressable, int pollingTime) {
        this.progressable = progressable;
        this.pollingTime = pollingTime;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(this.pollingTime);
                System.out.println(getProgressView(this.progressable.getProgress()));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String getProgressView(int progress) {
        return "Завершено " + progress + "%." + (progress < 100 ? " Для отмены введите 'q'" : "");
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
