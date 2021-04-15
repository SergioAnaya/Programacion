package org.example.Modelo;

public class Seccion {

    /**
     * Variables
     */

    private String id, nombre;

    /**
     * Constructor Vacío
     */

    public Seccion () {}

    /**
     * Constructor
     */

    public Seccion (String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getters y Setters
     */

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Seccion{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                "\n";
    }
}
