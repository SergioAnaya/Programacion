package org.example.Persistencia.DAO;

import org.example.Modelo.Elemento;

import javax.xml.transform.stax.StAXResult;
import java.security.interfaces.ECKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ElementoDAO {

    /**
     * Instancias
     */

    private Connection conn;
    private TipoElementoDAO tipoElementoDAO;

    /**
     * Constantes
     */

    private final static String INSERT = "INSERT INTO elemento(id, codigo, id_tipo_elemento) VALUES(?, ?, ?)";
    private final static String UPDATE = "UPDATE elemento SET codigo = ? WHERE codigo = ?";
    private final static String DELETE = "DELETE FROM elemento WHERE codigo = ?";
    private final static String GET_BY_CODIGO = "SELECT id, codigo, id_tipo_elemento FROM elemento WHERE codigo = ?";
    private final static String GET_BY_ID = "SELECT id, codigo, id_tipo_elemento FROM elemento WHERE id = ?";

    /**
     * Constructor con Conexión a la Base de Datos
     */

    public ElementoDAO (Connection conn) throws SQLException {
        this.conn = conn;
        tipoElementoDAO = new TipoElementoDAO(conn);
    }

    /**
     * Método para Crear un nuevo Elemento
     */


    public boolean crear (Elemento elemento) {
        boolean respuesta = false;
        try {
            PreparedStatement statement = conn.prepareStatement(INSERT);
            statement.setString(1, null);
            statement.setString(2, elemento.getCodigo());
            statement.setString(3, String.valueOf(getIdTipo(elemento.getTipo())));
            if (statement.executeUpdate() != 0) {
                respuesta = true;
            }
        } catch (SQLException throwables) {
            return respuesta;
        }
        return respuesta;
    }

    private int getIdTipo (String tipo) {
        return this.tipoElementoDAO.getId(tipo);
    }

    /**
     * Método para Obtener un Elemento mediante su Codigo
     */

    public Elemento leer (String codigo) {
        Elemento elemento = null;
        try {
            PreparedStatement statement = conn.prepareStatement(GET_BY_CODIGO);
            statement.setString(1, codigo);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                elemento = convertir(resultSet);
            }
        } catch (SQLException throwables) {
            return elemento;
        }
        return elemento;
    }

    /**
     * Método para Obtener el ID de un Elemento mediante su Código
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
            return -1;
        }
        return resultado;
    }

    /**
     * Método para Obtener un Elemento mediante su ID
     */

    public Elemento getElementoById (int id) {
        Elemento elemento = null;
        try {
            PreparedStatement statement = conn.prepareStatement(GET_BY_ID);
            statement.setString(1, String.valueOf(id));
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                elemento = convertir(resultSet);
            }
        } catch (SQLException throwables) {
            return null;
        }
        return elemento;
    }

    /**
     * Método para Actualizar el Código de un Elemento
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
     * Método para Eliminar un Elemento mediante su Código
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
            return false;
        }
        return respuesta;
    }

    /**
     * Método para Convertir a objetos los Elementos para su posterior uso
     */

    public Elemento convertir (ResultSet resultSet) throws SQLException {
        String codigo = resultSet.getString("codigo");
        String idTipoElemento = resultSet.getString("id_tipo_elemento");
        String tipoElemento = getElementoTipo(idTipoElemento);
        Elemento elemento = new Elemento(tipoElemento, codigo);
        return elemento;
    }

    private String getElementoTipo (String codigo) {
        return this.tipoElementoDAO.getTipoElementoById(Integer.parseInt(codigo));
    }
}