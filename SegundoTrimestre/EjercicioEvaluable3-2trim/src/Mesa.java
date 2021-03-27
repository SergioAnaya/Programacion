import java.util.LinkedList;
import java.util.List;

/**
 * Clase del objeto mesa
 */

public class Mesa {

    int identificadorMesa;

    /**
     * Esta lista es un atributo de la mesa que contiene los productos de dicha mesa
     */

    List<Producto> productos = new LinkedList<>();

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

    public List<Producto> getProductos() {
        return productos;
    }

    @Override
    public String toString() {
        return "\n---------------------------------" +
                "\n             Mesa " + identificadorMesa +
                "\n---------------------------------" +
                "\nProductos: \n" + productos + "\n";
    }
}