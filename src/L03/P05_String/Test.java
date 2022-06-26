package L03.P05_String;

import java.util.Locale;

public class Test {
    public static void main(String[] args) {
        String s = " Hello world "; //Попадет в String pool
        String ss = new String("!!!");

        System.out.println("s: " + s);
        System.out.println("ss: " + ss);
        System.out.println("s.length(): " + s.length());
        System.out.println("s.charAt(4): " + s.charAt(4));
        System.out.println("s.concat(ss): " + s.concat(ss));
        System.out.println("s + ss: " + s + ss);
        System.out.println("s.toUpperCase(): " + s.toUpperCase());
        System.out.println("s.toLowerCase(): " + s.toLowerCase());
        System.out.println("s.trim(): " + s.trim());
        System.out.println();

        String s1 = "Any string";
        String s2 = "Any string";
        String s3 = new String("Any string");
        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);
        System.out.println("s3: new(" + s3 + ")");
        System.out.println("s1.equals(s2): " + s1.equals(s2));
        System.out.println("s1 == s2: " + (s1 == s2));
        System.out.println("s1.equals(s3): " + s1.equals(s3));
        System.out.println("s1 == s3: " + (s1 == s3));
        System.out.println();

        System.out.println("s1.compareTo(s): " + s1.compareTo(s));
        System.out.println("s1.compareToIgnoreCase(s): " + s1.compareToIgnoreCase(s));
        System.out.println("s1.startsWith(\"Hello\"): " + s1.startsWith("Any"));
        System.out.println("s1.endsWith(\"string\"): " + s1.endsWith("string"));


    }
}
