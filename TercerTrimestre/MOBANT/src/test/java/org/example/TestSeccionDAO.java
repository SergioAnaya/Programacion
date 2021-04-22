package org.example;

import org.example.Persistencia.DAO.SeccionDAO;
import org.example.Persistencia.DBConn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TestSeccionDAO {
    private static Connection conn;
    private static String seccion1, seccion2;
    private SeccionDAO seccionDAO;

    public TestSeccionDAO() throws SQLException {
        this.conn = DBConn.conectar();
        TestHelper.borrarBD(conn);
        seccionDAO = new SeccionDAO(conn);
        seccion1 = "cocina";
        seccion2 = "comedor";
        seccionDAO.crear(seccion1);
    }

    public void ejecutar() throws SQLException {
        testCrearSeccion(seccion2);
        testExists(seccion2);
        testGetAll(new String[]{seccion1,seccion2});
        testModificarSeccion(seccion2,"baño");
        testBorrarSeccion("baño");
        seccionDAO.borrar(seccion1);
    }

    private void testCrearSeccion(String seccion) throws SQLException {
        TestHelper.printResultadoTest("TestSeccionDAO::crear (i)",seccionDAO.crear(seccion));
        TestHelper.printResultadoTest("TestSeccionDAO::crear (ii)",contarTuplas(seccion)==1);
        TestHelper.printResultadoTest("TestSeccionDAO::crear (ii)",!seccionDAO.crear(seccion));
    }


    private void testModificarSeccion(String seccion, String nuevoNombre) throws SQLException {
        TestHelper.printResultadoTest("TestSeccionDAO::actualizar (i)",seccionDAO.actualizar(seccion,nuevoNombre));
        TestHelper.printResultadoTest("TestSeccionDAO::actualizar (ii)",contarTuplas(nuevoNombre) == 1);
        TestHelper.printResultadoTest("TestSeccionDAO::actualizar (iii)",contarTuplas(seccion) == 0);
        TestHelper.printResultadoTest("TestSeccionDAO::actualizar (iv)",!seccionDAO.actualizar("inexistente",nuevoNombre));
    }

    private void testGetAll(String[] seccionesEsperadas) throws SQLException {
        List<String> seccionesObtenidas = seccionDAO.getAll();
        TestHelper.printResultadoTest("TestSeccionDAO::getAll (i)",seccionesObtenidas.size() == 2);
        for (String seccion: seccionesEsperadas)
            TestHelper.printResultadoTest("TestSeccionDAO::getAll (ii) - subtest",seccionesObtenidas.contains(seccion));
    }

    private void testExists(String nombre) throws SQLException {
        TestHelper.printResultadoTest("TestSeccionDAO::exists (i)",seccionDAO.exists(nombre));
        TestHelper.printResultadoTest("TestSeccionDAO::exists (ii)",contarTuplas(nombre) == 1);
        TestHelper.printResultadoTest("TestSeccionDAO::exists (iii)",!seccionDAO.exists("inexistente"+(Math.random()*1000)));
    }

    private void testBorrarSeccion(String nombre) throws SQLException {
        TestHelper.printResultadoTest("TestSeccionDAO::borrar (i)",seccionDAO.borrar(nombre));
        TestHelper.printResultadoTest("TestSeccionDAO::borrar (ii)", contarTuplas(nombre) == 0);
        TestHelper.printResultadoTest("TestSeccionDAO::borrar (iii)", !seccionDAO.borrar("inexistente"+(Math.random()*1000)));
    }

    private int contarTuplas(String nombre){
        try{
            ResultSet result = conn.prepareStatement("SELECT COUNT(*) FROM seccion WHERE nombre = '"+nombre+"'").executeQuery();
            if (result.next())
                return result.getInt(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }

}
