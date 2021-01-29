public class Paciente {

    private String nombre;
    private int edad;
    private int idEpecialidad;
    private String incidenciaGravedad;

    public Paciente () {}

    public Paciente(String nombre, int edad, int idEpecialidad, String incidenciaGravedad) {
        this.nombre = nombre;
        this.edad = edad;
        this.idEpecialidad = idEpecialidad;
        this.incidenciaGravedad = incidenciaGravedad; // Muy Grave - Estable
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getIdEpecialidad() {
        return idEpecialidad;
    }

    public void setIdEpecialidad(int idEpecialidad) {
        this.idEpecialidad = idEpecialidad;
    }

    public String getIncidenciaGravedad() {
        return incidenciaGravedad;
    }

    public void setIncidenciaGravedad(String incidenciaGravedad) {
        this.incidenciaGravedad = incidenciaGravedad;
    }

    @Override
    public String toString() {
        return "\n*** Pacientes ***" +
                "\nNombre: " + nombre + ", " +
                "Edad: " + edad + ", " +
                "Id de especialidad: " + idEpecialidad + ", " +
                "Incidencia de Gravedad: " + incidenciaGravedad;
    }
}
