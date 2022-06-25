package L02.P01_Static;

public class TestClass {
    public static final String staticData = "static data";
    public final String ordinaryData = "ordinary data";

    public static String staticMethod_GetData() {
        //Из статичного метода доступны только статичные поля

        String data = staticData;

        return data;
    }

    public String ordinaryMethod_GetData() {
        //Из обычного метода доступны статичные и обычные поля

        String data = staticData;
        data = this.ordinaryData;

        return data;
    }
}
