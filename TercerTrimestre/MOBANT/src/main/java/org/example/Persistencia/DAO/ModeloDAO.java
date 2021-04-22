package org.example.Persistencia.DAO;

import org.example.Modelo.Modelo;

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

    private Connection conn;
    private SeccionDAO seccionDAO;
    private CategoriaDAO categoriaDAO;

    /**
     * Constantes
     */

    private final static String INSERT = "INSERT INTO modelo(id, codigo, id_seccion, id_categoria) VALUES(?, ?, ?, ?)";
    private final static String UPDATE = "UPDATE modelo SET codigo = ? WHERE codigo = ?";
    private final static String DELETE = "DELETE FROM modelo WHERE codigo = ?";
    private final static String GET_BY_CODIGO = "SELECT id, codigo, id_seccion, id_categoria FROM modelo WHERE codigo = ?";
    private final static String GET_BY_CATEGORIA = "SELECT id, codigo, id_seccion, id_categoria FROM modelo WHERE id_categoria = ?";
    private final static String GET_BY_SECCION = "SELECT id, codigo, id_seccion, id_categoria FROM modelo WHERE id_seccion = ?";
    private final static String GETALL = "SELECT id, codigo, id_seccion, id_categoria FROM modelo";

    /**
     * Constructor con Conexión a la Base de Datos
     */

    public ModeloDAO (Connection conn) {
        this.conn = conn;
        seccionDAO = new SeccionDAO(conn);
        categoriaDAO = new CategoriaDAO(conn);
    }

    /**
     * Método para Crear un nuevo Modelo
     */

    public boolean crear (Modelo modelo) {
        boolean respuesta = false;
        try {
            PreparedStatement statement = conn.prepareStatement(INSERT);
            statement.setString(1, null);
            statement.setString(2, modelo.getCodigo());
            statement.setString(3, String.valueOf(getIdSeccion(modelo.getSeccion())));
            statement.setString(4, String.valueOf(getIdCategoria(modelo.getCategoria())));
            if (statement.executeUpdate() != 0) {
                respuesta = true;
            }
        } catch (SQLException throwables) {
            return respuesta;
        }
        return respuesta;
    }

    private int getIdSeccion (String seccion) {
        return this.seccionDAO.getId(seccion);
    }

    private int getIdCategoria (String categoria) {
        return this.categoriaDAO.getId(categoria);
    }

    /**
     * Método para Obtener un Modelo mediante su Código
     */

    public Modelo leer (String codigo) {
        Modelo modelo = null;
        try {
            PreparedStatement statement = conn.prepareStatement(GET_BY_CODIGO);
            statement.setString(1, codigo);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                modelo = convertir(resultSet);
            }
        } catch (SQLException throwables) {
            return modelo;
        }
        return modelo;
    }

    /**
     * Método para Obtener el ID de un Modelo mediante su Código
     */

    public int getId (String codigo) {
        int resultado = -1;
        try {
            PreparedStatement statement = conn.prepareStatement(GET_BY_CODIGO);
            statement.setString(1, codigo);
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
     * Método para Actualizar el Código de un Modelo
     */

    public boolean actualizar (String codigo, String nuevoCodigo) {
        boolean respuesta = false;
        try {
            PreparedStatement statement = conn.prepareStatement(UPDATE);
            statement.setString(1, nuevoCodigo);
            statement.setString(2, codigo);
            if (statement.executeUpdate() != 0) {
                respuesta = true;
            }
        } catch (SQLException throwables) {
            return respuesta;
        }
        return respuesta;
    }

    /**
     * Método para Eliminar un Modelo mediante su Código
     */

    public boolean borrar (String codigo) {
        boolean respuesta = false;
        try {
            PreparedStatement statement = conn.prepareStatement(DELETE);
            statement.setString(1, codigo);
            if (statement.executeUpdate() != 0) {
                respuesta = true;
            }
        } catch (SQLException throwables) {
            return respuesta;
        }
        return respuesta;
    }

    /**
     * Método para Obtener todos los Códigos de los Modelos
     */

    public List<String> getCodigosModelos () {
        List<String> listaCodigos = new ArrayList<>();
        try {
            PreparedStatement statement = conn.prepareStatement(GETALL);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                listaCodigos.add(resultSet.getString("codigo"));
            }
        } catch (SQLException throwables) {
            return null;
        }
        return listaCodigos;
    }

    /**
     * Métodos para Obtener todos los Códigos de los Modelos mediante la Categoría
     */

    public List<String> getCodigosModelosByCategoria (String categoria) {
        List<String> listaCodigos = new ArrayList<>();
        try {
            PreparedStatement statement = conn.prepareStatement(GET_BY_CATEGORIA);
            statement.setString(1, String.valueOf(getIdCategoria(categoria)));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                listaCodigos.add(resultSet.getString("codigo"));
            }
        } catch (SQLException throwables) {
            return null;
        }
        return listaCodigos;
    }

    /**
     * Métodos para Obtener todos los Códigos de los Modelos mediante la Sección
     */

    public List<String> getCodigosModelosBySeccion (String seccion) {
        List<String> listaCodigos = new ArrayList<>();
        try {
            PreparedStatement statement = conn.prepareStatement(GET_BY_SECCION);
            statement.setString(1, String.valueOf(getIdSeccion(seccion)));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                listaCodigos.add(resultSet.getString("codigo"));
            }
        } catch (SQLException throwables) {
            return null;
        }
        return listaCodigos;
    }

    /**
     * Método privado para Convertir a objetos los Modelos para su posterior uso
     */

    private Modelo convertir (ResultSet rs) throws SQLException {
        String codigo = rs.getString("codigo");
        String idseccion = rs.getString("id_seccion");
        String idCategoria = rs.getString("id_categoria");
        String idModeloSeccion = getModeloSeccion(idseccion);
        String idModeloCategoria = getModeloCategoria(idCategoria);
        Modelo modelo = new Modelo(codigo, idModeloSeccion, idModeloCategoria);
        return modelo;
    }

    private String getModeloSeccion (String seccion) {
        return this.seccionDAO.getSeccionById(Integer.parseInt(seccion));
    }

    private String getModeloCategoria (String categoria) {
        return this.categoriaDAO.getCategoriaById(Integer.parseInt(categoria));
    }
}