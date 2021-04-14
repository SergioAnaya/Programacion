package org.example.Persistencia.DAO;

import org.example.Modelo.Elemento;
import org.example.Modelo.Modelo;
import org.example.Persistencia.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModeloDAO {

    /**
     * Instancias
     */

    private DBConnection dbConnection = new DBConnection();
    private Connection conn;
    private SeccionDAO seccionDAO;
    private CategoriaDAO categoriaDAO;

    /**
     * Constantes
     */

    private final static String INSERT = "INSERT INTO modelo(codigo, id_seccion, id_categoria) VALUES(?, ?, ?)";
    private final static String UPDATE = "UPDATE modelo SET codigo = ? WHERE codigo = ?";
    private final static String DELETE = "DELETE FROM modelo WHERE codigo = ?";
    private final static String GET_BY_CODIGO = "SELECT id, codigo, id_seccion, id_categoria FROM modelo WHERE codigo = ?";
    private final static String GET_BY_ID = "SELECT id, codigo, id_tipo_elemento FROM elemento WHERE id = ?";
    private final static String GETALL = "SELECT id, codigo, id_tipo_elemento FROM elemento FROM modelo";

    /**
     * Variables
     */

    /**
     * Constructor con Conexión a la Base de Datos
     */

    public ModeloDAO () throws SQLException {
        conn = dbConnection.conectar();
    }

    /**
     * Método para Crear un nuevo Modelo
     */

    public boolean Crear (Modelo modelo) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;
        boolean respuesta = false;
        try {
            st = conn.prepareStatement(INSERT, st.RETURN_GENERATED_KEYS);
            st.setString(1, modelo.getCodigo());
            st.setString(2, modelo.getIdSeccion());
            st.setString(3, modelo.getIdCategoria());
            if (st.executeUpdate() != 0) {
                respuesta = true;
            }
            rs = st.getGeneratedKeys();
            if (rs.next()) {
                modelo.setId(rs.getString(1));
            } else System.out.println("No se pudo asignar el ID al Modelo");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (rs != null || st != null) {
            dbConnection.desconectar();
        }
        return respuesta;
    }

    /**
     * Método para Obtener un Modelo mediante su Código
     */

    public Modelo leer (String codigo) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;
        Modelo modelo = null;
        try {
            st = conn.prepareStatement(GET_BY_CODIGO);
            st.setString(1, codigo);
            rs = st.executeQuery();
            if (rs.next()) {
                modelo = convertir(rs);
            } else System.out.println("Error al obtener el Modelo");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (rs != null || st != null) {
            dbConnection.desconectar();
        }
        return modelo;
    }

    /**
     * Método para Obtener el ID del Modelo mediante su Código
     */

    public int getId (String codigo) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;
        int resultado = 0;
        try {
            st = conn.prepareStatement(GET_BY_CODIGO);
            st.setString(1, codigo);
            rs = st.executeQuery();
            if (rs.next()) {
                resultado = Integer.parseInt(rs.getString("id"));
            } else System.out.println("Error al obtener el ID del Modelo");
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
     * Método para Eliminar un Modelo mediante su Código
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
     *
     * @return
     */

    public List<String> getCodigosModelos () throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;
        List<String> listaCodigos = new ArrayList<>();
        try {
            st = conn.prepareStatement(GETALL);
            rs = st.executeQuery();
            while (rs.next()) {
                listaCodigos.add(rs.getString("codigo"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (rs != null || st != null) {
            dbConnection.desconectar();
        }
        return listaCodigos;
    }

    /**
     *
     * @param categoria
     * @return
     */

    public List<String> getCodigosModelosByCategoria (String categoria) {
        List<String> lista = new ArrayList<>();
        return lista;
    }

    /**
     *
     * @param seccion
     * @return
     */

    public List<String> getCodigosModelosBySeccion (String seccion) {
        List<String> lista = new ArrayList<>();
        return lista;
    }

    /**
     * Método privado para Convertir a objetos los Modelos para su posterior uso
     */

    private Modelo convertir (ResultSet rs) throws SQLException {
        String id = rs.getString("id");
        String codigo = rs.getString("codigo");
        String idseccion = rs.getString("id_seccion");
        String idCategoria = rs.getString("id_categoria");
        Modelo modelo = new Modelo(codigo, idseccion, idCategoria);
        modelo.setId(id);
        return modelo;
    }
}