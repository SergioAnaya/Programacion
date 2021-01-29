import java.util.Scanner;

public class eje8 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int numeros;
        int suma = 0;

        do {
            System.out.println("\nIntroduce número: \n");
            numeros = teclado.nextInt();

            if (numeros != 9999) {
                suma = suma + numeros;
            }
        } while (numeros != 9999);

        System.out.println("\nEl número total es: " + suma + "\n");

        if (suma == 0) {
            System.out.println("El número total es igual a 0");
        } else if (suma < 0) {
            System.out.println("El número total es menor que 0");
        } else {
            System.out.println("El número es mayor que 0");
        }
    }
}
