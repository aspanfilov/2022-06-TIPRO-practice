package L04.Task02_FileCopier;

import java.io.IOException;

public interface Copier {

    boolean copy(String filePath, String destinationFolderPath) throws IOException;

}
