package Modelo;

public class Venta {

    private Vendedor vendedor;
    private Vehiculo vehiculo;

    public Venta(Vendedor vendedor, Vehiculo vehiculo) {
        this.vendedor = vendedor;
        this.vehiculo = vehiculo;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "vendedor=" + vendedor +
                ", vehiculo=" + vehiculo +
                "\n";
    }
}