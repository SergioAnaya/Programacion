package org.example.Persistencia.DAO;

import org.example.Modelo.Elemento;
import org.example.Persistencia.DBConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ElementoModeloDAO {

    /**
     * Instancias
     */

    private Connection conn;
    private ElementoDAO elementoDAO;
    private ModeloDAO modeloDAO;

    /**
     * Constantes
     */

    private final static String INSERT = "INSERT INTO elemento_modelo(id, id_elemento, id_modelo) VALUES(?, ?, ?)";
    private final static String UPDATE = "UPDATE elemento_modelo SET id_modelo = ? WHERE idElemento = ? AND id_modelo = ?";
    private final static String DELETE = "DELETE FROM elemento_modelo WHERE id_elemento = ? AND id_modelo = ?";
    private final static String GET_BY_ID = "SELECT id, id_elemento, id_modelo FROM elemento_modelo WHERE idElemento = ? AND id_modelo = ?";
    private final static String GET_BY_CODMODELO = "SELECT id, id_elemento, id_modelo FROM elemento_modelo WHERE id_modelo = ?";

    /**
     * Constructor con Conexión a la Base de Datos
     */

    public ElementoModeloDAO (Connection conn) throws SQLException {
        this.conn = conn;
        elementoDAO = new ElementoDAO(conn);
        modeloDAO = new ModeloDAO(conn);
    }

    /**
     * Método para Crear un nuevo ElementoModelo
     */

    public boolean crear (String codigoElemento, String codigoModelo) {
        boolean respuesta = false;
        try {
            PreparedStatement statement = conn.prepareStatement(INSERT);
            statement.setString(1, null);
            statement.setString(2, String.valueOf(getIdElemento(codigoElemento)));
            statement.setString(3, String.valueOf(getIdModelo(codigoModelo)));
            if (statement.executeUpdate() != 0) {
                respuesta = true;
            }
        } catch (SQLException throwables) {
            return respuesta;
        }
        return respuesta;
    }

    private int getIdElemento (String elemento) {
        return this.elementoDAO.getId(elemento);
    }

    private int getIdModelo (String modelo) {
        return this.modeloDAO.getId(modelo);
    }

    /**
     * Método para Obtener el ID del ElementoModelo mediante su Código de Elemento y
     * Código de Modelo
     */

    public int getId (String codigoElemento, String codigoModelo) {
        int resultado = -1;
        try {
            PreparedStatement statement = conn.prepareStatement(GET_BY_ID);
            statement.setString(1, String.valueOf(getIdElemento(codigoElemento)));
            statement.setString(2, String.valueOf(getIdModelo(codigoModelo)));
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
     * Método para Actualizar el Código del Modelo
     */

    public boolean actualizarModelo (String codigoElemento, String codigoModelo, String codigoNuevoModelo) {
        boolean respuesta = false;
        try {
            PreparedStatement statement = conn.prepareStatement(UPDATE);
            statement.setString(1, codigoNuevoModelo);
            statement.setString(2, String.valueOf(getIdElemento(codigoElemento)));
            statement.setString(3, String.valueOf(getIdModelo(codigoModelo)));
            if (statement.executeUpdate() != 0) {
                respuesta = true;
            }
        } catch (SQLException throwables) {
            return respuesta;
        }
        return respuesta;
    }

    /**
     * Método para Obtener todos los Elementos mediante el Código del Modelo
     */

    public List<Elemento> getElementosByCodigoModelo (String codigoModelo) {
        List<Elemento> listaElementos = new ArrayList<>();
        try {
            PreparedStatement statement = conn.prepareStatement(GET_BY_CODMODELO);
            statement.setString(1, codigoModelo);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                listaElementos.add(elementoDAO.convertir(resultSet));
            }
        } catch (SQLException throwables) {
            return null;
        }
        return listaElementos;
    }

    /**
     * Método para Eliminar un ElementoModelo mediante el Código de Elemento  y
     * Código de Modelo
     */

    public boolean borrar (String codigoElemento, String codigoModelo) {
        boolean respuesta = false;
        try {
            PreparedStatement statement = conn.prepareStatement(DELETE);
            statement.setString(1, String.valueOf(getIdElemento(codigoElemento)));
            statement.setString(2, String.valueOf(getIdModelo(codigoModelo)));
            if (statement.executeUpdate() != 0) {
                respuesta = true;
            }
        } catch (SQLException throwables) {
            return respuesta;
        }
        return respuesta;
    }
}