package L03.P04_TryWithResources;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        File file = new File("out.txt");
        try(PrintWriter printWriter = new PrintWriter(file)) {
            printWriter.println("Hello");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
