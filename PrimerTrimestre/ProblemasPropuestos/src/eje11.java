import java.util.Scanner;

public class eje11 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int numrandom = (int) (Math.random() * 100) + 1;
        int valor;
        int contador = 0;
        int diferencia;

        do {
            System.out.println("Introduce el número:\n");
            valor = teclado.nextInt();
            contador++;
            diferencia = numrandom - valor;

            if (diferencia > 50) {
                System.out.println("\nMuy Frio\n");
            } else if (diferencia > 10 && diferencia <= 50) {
                System.out.println("\nFrío\n");
            } else if (diferencia >= 5 && diferencia <= 10 ) {
                System.out.println("\nCaliente\n");
            } else if (diferencia < 5) {
                System.out.println("\nMuy Caliente\n");
            }

        } while (valor != numrandom);
        System.out.println("Número de intentos: " + contador);

    }

}
