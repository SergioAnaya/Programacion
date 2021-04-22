package org.example;

import org.example.Modelo.Elemento;
import org.example.Persistencia.DAO.CategoriaDAO;
import org.example.Persistencia.DAO.ElementoDAO;
import org.example.Persistencia.DBConn;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        DBConn dbConn = new DBConn();

        CategoriaDAO categoriaDAO = new CategoriaDAO(dbConn.conectar());
        ElementoDAO elementoDAO = new ElementoDAO(dbConn.conectar());

        /**
         * CategoriaDAO
         */

        //System.out.println(categoriaDAO.crear("Gama de Prueba"));
        //System.out.println(categoriaDAO.actualizar("Gama Alta2", "Gama Alta"));
        //System.out.println(categoriaDAO.getCategoriaById(84));
        //System.out.println(categoriaDAO.getId("Gama Alta"));
        //System.out.println(categoriaDAO.borrar("Gama Alta"));
        //System.out.println(categoriaDAO.exists("Gama Alta"));
        //System.out.println(categoriaDAO.getAll());

        /**
         * ElementoDAO
         */



        System.out.println(elementoDAO.leer("silla"));
    }


}
