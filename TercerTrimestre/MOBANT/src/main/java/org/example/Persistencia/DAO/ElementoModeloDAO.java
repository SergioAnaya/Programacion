package org.example.Persistencia.DAO;

import org.example.Modelo.Elemento;
import org.example.Persistencia.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ElementoModeloDAO {

    /**
     * Instancias
     */

    private DBConnection dbConnection = new DBConnection();
    private Connection conn;
    private ElementoDAO elementoDAO;
    private ModeloDAO modeloDAO;

    /**
     * Constantes
     */

    /**
     * Variables
     */

    /**
     * Constructor con Conexión a la Base de Datos
     */

    public ElementoModeloDAO () throws SQLException {
        conn = dbConnection.conectar();
    }

    /**
     * Método para Crear un nuevo ElementoModelo
     */

    public boolean crear (String codigoElemento, String codigoModelo) {
        boolean respuesta = false;
        return respuesta;
    }

    /**
     * Método para Obtener el ID del ElementoModelo mediante su Código de Elemento y
     * Código de Modelo
     */

    public int getId (String codigoElemento, String codigoModelo) {
        return 1;
    }

    /**
     * Método para Actualizar el Código del Modelo
     */

    public boolean actualizarModelo (String codigoElemento, String codigoModelo, String codigoNuevoModelo) {
        boolean respuesta = false;
        return respuesta;
    }

    /**
     * Método para Obtener todos los Elementos mediante el Código del Modelo
     */

    public List<Elemento> getElementosByCodigoModelo (String codigoModelo) {
        List<Elemento> listaElementos = new ArrayList<>();
        return listaElementos;
    }

    /**
     * Método para Eliminar un ElementoModelo mediante el Código de Elemento  y
     * Código de Modelo
     */

    public boolean borrar (String codigoElemento, String codigoModelo) {
        boolean respuesta = false;
        return respuesta;
    }

}
