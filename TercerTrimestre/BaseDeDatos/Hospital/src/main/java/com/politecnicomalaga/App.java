package com.politecnicomalaga;

import com.politecnicomalaga.Modelo.Paciente;
import com.politecnicomalaga.Persistencia.DAO.MYSQL.PacienteMYSQL;
import com.politecnicomalaga.Persistencia.DBConnection;

import java.sql.SQLException;

public class App {

    /**
     * Registrar, Consultar, Modificar y Eliminar los datos del paciente, el médico y el historial clínico. PacienteDAO, MedicoDAO y HistorialClinicoDAO.
     * Getters y Setters para cada uno.
     *
     * Menú Principal:
     *
     *  1. Gestionar Paciente
     *  2. Gestionar Médicos
     *  3. Gestionar Historial Clinico
     *  4. Salir
     *
     * Submenu para cada entidad:
     *
     *  1. Registrar x (Pedir los datos de un paciente a registrar.)
     *  2. Mostrar x (Mostrar todos los pacientes registrados con sus atributos.)
     *  3. Modificar x (Modificar los atributos de un paciente a partir del IdPaciente, si el IdPaciente no existe decir x no encontrado.)
     *  4. Eliminar x (Pedir el IdPaciente y eliminarlo, si el IdPaciente no existe decir x no encontrado.)
     *  5. Atrás
     */

    public static void main(String[] args) throws SQLException {

        DBConnection dbConnection = new DBConnection();


        PacienteMYSQL pacienteMYSQL = new PacienteMYSQL(dbConnection.conectar());

        Paciente paciente = new Paciente("Francisco", "Rodriguez", 21, "Femenino");
        //pacienteMYSQL.crear(paciente);

        //Paciente paciente = pacienteMYSQL.obtener("3");

        //pacienteMYSQL.eliminar(pacienteMYSQL.obtener("6"));

        System.out.println(pacienteMYSQL.obtenerTodos());
        dbConnection.desconectar();

    }

}
