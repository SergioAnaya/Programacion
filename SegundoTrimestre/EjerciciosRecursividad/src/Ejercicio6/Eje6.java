package Ejercicio6; // SIN RESOLVER

public class Eje6 {

    public String invert (String text) {

        if (text.length() == 1) return text;

        else return invert(text.substring(1)) + text.charAt(0);

    }

    public static void main(String[] args) {

        Eje6 eje6 = new Eje6();

        System.out.println(eje6.invert("Buenos dias"));

    }

}
