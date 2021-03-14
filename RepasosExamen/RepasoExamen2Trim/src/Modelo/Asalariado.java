package Modelo;

public class Asalariado extends Empleado {

    /**
     * Variables
     */

    private double sueldoFijo;

    /**
     * Constructor
     */

    public Asalariado (int id, String nombre, String apellidos, double sueldoFijo) {
        super(id, nombre, apellidos);
        this.sueldoFijo = sueldoFijo;
    }

    /**
     * Getter para obtener el sueldo de dicho tipo de empleado
     */

    @Override
    public double getSueldo() {
        return sueldoFijo;
    }

    /**
     * Getter para obtener el tipo de empleado
     */

    @Override
    public int getTipo() {
        return Empleado.ASALARIADO;
    }

    /**
     * Setter para cambiar el sueldo por hora
     */

    public void setSueldoFijo (double sueldoFijo) {
        this.sueldoFijo = sueldoFijo;
    }

    @Override
    public String toString() {
        return "\n" + super.toString() +
                "\nSueldo fijo: " + sueldoFijo;
    }
}