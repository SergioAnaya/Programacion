package RepasoExamen;

import RepasoExamen.Modelo.Asalariado;
import RepasoExamen.Modelo.Comisionado;
import RepasoExamen.Modelo.PorHora;


import java.io.IOException;
import java.util.Scanner;

public class Director {

    /**
     * Instancias
     */

    Scanner teclado = new Scanner(System.in);

    Asalariado asalariado = new Asalariado();
    PorHora porHora = new PorHora();
    Comisionado comisionado = new Comisionado();
    Nomina nomina = new Nomina();

    /**
     * Método para inciar la aplicación
     */

    public void iniciar () throws IOException {
        nomina.readCSV();
        nomina.cargarEmpleados();

        comisionado.sueldo();
        porHora.sueldo();
        asalariado.sueldo();

    }

    public void readCSV () throws IOException {
        nomina.readCSV();
    }

    public void listaEmpleados () {
        System.out.println(nomina.getEmpleados().toString().replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(",", ""));
    }

    public void calcularSueldo () throws IOException {
        System.out.print("Id del empleado a calcular el sueldo: ");
        int opcion = teclado.nextInt();


        /*for (Empleado empleado : nomina.getEmpleados()) {
            if (empleado.getId().equals(String.valueOf(opcion))) {

            }
        }*/

        System.out.println("Sueldo del empleado con ID: " + opcion);
        System.out.println(nomina.calcularSueldo(opcion));

    }

    public void cambiarSueldoBase () throws IOException {
        System.out.println("\nCambiar sueldo base de: ");
        System.out.println("\n1. Comisionado" +
                "\n2. Por Horas" +
                "\n3. Asalariado");
        System.out.print("Opción: ");
        int tipoEmpleado = teclado.nextInt();

        if (tipoEmpleado >= 1 && tipoEmpleado <= 3) {
            System.out.print("Nuevo sueldo: ");
            int valorSueldo = teclado.nextInt();
            nomina.cambiarSueldoBase(tipoEmpleado, valorSueldo);
        } else System.out.println("Opción incorrecta");
    }

    public static void main(String[] args) throws IOException {

        Director director = new Director();
        director.iniciar();

        director.listaEmpleados();
        director.calcularSueldo();
        //director.cambiarSueldoBase();

    }
}