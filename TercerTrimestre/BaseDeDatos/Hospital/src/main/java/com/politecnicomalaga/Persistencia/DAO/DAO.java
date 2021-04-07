package com.politecnicomalaga.Persistencia.DAO;

import com.politecnicomalaga.Modelo.Paciente;

import java.sql.SQLException;
import java.util.List;

public interface DAO<Entidad, tipoDatos> {

    void crear (Entidad entidad) throws SQLException;
    void modificar (Entidad entidad) throws SQLException;
    void eliminar (Entidad entidad) throws SQLException;
    List<Entidad> obtenerTodos () throws SQLException;
    Entidad obtener (tipoDatos id) throws SQLException;

}