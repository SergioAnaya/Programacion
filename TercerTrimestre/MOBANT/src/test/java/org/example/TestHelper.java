package org.example;

import org.example.persistencia.DBConn;

import java.sql.Connection;
import java.sql.SQLException;

public class TestHelper {

    public static void borrarBD(Connection conn) {
        try {
            conn.prepareStatement("DELETE FROM elemento_modelo").executeUpdate();
            conn.prepareStatement("DELETE FROM modelo").executeUpdate();
            conn.prepareStatement("DELETE FROM elemento").executeUpdate();
            conn.prepareStatement("DELETE FROM categoria").executeUpdate();
            conn.prepareStatement("DELETE FROM tipo_elemento").executeUpdate();
            conn.prepareStatement("DELETE FROM seccion").executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void pruebaConexion() throws SQLException {
        System.out.print("Prueba de conexión - ");
        Connection conn = DBConn.conectar();
        if (conn == null) {
            System.out.println("No hay conexión");
            System.exit(-1);
        } else {
            System.out.println("Ok");
            DBConn.desconectar();
        }
    }

    public static void printResultadoTest(String mensaje, boolean ok) {
        System.out.print(mensaje + " - ");
        if (ok) System.out.println("Ok");
        else System.out.println("Ko");
    }

    public static void pausar(){
        System.out.println("Press Enter key to continue...");
        try {
            System.in.read();
        }
        catch(Exception e) {}
    }
}
