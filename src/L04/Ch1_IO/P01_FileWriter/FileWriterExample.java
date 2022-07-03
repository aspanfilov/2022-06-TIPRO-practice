package L04.Ch1_IO.P01_FileWriter;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
    public static void main(String[] args) {
        String someText1 =
                "У лукоморья дуб зелёный;\n" +
                "Златая цепь на дубе том:\n";
        String someText2 =
                "И днём и ночью кот учёный\n" +
                "Всё ходит по цепи кругом;\n";
        String someText3 =
                "Идёт направо — песнь заводит,\n" +
                "Налево — сказку говорит.\n";


        try (FileWriter fileWriter = new FileWriter("Pushkin.txt")) {
            //Создаем файл и пишем текст
            for (int i = 0; i < someText1.length(); i++) {
                fileWriter.write(someText1.charAt(i));
            }
            fileWriter.write(someText2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter fileWriter = new FileWriter("Pushkin.txt", true)) {
            //Продолжаем писать в файл
            fileWriter.write(someText3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
