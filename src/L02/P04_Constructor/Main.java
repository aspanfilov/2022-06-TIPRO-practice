package L02.P04_Constructor;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //Цепочка вызовов конструкторов родителей
        Animal doberman = new Doberman();

        System.out.println();

        //Переопределенные конструкторы
        Animal animal1 = new Animal();
        Animal animal2 = new Animal("Wolf");
        Animal animal3 = new Animal("Bear", LocalDate.now());

        System.out.println();
        Dog dog = new Dog("Bob");

    }

}
