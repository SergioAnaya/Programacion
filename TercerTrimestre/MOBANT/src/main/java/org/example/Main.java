package org.example;

import org.example.Persistencia.DAO.CategoriaDAO;
import org.example.Persistencia.DAO.ElementoDAO;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        CategoriaDAO categoriaDAO = new CategoriaDAO();
        ElementoDAO elementoDAO = new ElementoDAO();

        /**
         * CategoriaDAO
         */

        //System.out.println(categoriaDAO.crear("Gama Alta"));
        //System.out.println(categoriaDAO.actualizar("Gama Alta2", "Gama Alta"));
        //System.out.println(categoriaDAO.getCategoriaById(84));
        //System.out.println(categoriaDAO.getId("Gama Alta"));
        //System.out.println(categoriaDAO.borrar("Gama Alta"));
        //System.out.println(categoriaDAO.exists("Gama Alta"));
        //System.out.println(categoriaDAO.getAll());

        /**
         * ElementoDAO
         */

        //System.out.println(elementoDAO.crear());

    }


}
