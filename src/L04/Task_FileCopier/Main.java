package L04.Task_FileCopier;

public class Main {

    public static final String FILE_PATH = "D:\\TestFileCopier\\Threads.mp4";
    public static final String DESTINATION_FOLDER_PATH = "D:\\TestFileCopier";

    public static void main(String[] args) {
        ControlableCopierImpl fileCopier = new ControlableCopierImpl();
        CopyManager copyManager = new CopyManager(fileCopier, 2000);

        copyManager.copy(FILE_PATH, DESTINATION_FOLDER_PATH);
    }

}
