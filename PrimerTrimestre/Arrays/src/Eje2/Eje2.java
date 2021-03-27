package Eje2;

import Eje1.Eje1; // Importo el método rellenar para crear mi propio array.

public class Eje2 {

    public static int mayor (int [] datos) {
        int mayor = datos[0];

        for (int i = 0; i < datos.length; i++) {
            if (datos[i] > mayor) {
                mayor = datos[i];
            }
        }
        return mayor;
    }

    public static int menor (int [] datos) {
        int menor = datos[0];

        for (int i = 0; i < datos.length; i++) {
            if (datos[i] < menor) {
                menor = datos[i];
            }
        }
        return menor;
    }

    public static void main(String[] args) {
        Eje1 eje1 = new Eje1();
        Eje2 main = new Eje2();

        int [] datos = eje1.rellenar();

        System.out.println("\nEl número mayor de la lista es: " + main.mayor(datos));
        System.out.println("El número menor de la lista es: " + main.menor(datos));
    }
}