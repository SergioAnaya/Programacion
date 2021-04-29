package org.example.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {

    /**
     * Variables
     */

    private static Connection conn;
    private static String db = "mobant"; // Nombre de la Base de Datos
    private static String userLogin = "sergio"; // Nombre usuario de la Base de Datos
    private static String passLogin = "sergio"; // Contraseña del usuario
    private static String url = "jdbc:mysql://192.168.0.54:3306/" + db + "?useSSL=False";

    /**
     * Constructor Vacío
     */

    public DBConn() {}

    /**
     * Método para Conectarse a la Base de Datos
     */

    public static Connection conectar() {
        try {
            conn = DriverManager.getConnection(url, userLogin, passLogin);
        } catch (SQLException throwables) {
            return null;
        }
        return conn;
    }

    /**
     * Método para Desconectarse de la Base de Datos
     */

    public static void desconectar() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }
}