package org.example;

import org.example.persistencia.dao.CategoriaDAO;
import org.example.persistencia.DBConn;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestCategoriaDAO {
    private Connection conn;
    private CategoriaDAO categoriaDAO;

    public TestCategoriaDAO() throws SQLException {
        conn = DBConn.conectar();
        TestHelper.borrarBD(conn);
        categoriaDAO = new CategoriaDAO(conn);
    }

    public void ejecutar() throws SQLException {
        testCrear("Gama económica");
        testGetId("Gama económica");
        testGetCategoriaById("Gama económica");
        testActualizar("Gama económica","gama económica");
        testExists("gama económica");
        testGetAll();
        testBorrar("gama económica");
    }

    public void testCrear(String nombre) throws SQLException {
        TestHelper.printResultadoTest("TestCategoriaDAO::crear (i)",categoriaDAO.crear(nombre));
        TestHelper.printResultadoTest("TestCategoriaDAO::crear (ii)",!categoriaDAO.crear(nombre));
    }

    public void testGetId(String nombre){
        TestHelper.printResultadoTest("TestCategoriaDAO::getId (1)",categoriaDAO.getId(nombre) > -1);
        TestHelper.printResultadoTest("TestCategoriaDAO::getId (2)", categoriaDAO.getId("Inexistente") == -1);
    }

    public void testGetCategoriaById(String nombre){
        int id = categoriaDAO.getId(nombre);
        TestHelper.printResultadoTest("TestCategoriaDAO::getCategoriaById (i)",(id > -1) && (categoriaDAO.getCategoriaById(id).equals(nombre)));
        TestHelper.printResultadoTest("TestCategoriaDAO::getCategoriaById (ii)", categoriaDAO.getCategoriaById(Integer.MAX_VALUE) == null);
    }

    public void testActualizar(String nombre, String nuevoNombre) throws SQLException {
        TestHelper.printResultadoTest("TestCategoriaDAO::actualizar (i)",categoriaDAO.actualizar(nombre,nuevoNombre));
        TestHelper.printResultadoTest("TestCategoriaDAO::actualizar (ii)",!categoriaDAO.actualizar("Inexistente","modificado"));
    }

    public void testExists(String nombre){
        TestHelper.printResultadoTest("TestCategoriaDAO::exists (i)",categoriaDAO.exists(nombre));
        TestHelper.printResultadoTest("TestCategoriaDAO::exists (ii)",!categoriaDAO.exists("inexistente"));
    }

    public void testGetAll() throws SQLException {
        categoriaDAO.crear("gama media");
        List<String> categorias = categoriaDAO.getAll();
        TestHelper.printResultadoTest("TestCategoriaDAO::getAll (i)",categorias.size() == 2);
        TestHelper.printResultadoTest("TestCategoriaDAO::getAll (ii)", categorias.contains("gama económica") && categorias.contains("gama media"));
    }

    public void testBorrar(String nombre){
        TestHelper.printResultadoTest("TestCategoriaDAO::borrar (1)",categoriaDAO.borrar(nombre));
        TestHelper.printResultadoTest("TestCategoriaDAO::borrar (ii)",!categoriaDAO.exists(nombre));
        TestHelper.printResultadoTest("TestCategoriaDAO::borrar (ii)",!categoriaDAO.exists(nombre));
        TestHelper.printResultadoTest("TestCategoriaDAO::borrar (iii)",!categoriaDAO.borrar("inexistente"));
    }
}
