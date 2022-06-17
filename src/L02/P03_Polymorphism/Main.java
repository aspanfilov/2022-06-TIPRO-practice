package L02.P03_Polymorphism;

public class Main {

    public static void main(String[] args) {
        //Пример полиморфизма

        Speakable animal1 = new Cat();
        Speakable animal2 = new Dog();

        System.out.println("Это животное говорит: " + animal1.speak());
        System.out.println("Это животное говорит: " + animal2.speak());
    }
}
