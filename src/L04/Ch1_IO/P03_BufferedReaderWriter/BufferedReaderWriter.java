package L04.Ch1_IO.P03_BufferedReaderWriter;


import java.io.*;

public class BufferedReaderWriter {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("Pushkin.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Pushkin2.txt"))) {

            //Читаем посимвольно
            int character;
            while ((character = bufferedReader.read()) != -1) {
                bufferedWriter.write(character);
                System.out.print((char) character);
            }

            bufferedWriter.newLine();

            //Читаем построчно
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
