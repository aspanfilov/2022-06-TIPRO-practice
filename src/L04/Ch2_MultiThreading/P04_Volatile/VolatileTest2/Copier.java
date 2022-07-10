package L04.Ch2_MultiThreading.P04_Volatile.VolatileTest2;

import java.io.IOException;

public interface Copier {

    boolean copy(String filePath, String destinationFolderPath) throws IOException;

}
