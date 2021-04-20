package org.example.Persistencia.DAO;

import org.example.Modelo.Elemento;
import org.example.Persistencia.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ElementoDAO {

    /**
     * Instancias
     */

    private DBConnection dbConnection = new DBConnection();
    private Connection conn;
    private TipoElementoDAO tipoElementoDAO;

    /**
     * Constantes
     */

    private final static String INSERT = "INSERT INTO elemento(codigo, id_tipo_elemento) VALUES(?, (SELECT id FROM tipo_elemento WHERE id = ?))";
    private final static String UPDATE = "UPDATE elemento SET codigo = ? WHERE codigo = ?";
    private final static String DELETE = "DELETE FROM elemento WHERE codigo = ?";
    private final static String GET_BY_CODIGO = "SELECT id, codigo, id_tipo_elemento FROM elemento WHERE codigo = ?";
    private final static String GET_BY_ID = "SELECT id, codigo, id_tipo_elemento FROM elemento WHERE id = ?";
    private final static String GETALL = "SELECT id, codigo, id_tipo_elemento FROM elemento";

    /**
     * Constructor con Conexión a la Base de Datos
     */

    public ElementoDAO (Connection conn) throws SQLException {
        conn = dbConnection.conectar();
        this.conn = conn;
    }

    /**
     * Método para Crear un nuevo Elemento
     */

    public boolean crear (Elemento elemento) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;
        boolean respuesta = false;
        try {
            st = conn.prepareStatement(INSERT, st.RETURN_GENERATED_KEYS);
            st.setString(1, elemento.getCodigo());
            st.setString(2, elemento.getIdTipoElemento());
            if (st.executeUpdate() != 0) {
                respuesta = true;
            }
            rs = st.getGeneratedKeys();
            if (rs.next()) {
                elemento.setId(rs.getString(1));
            } else System.out.println("No se pudo asignar el ID a el Elemento");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (rs != null || st != null) {
            dbConnection.desconectar();
        }
        return respuesta;
    }

    /**
     * Método para Obtener un Elemento mediante su Codigo
     */

    public Elemento leer (String codigo) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;
        Elemento elemento = null;
        try {
            st = conn.prepareStatement(GET_BY_CODIGO);
            st.setString(1, codigo);
            rs = st.executeQuery();
            if (rs.next()) {
                elemento = convertir(rs);
            } else System.out.println("Error al obtener el Elemento");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (rs != null || st != null) {
            dbConnection.desconectar();
        }
        return elemento;
    }

    /**
     * Método para Obtener el ID de un Elemento mediante su Código
     */

    public int getId (String codigo) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;
        int resultado = -1;
        try {
            st = conn.prepareStatement(GET_BY_CODIGO);
            st.setString(1, codigo);
            rs = st.executeQuery();
            if (rs.next()) {
                resultado = Integer.parseInt(rs.getString("id"));
            } else System.out.println("Error al obtener el ID del Elemento");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (rs != null || st != null) {
            dbConnection.desconectar();
        }
        return resultado;
    }

    /**
     * Método para Obtener un Elemento mediante su ID
     */

    public Elemento getElementoById (int id) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;
        Elemento elemento = null;
        try {
            st = conn.prepareStatement(GET_BY_ID);
            st.setString(1, String.valueOf(id));
            rs = st.executeQuery();
            if (rs.next()) {
                elemento = new Elemento();
                elemento = convertir(rs);
            } else System.out.println("Error al obtener el Elemento");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (rs != null || st != null) {
            dbConnection.desconectar();
        }
        return elemento;
    }

    /**
     * Método para Actualizar el Código de un Elemento
     */

    public boolean actualizar (String codigo, String nuevoCodigo) throws SQLException {
        PreparedStatement st = null;
        boolean respuesta = false;
        try {
            st = conn.prepareStatement(UPDATE);
            st.setString(1, nuevoCodigo);
            st.setString(2, codigo);
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
     * Método para Eliminar un Elemento mediante su Código
     */

    public boolean borrar (String codigo) throws SQLException {
        PreparedStatement st = null;
        boolean resultado = false;
        try {
            st = conn.prepareStatement(DELETE);
            st.setString(1, codigo);
            if (st.executeUpdate() != 0) {
                resultado = true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (st != null) {
            dbConnection.desconectar();
        }
        return resultado;
    }

    /**
     * Método para Convertir a objetos los Elementos para su posterior uso
     */

    public Elemento convertir (ResultSet rs) throws SQLException {
        String id = rs.getString("id");
        String codigo = rs.getString("codigo");
        String idTipoElemento = rs.getString("id_tipo_elemento");
        Elemento elemento = new Elemento(codigo, idTipoElemento);
        elemento.setId(id);
        return elemento;
    }
}