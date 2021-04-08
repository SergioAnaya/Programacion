package com.politecnicomalaga;

import com.politecnicomalaga.Modelo.HistorialClinico;
import com.politecnicomalaga.Modelo.Medico;
import com.politecnicomalaga.Modelo.Paciente;
import com.politecnicomalaga.Persistencia.DAO.MYSQL.MYSQLManager;

import java.sql.SQLException;
import java.util.Scanner;

public class vistaHospital {

    /**
     * Instancias
     */

    Scanner teclado = new Scanner(System.in);
    Interfaz interfaz = new Interfaz();
    MYSQLManager mysqlManager = new MYSQLManager();

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
     * Constructor vacío
     */

    public vistaHospital() throws SQLException {
    }

    /**
     * Método para el funcionamiento del menú principal
     */

    public int mostrarMenuPrincipal () {
        interfaz.imprimirMenuPrincipal();
        return interfaz.leerRespuestaMenuPrincipal();
    }

    /**
     * Métodos para mostrar los submenús y recoger y devolver su respuesta
     */

    public int mostrarSubmenuPaciente () {
        interfaz.imprimirSubmenuPaciente();
        return interfaz.leerRespuestaSubmenuPaciente();
    }

    public int mostrarSubmenuMedico () {
        interfaz.imprimirSubmenuMedico();
        return interfaz.leerRespuestaSubmenuMedico();
    }

    public int mostrarSubmenuhistorialClinico () {
        interfaz.imprimirSubmenuHistorialClinico();
        return interfaz.leerRespuestaSubmenuHistorialClinico();
    }

    /**
     * Métodos de Registrar, Mostrar, Modificar y Eliminar Pacientes
     */

    private void addPaciente () throws SQLException {

        mysqlManager.getPacienteDAO().crear(interfaz.pedirDatosPaciente());

        System.out.println("\nEl Paciente se ha añadido correctamente");
    }

    private void mostrarPacientes () throws SQLException {
        System.out.println(mysqlManager.getPacienteDAO().obtenerTodos());
    }

    private void modificarPaciente () throws SQLException {
        System.out.print("\nId del Paciente que desea modificar: ");
        String idPaciente = teclado.next();
        Paciente paciente = mysqlManager.getPacienteDAO().obtener(idPaciente);

        if (idPaciente.equals(paciente.getId())) {
            paciente = interfaz.pedirDatosPaciente();
            paciente.setId(idPaciente);
            mysqlManager.getPacienteDAO().modificar(paciente);
        } else System.out.println("\nPaciente no encontrado");

        System.out.println("\n El Paciente se ha modificado correctamente");
    }

    private void eliminarPaciente () throws SQLException {
        System.out.print("\nId del Paciente que desea eliminar: ");
        String idPaciente = teclado.next();
        Paciente paciente = mysqlManager.getPacienteDAO().obtener(idPaciente);

        if (idPaciente.equals(paciente.getId())) {
            mysqlManager.getPacienteDAO().eliminar(paciente);
        } else System.out.println("\nPaciente no encontrado");

        System.out.println("\n El Paciente se ha eliminado correctamente");
    }

    /**
     * Métodos de Registrar, Mostrar, Modificar y Eliminar Médicos
     */

    private void addMedico () throws SQLException {

        mysqlManager.getMedicoDAO().crear(interfaz.pedirDatosMedico());

        System.out.println("\nEl Médico se ha añadido correctamente");
    }

    private void mostrarMedicos () throws SQLException {
        System.out.println(mysqlManager.getMedicoDAO().obtenerTodos());
    }

    private void modificarMedico () throws SQLException {
        System.out.print("\nId del Médico que desea modificar: ");
        String idMedico = teclado.next();
        Medico medico = mysqlManager.getMedicoDAO().obtener(idMedico);

        if (idMedico.equals(medico.getId())) {
            medico = interfaz.pedirDatosMedico();
            medico.setId(idMedico);
            mysqlManager.getMedicoDAO().modificar(medico);
        } else System.out.println("\nMédico no encontrado");

        System.out.println("\n El Médico se ha modificado correctamente");
    }

    private void eliminarMedico () throws SQLException {
        System.out.print("\nId del Médico que desea eliminar: ");
        String idMedico = teclado.next();
        Medico medico = mysqlManager.getMedicoDAO().obtener(idMedico);

        if (idMedico.equals(medico.getId())) {
            mysqlManager.getMedicoDAO().eliminar(medico);
        } else System.out.println("\nMédico no encontrado");
    }

    /**
     * Métodos de Registrar, Mostrar, Modificar y Eliminar Historiales Clínicos
     */

    private void addHistorialClinico () throws SQLException {

        mysqlManager.getHistorialClinicoDAO().crear(interfaz.pedirDatosHistorialClinico());

        System.out.println("\nEl Historial Clínico se ha añadido correctamente");
    }

