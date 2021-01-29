import java.util.Scanner;

public class eje5 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce un número:");
        int num = teclado.nextInt();

        if ((num % 2) == 0) {
            System.out.println("El número " + num + " es primo." );
        } else {
            System.out.println("El número " + num + " no es primo." );
        }
    }
}
