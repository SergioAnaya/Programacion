import java.util.Scanner;

public class eje2 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int countpositivo = 0;
        int countnegativo = 0;

        for (int i = 1; i <= 10; i++) {
            System.out.println("Introduce un número");
            int num = teclado.nextInt();

            if (num >= 0) {
                countpositivo++;
            } else {
                countnegativo++;
            }
        }
        System.out.println("Hay una cantidad de " + countpositivo + " positivos");
        System.out.println("Hay una cantidad de " + countnegativo + " negativos");
    }
}
