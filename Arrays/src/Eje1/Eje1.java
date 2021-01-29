package Eje1;

import java.util.Scanner;

public class Eje1 {

    public int[] rellenar() {

        Scanner teclado = new Scanner(System.in);

        int nValores;

        System.out.println("¿Cuantos números quieres introducir?");
        nValores = teclado.nextInt();

        int datos [] = new int[nValores];

        for (int i = 0; i < nValores; i++) {
            System.out.println("Introduce el número " + (i + 1) + ":");
            datos[i] = teclado.nextInt();
        }
        return datos;
    }

    public int suma (int [] datos) {
        int total = 0;

        for (int i = 0; i < datos.length; i++) {
            total+=datos[i];
        }
        return total;
    }

    public static void main(String[] args) {
        Eje1 main = new Eje1();

        int [] datos = main.rellenar();

        System.out.println("La suma total de los valores del array son: " + main.suma(datos));


    }
}
