package Modelo;

import java.util.LinkedList;
import java.util.List;

public class Ciudad {

    /**
     * Variables
     */

    String nombre;
    List<Establecimiento> establecimientos = new LinkedList<Establecimiento>();
    List<Plato> platos = new LinkedList<>();

    /**
     * Constructor
     */

    public Ciudad(String nombre, List<Establecimiento> establecimientos) {
        this.nombre = nombre;
        this.establecimientos = establecimientos;
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

    public List<Establecimiento> getEstablecimientos() {
        return establecimientos;
    }

    public void setEstablecimientos(List<Establecimiento> establecimientos) {
        this.establecimientos = establecimientos;
    }

    /**
     * Métodos
     */

    public void addEstablecimiento (Establecimiento establecimiento) {}

    /*public List<Plato> platosTipicos () {

    }

    public List<Establecimiento> establecimientosPorPlatoTipico (String nombrePlato) {

    }*/

}
