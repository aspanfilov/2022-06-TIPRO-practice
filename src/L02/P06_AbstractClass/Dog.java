package L02.P06_AbstractClass;

public class Dog extends Animal{

    public Dog() {
        super("Собака");
    }

    @Override
    public String speak() {
        return "Собака говорит Гав";
    }
}
