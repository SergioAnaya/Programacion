import java.util.Scanner;

public class eje4 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce una base:");
        int base = teclado.nextInt();
        System.out.println("Introduce un exponente");
        int exponente = teclado.nextInt();

        int suma = 1;

        for (int i = 1; i <= exponente; i++) {
            suma = suma * base;

            System.out.println("Base " + base + " elevado a " + i + " = " + suma);
        }
    }
}
