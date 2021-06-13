package org.example;

import org.example.persistencia.DBConn;
import org.example.persistencia.dao.ModeloDAO;

public class Main {

    public static void main(String[] args) {

        DBConn dbConn = new DBConn();
        ModeloDAO modeloDAO = new ModeloDAO(dbConn.conectar());

        System.out.println(modeloDAO.getCodigosModelos());

    }
}
