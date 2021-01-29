import java.util.Scanner;

public class eje1 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int contadorPositivo = 0;
        int contadorNegativo = 0;

        for (int i = 0; i < 10; i++) {
            int num1 = (int) (Math.random() * 10) + 1;
            int num2 = (int) (Math.random() * 10) + 1;

            System.out.println(num1 + " * " + num2 + ":");
            int tec1 = teclado.nextInt();

            if (tec1 == num1*num2) {
                contadorPositivo++;
            } else {
                contadorNegativo++;
            }
        }
        if (contadorPositivo >= 5) {
            System.out.println("¡APTO! - Nº de Fallos: " + contadorNegativo);
        } else {
            System.out.println("No apto - Nº de Fallos: " + contadorNegativo);
        }
    }
}
