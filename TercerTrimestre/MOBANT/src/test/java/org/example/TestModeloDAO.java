package org.example;

import org.example.Modelo.Modelo;
import org.example.Persistencia.DAO.CategoriaDAO;
import org.example.Persistencia.DAO.ModeloDAO;
import org.example.Persistencia.DAO.SeccionDAO;
import org.example.Persistencia.DBConn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TestModeloDAO {
    private Connection conn;
    private ModeloDAO modeloDAO;
    private CategoriaDAO categoriaDAO;
    private String seccion1, seccion2, categoria1, categoria2;
    private Modelo modelo1, modelo2, modelo3, modelo4;

    public TestModeloDAO() throws SQLException {
        conn = DBConn.conectar();
        TestHelper.borrarBD(conn);
        modeloDAO = new ModeloDAO(conn);
        inicializar();
    }

    private void inicializar() throws SQLException {

        seccion1 = "cocina";
        seccion2 = "comedor";
        categoria1 = "Gama económica";
        categoria2 = "Gama media";

        modelo1 = new Modelo("C1001",seccion1,categoria1);
        modelo2 = new Modelo("C2001",seccion2,categoria1);
        modelo3 = new Modelo("C3001",seccion1,categoria2);
        modelo4 = new Modelo("C4001",seccion2,categoria2);

        SeccionDAO seccionDAO = new SeccionDAO(conn);
        seccionDAO.crear(seccion1);
        seccionDAO.crear(seccion2);

        CategoriaDAO categoriaDAO = new CategoriaDAO(DBConn.conectar());
        categoriaDAO.crear(categoria1);
        categoriaDAO.crear(categoria2);

        modeloDAO.crear(modelo2);
        modeloDAO.crear(modelo3);
        modeloDAO.crear(modelo4);
    }

    public void ejecutar() throws SQLException {
        testCrear(modelo1);
        testLeer(modelo1);
        testGetCodigosModelosByCategoria(categoria1,new String[]{"C1001","C2001"});
        testGetCodigosModelosBySeccion(seccion1,new String[]{"C1001","C3001"});
        testActualizar(modelo1,"C1002");
        testGetCodigosModelos(new String[]{"C1002","C2001","C3001","C4001"});
        testBorrar("C1002");
    }

    private void testCrear(Modelo modelo) {
        TestHelper.printResultadoTest("TestModeloDAO::crear (i)",modeloDAO.crear(modelo));
        TestHelper.printResultadoTest("TestModeloDAO::crear (ii)",contarTuplas(modelo.getCodigo()) == 1);
        TestHelper.printResultadoTest("TestModeloDAO::crear (ii)",!modeloDAO.crear(modelo));
    }

    private void testLeer(Modelo modeloEsperado){
        Modelo modeloObtenido = modeloDAO.leer(modeloEsperado.getCodigo());
        TestHelper.printResultadoTest("TestModeloDAO::leer (i)", modeloObtenido.getCodigo().equals(modeloEsperado.getCodigo()) &&
                modeloObtenido.getCategoria().equals(modeloEsperado.getCategoria()) &&
                modeloObtenido.getSeccion().equals(modeloEsperado.getSeccion()));
        TestHelper.printResultadoTest("TestModeloDAO::leer (ii)",modeloDAO.leer("inexistente"+(Math.random()*1000)) == null);
    }

    private void testActualizar(Modelo modelo, String nuevoCodigo){
        TestHelper.printResultadoTest("TestModeloDAO::actualizar (i)",modeloDAO.actualizar(modelo.getCodigo(),nuevoCodigo));
        TestHelper.printResultadoTest("TestModeloDAO::actualizar (ii)",contarTuplas(nuevoCodigo) == 1);
        TestHelper.printResultadoTest("TestModeloDAO::actualizar (iii)",!modeloDAO.actualizar("inexistente"+(Math.random()*1000),nuevoCodigo));
    }

    private void testGetCodigosModelos(String[] codigosEsperados){
        List<String> codigosObtenidos = modeloDAO.getCodigosModelos();
        TestHelper.printResultadoTest("TestModeloDAO::getCodigosModelos (i)",codigosObtenidos.size() == 4);
        for (String codigo:codigosEsperados)
            TestHelper.printResultadoTest("TestModeloDAO::getCodigosModelos (ii) - subtest",codigosObtenidos.contains(codigo));
    }

    private void testGetCodigosModelosBySeccion(String seccion, String[] codigosEsperados){
        List<String> codigosObtenidos = modeloDAO.getCodigosModelosBySeccion(seccion);
        for (int i=0; i<codigosEsperados.length; i++)
            TestHelper.printResultadoTest("TestModeloDAO::getCodigosModelosBySeccion (i) - subtest",codigosObtenidos.contains(codigosEsperados[i]));
        TestHelper.printResultadoTest("TestModeloDAO::getCodigosModelosBySeccion (ii)",codigosObtenidos.size()==codigosEsperados.length);
        TestHelper.printResultadoTest("TestModeloDAO::getCodigosModelosBySeccion (iii)",modeloDAO.getCodigosModelosBySeccion("inexistente"+(Math.random()*1000)).size() == 0);
    }

    private void testGetCodigosModelosByCategoria(String categoria, String[] codigosEsperados) throws SQLException {
        List<String> codigosModelos = modeloDAO.getCodigosModelosByCategoria(categoria);
        boolean ok = true;
        for (int i=0; i<codigosEsperados.length; i++)
            TestHelper.printResultadoTest("TestModeloDAO::getCodigosModelosByCategoria (i) - subtest",codigosModelos.contains(codigosEsperados[i]));
        TestHelper.printResultadoTest("TestModeloDAO::getCodigosModelosByCategoria (ii)",codigosModelos.size()==codigosEsperados.length);
        TestHelper.printResultadoTest("TestModeloDAO::getCodigosModelosByCategoria (iii)",modeloDAO.getCodigosModelosByCategoria("inexistente").size() == 0);
    }

    private void testBorrar(String codigo){
        TestHelper.printResultadoTest("TestModeloDAO::borrar (i)",modeloDAO.borrar(codigo));
        TestHelper.printResultadoTest("TestModeloDAO::borrar (ii)",contarTuplas(codigo) == 0);
        TestHelper.printResultadoTest("TestModeloDAO::borrar (iii)",!modeloDAO.borrar("inexistente" + (Math.random()*1000)));
    }

    private int contarTuplas(String codigo){
        try{
            ResultSet result = conn.prepareStatement("SELECT COUNT(*) FROM modelo WHERE codigo = '"+codigo+"'").executeQuery();
            if (result.next())
                return result.getInt(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }
}
