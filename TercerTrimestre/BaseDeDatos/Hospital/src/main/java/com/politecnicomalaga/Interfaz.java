package com.politecnicomalaga;

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
        System.out.println("        Menú Principal" +
                "\n1. Gestionar Paciente" +
                "\n2. Gestionar Médico" +
                "\n3. Gestionar Historial Clínico" +
                "\n4. Salir");
    }

    public int leerRespuestaMenuPrincipal () {
        return teclado.nextInt();
    }

    /**
     * Métodos para mostrar el Submenú de Paciente
     */

    public void imprimirSubmenuPaciente() {
        System.out.println("        Submenú de Paciente" +
                "\n1. Registrar Paciente" +
                "\n2. Mostrar Paciente" +
                "\n3. Modificar Paciente" +
                "\n4 Eliminar Paciente" +
                "\n5. Atrás");
    }

    public int leerRespuestaSubmenuPaciente() {
        return teclado.nextInt();
    }

    /**
     * Métodos para mostrar el Submenú de Médico
     */

    public void imprimirSubmenuMedico () {
        System.out.println("        Submenú de Médico" +
                "\n1. Registrar Médico" +
                "\n2. Mostrar Médico" +
                "\n3. Modificar Médico" +
                "\n4 Eliminar Médico" +
                "\n5. Atrás");
    }

    public int leerRespuestaSubmenuMedico () {
        return teclado.nextInt();
    }

    /**
     * Métodos para mostrar el Submenú de Historial Clínico
     */

    public void imprimirSubmenuHistorialClinico () {
        System.out.println("        Submenú de Historial Clínico" +
                "\n1. Registrar Historial Clínico" +
                "\n2. Mostrar Historial Clínico" +
                "\n3. Modificar Historial Clínico" +
                "\n4 Eliminar Historial Clínico" +
                "\n5. Atrás");
    }

    public int leerRespuestaSubmenuHistorialClinico () {
        return teclado.nextInt();
    }

}
