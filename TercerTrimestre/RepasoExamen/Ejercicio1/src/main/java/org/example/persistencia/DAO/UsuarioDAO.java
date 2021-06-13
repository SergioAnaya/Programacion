package org.example.persistencia.DAO;

import org.example.modelo.Usuario;

import java.security.PrivilegedAction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    /**
     * Instancias
     */

    private Connection conn;

    /**
     * Constantes
     */

    private final static String INSERT = "INSERT INTO usuarios(nombre, edad) VALUES (?, ?)";
    private final static String GETALL = "SELECT id, nombre, edad FROM usuarios";
    private final static String UPDATE_EDAD = "UPDATE usuarios SET edad = ? WHERE nombre = ? ";
    private final static String DELETE = "DELETE FROM usuarios WHERE nombre = ?";

    /**
     * Constructor con Conexión a la Base de Datos
     */

    public UsuarioDAO (Connection conn) {
        this.conn = conn;
    }

    /**
     * Método para Crear un Usuario
     */

    public boolean crear (Usuario usuario) {
        boolean respuesta = false;
        try {
            PreparedStatement statement = conn.prepareStatement(INSERT/*, statement.RETURN_GENERATED_LEYS*/);
            statement.setString(1, usuario.getNombre());
            statement.setInt(2, usuario.getEdad());
            if (statement.executeUpdate() != 0) {
                respuesta = true;
            }
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                usuario.setId(resultSet.getInt(1));
            } else respuesta = false;
        } catch (SQLException throwables) {
            return respuesta;
        }
        return respuesta;
    }

    /**
     * Método para Actualizar la Edad de un Usuario mediante su Nombre
     */

    public boolean actualizar (int nuevaEdad, String nombre) {
        boolean respuesta = false;
        try {
            PreparedStatement statement = conn.prepareStatement(UPDATE_EDAD);
            statement.setInt(1, nuevaEdad);
            statement.setString(2, nombre);
            if (statement.executeUpdate() != 0) {
                respuesta = true;
            }
        } catch (SQLException throwables) {
            return respuesta;
        }
        return respuesta;
    }

    /**
     * Método para Obtener una Lista de los Usuarios
     */

    public List<Usuario> leerTodos () {
        List<Usuario> listaUsuarios = new ArrayList<>();
        try {
            PreparedStatement statement = conn.prepareStatement(GETALL);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Usuario usuario = new Usuario(resultSet.getString("nombre"), resultSet.getInt("edad"));
                usuario.setId(resultSet.getInt("id"));
                listaUsuarios.add(usuario);
            }
        } catch (SQLException throwables) {
            return null;
        }
        return listaUsuarios;
    }

    /**
     * Método para Borrar un Usuario por su Nombre
     */

    public boolean borrar (String nombre) {
        boolean respuesta = false;
        try {
            PreparedStatement statement = conn.prepareStatement(DELETE);
            statement.setString(1, nombre);
            if (statement.executeUpdate() != 0) {
                respuesta = true;
            }
        } catch (SQLException throwables) {
            return respuesta;
        }
        return respuesta;
    }
}
