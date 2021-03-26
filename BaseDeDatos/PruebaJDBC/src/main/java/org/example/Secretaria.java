package org.example;

import org.example.Modelo.Alumno;
import org.example.Persistencia.DBConnection;

import java.sql.SQLException;
import java.util.List;

public class Secretaria {

    /**
     * Varaibles
     */

    private List<Alumno> listaAlumnos;

    public Secretaria () throws SQLException {

        DBConnection dbConnection = new DBConnection();
        dbConnection.conectar();
        listaAlumnos = dbConnection.cargarAlumnos();
        dbConnection.desconectar();
    }

    public List<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }
}
