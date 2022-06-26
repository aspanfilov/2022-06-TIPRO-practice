package L03.P03_Exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws OwnException {

        try {
            readFile("asdf");
        } catch (FileNotFoundException | IllegalArgumentException e) {
            throw new OwnException(e);
        }

    }

    public static void readFile(String fileName) throws FileNotFoundException, IllegalArgumentException {
        if (fileName == null) {
            throw new IllegalArgumentException("input parameter fileName is null");
        }
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
    }
}
