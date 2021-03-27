import Modelo.Asalariado;
import Modelo.Comisionado;
import Modelo.Empleado;
import Modelo.PorHoras;
import Persistencia.LectorEmpleados;
import Persistencia.SueldoBase;

import java.util.*;

public class Nomina {

    /**
     * Constantes
     */

    private final static String ARCHIVO_EMPLEADOS = "empleados.xml";
    private final static String ARCHIVO_SUELDO_BASE = "sueldo_base.csv";

    /**
     * Variables
     */

    private List<Empleado> listaEmpleados;
    private Map<Integer, Double> sueldosBase;

    /**
     * Método para cargar los empleados en la lista de empleados y los sueldos bases en la lista de sueldos bases
     */

    public void cargarEmpleado () {

        /**
         * Estos métodos leen los archivos y los vuelcan a las listas correspondientes
         */

        SueldoBase sueldoBase = new SueldoBase(ARCHIVO_SUELDO_BASE);
        sueldosBase = sueldoBase.read();

        LectorEmpleados lectorEmpleados = new LectorEmpleados(ARCHIVO_EMPLEADOS);
        listaEmpleados = lectorEmpleados.read();

        /**
         * Este método sobreescribe los sueldo bases de los empleados
         */

        asignarSueldoBase(sueldosBase, listaEmpleados);

        //System.out.println(listaEmpleados);
    }

    public List<Empleado> getEmpleados () { return listaEmpleados; }

    public double calcularSueldo (int idEmpleado) {
        for (Empleado empleado : listaEmpleados) {
            if (empleado.getId() == idEmpleado) {
                return empleado.getSueldo();
            }
        }
        throw new NoSuchElementException ("No se encuentra el empleado");
    }

    public void cambiarSueldoBase (int tipoEmpleado, double sueldo) {

        /**
         * Se sobreescribe (guardar) la lista de sueldos base
         */

        sueldosBase.replace(tipoEmpleado, sueldo);

        /**
         * Se recorre la lista de empleados, se filtra por el tipo y se usa el método asignarSueldoBaseAEmpleado
         */

        for (Empleado empleado : listaEmpleados) {
            if (empleado.getTipo() == tipoEmpleado) {
                asignarSueldoBaseAEmpleado(empleado, sueldo);
            }
        }
    }

    /**
     * Método para sobreescribir (guardar) el documento de sueldo base, complementario al método de cambiarSueldoBase
     */

    public void guardarSueldoBase () {
        SueldoBase sueldoBase = new SueldoBase(ARCHIVO_SUELDO_BASE);
        sueldoBase.writeSueldoBase(sueldosBase);
    }

    /**
     * Método para mostrar el empleado que más cobra y el que menos
     */

    public Empleado getEmpleadoMejorPagado () {
        ordernarPorSueldo();
        return listaEmpleados.get(0);
    }

    public Empleado getEmpleadoPeorPagado () {
        return listaEmpleados.get(listaEmpleados.size() - 1);
    }



    /**
     * Método para cargar el sueldo base de cada tipo de empleado por primera vez, este método sobreescribe el sueldo
     * de los empleados por primera vez usando los datos del documento
     */

    private void asignarSueldoBase (Map<Integer, Double> sueldosBase, List<Empleado> listaEmpleados) {

        /**
         * Se recorre la lista de empleados, se llama al método asignarSueldoBaseAEmpleado por cada iteración,
         * este filtra el tipo de empleado y le añade el sueldo base estipulado en el indice del mapa en el que
         * se encuentra el tipo del empleado
         */

        for (Empleado empleado : listaEmpleados) {
            asignarSueldoBaseAEmpleado(empleado, sueldosBase.get(empleado.getTipo()));
        }
    }

    /**
     * Método para cambiar el sueldo base de cada tipo de empleado
     */

    private void asignarSueldoBaseAEmpleado (Empleado empleado, double sueldo) {
        switch (empleado.getTipo()) {
            case Empleado.COMISIONADO:
                ((Comisionado) empleado).setSueldoBase(sueldo);
                break;
            case Empleado.POR_HORAS:
                ((PorHoras) empleado).setSueldoPorHora(sueldo);
                break;
            case Empleado.ASALARIADO:
                ((Asalariado) empleado).setSueldoFijo(sueldo);
                break;
        }
    }

    /**
     * Método para ordenar los empleados por sueldos
     */

    private void ordernarPorSueldo () {
        Collections.sort(listaEmpleados, new Comparator<Empleado>() {
            @Override
            public int compare(Empleado empleado1, Empleado empleado2) {
                if (empleado1.getSueldo() < empleado2.getSueldo()) return 1;
                else if (empleado1.getSueldo() > empleado2.getSueldo()) return 0;
                else return 0;
            }
        });
    }

}
