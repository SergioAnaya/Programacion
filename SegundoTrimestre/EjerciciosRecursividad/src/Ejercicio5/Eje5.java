package Ejercicio5;

public class Eje5 {

    public int exponente (int a, int b) {

        int valor = 0;

        if (b > 0) {
            if (b % 2 == 0) {
                valor = (int) Math.pow(Math.pow(a, b / 2), 2); // Math.pow es una función que devuelve la base elevada al exponente
                return valor;
            } else {
                valor = (int) Math.pow(a * Math.pow(a, b / 2), 2);
                return valor;
            }
        } else return -1;

    }

    public static void main(String[] args) {

        Eje5 eje5 = new Eje5();

        System.out.println("Resultado: " + eje5.exponente(3, 6));

    }

}
