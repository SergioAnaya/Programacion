import java.util.LinkedList;

public class Colas {

    LinkedList<Paciente> neumologia = new LinkedList<Paciente>();
    LinkedList<Paciente> cardiologia = new LinkedList<Paciente>();
    LinkedList<Paciente> toxicologia = new LinkedList<Paciente>();
    LinkedList<Paciente> pediatria = new LinkedList<Paciente>();
    LinkedList<Paciente> psiquiatria = new LinkedList<Paciente>();
    LinkedList<Paciente> radiologia = new LinkedList<Paciente>();
    LinkedList<Paciente> digestivo = new LinkedList<Paciente>();
    LinkedList<Paciente> traumatologia = new LinkedList<Paciente>();
    LinkedList<Paciente> otorrinoLaringologia = new LinkedList<Paciente>();
    LinkedList<Paciente> cirugia = new LinkedList<Paciente>();
    LinkedList<Paciente> oftalmologia = new LinkedList<Paciente>();

    int countneumologia = 0;
    int countcardiologia = 0;
    int counttoxicologia = 0;
    int countpediatria = 0;
    int countpsiquiatria = 0;
    int countradiologia = 0;
    int countdigestivo = 0;
    int counttraumatologia = 0;
    int countotorrinoLaringologia = 0;
    int countcirugia = 0;
    int countoftalmologia = 0;

    public void añadirPaciente (Paciente paciente) {

        if (paciente.getIdEpecialidad() == 1) {
            if (paciente.getIncidenciaGravedad().equals("muy grave")) {
                neumologia.add(paciente);
                countneumologia++;
            } else if (paciente.getIncidenciaGravedad().equals("estable")){
                neumologia.add(paciente);
            } else System.out.println("Error al añadir paciente");
        } else if (paciente.getIdEpecialidad() == 2) {
            if (paciente.getIncidenciaGravedad().equals("muy grave")) {
                cardiologia.add(countcardiologia, paciente);
                countcardiologia++;
            } else if (paciente.getIncidenciaGravedad().equals("estable")){
                cardiologia.add(paciente);
            } else System.out.println("Error al añadir paciente");
        } else if (paciente.getIdEpecialidad() == 3) {
            if (paciente.getIncidenciaGravedad().equals("muy grave")) {
                toxicologia.add(counttoxicologia, paciente);
                counttoxicologia++;
            } else if (paciente.getIncidenciaGravedad().equals("estable")){
                toxicologia.add(paciente);
            } else System.out.println("Error al añadir paciente");
        } else if (paciente.getIdEpecialidad() == 4) {
            if (paciente.getIncidenciaGravedad().equals("muy grave")) {
                pediatria.add(countpediatria, paciente);
                countpediatria++;
            } else if (paciente.getIncidenciaGravedad().equals("estable")){
                pediatria.add(paciente);
            } else System.out.println("Error al añadir paciente");
        } else if (paciente.getIdEpecialidad() == 5) {
            if (paciente.getIncidenciaGravedad().equals("muy grave")) {
                psiquiatria.add(countpsiquiatria, paciente);
                countpsiquiatria++;
            } else if (paciente.getIncidenciaGravedad().equals("estable")){
                psiquiatria.add(paciente);
            } else System.out.println("Error al añadir paciente");
        } else if (paciente.getIdEpecialidad() == 6) {
            if (paciente.getIncidenciaGravedad().equals("muy grave")) {
                radiologia.add(countradiologia, paciente);
                countradiologia++;
            } else if (paciente.getIncidenciaGravedad().equals("estable")){
                radiologia.add(paciente);
            } else System.out.println("Error al añadir paciente");
        } else if (paciente.getIdEpecialidad() == 7) {
            if (paciente.getIncidenciaGravedad().equals("muy grave")) {
                digestivo.add(countdigestivo, paciente);
                countdigestivo++;
            } else if (paciente.getIncidenciaGravedad().equals("estable")){
                digestivo.add(paciente);
            } else System.out.println("Error al añadir paciente");
        } else if (paciente.getIdEpecialidad() == 8) {
            if (paciente.getIncidenciaGravedad().equals("muy grave")) {
                traumatologia.add(counttraumatologia, paciente);
                counttraumatologia++;
            } else if (paciente.getIncidenciaGravedad().equals("estable")){
                traumatologia.add(paciente);
            } else System.out.println("Error al añadir paciente");
        } else if (paciente.getIdEpecialidad() == 9) {
            if (paciente.getIncidenciaGravedad().equals("muy grave")) {
                otorrinoLaringologia.add(countotorrinoLaringologia, paciente);
                countotorrinoLaringologia++;
            } else if (paciente.getIncidenciaGravedad().equals("estable")){
                otorrinoLaringologia.add(paciente);
            } else System.out.println("Error al añadir paciente");
        } else if (paciente.getIdEpecialidad() == 10) {
            if (paciente.getIncidenciaGravedad().equals("muy grave")) {
                cirugia.add(countcirugia, paciente);
                countcirugia++;
            } else if (paciente.getIncidenciaGravedad().equals("estable")){
                cirugia.add(paciente);
            } else System.out.println("Error al añadir paciente");
        } else if (paciente.getIdEpecialidad() == 11) {
            if (paciente.getIncidenciaGravedad().equals("muy grave")) {
                oftalmologia.add(countoftalmologia, paciente);
                countoftalmologia++;
            } else if (paciente.getIncidenciaGravedad().equals("estable")){
                oftalmologia.add(paciente);
            } else System.out.println("Error al añadir paciente");
        }
    }

    public void mostrarSiguientePaciente () {
        if (!neumologia.isEmpty()) {
            System.out.println(neumologia.pop());
        } else if (!cardiologia.isEmpty()) {
            System.out.println(cardiologia.pop());
        } else if (!toxicologia.isEmpty()) {
            System.out.println(toxicologia.pop());
        } else if (!pediatria.isEmpty()) {
            System.out.println(pediatria.pop());
        } else if (!psiquiatria.isEmpty()) {
            System.out.println(psiquiatria.pop());
        } else if (!radiologia.isEmpty()) {
            System.out.println(radiologia.pop());
        } else if (!digestivo.isEmpty()) {
            System.out.println(digestivo.pop());
        } else if (!traumatologia.isEmpty()) {
            System.out.println(traumatologia.pop());
        } else if (!otorrinoLaringologia.isEmpty()) {
            System.out.println(otorrinoLaringologia.pop());
        } else if (!cirugia.isEmpty()) {
            System.out.println(cirugia.pop());
        } else if (!oftalmologia.isEmpty()) {
            System.out.println(oftalmologia.pop());
        }
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