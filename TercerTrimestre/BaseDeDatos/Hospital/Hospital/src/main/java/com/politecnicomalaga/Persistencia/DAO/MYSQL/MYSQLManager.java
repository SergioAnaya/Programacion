package com.politecnicomalaga.Persistencia.DAO.MYSQL;

import com.politecnicomalaga.Persistencia.DAO.PacienteDAO;
import com.politecnicomalaga.Persistencia.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class MYSQLManager {

    private Connection conn;
    private PacienteDAO pacientes = null;

    public MYSQLManager () throws SQLException {
        DBConnection dbConnection = new DBConnection();
        conn = dbConnection.conectar();
    }

    public PacienteDAO getPacienteDAO () {
        if (pacientes == null) {
            pacientes = new PacienteMYSQL(conn);
        }
        return pacientes;
    }

}
