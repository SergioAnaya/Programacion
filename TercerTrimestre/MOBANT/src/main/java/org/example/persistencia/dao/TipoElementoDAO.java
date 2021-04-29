package org.example.persistencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoElementoDAO {

    /**
     * Instancias
     */

    private Connection conn;

    /**
     * Constantes
     */

    private final static String INSERT = "INSERT INTO tipo_elemento(nombre) VALUES(?)";
    private final static String UPDATE = "UPDATE tipo_elemento SET nombre = ? WHERE nombre = ?";
    private final static String DELETE = "DELETE FROM tipo_elemento WHERE nombre = ?";
    private final static String GETALL = "SELECT id, nombre FROM tipo_elemento";
    private final static String GET_BY_ID = "SELECT id, nombre FROM tipo_elemento WHERE id = ?";
    private final static String GET_BY_NOMBRE = "SELECT id, nombre FROM tipo_elemento WHERE nombre = ?";

    /**
     * Constructor con Conexión a la Base de Datos
     */

    public TipoElementoDAO (Connection conn) throws SQLException {
        this.conn = conn;
    }

    /**
     * Método para Crear un nuevo TipoElemento
     */

    public boolean crear (String nombre) {
        boolean respuesta = false;
        try {
            PreparedStatement statement = conn.prepareStatement(INSERT);
            statement.setString(1, nombre);
            if (statement.executeUpdate() != 0) {
                respuesta = true;
            }
        } catch (SQLException throwables) {
            return respuesta;
        }
        return respuesta;
    }

    /**
     * Método para Obtener el ID de un Tipo de Elemento mediante su ID
     */

    public String getTipoElementoById (int id) {
        String resultado = null;
        try {
            PreparedStatement statement = conn.prepareStatement(GET_BY_ID);
            statement.setString(1, String.valueOf(id));
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                resultado = resultSet.getString("nombre");
            }
        } catch (SQLException throwables) {
            return resultado;
        }
        return resultado;
    }

    /**
     * Método para Obtener el ID de un Tipo de Elemento mediante su nombre
     */

    public int getId (String nombre) {
        int resultado = -1;
        try {
            PreparedStatement statement = conn.prepareStatement(GET_BY_NOMBRE);
            statement.setString(1, nombre);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                resultado = Integer.parseInt(resultSet.getString("id"));
            }
        } catch (SQLException throwables) {
            return resultado;
        }
        return resultado;
    }

    /**
     * Método para Actualizar el Nombre de un Tipo de Elemento
     */

    public boolean actualizar (String nombre, String nuevoNombre) {

        boolean respuesta = false;
        try {
            PreparedStatement statement = conn.prepareStatement(UPDATE);
            statement.setString(1, nuevoNombre);
            statement.setString(2, nombre);
            if (statement.executeUpdate() != 0) {
                respuesta = true;
            }
        } catch (SQLException throwables) {
            return respuesta;
        }
        return respuesta;
    }

    /**
     * Método para Obtener todos los Tipos de Elementos
     */

    public List<String> getAll () {
        List<String> lista = new ArrayList<String>();
        try {
            PreparedStatement statement = conn.prepareStatement(GETALL);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                lista.add(resultSet.getString("nombre"));
            }
        } catch (SQLException throwables) {
            return null;
        }
        return lista;
    }

    /**
     * Método para Comprobar si existe un Tipo de Elemento mediante su Nombre
     */

    public boolean exists (String tipoElemento) {
        boolean respuesta = false;
        for (String valor : getAll()) {
            if (valor.equals(tipoElemento)) {
                respuesta = true;
            }
        }
        return respuesta;
    }

    /**
     * Método para Eliminar un Tipo de Elemento mediante su Nombre
     */

    public boolean borrar (String nombre) {
        boolean respuesta = false;
        try {
            PreparedStatement statement = conn.prepareStatement(DELETE);
            statement.setString(1, nombre);
            if (statement.executeUpdate() != 0) {
                respuesta = true;
            }
        } catch (SQLException throwables) {
            return respuesta;
        }
        return respuesta;
    }
}
