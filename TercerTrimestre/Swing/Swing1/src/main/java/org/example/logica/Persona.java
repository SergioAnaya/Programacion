package org.example.logica;

import java.util.ArrayList;
import java.util.List;

public class Persona {

    public final static int ASALARIADO = 1;
    public final static int COMISIONADO = 2;
    public final static int POR_HORAS = 3;

    private String nombre;
    private int edad;
    private String dni;
    private int categoria;

    public Persona(String nombre, int edad, String dni, int categoria) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public static String getCategoriaById (int categoria) {
        switch (categoria) {
            case ASALARIADO:
                return "Asalariado";
            case COMISIONADO:
                return "Comisionado";
            case POR_HORAS:
                return "Por horas";
        }
        return null;
    }

    public static int getCategoriaByTag (String categoria) {
        switch (categoria) {
            case "Asalariado":
                return ASALARIADO;
            case "Comisionado":
                return COMISIONADO;
            case "Por horas":
                return POR_HORAS;
        }
        return -1;
    }

    public static List<String> getCategorias () {
        List<String> categorias = new ArrayList<>();
        categorias.add("Asalariado");
        categorias.add("Comisionado");
        categorias.add("Por horas");

        return categorias;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", categoria=" + categoria +
                '}';
    }
}
