package L02.P02_AccessModifier.AnotherPackage;

import L02.P02_AccessModifier.OwnPackage.TestClass;
import L02.P02_AccessModifier.OwnPackage.TestClassChild;

public class Main {
    public static void main(String[] args) {
        //Видимость полей из другого пакета

        TestClass testClass = new TestClass();
        testClass.publicField = "publicField";

        TestClassChild testClassChild = new TestClassChild();
        testClassChild.publicField = "publicField";
    }
}
