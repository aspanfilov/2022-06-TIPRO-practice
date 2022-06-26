package L03.P01_Enum;

public class Test {
    public static void main(String[] args) {
        //Object -> Enum -> Season
        Season season = Season.AUTUMN;
        System.out.println("season instance of Season: " + (season instanceof Season));
        System.out.println("season instance of Enum: " + (season instanceof Enum));
        System.out.println("season instance of Object: " + (season instanceof Object));
        System.out.println(season.getClass());
        System.out.println();

        System.out.println("season.toString = " + season);
        System.out.println("Отобразить поле season.translation: " + season.getTranslation());
        System.out.println("Отобразить поле season.temperature: " + season.getTemperature());
        System.out.println();

        System.out.println("Методы enum");
        var name = season.name();
        System.out.println("season.name() = " + name);

        var season2 = Season.valueOf("WINTER");
        System.out.println("Season.valueOf('WINTER') = " + season2);

        var seasonIndex = season2.ordinal();
        System.out.println("Индекс season2 = " + seasonIndex);

    }
}
