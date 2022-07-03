package L04.Ch1_IO.P06_ObjectIOStream.Node1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ListSerializationExample {
    public static void main(String[] args) {

        List<String> employees = new ArrayList<>();
        employees.add("Ivan");
        employees.add("Petr");
        employees.add("Sidr");

        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("List.bin")))  {

            outputStream.writeObject(employees);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
