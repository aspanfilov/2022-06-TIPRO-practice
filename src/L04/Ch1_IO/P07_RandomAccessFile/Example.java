package L04.Ch1_IO.P07_RandomAccessFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Example {
    public static void main(String[] args) {

        try(RandomAccessFile randomAccessFile = new RandomAccessFile("Rhyme.txt", "rw")) {

            //Прочитать символ
            int a = randomAccessFile.read();
            System.out.println((char) a);

            //Прочитать строку
            String s = randomAccessFile.readLine();
            System.out.println(s);

            //Установить курсор
            randomAccessFile.seek(50);
            String s2 = randomAccessFile.readLine();
            System.out.println(s2);

            //Узнать где находится курсор
            long position = randomAccessFile.getFilePointer();
            System.out.println("Current position: " + position);

            //Записать в начало файла свою строку
            randomAccessFile.seek(0);
            randomAccessFile.writeBytes("ONE");

            //Добавить в конец файла свою строку
            randomAccessFile.seek(randomAccessFile.length());
            randomAccessFile.writeBytes("\n\t\t\t\t Author unknown");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
