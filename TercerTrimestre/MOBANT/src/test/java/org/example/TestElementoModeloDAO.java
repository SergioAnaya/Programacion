package org.example;

import org.example.Modelo.Elemento;
import org.example.Modelo.Modelo;
import org.example.Persistencia.DAO.*;
import org.example.Persistencia.DBConn;
import org.example.TestHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TestElementoModeloDAO {

    private Connection conn;
    private ElementoModeloDAO elementoModeloDAO;
    private Elemento elemento1, elemento2;
    private Modelo modelo1, modelo2, nuevoModelo;

    public TestElementoModeloDAO() throws SQLException {
        conn = DBConn.conectar();
        TestHelper.borrarBD(conn);
        elementoModeloDAO = new ElementoModeloDAO(conn);
        inicializar();
    }

    private void inicializar() throws SQLException {
        // Crear tipoElemento silla
        TipoElementoDAO tipoElementoDAO = new TipoElementoDAO(conn);
        tipoElementoDAO.crear("silla");

        // Crear elementos silla/sc0331 y silla/sc0555
        elemento1 = new Elemento("silla","sc0331");
        elemento2 = new Elemento("silla","sc0555");

        ElementoDAO elementoDAO = new ElementoDAO(conn);
        elementoDAO.crear(elemento1);
        elementoDAO.crear(elemento2);

        // Crear sección cocina
        SeccionDAO seccionDAO = new SeccionDAO(conn);
        String seccion = "cocina";
        seccionDAO.crear(seccion);

        // Crear categoría Gama económica
        CategoriaDAO categoriaDAO = new CategoriaDAO(conn);
        categoriaDAO.crear("Gama económica");

        // Crear modelo C1001/cocina/Gama económica y C1002/cocina/Gama económica
        modelo1 = new Modelo("C1001",seccion,"Gama económica");
        modelo2 = new Modelo("C2001",seccion,"Gama económica");
        nuevoModelo = new Modelo("C1002",seccion,"Gama económica");

        ModeloDAO modeloDAO = new ModeloDAO(conn);
        modeloDAO.crear(modelo1);
        modeloDAO.crear(modelo2);
        modeloDAO.crear(nuevoModelo);

        insertarNuevaTupla(elemento1.getCodigo(),modelo1.getCodigo());
    }

    public void ejecutar(){
        testCrear(elemento2, modelo2);
        testActualizar(elemento1, modelo1,nuevoModelo);
        testGetElementosByCodigoModelo(nuevoModelo.getCodigo());
        testBorrar(elemento1,nuevoModelo);
    }

    private void testCrear(Elemento elemento, Modelo modelo){
        TestHelper.printResultadoTest("TestElementoModeloDAO::crear (i)",elementoModeloDAO.crear(elemento.getCodigo(),modelo.getCodigo()));
        TestHelper.printResultadoTest("TestElementoModeloDAO::crear (ii)",contarNumeroTuplas(elemento.getCodigo(),modelo.getCodigo()) == 1);
        TestHelper.printResultadoTest("TestElementoModeloDAO::crear (iii)",!elementoModeloDAO.crear(elemento.getCodigo(),modelo.getCodigo()));
    }

    private void testActualizar(Elemento elemento, Modelo modelo, Modelo nuevoModelo){
        TestHelper.printResultadoTest("TestElementoModeloDAO::actualizar (i)",elementoModeloDAO.actualizarModelo(elemento.getCodigo(),modelo.getCodigo(),nuevoModelo.getCodigo()));
        TestHelper.printResultadoTest("TestElementoModeloDAO::actualizar (ii)",contarNumeroTuplas(elemento.getCodigo(),nuevoModelo.getCodigo()) == 1);
        TestHelper.printResultadoTest("TestElementoModeloDAO::actualizar (iii)",!elementoModeloDAO.actualizarModelo(elemento.getCodigo(),"inexistente"+(Math.random()*1000),nuevoModelo.getCodigo()));
    }

    private void testGetElementosByCodigoModelo(String codigoModelo){
        elementoModeloDAO.crear(elemento2.getCodigo(), modelo1.getCodigo());
        List<Elemento> elementos = elementoModeloDAO.getElementosByCodigoModelo(modelo1.getCodigo());
        TestHelper.printResultadoTest("TestElementoModeloDAO::testGetElementosByCodigoModelo (i)",elementos.size() == 1);
        TestHelper.printResultadoTest("TestElementoModeloDAO::testGetElementosByCodigoModelo (ii)",elementos.contains(elemento2));
        TestHelper.printResultadoTest("TestElementoModeloDAO::testGetElementosByCodigoModelo (iii)",elementoModeloDAO.getElementosByCodigoModelo("inexistente").size() == 0);
        System.out.println(elementos);
        TestHelper.pausar();
    }

    private void testBorrar(Elemento elemento, Modelo nuevoModelo){
        TestHelper.printResultadoTest("TestElementoModeloDAO::borrar (i)",elementoModeloDAO.borrar(elemento.getCodigo(),nuevoModelo.getCodigo()));
        TestHelper.printResultadoTest("TestElementoModeloDAO::borrar (ii)",contarNumeroTuplas(elemento.getCodigo(),nuevoModelo.getCodigo()) == 0);
        TestHelper.printResultadoTest("TestElementoModeloDAO::borrar (iii)",!elementoModeloDAO.borrar("inexistente"+(Math.random()*1000),"inexistente"));
    }

    private int getIdModeloByCodigo(String codigo) {
        try {
            ResultSet result = conn.prepareStatement("SELECT id FROM modelo WHERE codigo = '"+codigo+"'").executeQuery();
            if (result.next()) return result.getInt(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }

    private int getIdElementoByCodigo(String codigo) {
        try{
            ResultSet result = conn.prepareStatement("SELECT id FROM elemento WHERE codigo = '"+codigo+"'").executeQuery();
            if (result.next()) return result.getInt(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }

    private int contarNumeroTuplas(String codigoElemento, String codigoModelo){
        try{
            int idElemento = getIdElementoByCodigo(codigoElemento);
            int idModelo= getIdModeloByCodigo(codigoModelo);
            ResultSet result = conn.prepareStatement("SELECT COUNT(*) FROM elemento_modelo WHERE id_elemento  = '"+idElemento+"' AND id_modelo = '"+idModelo+"'").executeQuery();
            if (result.next())
                return result.getInt(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }

    private boolean insertarNuevaTupla(String codigoElemento, String codigoModelo){
        try{
            int idElemento = getIdElementoByCodigo(codigoElemento);
            int idModelo = getIdModeloByCodigo(codigoModelo);
            return conn.prepareStatement("INSERT INTO elemento_modelo(id_elemento,id_modelo) VALUES ('"+idElemento+"','"+idModelo+"')").executeUpdate() == 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

}
