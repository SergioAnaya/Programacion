import java.util.Scanner;

public class eje14 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("Introducir palabra: \n");
        String palabra = teclado.nextLine();

        for (int i = 0; i <= palabra.length(); i++) {
            System.out.println(palabra.substring(0,i));
        }

    }

}
