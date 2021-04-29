package org.example;

import org.example.modelo.Elemento;
import org.example.persistencia.dao.ElementoDAO;
import org.example.persistencia.dao.TipoElementoDAO;
import org.example.persistencia.DBConn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestElementoDAO {

    private Connection conn;
    private ElementoDAO elementoDAO;
    private Elemento elemento;

    public TestElementoDAO() throws SQLException {
        conn = DBConn.conectar();
        TestHelper.borrarBD(conn);
        inicializar();
        elementoDAO = new ElementoDAO(conn);
        elemento = new Elemento("silla","SC0331");
    }

    private void inicializar() throws SQLException {
        TipoElementoDAO tipoElementoDAO = new TipoElementoDAO(conn);
        tipoElementoDAO.crear("silla");
    }

    public void ejecutar(){
        testCrear(elemento);
        testGetId(elemento.getCodigo());
        testLeer(elemento.getCodigo());
        testActualizar(elemento,"sc0332");
        testBorrar("sc0332");
    }

    public void testCrear(Elemento elemento){
        TestHelper.printResultadoTest("TestElementoDAO::crear (i)",elementoDAO.crear(new Elemento("silla","SC0331")));
        TestHelper.printResultadoTest("TestElementoDAO::crear (ii)",!elementoDAO.crear(new Elemento("silla","SC0331")));
        TestHelper.printResultadoTest("TestElementoDAO::crear (iii)",contarTuplas("SC0331") == 1);
    }
    public void testLeer(String codigo){
        Elemento elemento = elementoDAO.leer(codigo);
        TestHelper.printResultadoTest("TestElementoDAO::leer (i)",(elemento.getCodigo().equals(codigo)) && (elemento.getTipo().equals("silla")));
        TestHelper.printResultadoTest("TestElementoDAO::leer (ii)", elementoDAO.leer("inexistente"+(Math.random()*1000)) == null);
    }

    public void testGetId(String codigo){
        int id = getIdElemento(codigo);
        TestHelper.printResultadoTest("TestElementoDAO::getId (i)",elementoDAO.getId(codigo) == id);
        TestHelper.printResultadoTest("TestElementoDAO::getId (ii)",elementoDAO.getId("inexistente"+(Math.random()*1000)) == -1);
    }

    public void testActualizar(Elemento elemento, String nuevoCodigo){
        TestHelper.printResultadoTest("TestElementoDAO::actualizar (i)",elementoDAO.actualizar(elemento.getCodigo(),nuevoCodigo));
        TestHelper.printResultadoTest("TestElementoDAO::actualizar (ii)",contarTuplas(nuevoCodigo) == 1);
        TestHelper.printResultadoTest("TestElementoDAO::actualizar (iii)",contarTuplas(elemento.getCodigo()) == 0);
        TestHelper.printResultadoTest("TestElementoDAO::actualizar (iv)",!elementoDAO.actualizar("inexistente","no_importa"));
    }

    public void testBorrar(String codigo){
        TestHelper.printResultadoTest("TestElementoDAO::borrar (i)",elementoDAO.borrar(codigo));
        TestHelper.printResultadoTest("TestElementoDAO::borrar (ii)",contarTuplas(codigo) == 0);
        TestHelper.printResultadoTest("TestElementoDAO::borrar (iii)",elementoDAO.getId(codigo) == -1);
    }

    private int contarTuplas(String codigo){
        try {
            ResultSet result = conn.prepareStatement("SELECT COUNT(codigo) FROM elemento WHERE codigo = '"+codigo+"'").executeQuery();
            if (result.next())
                return result.getInt(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }

    private int getIdElemento(String codigo) {
        try {
            ResultSet result = conn.prepareStatement("SELECT id FROM elemento WHERE codigo = '"+codigo+"'").executeQuery();
            if (result.next())
                return result.getInt(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }
}
