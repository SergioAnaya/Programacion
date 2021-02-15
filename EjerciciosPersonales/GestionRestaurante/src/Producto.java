import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase del objeto producto
 */

public class Producto {

    String nombreProducto;
    double precioProducto;

    /**
     * Definición de los productos por defecto
     */

    public final static Producto producto1 = new Producto("Churro", 0.50);
    public final static Producto producto2 = new Producto("Café con leche", 1.00);
    public final static Producto producto3 = new Producto("Tostada", 1.50);
    public final static Producto producto4 = new Producto("Zumo de naranja", 2.00);

    List<Producto> listaProductos = new LinkedList<>(Arrays.asList(producto1, producto2, producto3, producto4));

    public Producto () {}

    public Producto(String nombreProducto, double precioProducto) {
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    @Override
    public String toString() {
        return "\nNombre del producto: " + nombreProducto +
                "\nPrecio del producto: " + precioProducto + "€\n";
    }
}