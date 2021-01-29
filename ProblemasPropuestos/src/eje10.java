import java.util.Scanner;

public class eje10 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int valor = 0;
        int sumalista1 = 0;
        int sumalista2 = 0;
        int contadorlista1 = 1;
        int contadorlista2 = 1;

        do {
            System.out.println("Introduce el valor " + contadorlista1 + " de la lista.\n");
            valor = teclado.nextInt();
            sumalista1 = sumalista1 + valor;
            contadorlista1 = contadorlista1 + 1;
        } while (contadorlista1 <= 15);

        do {
            System.out.println("Introduce el valor " + contadorlista2 + " de la lista.\n");
            valor = teclado.nextInt();
            sumalista2 = sumalista2 + valor;
            contadorlista2 = contadorlista2 + 1;
        } while (contadorlista2 <= 15);

        if (sumalista1 > sumalista2) {
            System.out.println("\nLa lista 1 es mayor que la lista 2.");
        } else if (sumalista2 > sumalista1) {
            System.out.println("\nLa lista 2 es mayor que la lista 1.");
        } else {
            System.out.println("\nLas listas tienen el mismo valor");
        }

    }

}
