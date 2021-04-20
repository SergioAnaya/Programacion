package org.example.Persistencia.DAO;

import org.example.Persistencia.DBConnection;

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

    private DBConnection dbConnection = new DBConnection();
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
        conn = dbConnection.conectar();
        this.conn = conn;
    }

    /**
     * Método para Crear un nuevo TipoElemento
     */

    public boolean crear (String nombre) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;
        boolean respuesta = false;
        try {
            st = conn.prepareStatement(INSERT, st.RETURN_GENERATED_KEYS);
            st.setString(1, nombre);
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
     * Método para Obtener el ID de un Tipo de Elemento mediante su ID
     */

    public String getTipoElementoById (int id) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;
        String resultado = null;
        try {
            st = conn.prepareStatement(GET_BY_ID);
            st.setString(1, String.valueOf(id));
            rs = st.executeQuery();
            if (rs.next()) {
                resultado = rs.getString("nombre");
            } else System.out.println("No se ha encontrado el ID del Tipo de Elemento");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (rs != null || st != null) {
            dbConnection.desconectar();
        }
        return resultado;
    }

    /**
     * Método para Obtener el ID de un Tipo de Elemento mediante su nombre
     */

    public int getId (String nombre) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;
        int resultado = -1;
        try {
            st = conn.prepareStatement(GET_BY_NOMBRE);
            st.setString(1, nombre);
            rs = st.executeQuery();
            if (rs.next()) {
                resultado = Integer.parseInt(rs.getString("id"));
            } else System.out.println("No se ha encontrado el ID del Tipo de Elemento");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (rs != null || st != null) {
            dbConnection.desconectar();
        }
        return resultado;
    }

    /**
     * Método para Actualizar el Nombre de un Tipo de Elemento
     */

    public boolean actualizar (String nombre, String nuevoNombre) throws SQLException {
        PreparedStatement st = null;
        boolean respuesta = false;
        try {
            st = conn.prepareStatement(UPDATE);
            st.setString(1, nuevoNombre);
            st.setString(2, nombre);
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
     * Método para Obtener todos los Tipos de Elementos
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

    /**
     * Método para Comprobar si existe un Tipo de Elemento mediante su Nombre
     */

    public boolean exists (String tipoElemento) throws SQLException {
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

    public boolean borrar (String nombre) throws SQLException {
        PreparedStatement st = null;
        boolean respuesta = false;
        try {
            st = conn.prepareStatement(DELETE);
            st.setString(1, nombre);
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
}
