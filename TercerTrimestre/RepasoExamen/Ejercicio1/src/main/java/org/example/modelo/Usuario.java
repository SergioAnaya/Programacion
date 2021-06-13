package org.example.modelo;

public class Usuario {

    /**
     * Variables
     */

    private int id;
    private String nombre;
    private int edad;

    /**
     * Constructor Vacío
     */
    public Usuario() {
    }

    /**
     * Constructor
     */

    public Usuario(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    /**
     * Getters y Setters
     */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String tipo) {
        this.nombre = tipo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "\nUsuario Nº " + id +
                "\nNombre: " + nombre +
                "\nEdad: " + edad +
                "\n";
    }
}