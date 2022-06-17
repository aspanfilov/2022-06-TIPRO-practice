package L02.P06_AbstractClass;

public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog();
        System.out.println("Создана собака");
        System.out.println(dog.speak());
        System.out.println(dog.move());

        System.out.println();

        Animal cat = new Cat();
        System.out.println("Создана кошка");
        System.out.println(cat.speak());
        System.out.println(cat.move());
    }
}
