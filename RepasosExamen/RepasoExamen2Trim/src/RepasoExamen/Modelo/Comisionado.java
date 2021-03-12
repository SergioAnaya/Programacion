package RepasoExamen.Modelo;

import RepasoExamen.Nomina;

public class Comisionado extends Empleado {

    /**
     * Instancias
     */

    Nomina nomina = new Nomina();

    /**
     * Comisionados: Cobran un sueldo base, y un sueldo extra por venta realizada.
     */

    static String sueldo;
    String extra, ventas;

    public Comisionado () {}

    public Comisionado (String id, String nombre, String apellido, String tipo, String extra, String ventas) {
        super(id, nombre, apellido, tipo);
        this.extra = extra;
        this.ventas = ventas;
    }

    public String getExtra() {
        return extra;
    }

    public String getVentas() {
        return ventas;
    }

    @Override
    public String sueldo() {
        for (int i = 0; i < nomina.getTiposSueldos().size(); i++) {
            if (nomina.getTiposSueldos().get(i).getTipo().equals(COMISIONADO)) {
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
                "\nExtra: " + extra +
                "\nVentas: " + ventas +
                "\nSueldo: " + sueldo + "\n";
    }
}