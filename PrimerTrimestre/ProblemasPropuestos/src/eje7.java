import java.util.Scanner;
import java.util.StringTokenizer;

public class eje7 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        String nombre;

        /*do {
            System.out.println("\nIntroduce el nombre completo:\n");
            nombre = teclado.nextLine();

            StringTokenizer separados = new StringTokenizer(nombre);

            while (separados.hasMoreTokens()) {
                String iniciales = separados.nextToken();
                System.out.println(iniciales.substring(0,1));
            }

        } while (nombre.isEmpty());*/


        // Este es algo más completo

        System.out.println("\nIntroduce el nombre completo: ");
        nombre = teclado.nextLine();

        if (nombre != "") {

            StringTokenizer separados = new StringTokenizer(nombre);

            while (separados.hasMoreTokens()) {
                String iniciales = separados.nextToken();
                System.out.print(iniciales.substring(0,1) + ".");
            }
        } else {
            System.out.println("Prueba de nuevo");
        }

    }

}