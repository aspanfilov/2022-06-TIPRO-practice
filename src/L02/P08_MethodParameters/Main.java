package L02.P08_MethodParameters;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal("Слон");
        int a = 0;

        System.out.println("Параметры до передачи в метод: ");
        System.out.println(animal.getObjectDescription());
        System.out.println("a = " + a);
        System.out.println();

        testMethod(animal, a);
        System.out.println("вызов метода ");
        System.out.println();

        System.out.println("Параметры после передачи в метод: ");
        System.out.println(animal.getObjectDescription());
        System.out.println("a = " + a);
        System.out.println();

    }

    static void testMethod(Animal animal, int a) {
        a = 1;
        animal.type = "Крокодил";

        System.out.println("Параметры внутри метода: ");
        System.out.println(animal.getObjectDescription());
        System.out.println("a = " + a);
        System.out.println();

    }
}
