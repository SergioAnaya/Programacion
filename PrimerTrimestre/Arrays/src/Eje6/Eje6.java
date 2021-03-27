package Eje6;

import java.util.Scanner;

public class Eje6 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner (System.in);

        System.out.println("Longitud del array: ");
        int longitud = teclado.nextInt();

        int [] array = new int[longitud];

        for (int i = 0; i < longitud; i++) {
            System.out.println("Valores del array:");
            array[i] = teclado.nextInt();
        }

        for (int x:array) {
            for (int i = 0; i < x; i++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }
}
