package org.example.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {

    private static String db = "Usuarios";
    private static String login = "sergio";
    private static String password = "sergio";
    private static String url = "jdbc:mysql://192.168.0.54:3306/" + db + "?useSSL=false";
    private Connection conn = null;

    public DBConn () {}

    public Connection conectar () {
        try {
            conn = DriverManager.getConnection(url, login, password);

            if (conn != null) {
                return conn;
            }
        } catch (SQLException throwables) {
            return null;
        }
        return conn;
    }

    public void desconectar () {conn = null;}

}
