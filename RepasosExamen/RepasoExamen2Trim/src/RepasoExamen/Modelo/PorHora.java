package RepasoExamen.Modelo;

import RepasoExamen.Nomina;

public class PorHora extends Empleado {


    /**
     * PorHoras: Cobran una cierta cantidad por cada hora trabajada, sueldo*horasTrabajadas.
     */

    /**
     * Instancias
     */

    Nomina nomina = new Nomina();

    static String sueldo;
    String horas;

    public PorHora () {}

    public PorHora (String id, String nombre, String apellido, String tipo, String horas) {
        super(id, nombre, apellido, tipo);
        this.horas = horas;
    }

    public String getHoras() {
        return horas;
    }

    @Override
    public String sueldo() {
        for (int i = 0; i < nomina.getTiposSueldos().size(); i++) {
            if (nomina.getTiposSueldos().get(i).getTipo().equals(POR_HORAS)) {
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
                "\nHoras: " + horas +
                "\nSueldo: " + sueldo + "\n";
    }
}