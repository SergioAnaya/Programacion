package org.example.Modelo;

public class Modelo {

    /**
     * Variables
     */

    private String id, codigo, idSeccion, idCategoria;

    /**
     * Constructor Vacío
     */

    public Modelo() {
    }

    /**
     * Constructor
     */

    public Modelo(String codigo, String idSeccion, String idCategoria) {
        this.codigo = codigo;
        this.idSeccion = idSeccion;
        this.idCategoria = idCategoria;
    }

    /**
     * Getters y Setter
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

    public String getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(String idSeccion) {
        this.idSeccion = idSeccion;
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public String toString() {
        return "Modelo{" +
                "id='" + id + '\'' +
                ", codigo='" + codigo + '\'' +
                ", idSeccion='" + idSeccion + '\'' +
                ", idCategoria='" + idCategoria + '\'' +
                "\n";
    }
}
