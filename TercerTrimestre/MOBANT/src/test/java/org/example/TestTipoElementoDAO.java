package org.example;

import org.example.persistencia.dao.TipoElementoDAO;
import org.example.persistencia.DBConn;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TestTipoElementoDAO {
    private Connection conn;
    private TipoElementoDAO tipoElementoDAO;

    public TestTipoElementoDAO() throws SQLException {
        conn = DBConn.conectar();
        TestHelper.borrarBD(conn);
        tipoElementoDAO = new TipoElementoDAO(conn);
    }

    public void ejecutar(){
        testCrear("silla");
        testGetTipoElementoById("silla");
        testActualizar("silla","mesa");
        testExists("mesa");
        testGetAll();
        testBorrar("mesa");
    }

    public void testCrear(String nombre){
        TestHelper.printResultadoTest("TestTipoElementoDAO::crear (i)",tipoElementoDAO.crear(nombre));
        TestHelper.printResultadoTest("TestTipoElementoDAO::crear (ii)",contarTuplas(nombre) == 1);
        TestHelper.printResultadoTest("TestTipoElementoDAO::crear (iii)",!tipoElementoDAO.crear(nombre));
    }

    public void testGetTipoElementoById(String nombre) {
        int id = getId(nombre);
        TestHelper.printResultadoTest("TestTipoElementoDAO::tipoElementoById (i)",(id > -1) && (tipoElementoDAO.getTipoElementoById(id).equals(nombre)));
        TestHelper.printResultadoTest("TestTipoElementoDAO::tipoElementoById (ii)",tipoElementoDAO.getTipoElementoById(Integer.MAX_VALUE) == null);
    }

    public void testActualizar(String nombre, String nuevoNombre){
        TestHelper.printResultadoTest("TestTipoElementoDAO::actualizar (i)",tipoElementoDAO.actualizar(nombre,nuevoNombre));
        TestHelper.printResultadoTest("TestTipoElementoDAO::actualizar (ii)",contarTuplas(nuevoNombre) == 1);
        TestHelper.printResultadoTest("TestTipoElementoDAO::actualizar (iii)",contarTuplas(nombre) == 0);
        TestHelper.printResultadoTest("TestTipoElementoDAO::actualizar (iv)",!tipoElementoDAO.actualizar("inexistente",nuevoNombre));
    }

    public void testExists(String nombre){
        TestHelper.printResultadoTest("TestTipoElementoDAO::exists (i)",tipoElementoDAO.exists(nombre));
        TestHelper.printResultadoTest("TestTipoElementoDAO::exists (ii)",contarTuplas(nombre) == 1);
        TestHelper.printResultadoTest("TestTipoElementoDAO::exists (iii)",!tipoElementoDAO.exists("inexistente"+(Math.random()*1000)));
    }

    public void testGetAll(){
        tipoElementoDAO.crear("escritorio");
        List<String> tiposElementosObtenidos = tipoElementoDAO.getAll();
        TestHelper.printResultadoTest("TestTipoElementoDAO::getAll (i)",tiposElementosObtenidos.size() == 2);
        TestHelper.printResultadoTest("TestTipoElementoDAO::getAll (ii)",tiposElementosObtenidos.contains("mesa") && tiposElementosObtenidos.contains("escritorio"));
    }

    public void testBorrar(String nombre){
        TestHelper.printResultadoTest("TestTipoElementoDAO::borrar (i)",tipoElementoDAO.borrar(nombre));
        TestHelper.printResultadoTest("TestTipoElementoDAO::borrar (ii)",contarTuplas(nombre) == 0);
        TestHelper.printResultadoTest("TestTipoElementoDAO::borrar (iii)",!tipoElementoDAO.borrar("inexistente"+(Math.random()*1000)));
    }

    private int contarTuplas(String nombre){
        try {
            ResultSet result = conn.prepareStatement("SELECT COUNT(*) FROM tipo_elemento WHERE nombre = '"+nombre+"'").executeQuery();
            if (result.next())
                return result.getInt(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }

    private int getId(String nombre){
        try {
            ResultSet result = conn.prepareStatement("SELECT id FROM tipo_elemento WHERE nombre = '"+nombre+"'").executeQuery();
            if (result.next())
                return result.getInt(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }
}
