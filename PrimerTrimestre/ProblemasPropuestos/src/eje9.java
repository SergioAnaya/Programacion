import java.util.Scanner;

public class eje9 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int numero;
        int contadornumeros = 0;
        int contadorpares = 0;
        int contadorimpares = 0;
        int contadorpares2 = 0;
        int contadorimpares2 = 0;

        do {
            System.out.println("\nIntroduce número\n");
            numero = teclado.nextInt();
            contadornumeros++;

            if (numero % 2 == 0) {
                contadorpares++;
                contadorpares2 = contadorpares - 1; // Arreglo para que no cuente el número negativo en caso de ser par
            } else {
                contadorimpares++;
                contadorimpares2 = contadorimpares - 1; // Arreglo para que no cuente el número negativo en caso de ser impar
            }
        } while (numero > 0);

        System.out.println("\nSe han introducido un total de: " + (contadornumeros - 1) + " números sin contar el negativo.");
        System.out.println("\nSe han introducir un total de: " + contadorpares2 + " números pares.");
        System.out.println("\nSe han introducir un total de: " + contadorimpares2 + " números impares.");
    }
}