    private void mostrarHistorialesClinicos () throws SQLException {
        System.out.println(mysqlManager.getHistorialClinicoDAO().obtenerTodos());
    }

    private void modificarHistorialClinico () throws SQLException {
        System.out.print("\nCod del Historial Clínico que desea modificar: ");
        String cod = teclado.next();
        HistorialClinico historialClinico = mysqlManager.getHistorialClinicoDAO().obtener(cod);

        if (cod.equals(historialClinico.getCod())) {
            historialClinico = interfaz.pedirDatosHistorialClinico();
            historialClinico.setCod(cod);
            mysqlManager.getHistorialClinicoDAO().modificar(historialClinico);
        } else System.out.println("\nHistorial Clínico no encontrado");

        System.out.println("\n El Historial Clínico se ha modificado correctamente");
    }

    private void eliminarHistorialClinico () throws SQLException {
        System.out.print("\nCod del Historial Clínico que desea eliminar: ");
        String cod = teclado.next();
        HistorialClinico historialClinico = mysqlManager.getHistorialClinicoDAO().obtener(cod);

        if (cod.equals(historialClinico.getCod())) {
            mysqlManager.getHistorialClinicoDAO().eliminar(historialClinico);
        } else System.out.println("\nHistorial Clínico no encontrado");
    }

    /**
     * Método para el funcionamiento del Programa Principal
     */

    public void programaPrincipal (int opcionMenu) throws SQLException {
        switch (opcionMenu) {
            case OP_GESTIONAR_PACIENTE: bucleParaSubmenuPaciente();
                break;
            case OP_GESTIONAR_MEDICO: bucleParaSubmenuMedico();
                break;
            case OP_GESTIONAR_HISTORIAL_CLINICO: bucleParaSubmenuHistorialClinico();
                break;
        }
    }

    /**
     * Métodos para el funcionamiento de los Submenús
     */

    private void submenuPaciente (int opcionMenu) throws SQLException {
        switch (opcionMenu) {
            case OP_REGISTRAR: addPaciente();
                break;
            case OP_MOSTRAR: mostrarPacientes();
                break;
            case OP_MODIFICAR: modificarPaciente();
                break;
            case OP_ELIMINAR: eliminarPaciente();
                break;
        }
    }

    private void submenuMedico (int opcionMenu) throws SQLException {
        switch (opcionMenu) {
            case OP_REGISTRAR: addMedico();
                break;
            case OP_MOSTRAR: mostrarMedicos();
                break;
            case OP_MODIFICAR: modificarMedico();
                break;
            case OP_ELIMINAR: eliminarMedico();
                break;
        }
    }

    private void submenuHistorialClinico (int opcionMenu) throws SQLException {
        switch (opcionMenu) {
            case OP_REGISTRAR: addHistorialClinico();
                break;
            case OP_MOSTRAR: mostrarHistorialesClinicos();
                break;
            case OP_MODIFICAR: modificarHistorialClinico();
                break;
            case OP_ELIMINAR: eliminarHistorialClinico();
                break;
        }
    }

    /**
     * Métodos que realizan los búcles de repetición de los Submenús
     */

    private void bucleParaSubmenuPaciente () throws SQLException {
        int opcionMenu = 0;
        do {
            opcionMenu = mostrarSubmenuPaciente();
            if (opcionMenu != OP_TERMINAR_SUBMENU) submenuPaciente(opcionMenu);
        } while (opcionMenu != OP_TERMINAR_SUBMENU);
    }

    private void bucleParaSubmenuMedico () throws SQLException {
        int opcionMenu = 0;
        do {
            opcionMenu = mostrarSubmenuMedico();
            if (opcionMenu != OP_TERMINAR_SUBMENU) submenuMedico(opcionMenu);
        } while (opcionMenu != OP_TERMINAR_SUBMENU);
    }

    private void bucleParaSubmenuHistorialClinico () throws SQLException {
        int opcionMenu = 0;
        do {
            opcionMenu = mostrarSubmenuhistorialClinico();
            if (opcionMenu != OP_TERMINAR_SUBMENU) submenuHistorialClinico(opcionMenu);
        } while (opcionMenu != OP_TERMINAR_SUBMENU);
    }

    /**
     * Main
     */

    public static void main(String[] args) throws SQLException {

        vistaHospital vistaHospital = new vistaHospital();

        int opcionMenu = 0;

        do {
            opcionMenu = vistaHospital.mostrarMenuPrincipal();
            if (opcionMenu != OP_TERMINAR_MENU_PRINCIPAL) vistaHospital.programaPrincipal(opcionMenu);
        } while (opcionMenu != OP_TERMINAR_MENU_PRINCIPAL);

    }

}