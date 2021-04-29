package org.example.persistencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    /**
     * Instancias
     */

    private Connection conn;

    /**
     * Constantes
     */

    private final static String INSERT = "INSERT INTO categoria(nombre) VALUES(?)";
    private final static String UPDATE = "UPDATE categoria SET nombre = ? WHERE nombre = ?";
    private final static String DELETE = "DELETE FROM categoria WHERE nombre = ?";
    private final static String GETALL = "SELECT id, nombre FROM categoria";
    private final static String GETALL_BY_ID = "SELECT nombre FROM categoria WHERE id = ?";
    private final static String GETALL_BY_NAME = "SELECT id FROM categoria WHERE nombre = ?";

    /**
     * Constructor con Conexión a la Base de Datos
     */

    public CategoriaDAO (Connection conn) {
        this.conn = conn;
    }

    /**
     * Método para Crear una nueva Categoría
     */

    public boolean crear (String categoria) {
        boolean respuesta = false;
        try {
            PreparedStatement statement = conn.prepareStatement(INSERT);
            statement.setString(1, categoria);
            if (statement.executeUpdate() != 0) {
                respuesta = true;
            }
        } catch (SQLException throwables) {
            return respuesta;
        }
        return respuesta;
    }

    /**
     * Método para Actualizar el Nombre de una Categoría
     */

    public boolean actualizar (String categoria, String nuevoNombre) {
        boolean respuesta = false;
        try {
            PreparedStatement statement = conn.prepareStatement(UPDATE);
            statement.setString(1, nuevoNombre);
            statement.setString(2, categoria);
            if (statement.executeUpdate() != 0) {
                respuesta = true;
            }
        } catch (SQLException throwables) {
            return respuesta;
        }
        return respuesta;
    }

    /**
     * Método para Obtener el Nombre de una Categoría mediante su ID
     */

    public String getCategoriaById (int id) {
        String resultado = null;
        try {
            PreparedStatement statement = conn.prepareStatement(GETALL_BY_ID);
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
     * Método para Obtener el ID una Categoría mediante su Nombre
     */

    public int getId (String categoria) {
        int resultado = -1;
        try {
            PreparedStatement statement = conn.prepareStatement(GETALL_BY_NAME);
            statement.setString(1, categoria);
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
     * Método para Eliminar una Categoría mediante su Nombre
     */

    public boolean borrar (String categoria) {
        boolean respuesta = false;
        try {
            PreparedStatement statement = conn.prepareStatement(DELETE);
            statement.setString(1, categoria);
            if (statement.executeUpdate() != 0) {
                respuesta = true;
            }
        } catch (SQLException throwables) {
            return respuesta;
        }
        return respuesta;
    }

    /**
     * Método para Comrpobar si existe una Categoría mediante su Nombre
     */

    public boolean exists (String categoria) {
        boolean respuesta = false;
        for (String valor : getAll()) {
            if (valor.equals(categoria)) {
                respuesta = true;
            }
        }
        return respuesta;
    }

    /**
     * Método para Obtener todos los Nombres de las Categorias
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