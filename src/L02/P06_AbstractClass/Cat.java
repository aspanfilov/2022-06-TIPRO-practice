package L02.P06_AbstractClass;

public class Cat extends Animal {
    public Cat() {
        super("Кошка");
    }

    @Override
    public String speak() {
        return "Кошка говорит Мяу";
    }
}
