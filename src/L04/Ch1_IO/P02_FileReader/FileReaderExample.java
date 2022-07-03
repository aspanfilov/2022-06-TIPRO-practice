package L04.Ch1_IO.P02_FileReader;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {
    public static void main(String[] args) {
        try (FileReader fileReader = new FileReader("Pushkin.txt")) {
            int character;
            while ((character = fileReader.read()) != -1) {
                System.out.print((char) character);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
