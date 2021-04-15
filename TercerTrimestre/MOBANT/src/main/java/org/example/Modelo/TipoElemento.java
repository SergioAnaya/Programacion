package org.example.Modelo;

public class TipoElemento {

    /**
     * Variables
     */

    private String id, nombre;

    /**
     * Constructor Vacío
     */
    public TipoElemento() {
    }

    /**
     * Constructor
     */
    public TipoElemento(String nombre) {
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
        return "TipoElemento{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                "\n";
    }
}
