import java.util.Scanner;

public class Interfaz {

    Scanner teclado = new Scanner(System.in);
    Paciente paciente;

    public void menu () {
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