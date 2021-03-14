package Modelo;

public class PorHoras extends Empleado {

    /**
     * Variables
     */

    private double sueldoPorHora;
    private double horasTrabajadas;

    /**
     * Constructor
     */

    public PorHoras (int id, String nombre, String apellidos, double sueldoPorHora, double horasTrabajadas) {
        super(id, nombre, apellidos);
        this.sueldoPorHora = sueldoPorHora;
        this.horasTrabajadas = horasTrabajadas;
    }

    /**
     * Getter para obtener el sueldo de dicho tipo de empleado
     */

    @Override
    public double getSueldo() {
        return sueldoPorHora * horasTrabajadas;
    }

    /**
     * Getter para obtener el tipo de empleado
     */

    @Override
    public int getTipo() {
        return Empleado.POR_HORAS;
    }

    /**
     * Setter para cambiar el sueldo por hora
     */

    public void setSueldoPorHora(double sueldoPorHora) {
        this.sueldoPorHora = sueldoPorHora;
    }

    @Override
    public String toString() {
        return "\n" + super.toString() +
                "\nSueldo por hora: " + sueldoPorHora +
                "\nHoras trabajadas: " + horasTrabajadas;
    }
}