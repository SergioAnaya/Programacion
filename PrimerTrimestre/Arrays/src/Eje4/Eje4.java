package Eje4;

import java.util.Scanner;

public class Eje4 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner (System.in);

        System.out.println("Longitud de los arrays: ");
        int longitud = teclado.nextInt();

        int [] array1 = new int[longitud];
        int [] array2 = new int[longitud];
        int [] resultado = new int[longitud];

        for (int i = 0; i < longitud; i++) {
            System.out.println("Valores del primer array:");
            array1[i] = teclado.nextInt();

            System.out.println("Valores del segundo array:");
            array2[i] = teclado.nextInt();

            resultado[i] = array1[i] * array2[i];
        }

        for (int i = 0; i < longitud; i++) {
            System.out.println(resultado[i]);
        }
    }
}