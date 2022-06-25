package L02.P09_TypeCasting;

public class Test {
    public static void main(String[] args) {

//      Авто преобразование типа вверх - без потери данных:
//      byte -> short -> int -> long
//      int -> double
//      short -> float -> double
//      char -> int

        byte byteA = 4;
        int intA = byteA;
        print(byteA, intA);

//      явное преобразование типа вниз - с потерей данных
        int intB = 1111;
        byte byteB = (byte) intB;
        print(intB, byteB);

        //авто преобразование типа с потерей данных
        int intC = 2147483647;
        float floatC = intC;
        print(intC, floatC);

//      авто Преобразование вверх при операциях
//        если один из операндов операции относится к типу double, то и второй операнд преобразуется к типу double
//        если предыдущее условие не соблюдено, а один из операндов операции относится к типу float, то и второй операнд преобразуется к типу float
//        если предыдущие условия не соблюдены, один из операндов операции относится к типу long, то и второй операнд преобразуется к типу long
//        иначе все операнды операции преобразуются к типу int
        int intD = 1000000;
        float floatD = intD + 1f;
        print(floatD);

        //Результат остался целочисленным - преобразование не произошло
        int intE = 7;
        int intE2 = 2;
        var e3 = intE / intE2;
        print(e3);

    }

    public static void print(Object a) {
        System.out.println("Результат: " + a);
    }

    public static void print(Object a, Object b) {
        System.out.println("Было: " + a + " Стало: " + b);
    }
}
