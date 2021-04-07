package com.politecnicomalaga;

import java.util.Scanner;

public class vistaHospital {

    /**
     * Instancias
     */

    Interfaz interfaz = new Interfaz();

    /**
     * Constantes Menú Principal
     */

    private final static int OP_GESTIONAR_PACIENTE = 1;
    private final static int OP_GESTIONAR_MEDICO = 2;
    private final static int OP_GESTIONAR_HISTORIAL_CLINICO = 3;
    private final static int OP_TERMINAR_MENU_PRINCIPAL = 4;

    /**
     * Constantes Submenús
     */

    private final static int OP_REGISTRAR = 1;
    private final static int OP_MOSTRAR = 2;
    private final static int OP_MODIFICAR = 3;
    private final static int OP_ELIMINAR = 4;
    private final static int OP_TERMINAR_SUBMENU = 5;

    /**
     *
     */

    public int mostrarMenuPrincipal () {
        interfaz.imprimirMenuPrincipal();
        return interfaz.leerRespuestaMenuPrincipal();
    }

    /**
     *
     */

    public int mostrarSubmenuPaciente () {
        interfaz.imprimirSubmenuPaciente();
        return interfaz.leerRespuestaSubmenuPaciente();
    }

    /**
     *
     */

    public int mostrarSubmenuMedico () {
        interfaz.imprimirSubmenuMedico();
        return interfaz.leerRespuestaSubmenuMedico();
    }

    /**
     *
     */

    public int mostrarSubmenuhistorialClinico () {
        interfaz.imprimirSubmenuHistorialClinico();
        return interfaz.leerRespuestaSubmenuHistorialClinico();
    }

    /**
     * Método para el funcionamiento del Programa Principal
     */

    public void programaPrincipal (int opcionMenu) {
        switch (opcionMenu) {
            case OP_GESTIONAR_PACIENTE:
                break;
            case OP_GESTIONAR_MEDICO:
                break;
            case OP_GESTIONAR_HISTORIAL_CLINICO:
                break;
            case OP_TERMINAR_MENU_PRINCIPAL:
                break;
        }
    }

    /**
     * Main
     */

    public static void main(String[] args) {

        vistaHospital vistaHospital = new vistaHospital();

        int opcionMenu = 0;

        do {
            opcionMenu = vistaHospital.mostrarMenuPrincipal();
            if (opcionMenu != OP_TERMINAR_MENU_PRINCIPAL) vistaHospital.programaPrincipal(opcionMenu);
        } while (opcionMenu != OP_TERMINAR_MENU_PRINCIPAL);

    }

}