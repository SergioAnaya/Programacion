package Ejercicio1;

import java.util.Scanner;

public class Eje1 {

    public int factorial (int valor) {

        if (valor == 0) return 1;

        else return valor * factorial(valor-1);

    }

    public static void main(String[] args) {
        Eje1 eje1 = new Eje1();

        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce el número:");
        int valor = teclado.nextInt();

        System.out.println("El factorial de " + valor + ": " + eje1.factorial(valor));
    }

}
