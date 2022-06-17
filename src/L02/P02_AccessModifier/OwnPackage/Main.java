package L02.P02_AccessModifier.OwnPackage;

public class Main {
    public static void main(String[] args) {
        //Видимость полей из собственного пакета

        TestClass testClass = new TestClass();

        testClass.publicField = "publicField";
        testClass.protectedField = "protectedField";
        testClass.defaultField = "defaultField";



    }
}
