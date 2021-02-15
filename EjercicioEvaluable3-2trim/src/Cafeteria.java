import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Cafeteria {

    /**
     * Instancias
     */

    Scanner teclado = new Scanner(System.in);

    /**
     * Constantes del submenú para añadir productos, borrar cuenta y terminar
     */

    final static int OP_BORRAR_CUENTA = -1;
    final static int OP_AÑADIR_CHURRO = 1;
    final static int OP_AÑADIR_CAFE_CON_LECHE = 2;
    final static int OP_AÑADIR_TOSTADA = 3;
    final static int OP_AÑADIR_ZUMO_NATURAL = 4;
    final static int OP_TERMINAR_AÑADIR_PRODUCTO = 0;

    static List<Mesa> mesas = new LinkedList<>();
    double caja;
    List<Producto> carta = new LinkedList<>(Arrays.asList(Producto.producto1, Producto.producto2, Producto.producto3, Producto.producto4));

    /**
     *
     */

    List<Producto> pedido = new LinkedList<>();

    /**
     * Contador de las mesas abiertas
     */

    static int countMesas = 0;

    public static int getCountMesas() {
        return countMesas;
    }

    /**
     * Método para abrir las mesas iniciales
     * @param numMesas Este parámetro se usa para indicar el número de mesas a abrir
     */

    public void abrirMesasIniciales (int numMesas) {

        for (int i = 0; i < numMesas; i++) {
            countMesas++;
            mesas.add(i, new Mesa(countMesas));
        }
        System.out.println("Se han abierto " + numMesas + " mesas.");
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

    public List<Mesa> getMesas() {
        return mesas;
    }

    public double getCaja() {
        return caja;
    }

    /**
     *
     */

    /**
     *
     */

    int countChurro = 0;
    int countCafeConLeche = 0;
    int countTostada = 0;
    int countZumoNatural = 0;

    public void addProducto (int numProducto, int numMesa) {



        if (numMesa == getMesa(numMesa).getIdentificadorMesa()) {
            if (numProducto == OP_AÑADIR_CHURRO) {
                System.out.print("Cantidad: ");
                int cantidad = teclado.nextInt();
                for (int i = 0; i < cantidad; i++) {
                    pedido.add(carta.get(0));
                    getMesa(numMesa).setProductos(pedido);
                    countChurro++;
                }
            } else if (numProducto == OP_AÑADIR_CAFE_CON_LECHE) {
                System.out.print("Cantidad: ");
                int cantidad = teclado.nextInt();
                for (int i = 0; i < cantidad; i++) {
                    pedido.add(carta.get(1));
                    getMesa(numMesa).setProductos(pedido);
                    countCafeConLeche++;
                }
            } else if (numProducto == OP_AÑADIR_TOSTADA) {
                System.out.print("Cantidad: ");
                int cantidad = teclado.nextInt();
                for (int i = 0; i < cantidad; i++) {
                    pedido.add(carta.get(2));
                    getMesa(numMesa).setProductos(pedido);
                    countTostada++;
                }
            } else if (numProducto == OP_AÑADIR_ZUMO_NATURAL) {
                System.out.print("Cantidad: ");
                int cantidad = teclado.nextInt();
                for (int i = 0; i < cantidad; i++) {
                    pedido.add(carta.get(3));
                    getMesa(numMesa).setProductos(pedido);
                    countZumoNatural++;
                }
            } else if (numProducto == OP_BORRAR_CUENTA) {
                pedido.clear();
                countChurro = 0;
                countCafeConLeche = 0;
                countTostada = 0;
                countZumoNatural = 0;
                System.out.println("\nMesa borrada correctamente.");
            } else System.out.println("Ese producto no existe.");
        }
    }

    /**
     *
     */

    public void contadorProductos () {
        System.out.println("\n");
        if (countChurro != 0) {
            System.out.println(countChurro + " x Churro");
        } if (countCafeConLeche != 0) {
            System.out.println(countCafeConLeche + " x Café con leche");
        } if (countTostada != 0) {
            System.out.println(countTostada + " x Tostada");
        } if (countZumoNatural != 0) {
            System.out.println(countZumoNatural + " x Zumo natural");
        }
        System.out.println("\n---------------------------------");
    }

    public void borrarProductos (int numMesa) {

    }

    public double cobrarMesa (int numMesa) {
        return caja;
    }

    public List<Producto> getCarta() {
        return carta;
    }

    public int abrirMesa () {
        mesas.add(new Mesa(countMesas + 1));
        countMesas++;
        return countMesas;
    }

    @Override
    public String toString() {
        return "Cafeteria{" +
                "mesas=" + mesas +
                '}';
    }
}