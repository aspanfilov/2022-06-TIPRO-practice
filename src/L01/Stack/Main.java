package L01.Stack;

public class Main {
    public static void main(String[] args) {

        Stack<Dog> dogs = new Stack<>();
        System.out.println(dogs);

        Dog dog1 = new Dog("dog1");
        System.out.println(dog1);
        Dog dog2 = new Dog("dog2");
        System.out.println(dog2);
        Dog dog3 = new Dog("dog3");
        System.out.println(dog3);
        Dog dog4 = new Dog("dog4");
        System.out.println(dog4);
        Dog dog5 = new Dog("dog5");
        System.out.println(dog5);

        dogs.push(dog1);
        System.out.println(dogs);
        dogs.push(dog2);
        System.out.println(dogs);
        dogs.push(dog3);
        System.out.println(dogs);
        dogs.push(dog4);
        System.out.println(dogs);
        dogs.push(dog5);
        System.out.println(dogs);

        for (int i = 0; i < 6; i++) {
            System.out.println("Достаем элемент: " + dogs.pop());
            System.out.println("Состояние текущего стэка: " + dogs);
        }


    }
}
