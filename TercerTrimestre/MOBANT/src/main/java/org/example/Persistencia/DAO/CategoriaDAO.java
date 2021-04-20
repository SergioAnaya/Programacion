package org.example.Persistencia.DAO;

import org.example.Persistencia.DBConnection;

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

    private DBConnection dbConnection = new DBConnection();
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

    public CategoriaDAO (Connection conn) throws SQLException {
        conn = dbConnection.conectar();
        this.conn = conn;
    }

    /**
     * Método para Crear una nueva Categoría
     */

    public boolean crear (String categoria) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;
        boolean respuesta = false;
        try {
            st = conn.prepareStatement(INSERT, st.RETURN_GENERATED_KEYS);
            st.setString(1, categoria);
            if (st.executeUpdate() != 0) {
                respuesta = true;
            }
            rs = st.getGeneratedKeys();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (rs != null || st != null) {
            dbConnection.desconectar();
        }
        return respuesta;
    }

    /**
     * Método para Actualizar el Nombre de una Categoría
     */

    public boolean actualizar (String categoria, String nuevoNombre) throws SQLException {
        PreparedStatement st = null;
        boolean respuesta = false;
        try {
            st = conn.prepareStatement(UPDATE);
            st.setString(1, nuevoNombre);
            st.setString(2, categoria);
            if (st.executeUpdate() != 0) {
                respuesta = true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (st != null) {
            dbConnection.desconectar();
        }
        return respuesta;
    }

    /**
     * Método para Obtener el Nombre de una Categoría mediante su ID
     */

    public String getCategoriaById (int id) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;
        String resultado = null;
        try {
            st = conn.prepareStatement(GETALL_BY_ID);
            st.setString(1, String.valueOf(id));
            rs = st.executeQuery();
            if (rs.next()) {
                resultado = rs.getString("nombre");
            } else System.out.println("No se ha encontrado el nombre de la Categoría");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (rs != null || st != null) {
            dbConnection.desconectar();
        }
        return resultado;
    }

    /**
     * Método para Obtener el ID una Categoría mediante su Nombre
     */

    public int getId (String categoria) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;
        int resultado = -1;
        try {
            st = conn.prepareStatement(GETALL_BY_NAME);
            st.setString(1, categoria);
            rs = st.executeQuery();
            if (rs.next()) {
                resultado = Integer.parseInt(rs.getString("id"));
            } else System.out.println("No se ha encontrado el ID de la Categoría");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (rs != null || st != null) {
            dbConnection.desconectar();
        }
        return resultado;
    }

    /**
     * Método para Eliminar una Categoría mediante su Nombre
     */

    public boolean borrar (String categoria) throws SQLException {
        PreparedStatement st = null;
        boolean respuesta = false;
        try {
            st = conn.prepareStatement(DELETE);
            st.setString(1, categoria);
            if (st.executeUpdate() != 0) {
                respuesta = true;
            }
            respuesta = true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (st != null) {
            dbConnection.desconectar();
        }
        return respuesta;
    }

    /**
     * Método para Comrpobar si existe una Categoría mediante su Nombre
     */

    public boolean exists (String categoria) throws SQLException {
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

    public List<String> getAll () throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;
        List<String> lista = new ArrayList<String>();
        try {
            st = conn.prepareStatement(GETALL);
            rs = st.executeQuery();
            while (rs.next()) {
                lista.add(rs.getString("nombre"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("NULL");
        }
        if (rs != null || st != null) {
            dbConnection.desconectar();
        }
        return lista;
    }
}