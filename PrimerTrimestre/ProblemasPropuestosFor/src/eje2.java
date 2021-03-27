import java.util.Scanner;

public class eje2 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int contador = 1;
        int suma = 0;

        for (int i = 1; i <= 10; i++) {
            System.out.println("Introduce el número " + contador);
            int valor = teclado.nextInt();
            contador++;

            if (i > 5) {
                suma = suma + valor;
            }
        }
        System.out.println("\nSuma de los 5 últimos números: " + suma);
    }
}
