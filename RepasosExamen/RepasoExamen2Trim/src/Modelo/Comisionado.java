package Modelo;

public class Comisionado extends Empleado {

    /**
     * Variables
     */

    private double sueldoBase;
    private int numeroVentas;
    private double comision = 10;

    /**
     * Constructor
     */

    public Comisionado (int id, String nombre, String apellidos, double sueldoBase, double comision, int numeroVentas) {
        super(id, nombre, apellidos);
        this.sueldoBase = sueldoBase;
        this.comision = comision;
        this.numeroVentas = numeroVentas;
    }

    /**
     * Getter para obtener el sueldo de dicho tipo de empleado
     */

    @Override
    public double getSueldo() {
        return sueldoBase + (numeroVentas * comision);
    }

    /**
     * Getter para obtener el tipo de empleado
     */

    @Override
    public int getTipo() {
        return Empleado.COMISIONADO;
    }

    /**
     * Setter para cambiar el sueldo base
     */

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    @Override
    public String toString() {
        return "\n" + super.toString() +
                "\nSueldo Base: " + sueldoBase +
                "\nNúmero de Ventas: " + numeroVentas +
                "\nComision: " + comision;
    }
}