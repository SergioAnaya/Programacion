import java.util.Scanner;

public class eje5 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("Multiplos de: ");
        int numero = teclado.nextInt();

        for (int i = 1; i < 200; i++) {
            if (numero % i == 0) {
                System.out.println(i);
            }
        }
    }
}
