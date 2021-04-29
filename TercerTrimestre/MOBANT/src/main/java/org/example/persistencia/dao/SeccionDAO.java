package org.example.persistencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SeccionDAO {

    /**
     * Instancias
     */

    private Connection conn;

    /**
     * Constantes
     */

    private final static String INSERT = "INSERT INTO seccion(nombre) VALUES(?)";
    private final static String UPDATE = "UPDATE seccion SET nombre = ? WHERE nombre = ?";
    private final static String DELETE = "DELETE FROM seccion WHERE nombre = ?";
    private final static String GETALL = "SELECT id, nombre FROM seccion";
    private final static String GET_BY_ID = "SELECT id, nombre FROM seccion WHERE id = ?";
    private final static String GET_BY_SECCION = "SELECT id, nombre FROM seccion WHERE nombre = ?";

    /**
     * Constructor con Conexión a la Base de Datos
     */

    public SeccionDAO (Connection conn) {
        this.conn = conn;
    }

    /**
     * Método para Crear una nueva Sección
     */

    public boolean crear (String seccion) {
        boolean respuesta = false;
        try {
            PreparedStatement statement = conn.prepareStatement(INSERT);
            statement.setString(1, seccion);
            if (statement.executeUpdate() != 0) {
                respuesta = true;
            }
        } catch (SQLException throwables) {
            return respuesta;
        }
        return respuesta;
    }

    /**
     * Método para Comrpobar si existe una Sección mediante su Nombre
     */

    public boolean exists (String nombre) {
        boolean respuesta = false;
        for (String valor : getAll()) {
            if (valor.equals(nombre)) {
                respuesta = true;
            }
        }
        return respuesta;
    }

    /**
     * Método para Actualizar el Nombre de una Sección
     */

    public boolean actualizar (String seccion, String nuevoNombre) {
        boolean respuesta = false;
        try {
            PreparedStatement statement = conn.prepareStatement(UPDATE);
            statement.setString(1, nuevoNombre);
            statement.setString(2, seccion);
            if (statement.executeUpdate() != 0) {
                respuesta = true;
            }
        } catch (SQLException throwables) {
            return respuesta;
        }
        return respuesta;
    }

    /**
     * Método para Eliminar una Sección mediante su Nombre
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

    /**
     * Método para Obtener el ID de una Sección mediante su Nombre
     */

    public int getId (String seccion) {
        int resultado = -1;
        try {
            PreparedStatement statement = conn.prepareStatement(GET_BY_SECCION);
            statement.setString(1, seccion);
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
     * Método para Obtener el Nombre de una Sección mediante su ID
     */

    public String getSeccionById (int id) {
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
     * Método para Obtener todas las Secciones
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
}