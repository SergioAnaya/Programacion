import java.util.Scanner;

public class eje5 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("¿Quieres que funcione el reloj?");
        String opcion = teclado.next();

            if (opcion.equals("s")) {
                while (opcion.equals("s")) {
                    for (int h = 0; h <= 23; h++) {
                        for (int m = 0; m <= 59; m++) {
                            for (int s = 0; s <= 59; s++)
                                System.out.println(h + ":" + m + ":" + s + "\n" );
                        }
                    }
                    System.out.println("Repetir reloj");
                    opcion = teclado.next();
                }
                System.out.println("\nFinalizando reloj");
            } else if (opcion.equals("n")) {
                System.out.println("\nFinalizando reloj");
            } else {
                System.out.println("Introduce una opción válida");
            }
    }
}