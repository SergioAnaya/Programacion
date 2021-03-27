public class Paciente {

    private String nombre;
    private int edad;
    private int idEpecialidad;
    private String incidenciaGravedad;

    public Paciente(String nombre, int edad, int idEpecialidad, String incidenciaGravedad) {
        this.nombre = nombre;
        this.edad = edad;
        this.idEpecialidad = idEpecialidad;
        this.incidenciaGravedad = incidenciaGravedad; // Muy Grave - Estable
    }

    public int getIdEpecialidad() {
        return idEpecialidad;
    }

    public String getIncidenciaGravedad() {
        return incidenciaGravedad;
    }

    @Override
    public String toString() {
        return "\nNombre: " + nombre + ", " +
                "Edad: " + edad + ", " +
                "Id de especialidad: " + idEpecialidad + ", " +
                "Incidencia de Gravedad: " + incidenciaGravedad;
    }
}