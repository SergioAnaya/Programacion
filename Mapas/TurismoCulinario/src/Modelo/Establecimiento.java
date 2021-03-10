package Modelo;

public class Establecimiento {

    /**
     * Variables
     */

    String nombre;
    Coordenada ubicacion;
    Plato plato;

    /**
     * Constructor
     */

    public Establecimiento(String nombre, Coordenada ubicacion, Plato plato) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.plato = plato;
    }

    /**
     * Getters y Setters
     */

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Coordenada getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Coordenada ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }

    /**
     * Métodos
     */

    /*public boolean tienePlato (Plato plato) {

    }

    public boolean addPlato (Plato plato) {

    }*/
}
