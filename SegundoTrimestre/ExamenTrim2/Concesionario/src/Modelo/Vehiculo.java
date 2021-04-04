package Modelo;

public class Vehiculo {

    private String marca, modelo, matricula;
    private int km;
    private Double precio;

    public Vehiculo(String marca, String modelo, int km, String matricula, Double precio) {
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

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
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
                "\n";
    }
}