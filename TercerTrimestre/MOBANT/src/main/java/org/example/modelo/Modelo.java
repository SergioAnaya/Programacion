package org.example.modelo;

import java.util.ArrayList;
import java.util.List;

public class Modelo {

    /**
     * Variables
     */

    private String codigo, seccion, categoria;
    private List<Elemento> elementos;


    /**
     * Constructor
     */

    public Modelo(String codigo, String seccion, String categoria) {
        this.codigo = codigo;
        this.seccion = seccion;
        this.categoria = categoria;
        this.elementos = new ArrayList<>();
    }

    public Modelo(String codigo, String seccion, String categoria, List<Elemento> elementos) {
        this.codigo = codigo;
        this.seccion = seccion;
        this.categoria = categoria;
        this.elementos = elementos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<Elemento> getElementos() {
        return elementos;
    }

    public void setElementos(List<Elemento> elementos) {
        this.elementos = elementos;
    }

    /**
     * Getters y Setter
     */



    @Override
    public String toString() {
        return "Modelo{" +
                ", codigo='" + codigo + '\'' +
                ", seccion='" + seccion + '\'' +
                ", categoria='" + categoria + '\'' +
                ", elementos=" + elementos +
                '}';
    }
}
