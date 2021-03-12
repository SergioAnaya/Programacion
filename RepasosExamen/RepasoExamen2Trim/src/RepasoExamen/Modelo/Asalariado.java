package RepasoExamen.Modelo;

import RepasoExamen.Nomina;

public class Asalariado extends Empleado {

    /**
     * Asalariado: Cobran un sueldo base, y un sueldo extra por venta realizada.
     */

    /**
     * Instancias
     */

    Nomina nomina = new Nomina();

    static String sueldo;

    public Asalariado () {}

    public Asalariado (String id, String nombre, String apellido, String tipo) {
        super(id, nombre, apellido, tipo);
    }

    @Override
    public String sueldo() {
        for (int i = 0; i < nomina.getTiposSueldos().size(); i++) {
            if (nomina.getTiposSueldos().get(i).getTipo().equals(ASALARIADO)) {
                sueldo = nomina.getTiposSueldos().get(i).getValor();
            }
        }
        return sueldo;
    }

    @Override
    public String toString() {

        return "\nId: " + id +
                "\nNombre: " + nombre +
                "\nApellidos: " + apellido +
                "\nTipo: " + tipo +
                "\nSueldo: " + sueldo + "\n";
    }
}