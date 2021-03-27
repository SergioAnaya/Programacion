import java.util.Scanner;

public class eje3 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int suma = 0;

        for (int i = 1; i <= 10; i++) {
            System.out.println("\nIntroduce el número " + i + " de la lista.");
            int numero = teclado.nextInt();

            if (i > 5) {
                suma = suma + numero;
            }
        }
        System.out.println("\nLa suma de los últimos 5 números es: " + suma);
    }
}
