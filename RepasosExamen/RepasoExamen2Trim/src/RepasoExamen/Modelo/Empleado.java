package RepasoExamen.Modelo;

public abstract class Empleado {

    public final static String COMISIONADO = "comisionado";
    public final static String POR_HORAS = "por_horas";
    public final static String ASALARIADO = "asalariado";

    String id, nombre, apellido, tipo;

    public Empleado () {}

    public Empleado(String id, String nombre, String apellido, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipo() {
        return tipo;
    }

    public abstract String sueldo ();

}