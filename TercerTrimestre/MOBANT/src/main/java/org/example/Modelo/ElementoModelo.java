package org.example.Modelo;

public class ElementoModelo {

    /**
     * Variables
     */

    private String id, idElemento, idModelo;

    /**
     * Constructor Vacío
     */
    public ElementoModelo() {
    }

    /**
     * Constructor
     */
    public ElementoModelo(String idElemento, String idModelo) {
        this.idElemento = idElemento;
        this.idModelo = idModelo;
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

    public String getIdElemento() {
        return idElemento;
    }

    public void setIdElemento(String idElemento) {
        this.idElemento = idElemento;
    }

    public String getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(String idModelo) {
        this.idModelo = idModelo;
    }

    @Override
    public String toString() {
        return "ElementoModelo{" +
                "id='" + id + '\'' +
                ", idElemento='" + idElemento + '\'' +
                ", idModelo='" + idModelo + '\'' +
                "\n";
    }
}
