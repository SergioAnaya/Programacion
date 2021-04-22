package org.example.Modelo;

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
    }

    public Modelo(String codigo, String seccion, String categoria, List<Elemento> elementos) {
        this.codigo = codigo;
        this.seccion = seccion;
        this.categoria = categoria;
        this.elementos = elementos;
    }

    /**
     * Getters y Setter
     */

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String idSeccion) {
        this.seccion = idSeccion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String idCategoria) {
        this.categoria = idCategoria;
    }

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
