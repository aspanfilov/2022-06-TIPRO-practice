package L02.P01_Static;

public class Main {
    public static void main(String[] args) {
        //Пример работы со Static полями, методами
        System.out.println(TestClass.staticMethod_GetData());

        var testObject = new TestClass();
        System.out.println(testObject.ordinaryMethod_GetData());
    }
}
