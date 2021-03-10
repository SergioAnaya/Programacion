package Modelo;

public class Coordenada {

    /**
     * Variables
     */

    double latitud, longitud;

    /**
     * Constructor
     */

    public Coordenada(double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    /**
     * Getters y Setters
     */

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
}
