import java.util.Scanner;

public class eje4 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int factorial = 1;

        System.out.println("Introduce el número del que queremos sacar el factorial: ");
        int numero = teclado.nextInt();

        for (int i = 1; i <= numero; i++) {
            factorial = factorial * i;
        }
        System.out.println("El factorial de " + numero + " es: " + factorial);
    }
}
