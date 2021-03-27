package Modelo;

public class Venta {

    Vehiculo vehiculo;
    Vendedor vendedor;

    public Venta(Vehiculo vehiculo, Vendedor vendedor) {
        this.vehiculo = vehiculo;
        this.vendedor = vendedor;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "vehiculo=" + vehiculo +
                ", vendedor=" + vendedor +
                '}';
    }
}
