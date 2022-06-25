package L02.P04_Constructor;

public class Dog extends Animal{
    public Dog() {
        System.out.println("Конструктор Dog()");
    }

    public Dog(String name) {
        super(name);
        System.out.println("Конструктор Dog(String name)");
    }


    public String move() {
        return "Dog is moving";
    }
}
