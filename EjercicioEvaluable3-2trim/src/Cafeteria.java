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
    double caja = 0;
    List<Producto> carta = new LinkedList<>(Arrays.asList(Producto.producto1, Producto.producto2, Producto.producto3, Producto.producto4));

    /**
     * Contador para controlar el total de las mesas abiertas
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

    /**
     * Método para obtener una mesa según su identificador
     * @param numMesa Este parámetro indica el número de la mesa que se quiere buscar
     * @return Devuelve la propia mesa
     */

    public Mesa getMesa (int numMesa) {
        Mesa resultado = null;
        for (Mesa mesa : mesas) {
            if (mesa.getIdentificadorMesa() == numMesa) {
                resultado = mesa;
            }
        }
        return resultado;
    }

    /**
     * Método para devolver todas las mesas
     * @return Devuelve todas las mesas
     */

    public List<Mesa> getMesas() {
        return mesas;
    }

    /**
     * Método para devolver el total de la caja
     * @return Devuelve el valor total de la caja hecha
     */

    public double getCaja() {
        return caja;
    }

    /**
     * Contadores para mostrar el resumen de los productos agregados
     */

    int countChurro = 0;
    int countCafeConLeche = 0;
    int countTostada = 0;
    int countZumoNatural = 0;

    /**
     * Método que devuelve la mesa y añade los productos que se le indiquen, también permite borrar los productos de la mesa
     * @param numProducto Este parámetro indica el producto que se quiere añadir, también sirve para terminar de añadir los productos
     *                    con la opción 0 y para borrar los productos de la mesa con la opción -1
     * @param numMesa Este parámetro indica el número de la mesa con la que se trabajará
     */

    public void addProducto (int numProducto, int numMesa) {

        if (numMesa == getMesa(numMesa).getIdentificadorMesa()) {
            if (numProducto == OP_AÑADIR_CHURRO) {
                System.out.print("Cantidad: ");
                int cantidad = teclado.nextInt();
                for (int i = 0; i < cantidad; i++) {
                    getMesa(numMesa).getProductos().add(carta.get(0));
                }
            } else if (numProducto == OP_AÑADIR_CAFE_CON_LECHE) {
                System.out.print("Cantidad: ");
                int cantidad = teclado.nextInt();
                for (int i = 0; i < cantidad; i++) {
                    getMesa(numMesa).getProductos().add(carta.get(1));
                }
            } else if (numProducto == OP_AÑADIR_TOSTADA) {
                System.out.print("Cantidad: ");
                int cantidad = teclado.nextInt();
                for (int i = 0; i < cantidad; i++) {
                    getMesa(numMesa).getProductos().add(carta.get(2));
                }
            } else if (numProducto == OP_AÑADIR_ZUMO_NATURAL) {
                System.out.print("Cantidad: ");
                int cantidad = teclado.nextInt();
                for (int i = 0; i < cantidad; i++) {
                    getMesa(numMesa).getProductos().add(carta.get(3));
                }
            } else if (numProducto == OP_BORRAR_CUENTA) {
                countChurro = 0;
                countCafeConLeche = 0;
                countTostada = 0;
                countZumoNatural = 0;
                borrarProductos(numMesa);
            } else System.out.println("Ese producto no existe.");
        }
    }

    /**
     * Método para borrar los productos añadidos a la mesa
     * @param numMesa Este párametro indica el número de mesa del que queremos borrar
     */

    public void borrarProductos (int numMesa) {
        if (numMesa == getMesa(numMesa).getIdentificadorMesa()) {
            getMesa(numMesa).getProductos().clear();
            System.out.println("\nSe han borrado los productos correctamente.");
        }
    }

    /**
     * Método que recorre los productos de la mesa especificada y va añadiendo al contador si existen
     * @param numMesa Este parámetro indica el número de la mesa con la que se trabajará
     */

    public void contadorProductos (int numMesa) {

        countChurro = 0;
        countCafeConLeche = 0;
        countTostada = 0;
        countZumoNatural = 0;

        for (int i =0; i < getMesa(numMesa).getProductos().size(); i++) {
            if (getMesa(numMesa).getProductos().get(i).getNombreProducto().equals("Churro")) {
                countChurro++;
            } else if (getMesa(numMesa).getProductos().get(i).getNombreProducto().equals("Café con leche")) {
                countCafeConLeche++;
            } else if (getMesa(numMesa).getProductos().get(i).getNombreProducto().equals("Tostada")) {
                countTostada++;
            } else if (getMesa(numMesa).getProductos().get(i).getNombreProducto().equals("Zumo de naranja")) {
                countZumoNatural++;
            }
        }
    }

    /**
     * Método que imprime el contador de productos en caso de que no sea 0, este método se usa a la hora de añadir un producto y de cobrarlo
     */

    public void imprimirContadorProductos () {

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
        System.out.println("---------------------------------");
    }

    /**
     * Este método cuenta e imprime los productos de la mesa que pidamos,
     * este método se usa al finalizar de añadir los productos se imprime
     * para mostrar el resumen de todos los productos añadidos a la mesa
     * @param numMesa Este parámetro indica el número de la mesa con la que se trabajará
     */

    public void resumenPedido (int numMesa) {
        contadorProductos(numMesa);
        imprimirContadorProductos();
    }

    /**
     * Este método hace el recuento de los productos y los multiplica por su precio de unidad
     * @param numMesa Este parámetro indica el número de la mesa con la que se trabajará
     * @return Devuelve la suma total del precio de los productos de la mesa
     */

    public double cobrarMesa (int numMesa) {

        double total = 0;

        if (numMesa == getMesa(numMesa).getIdentificadorMesa()) {
            total += countChurro * 0.50;
            total += countCafeConLeche * 1.00;
            total += countTostada * 1.50;
            total += countZumoNatural * 2.00;

            caja += total;
        }
        return total;
    }

    /**
     * @return Devuélve todos los productos que se ofrecen
     */

    public List<Producto> getCarta() {
        return carta;
    }

    /**
     * Método para abrir una mesa nueva
     * @return Devuelve el número de mesa que se acaba de abrir
     */

    public int abrirMesa () {
        mesas.add(new Mesa(countMesas + 1));
        countMesas++;
        return countMesas;
    }
}