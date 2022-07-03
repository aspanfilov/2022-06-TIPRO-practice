package L04.Ch1_IO.P04_FileIOStream;

import java.io.*;

public class FileIOStream {
    public static void main(String[] args) {

        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("Pic.jpg"));
             BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("Pic2.jpg"))) {

            int character;
            while ((character = inputStream.read()) != -1) {
                outputStream.write(character);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
