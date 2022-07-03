package L04.Ch1_IO.P06_ObjectIOStream.Node1;

import L04.Ch1_IO.P06_ObjectIOStream.Node1.Domain.Car;
import L04.Ch1_IO.P06_ObjectIOStream.Node1.Domain.Employee;

import java.io.*;

public class EmployeeSerializationExample {
    public static void main(String[] args) {

        Car car = new Car("BMW", "Black");
        Employee employee = new Employee("Lena", "IT", 34, 20_000, car);

        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("Employee.bin"))) {
            outputStream.writeObject(employee);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
