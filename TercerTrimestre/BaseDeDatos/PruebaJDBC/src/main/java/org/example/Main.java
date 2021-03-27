package org.example;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        Secretaria secretaria = new Secretaria();
        System.out.println(secretaria.getListaAlumnos());

    }

}
