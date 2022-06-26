package L03.P01_Enum;

public enum Season {
    SUMMER("Лето", 35),
    AUTUMN("Осень", 10),
    SPRING("Весна", 20),
    WINTER("Зима", -20);

    private String translation;
    private int temperature;

    Season(String translation, int temperature) {
        this.translation = translation;
        this.temperature = temperature;
    }

    public String getTranslation() {
        return this.translation;
    }

    public int getTemperature() {
        return this.temperature;
    }

}
