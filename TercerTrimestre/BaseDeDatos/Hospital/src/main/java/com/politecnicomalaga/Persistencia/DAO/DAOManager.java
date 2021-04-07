package com.politecnicomalaga.Persistencia.DAO;

public interface DAOManager {

    PacienteDAO getPacienteDAO ();
    MedicoDAO getMedicoDAO ();
    HistorialClinicoDAO getHistorialClinicoDAO ();
}
