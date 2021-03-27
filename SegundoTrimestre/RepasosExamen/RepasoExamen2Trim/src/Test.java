import Modelo.Empleado;

public class Test {

    public static void main(String[] args) {
        // Carga de los datos de los empleados
        Nomina nomina = new Nomina();
        nomina.cargarEmpleado();

        // Comprobación de los datos cargados
        System.out.println("--------------------------------------");
        System.out.println("Datos cargados");
        System.out.println(nomina.getEmpleados());

        // Cálculo del sueldo de un empleado
        System.out.println("---------------------------------------");
        System.out.println("Nómina del empleado con id = 1");
        System.out.println(nomina.calcularSueldo(1));

        // Cambio del sueldo base de los empleados comisionados
        System.out.println("----------------------------------------");
        System.out.println("Cambio del sueldo base de los empleados comisionados a 850€");
        nomina.cambiarSueldoBase(Empleado.COMISIONADO,850);
        nomina.guardarSueldoBase();
        System.out.println("La lista de empleados tras modificar el sueldo base es: ");
        System.out.println(nomina.getEmpleados());

        // El empleado mejor pagado
        System.out.println("------------------------------------------");
        System.out.println("El empleado mejor pagado es:");
        System.out.println(nomina.getEmpleadoMejorPagado());

        // El empleado peor pagado
        System.out.println("-------------------------------------------");
        System.out.println("El empleado peor pagado es:");
        System.out.println(nomina.getEmpleadoPeorPagado());
    }
}
