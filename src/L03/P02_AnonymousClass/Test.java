package L03.P02_AnonymousClass;

public class Test {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.eat();

        Dog dog = new Dog();
        dog.eat();

        Animal anonymAnimal = new Animal() {
            //Анонимный класс - наследник класса Animal
            @Override
            public void eat() {
                System.out.println("Cat is eating (anonymous class extends Animal)");
            }
        };
        anonymAnimal.eat();

        Movable movableMouse = new Movable() {
            //Анонимный класс реализующий интерфейс
            @Override
            public void move() {
                System.out.println("Mouse is moving (anonymous class implements interface");
            }
        };
        movableMouse.move();

    }
}
