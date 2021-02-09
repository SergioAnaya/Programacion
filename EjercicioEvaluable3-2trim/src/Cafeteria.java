import java.util.LinkedList;
import java.util.List;

public class Cafeteria {

    Mesa mesa = new Mesa();
    Interfaz interfaz = new Interfaz();

    //List<Mesa> mesas = new LinkedList<>();
    List<List<Producto>> mesas = new LinkedList<>();
    List<Producto> carta = mesa.productos;

    double caja;

    public Mesa getMesa (int numMesa) {
        return mesa;
    }

    /*public List<Mesa> getMesas () {
        return mesas;
    }*/

    public double getCaja() {
        return caja;
    }

    public void addProducto (int numProducto, int numMesa) {

    }

    public void borrarProductos (int numMesa) {

    }

    public double cobrarMesa (int numMesa) {
        return 1.0;
    }

    public List<Producto> getCarta() {
        return carta;
    }

    public int abrirMesa () {
        return 1;
    }

    // Método para crear x número de mesas

    public void abrirMesasIniciales (int numeroMesas) {
        for (int i = 0; i < numeroMesas; i++) {
            mesas.add(new LinkedList<>());
        }
    }

}