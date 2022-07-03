package L04.Ch1_IO.P06_ObjectIOStream.Node2;

import L04.Ch1_IO.P06_ObjectIOStream.Node1.Domain.Employee;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class EmployeeDeserializationExample {
    public static void main(String[] args) {

        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("Employee.bin"))) {

            Employee employee = (Employee) inputStream.readObject();
            System.out.println(employee);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
