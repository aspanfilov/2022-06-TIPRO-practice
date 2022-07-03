package L04.Task_FileCopier;

import java.io.IOException;
import java.util.Scanner;

public class CopyManager {

    private final ControlableCopier controlableCopier;
    private final int pollingTime;
    private final Scanner scanner;

    public CopyManager(ControlableCopier controlableCopier, int pollingTime) {
        this.controlableCopier = controlableCopier;
        this.pollingTime = pollingTime;
        this.scanner = new Scanner(System.in);
    }

    public void copy(String filePath, String destinationFolderPath) {

        Thread copyThread = new Thread(() -> {
            try {
                System.out.println("Начинается копирование...");
                if (controlableCopier.copy(filePath, destinationFolderPath)) {
                    System.out.println(getProgressView(100));
                } else {
                    System.out.println("Копирование отменено");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Thread progressThread = new Thread(() -> {
            try {
                while (copyThread.getState() != Thread.State.TERMINATED) {
                    Thread.sleep(pollingTime);
                    System.out.println(getProgressView(controlableCopier.getProgress()));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        progressThread.setDaemon(true);

        Thread cancelWaitingThread = new Thread(() -> {
            String cancelCommand = "";
            while (!cancelCommand.equalsIgnoreCase("q")) {
                cancelCommand = scanner.nextLine();
            }
            this.controlableCopier.cancel();
        });
        cancelWaitingThread.setDaemon(true);

        copyThread.start();
        progressThread.start();
        cancelWaitingThread.start();

    }

    private String getProgressView(int progress) {
        return "Завершено " + progress + "%." + (progress < 100 ? " Для отмены введите 'q'" : "");
    }
}
