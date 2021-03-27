package com.politecnicomalaga.Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    /**
     * Variables
     */

    private Connection conn;

    private static String db = "Hospital"; // Nombre base de datos
    private static String login = "sergio"; // Nombre usuario de la base de datos
    private static String password = "sergio"; // // Contraseña de usuario de la base de datos
    private static String url = "jdbc:mysql://192.168.0.216:3306/" + db + "?useSSL=false";

    /**
     * Constructor Vacío
     */

    public DBConnection () {}

    /**
     * Método para conectarse a la base de datos
     */

    public Connection conectar () throws SQLException {
        conn = DriverManager.getConnection(url, login, password);
        return conn;
    }

    /**
     * Método para desconectarse de la base de datos
     */

    public void desconectar () throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

    public static void main(String[] args) throws SQLException {

        DBConnection dbConnection = new DBConnection();
        dbConnection.conectar();

    }

}
