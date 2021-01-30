import java.util.Scanner;

public class Interfaz {

    Scanner teclado = new Scanner(System.in);
    Colas colas = new Colas();
    Paciente paciente;

    public void menu () {

        int opcionMenu = 0;

        while (opcionMenu <= 3) {

            System.out.println("\n1. Añadir un nuevo paciente" +
                    "\n2. Elegir siguiente paciente" +
                    "\n3. Mostrar contenido de las colas de espera" +
                    "\n4. Salir" +
                    "\nOpción:");

            opcionMenu = teclado.nextInt();
            teclado.nextLine();

            if (opcionMenu == 1) {
                menuAñadirPaciente();
                colas.añadirPaciente(paciente);
            } else if (opcionMenu == 2) {
                colas.mostrarSiguientePaciente();
            } else if (opcionMenu == 3) {
                System.out.println(colas);
            } else if (opcionMenu == 4) {
                System.out.println("\nHa salido correctamente");
            }
        }
    }

    public void menuAñadirPaciente () {

        System.out.println("Nombre: ");
        String nombre = teclado.nextLine();
        System.out.println("Edad: ");
        int edad = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Id de especialidad: ");
        int idEspecialidad = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Incidencia de gravedad: ");
        String incidenciaGravedad = teclado.nextLine().toLowerCase();
        paciente = new Paciente(nombre, edad, idEspecialidad, incidenciaGravedad);
    }
}