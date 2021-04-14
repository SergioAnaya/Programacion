package org.example.Persistencia.DAO;

import org.example.Modelo.Categoria;
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
    private Categoria categoria = new Categoria();

    /**
     * Constantes
     */

    private final static String INSERT = "INSERT INTO categoria(nombre) VALUES(?)";
    private final static String UPDATE = "UPDATE categoria SET nombre = ? WHERE nombre = ?";
    private final static String DELETE = "DELETE FROM categoria WHERE nombre = ?";
    private final static String GETALL = "SELECT id, nombre FROM categoria";
    private final static String GET_BY_ID = "SELECT id, nombre FROM categoria WHERE id = ?";
    private final static String GET_BY_NAME = "SELECT id, nombre FROM categoria WHERE nombre = ?";

    /**
     * Variables
     */

    private List<Categoria> listaCategorias;

    /**
     * Constructor con Conexión a la Base de Datos
     */

    public CategoriaDAO () throws SQLException {
        conn = dbConnection.conectar();
    }

    /**
     * Método para Crear una nueva Categoría
     */

    public boolean crear (String categoria) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;
        boolean respuesta = false;
        listaCategorias = new ArrayList<>();
        try {
            st = conn.prepareStatement(INSERT, st.RETURN_GENERATED_KEYS);
            st.setString(1, categoria);
            if (st.executeUpdate() != 0) {
                respuesta = true;
            }
            rs = st.getGeneratedKeys();
            if (rs.next()) {
                this.categoria.setId(rs.getString(1));
                listaCategorias.add(this.categoria);
            } else System.out.println("No se pudo asignar el ID a la Categoría");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (rs != null || st != null) {
            dbConnection.desconectar();
        }
        return respuesta;
    }

    /**
     * Método para Actualizar el Nombre de la Categoría
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
            st = conn.prepareStatement(GET_BY_ID);
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
     * Método para Obtener el ID de la Categoría mediante su Nombre
     */

    public int getId (String categoria) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;
        int resultado = 0;
        try {
            st = conn.prepareStatement(GET_BY_NAME);
            st.setString(1, categoria);
            rs = st.executeQuery();
            if (rs.next()) {
                resultado = Integer.parseInt(rs.getString("id"));
            } else System.out.println("No se ha encontrado el id de la Categoría");
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

    public boolean exists (String categoria) {
        boolean respuesta = false;
        if (listaCategorias.contains(categoria)) {
            respuesta = false;
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
                lista.add(convertir(rs));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (rs != null || st != null) {
            dbConnection.desconectar();
        }
        return lista;
    }

    /**
     * Método privado para Convertir a objetos las Categorias para su posterior uso
     */

    private String convertir (ResultSet rs) throws SQLException {
        String id = rs.getString("id");
        String nombre = rs.getString("nombre");
        Categoria categoria = new Categoria(nombre);
        categoria.setId(id);
        return categoria.getNombre();
    }
}