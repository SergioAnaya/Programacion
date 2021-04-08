package com.politecnicomalaga;

import com.politecnicomalaga.Modelo.HistorialClinico;
import com.politecnicomalaga.Modelo.Medico;
import com.politecnicomalaga.Modelo.Paciente;

import java.util.Scanner;

public class Interfaz {

    /**
     * Instancias
     */

    Scanner teclado = new Scanner(System.in);

    /**
     * Métodos para mostrar el menú principal de la aplicación
     */

    public void imprimirMenuPrincipal () {
        System.out.println("\n----------------------");
        System.out.println("    Menú Principal");
        System.out.println("----------------------");
        System.out.print("\n1. Gestionar Paciente" +
                "\n2. Gestionar Médico" +
                "\n3. Gestionar Historial Clínico" +
                "\n4. Salir" +
                "\nOpción: ");
    }

    public int leerRespuestaMenuPrincipal () {
        return teclado.nextInt();
    }

    /**
     * Métodos para mostrar el Submenú de Paciente y recoger su respuesta
     */

    public void imprimirSubmenuPaciente() {
        System.out.println("\n----------------------");
        System.out.println(" Submenú de Paciente");
        System.out.println("----------------------");


        System.out.print("\n1. Registrar Paciente" +
                "\n2. Mostrar Paciente" +
                "\n3. Modificar Paciente" +
                "\n4. Eliminar Paciente" +
                "\n5. Atrás" +
                "\nOpción: ");
    }

    public int leerRespuestaSubmenuPaciente() {
        return teclado.nextInt();
    }

    /**
     * Métodos para mostrar el Submenú de Médico y recoger su respuesta
     */

    public void imprimirSubmenuMedico () {
        System.out.println("\n----------------------");
        System.out.println(" Submenú de Médico");
        System.out.println("----------------------");


        System.out.print("\n1. Registrar Médico" +
                "\n2. Mostrar Médico" +
                "\n3. Modificar Médico" +
                "\n4. Eliminar Médico" +
                "\n5. Atrás" +
                "\nOpción: ");
    }

    public int leerRespuestaSubmenuMedico () {
        return teclado.nextInt();
    }

    /**
     * Métodos para mostrar el Submenú de Historial Clínico y recoger su respuesta
     */

    public void imprimirSubmenuHistorialClinico () {
        System.out.println("\n----------------------");
        System.out.println(" Submenú de Historial Clínico");
        System.out.println("----------------------");


        System.out.print("\n1. Registrar Historial Clínico" +
                "\n2. Mostrar Historial Clínico" +
                "\n3. Modificar Historial Clínico" +
                "\n4. Eliminar Historial Clínico" +
                "\n5. Atrás" +
                "\nOpción: ");
    }

    public int leerRespuestaSubmenuHistorialClinico () {
        return teclado.nextInt();
    }

    /**
     * Método para pedir los datos del paciente y devolverlo como objeto
     */

    public Paciente pedirDatosPaciente () {
        teclado.nextLine();
        System.out.print("Nombre: ");
        String nombre = teclado.nextLine();
        System.out.print("Apellidos: ");
        String apellidos = teclado.nextLine();
        System.out.print("Edad: ");
        int edad = teclado.nextInt();
        teclado.nextLine();
        System.out.print("Género: ");
        String genero = teclado.next();

        Paciente paciente = new Paciente(nombre, apellidos, edad, genero);

        return paciente;
    }

    /**
     * Método para pedir los datos del médico y devolverlo como objeto
     */

    public Medico pedirDatosMedico () {
        teclado.nextLine();
        System.out.print("Nombre: ");
        String nombre = teclado.nextLine();
        System.out.print("Apellidos: ");
        String apellidos = teclado.nextLine();
        System.out.print("Epecialidad: ");
        String especialidad = teclado.next();

        Medico medico = new Medico(nombre, apellidos, especialidad);

        return medico;
    }

    /**
     * Método para pedir los datos del historial clínico y devolverlo como objeto
     */

    public HistorialClinico pedirDatosHistorialClinico () {
        teclado.nextLine();
        System.out.print("Fecha: ");
        String fecha = teclado.nextLine();
        System.out.print("ID Paciente: ");
        String idPaciente = teclado.nextLine();
        System.out.print("ID Médico: ");
        String idMedico = teclado.nextLine();
        System.out.print("Observación: ");
        String observacion = teclado.nextLine();

        HistorialClinico historialClinico = new HistorialClinico(fecha, idPaciente, idMedico, observacion);

        return historialClinico;
    }

}
