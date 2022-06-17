package L02.P02_AccessModifier.OwnPackage;

public class TestClass {
    public String publicField;
    private String privateField;
    protected String protectedField;
    String defaultField;

    public TestClass() {
        this.publicField = "publicField";
        this.privateField = "privateField";
        this.protectedField = "protectedField";
        this.defaultField = "defaultField";
    }

}
