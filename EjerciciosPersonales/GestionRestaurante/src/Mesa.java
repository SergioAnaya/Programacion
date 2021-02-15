import java.util.LinkedList;
import java.util.List;

/**
 * Clase del objeto mesa
 */

public class Mesa {

    Producto producto = new Producto();

    int identificadorMesa;
    List<Producto> productos = new LinkedList<>(); // Esta lista es un atributo de la mesa, para ir añadiendo los productos

    public Mesa () {}

    public Mesa(int identificadorMesa) {
        this.identificadorMesa = identificadorMesa;
    }

    public Mesa(int identificadorMesa, List<Producto> productos) {
        this.identificadorMesa = identificadorMesa;
        this.productos = productos;
    }

    public int getIdentificadorMesa() {
        return identificadorMesa;
    }

    public void setIdentificadorMesa(int identificadorMesa) {
        this.identificadorMesa = identificadorMesa;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "\n---------------------------------" +
                "\n             Mesa " + identificadorMesa +
                "\n---------------------------------" +
                "\nProductos: \n" + productos + "\n";
    }
}