package L04.Ch1_IO.P06_ObjectIOStream.Node2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class ListDeserializationExample {
    public static void main(String[] args) {

        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("List.bin"))) {

            List<String> employees = (List<String>) inputStream.readObject();
            System.out.println(employees);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
