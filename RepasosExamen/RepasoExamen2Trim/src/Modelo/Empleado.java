package Modelo;

public abstract class Empleado {

    /**
     * Constantes
     */

    // Se definen así los tipos para mayor facilidad y mayor compatibilidad con uno de los métodos que se piden

    public final static int COMISIONADO = 1;
    public final static int POR_HORAS = 2;
    public final static int ASALARIADO = 3;

    /**
     * Variables
     */

    int id;
    String nombre, apellidos;

    /**
     * Constructor
     */

    public Empleado(int id, String nombre, String apellidos) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    /**
     * Getters y Setters
     */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Métodos abstractos
     */

    public abstract double getSueldo ();

    public abstract int getTipo ();

    @Override
    public String toString() {
        return "\nID: " + id +
                "\nNombre: " + nombre +
                "\nApellidos: " + apellidos +
                "\nSueldo: " + getSueldo();
    }
}