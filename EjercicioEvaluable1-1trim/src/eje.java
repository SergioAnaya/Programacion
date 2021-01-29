import java.util.Scanner;

public class eje {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

            for (int i = 0; i < 3; i++) {
                System.out.println("Usuario: ");
                String user = teclado.next();
                System.out.println("Contraseña: ");
                String pass = teclado.next();
                if (user.equals("hola") && pass.equals("adios")) {
                    System.out.println("\nACCESO CONCEDIDO");
                    break;
                } else if (i == 2) {
                    System.out.println("\nUsuario bloqueado. Contacte con el dpto. de informática.");
                    break;
                } else {
                    System.out.println("\nUsuario y contraseña incorrectos\n");
                }
            }
    }
}
