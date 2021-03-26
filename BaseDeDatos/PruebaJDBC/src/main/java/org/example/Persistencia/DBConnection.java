package org.example.Persistencia;

import org.example.Modelo.Alumno;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase para realizar la conexión a la Base de Datos
 */

public class DBConnection {

    /**
     * Variables
     */

    private Connection conn;

    private static String db = "Hospital"; // Nombre base de datos
    private static String login = "sergio"; // Nombre usuario de la base de datos
    private static String password = "sergio"; // // Contraseña de usuario de la base de datos
    private static String url = "jdbc:mysql://192.168.0.216:3306/" + db + "?useSSL=false";
    private ResultSet resultSet;

    public DBConnection () {

    }

    public Connection conectar () throws SQLException {
        conn = DriverManager.getConnection(url, login, password);
        return conn;
    }

    public void desconectar () throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

    public List<Alumno> cargarAlumnos () throws SQLException {
        List<Alumno> listaAlumnos = new LinkedList<>();
        resultSet = conn.prepareStatement("SELECT * FROM Alumnos").executeQuery();

        while (resultSet.next()) {
            Alumno alumno = resultSetToAlumnos(resultSet);
            listaAlumnos.add(alumno);

        }
        return listaAlumnos;
    }

    public Alumno resultSetToAlumnos (ResultSet resultSet) throws SQLException {

        int id = resultSet.getInt("Id");
        String nombre = resultSet.getString("Nombre");
        String apellidos = resultSet.getString("Apellidos");
        String dni = resultSet.getString("DNI");

        Alumno alumno = new Alumno(nombre, apellidos, dni);
        alumno.setId(id);

        return alumno;
    }
}


