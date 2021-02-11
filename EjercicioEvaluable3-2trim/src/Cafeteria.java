import java.util.LinkedList;
import java.util.List;

public class Cafeteria {

    static List<Mesa> mesas = new LinkedList<>();
    List<Producto> carta = new LinkedList<>();

    double caja;
    static int countMesas = 0;

    public int getCountMesas() {
        return countMesas;
    }

    public Mesa getMesa (int numMesa) {
        Mesa resultado = null;
        for (Mesa mesa : mesas) {
            if (mesa.getIdentificadorMesa() == numMesa) {
                resultado = mesa;
            }
        }
        return resultado;
    }


















    public List<Mesa> getMesas () {
        return mesas;
    }

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
        mesas.add(new Mesa(countMesas + 1));
        countMesas++;
        return countMesas;
    }

    // Método para abrir las mesas iniciales

    public void abrirMesasIniciales (int numMesas) {
        for (int i = 0; i < numMesas; i++) {
            countMesas++;
            mesas.add(i, new Mesa(countMesas));
        }
        System.out.println("Se han abierto " + numMesas + " mesas.");
    }











    @Override
    public String toString() {
        return "Cafeteria{" +
                "mesas=" + mesas +
                '}';
    }
}