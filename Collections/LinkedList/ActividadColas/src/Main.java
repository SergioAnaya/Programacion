import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        Colas colas = new Colas();
        Interfaz interfaz = new Interfaz();

        // El menú principal hay que moverlo a Interfaz

        int opcionMenu = 0;

        while (opcionMenu <= 3) {

            System.out.println("\n1. Añadir un nuevo paciente" +
                    "\n2. Elegir siguiente paciente" +
                    "\n3. Mostrar contenido de las colas de espera" +
                    "\nOpción:");

            opcionMenu = teclado.nextInt();

            if (opcionMenu == 1) {
                interfaz.menu();
                colas.añadirPaciente();
            } else if (opcionMenu == 2) {
                System.out.println("Hola");
            } else if (opcionMenu == 3) {
                System.out.println(colas);
            }

        }
    }
}


