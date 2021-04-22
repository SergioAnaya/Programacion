package org.example.Modelo;

public class Elemento {

    /**
     * Variables
     */

    private String codigo, tipo;

    /**
     * Constructor
     */

    public Elemento(String tipo, String codigo) {
        this.codigo = codigo;
        this.tipo = tipo;
    }

    /**
     * Getters y Setters
     */

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Elemento{" +
                "codigo='" + codigo + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}