import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Mesa {

    int identificadorMesa;

    Producto producto1 = new Producto("Churro", 0.50);
    Producto producto2 = new Producto("Café con leche", 1.00);
    Producto producto3 = new Producto("Tostada", 1.50);
    Producto producto4 = new Producto("Zumo de naranja", 2.00);

    List<Producto> productos = new LinkedList<>(Arrays.asList(producto1, producto2, producto3, producto4));

    public Mesa() {}

    public Mesa(int identificadorMesa) {
        this.identificadorMesa = identificadorMesa;
    }

    public int getIdentificadorMesa() {
        return identificadorMesa;
    }

    public void setIdentificadorMesa(int identificadorMesa) {
        this.identificadorMesa = identificadorMesa;
    }
}