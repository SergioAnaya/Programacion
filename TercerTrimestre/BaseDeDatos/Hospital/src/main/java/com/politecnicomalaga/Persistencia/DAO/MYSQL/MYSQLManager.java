package com.politecnicomalaga.Persistencia.DAO.MYSQL;

import com.politecnicomalaga.Persistencia.DAO.HistorialClinicoDAO;
import com.politecnicomalaga.Persistencia.DAO.MedicoDAO;
import com.politecnicomalaga.Persistencia.DAO.PacienteDAO;
import com.politecnicomalaga.Persistencia.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class MYSQLManager {

    private Connection conn;
    private PacienteDAO pacientes = null;
    private MedicoDAO medicos = null;
    private HistorialClinicoDAO historialesClinicos = null;

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

    public MedicoDAO getMedicoDAO () {
        if (medicos == null) {
            medicos = new MedicoMYSQL(conn);
        }
        return medicos;
    }

    public HistorialClinicoDAO getHistorialClinicoDAO () {
        if (historialesClinicos == null) {
            historialesClinicos = new HistorialClinicoMYSQL(conn);
        }
        return historialesClinicos;
    }

}