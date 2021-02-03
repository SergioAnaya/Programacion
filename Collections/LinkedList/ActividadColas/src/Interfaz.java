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

        System.out.print("Nombre: ");
        String nombre = teclado.nextLine();
        System.out.print("Edad: ");
        int edad = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Id de especialidad: ");
        especialidades();
        int idEspecialidad = teclado.nextInt();
        teclado.nextLine();
        System.out.print("Incidencia de gravedad: ");
        String incidenciaGravedad = teclado.nextLine().toLowerCase();
        paciente = new Paciente(nombre, edad, idEspecialidad, incidenciaGravedad);
    }

    public void especialidades () {
        System.out.println("1. Neumología" +
                "\n2. Cardiología" +
                "\n3. Toxicología" +
                "\n4. Pediatría" +
                "\n5. Psiquiatría" +
                "\n6. Radiología" +
                "\n7. Digestivo" +
                "\n8. Traumatología" +
                "\n9. Otorrino-laringología" +
                "\n10. Cirugía" +
                "\n11. Oftalmología");
    }
}