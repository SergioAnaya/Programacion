package org.example.Modelo;

public class Elemento {

    /**
     * Variables
     */

    private String id, codigo, idTipoElemento;

    /**
     * Constructor Vacío
     */

    public Elemento() {
    }

    /**
     * Constructor
     */

    public Elemento(String codigo, String idTipoElemento) {
        this.codigo = codigo;
        this.idTipoElemento = idTipoElemento;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getIdTipoElemento() {
        return idTipoElemento;
    }

    public void setIdTipoElemento(String idTipoElemento) {
        this.idTipoElemento = idTipoElemento;
    }
}
