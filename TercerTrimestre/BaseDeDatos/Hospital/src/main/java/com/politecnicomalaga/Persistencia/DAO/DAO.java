package com.politecnicomalaga.Persistencia.DAO;

import com.politecnicomalaga.Modelo.Paciente;

import java.sql.SQLException;
import java.util.List;

public interface DAO<Entidad, tipoDatos> {

    void crear (Entidad paciente) throws SQLException;
    void modificar (Entidad paciente) throws SQLException;
    void eliminar (Entidad paciente) throws SQLException;
    List<Entidad> obtenerTodos () throws SQLException;
    Paciente obtener (tipoDatos id) throws SQLException;

}