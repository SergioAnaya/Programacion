package Modelo;

public class Vehiculo {

    private String marca, modelo, km, matricula, precio;

    public Vehiculo(String marca, String modelo, String km, String matricula, String precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.km = km;
        this.matricula = matricula;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", km='" + km + '\'' +
                ", matricula='" + matricula + '\'' +
                ", precio='" + precio + '\'' +
                '}';
    }
}
