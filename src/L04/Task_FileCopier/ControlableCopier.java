package L04.Task_FileCopier;

import java.io.IOException;

public interface ControlableCopier {

    boolean copy(String filePath, String destinationFolderPath) throws IOException;
    int getProgress();
    void cancel();

}
