package org.example.Persistencia.DAO;

import org.example.Modelo.TipoElemento;
import org.example.Persistencia.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoElementoDAO {

    /**
     * Instancias
     */

    private DBConnection dbConnection = new DBConnection();
    private Connection conn;

    /**
     * Constantes
     */

    /**
     * Variables
     */

    private List<TipoElemento> listaTiposElementos;

    /**
     * Constructor con Conexión a la Base de Datos
     */

    public TipoElementoDAO () throws SQLException {
        conn = dbConnection.conectar();
    }

    /**
     * Método para Crear un nuevo TipoElemento
     */

    public boolean crear (String nombre) {
        boolean respuesta = false;
        return respuesta;
    }

    /**
     * Método para
     */

    public String getTipoElementoById (int id) {
        String resultado = null;
        return resultado;
    }

    /**
     * Método para
     */

    public int getId (String nombre) {
        return 1;
    }

    /**
     * Método para
     */

    public boolean actualizar (String nombre, String nuevoNombre) {
        boolean respuesta = false;
        return respuesta;
    }

    /**
     * Método para
     */

    public List<String> getAll () {
        List<String> lista = new ArrayList<>();
        return lista;
    }

    /**
     * Método para
     */

    public boolean exists (String tipoElemento) {
        boolean respuesta = false;
        return respuesta;
    }

    /**
     * Método para
     */

    public boolean borrar (String nombre) {
        boolean respuesta = false;
        return respuesta;
    }

    public List<TipoElemento> getListaTiposElementos() {
        return listaTiposElementos;
    }
}
