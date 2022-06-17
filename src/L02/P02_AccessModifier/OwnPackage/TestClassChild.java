package L02.P02_AccessModifier.OwnPackage;

public class TestClassChild extends TestClass{
    String getsome() {

        this.publicField = "publicField";
        this.protectedField = "protectedField";
        this.defaultField = "defaultField";

        return null;
    }
}
