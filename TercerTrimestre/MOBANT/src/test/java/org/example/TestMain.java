package org.example;

import org.example.Persistencia.DBConn;

import java.sql.SQLException;

public class TestMain {
    public static void main(String[] args) throws SQLException {

        TestHelper.pruebaConexion();

        TestCategoriaDAO testCategoria = new TestCategoriaDAO();
        testCategoria.ejecutar();

        System.out.println("----------------------------------------");

        TestSeccionDAO testSeccionDAO = new TestSeccionDAO();
        testSeccionDAO.ejecutar();

        System.out.println("----------------------------------------");

        TestElementoDAO testElementoDAO = new TestElementoDAO();
        testElementoDAO.ejecutar();

        System.out.println("----------------------------------------");

        TestModeloDAO testModeloDAO = new TestModeloDAO();
        testModeloDAO.ejecutar();

        System.out.println("----------------------------------------");

        TestTipoElementoDAO testTipoElemento = new TestTipoElementoDAO();
        testTipoElemento.ejecutar();

        System.out.println("----------------------------------------");

        TestElementoModeloDAO testElementoModeloDAO = new TestElementoModeloDAO();
        testElementoModeloDAO.ejecutar();

        DBConn.desconectar();
    }
}
