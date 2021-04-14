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

        //System.out.println(categoriaDAO.crear("Gama Prueba"));
        /**
         * Echarle un vistazo a los métodos para arreglar el control de errores
         */
        //System.out.println(categoriaDAO.actualizar("Gama EstándarPrueba", "Gama Estándar"));
        //System.out.println(categoriaDAO.getCategoriaById(75));
        //System.out.println(categoriaDAO.getId("Gama Económica"));
        //System.out.println(categoriaDAO.borrar("Prueba"));
        //System.out.println(categoriaDAO.exists("Gama Económica"));
        //System.out.println(categoriaDAO.getAll());

        /**
         * ElementoDAO
         */

        //System.out.println(elementoDAO.crear());

    }


}
