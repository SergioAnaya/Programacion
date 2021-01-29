import java.util.ArrayList;
import java.util.Scanner;

public class Colas {

    Interfaz interfaz = new Interfaz();

    private ArrayList<Paciente> neumologia = new ArrayList<Paciente>();
    ArrayList<Paciente> cardiologia = new ArrayList<Paciente>();
    ArrayList<Paciente> toxicologia = new ArrayList<Paciente>();
    ArrayList<Paciente> pediatria = new ArrayList<Paciente>();
    ArrayList<Paciente> psiquiatria = new ArrayList<Paciente>();
    ArrayList<Paciente> radiologia = new ArrayList<Paciente>();
    ArrayList<Paciente> digestivo = new ArrayList<Paciente>();
    ArrayList<Paciente> traumatologia = new ArrayList<Paciente>();
    ArrayList<Paciente> otorrinoLaringologia = new ArrayList<Paciente>();
    ArrayList<Paciente> cirugia = new ArrayList<Paciente>();
    ArrayList<Paciente> oftalmologia = new ArrayList<Paciente>();

    int countneumologia = 0;
    int countcardiologia = 0;
    int counttoxicologia = 0;
    int countpediatria = 0;
    int countpsiquiatria = 0;
    int countradiologia = 0;
    int countdigestivo = 0;
    int counttraumatologia = 0;
    int countorrinoLaringologia = 0;
    int countcirugia = 0;
    int countoftalmologia = 0;

    /*public void añadirPaciente () {

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
        Paciente paciente = new Paciente(nombre, edad, idEspecialidad, incidenciaGravedad);

        if (idEspecialidad == 1) {
            if (incidenciaGravedad.equals("muy grave")) {
                neumologia.add(countneumologia, paciente);
                countneumologia++;
            } else if (incidenciaGravedad.equals("estable")){
                neumologia.add(paciente);
            } else System.out.println("Error al añadir paciente");

        } else if (idEspecialidad == 2) {
            if (incidenciaGravedad.equals("muy grave")) {
                cardiologia.add(countcardiologia, paciente);
                countcardiologia++;
            } else if (incidenciaGravedad.equals("estable")){
                cardiologia.add(paciente);
            } else System.out.println("Error al añadir paciente");

        } else if (idEspecialidad == 3) {
            if (incidenciaGravedad.equals("muy grave")) {
                toxicologia.add(counttoxicologia, paciente);
                counttoxicologia++;
            } else if (incidenciaGravedad.equals("estable")){
                toxicologia.add(paciente);
            } else System.out.println("Error al añadir paciente");

        } else if (interfaz.paciente.getIdEpecialidad() == 4) {
            pediatria.add(interfaz.paciente);
        } else if (interfaz.paciente.getIdEpecialidad() == 5) {
            psiquiatria.add(interfaz.paciente);
        } else if (interfaz.paciente.getIdEpecialidad() == 6) {
            radiologia.add(interfaz.paciente);
        } else if (interfaz.paciente.getIdEpecialidad() == 7) {
            digestivo.add(interfaz.paciente);
        } else if (interfaz.paciente.getIdEpecialidad() == 8) {
            traumatologia.add(interfaz.paciente);
        } else if (interfaz.paciente.getIdEpecialidad() == 9) {
            otorrinoLaringologia.add(interfaz.paciente);
        } else if (interfaz.paciente.getIdEpecialidad() == 10) {
            cirugia.add(interfaz.paciente);
        } else if (interfaz.paciente.getIdEpecialidad() == 11) {
            oftalmologia.add(interfaz.paciente);
        } else System.out.println("Error");

    }*/

    public void añadirPaciente () {
        neumologia.add(interfaz.paciente);
    }

    @Override
    public String toString() {
        return "***** Listas de Espera *****" +
                "\nNeumología: " + neumologia +
                "\nCardiología: " + cardiologia +
                "\nToxicología: " + toxicologia +
                "\nPediatría: " + pediatria +
                "\nPsiquiatría: " + psiquiatria +
                "\nRadiología: " + radiologia +
                "\nDigestivo: " + digestivo +
                "\nTraumatología: " + traumatologia +
                "\nOtorrinoLaringología: " + otorrinoLaringologia +
                "\nCirugía: " + cirugia +
                "\nOftalmología: " + oftalmologia;
    }
}