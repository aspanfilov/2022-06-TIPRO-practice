package L02.P04_Constructor;

import java.time.LocalDate;

public class Animal {
    private String name;
    private LocalDate birthDate;

    public Animal() {
        System.out.println("Конструктор Animal()");
    }

    public Animal(String name) {
        this.name = name;
        System.out.println("Конструктор Animal(String name)");
    }

    public Animal(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        System.out.println("Конструктор Animal(String name, LocalDate birthDate)");
    }

}
