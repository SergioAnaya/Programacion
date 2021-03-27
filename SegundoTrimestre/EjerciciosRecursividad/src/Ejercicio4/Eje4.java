package Ejercicio4;

public class Eje4 {

    String cadena = "Esto es una cadena";

    public void printReversed (String text, int index) {
        if (text.length()-1 == index) System.out.print(cadena.charAt(index));

        else {
            printReversed(text, index + 1);

            System.out.print(cadena.charAt(index));
        }
    }

    public static void main(String[] args) {
        String cadena = "Esto es una cadena";

        Eje4 eje4 = new Eje4();

        eje4.printReversed(cadena, 0);
    }

}