package org.example.Persistencia.DAO;

import org.example.Modelo.Elemento;
import org.example.Persistencia.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ElementoModeloDAO {

    /**
     * Instancias
     */

    private DBConnection dbConnection = new DBConnection();
    private Connection conn;
    private ElementoDAO elementoDAO;
    private ModeloDAO modeloDAO;

    /**
     * Constantes
     */

    private final static String INSERT = "INSERT INTO elemento_modelo(id_elemento, id_modelo) VALUES(?, ?)";
    private final static String UPDATE = "UPDATE elemento_modelo SET id_modelo = ? WHERE idElemento = ? AND id_modelo = ?";
    private final static String DELETE = "DELETE FROM elemento_modelo WHERE id_elemento = ? AND id_modelo = ?";
    private final static String GET_BY_ID = "SELECT id, id_elemento, id_modelo FROM elemento_modelo WHERE idElemento = ? AND id_modelo = ?";
    private final static String GET_BY_CODMODELO = "SELECT id, id_elemento, id_modelo FROM elemento_modelo WHERE id_modelo = ?";


    /**
     * Variables
     */

    /**
     * Constructor con Conexión a la Base de Datos
     */

    public ElementoModeloDAO (Connection conn) throws SQLException {
        conn = dbConnection.conectar();
        this.conn = conn;
    }

    /**
     * Método para Crear un nuevo ElementoModelo
     */

    public boolean crear (String codigoElemento, String codigoModelo) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;
        boolean respuesta = false;
        try {
            st = conn.prepareStatement(INSERT, st.RETURN_GENERATED_KEYS);
            st.setString(1, codigoElemento);
            st.setString(2, codigoModelo);
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
     * Método para Obtener el ID del ElementoModelo mediante su Código de Elemento y
     * Código de Modelo
     */

    public int getId (String codigoElemento, String codigoModelo) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;
        int resultado = -1;
        try {
            st = conn.prepareStatement(GET_BY_ID);
            st.setString(1, codigoElemento);
            st.setString(2, codigoModelo);
            rs = st.executeQuery();
            if (rs.next()) {
                resultado = Integer.parseInt(rs.getString("id"));
            } else System.out.println("Error al obtener el ID de ElementoModelo");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (rs != null || st != null) {
            dbConnection.desconectar();
        }
        return resultado;
    }

    /**
     * Método para Actualizar el Código del Modelo
     */

    public boolean actualizarModelo (String codigoElemento, String codigoModelo, String codigoNuevoModelo) throws SQLException {
        PreparedStatement st = null;
        boolean respuesta = false;
        try {
            st = conn.prepareStatement(UPDATE);
            st.setString(1, codigoNuevoModelo);
            st.setString(2, codigoElemento);
            st.setString(3, codigoModelo);
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
     * Método para Obtener todos los Elementos mediante el Código del Modelo
     */

    public List<Elemento> getElementosByCodigoModelo (String codigoModelo) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Elemento> listaCodigos = new ArrayList<>();
        try {
            st = conn.prepareStatement(GET_BY_CODMODELO);
            st.setString(1, codigoModelo);
            rs = st.executeQuery();
            while (rs.next()) {
                listaCodigos.add(elementoDAO.convertir(rs));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("NULL");
        }
        if (rs != null || st != null) {
            dbConnection.desconectar();
        }
        return listaCodigos;
    }

    /**
     * Método para Eliminar un ElementoModelo mediante el Código de Elemento  y
     * Código de Modelo
     */

    public boolean borrar (String codigoElemento, String codigoModelo) throws SQLException {
        PreparedStatement st = null;
        boolean respuesta = false;
        try {
            st = conn.prepareStatement(DELETE);
            st.setString(1, codigoElemento);
            st.setString(2, codigoModelo);
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