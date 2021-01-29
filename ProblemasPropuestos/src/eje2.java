import java.util.Scanner;

public class eje2 {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int numrandom = (int) (Math.random() * 10) + 1;
        int maximo = -1;
        String cadena = "";

        System.out.println("Número de cadenas: " + numrandom);

        for (int i = 0; i < numrandom; i++) {
            System.out.println("Introduce la cadena de texto: ");
            String texto = teclado.nextLine();

            int largo = texto.length();

            if (largo > maximo) {
                maximo = largo;
                cadena = texto;
            }
        }
        System.out.println("La cadena más larga es: " + cadena);
    }
}
