package org.example;

import org.example.modelo.Usuario;
import org.example.persistencia.DAO.UsuarioDAO;
import org.example.persistencia.DBConn;

public class Main {

    public static void main(String[] args) {

        /**
         * Después, escribe el código necesario para llevar a cabo las siguientes tareas:
         *
         * Insertar los usuarios siguientes:
         * "Pedro García", 33 años.
         * "Carlos Orozco", 15 años.
         * "Ana López", 21 años.
         * Leer de la base de datos los datos anteriores y cargarlos en una lista de tipo List<Usuario>. Recorre la lista, mostrando el contenido de los objetos que contiene.
         * Modificar la base de datos, de forma que el usuario "Pedro García" tenga 23 años.
         * Borrar el registro de "Ana López".
         */


        /**
         * Instancias
         */

        DBConn dbConn = new DBConn();
        UsuarioDAO usuarioDAO = new UsuarioDAO(dbConn.conectar());

        /**
         * Se crean los 3 Usuarios
         */

        Usuario usuario1 = new Usuario("Pedro García", 33);
        Usuario usuario2 = new Usuario("Carlos Orozco", 15);
        Usuario usuario3 = new Usuario("Ana López", 21);

        /**
         * Se insertan los 3 Usuarios
         */

        //System.out.println(usuarioDAO.crear(usuario1));
        //System.out.println(usuarioDAO.crear(usuario2));
        //System.out.println(usuarioDAO.crear(usuario3));

        /**
         * Se muestra la lista de los Usuarios
         */

        //System.out.println(usuarioDAO.leerTodos());

        /**
         * Método para Actualizar
         */

        //System.out.println(usuarioDAO.actualizar(23, "Pedro García"));

        /**
         * Método para Borrar
         */

        //System.out.println(usuarioDAO.borrar("Ana López"));

        /**
         * Método para Desconectarse de la Base de Datos
         */

        dbConn.desconectar();

    }

}
