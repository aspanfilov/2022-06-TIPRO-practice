package L04.Task_FileCopier;

public class Main {

    public static final String FILE_PATH = "D:\\TestFileCopier\\Threads.mp4";
//    public static final String FILE_PATH = "C:\\JProjects\\TestFileCopier\\1Cv8.cf";
    public static final String DESTINATION_FOLDER_PATH = "D:\\TestFileCopier";
//    public static final String DESTINATION_FOLDER_PATH = "C:\\JProjects\\TestFileCopier";


    public static void main(String[] args) {
//        ControlableCopierImpl copier = new ControlableCopierImpl();
        Copier copier = new ControlableCopierImpl();
        CopyManager copyManager = new CopyManager(copier, 2000);

        copyManager.copy(FILE_PATH, DESTINATION_FOLDER_PATH);
    }

}
