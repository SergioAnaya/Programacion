import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Esta clase contiene los métodos a usar para el funcionamiento de la aplicación
 */

public class Cafeteria {

    /**
     * Instancias
     */

    Scanner teclado = new Scanner(System.in);
    Producto producto = new Producto();
    Interfaz interfaz = new Interfaz();


    /**
     * Constantes para añadir los productos
     */

    public final static int OP_BORRAR_CUENTA = -1;
    public final static int OP_AÑADIR_CHURRO = 1;
    public final static int OP_AÑADIR_CAFE_CON_LECHE = 2;
    public final static int OP_AÑADIR_TOSTADA = 3;
    public final static int OP_AÑADIR_ZUMO_NATURAL = 4;
    public final static int OP_TERMINAR_AÑADIR_PRODUCTO = 0;

    /**
     * Constante para indicar el número mínimo de mesas iniciales
     */

    public final static int NUMERO_MINIMO_MESAS_INICIALES = 1;

    /**
     * Constante para consultar todas las mesas
     */

    public final static int OP_CONSULTAR_TODAS_LAS_MESAS = 0;

    /**
     * Variables
     */

    static List<Mesa> mesas = new LinkedList<>();
    List<Producto> carta = producto.listaProductos;
    double caja;
    static int countMesas = 0;

    /**
     * @return Este metodo devuelve el contador de las mesas abiertas
     */

    public int getCountMesas() {
        return countMesas;
    }

    /**
     * Método para ver el contenido de una mesa en particular
     * @param numMesa Este parámetro se usa para indicar el número de mesa a buscar mediante el identificador de la mesa
     * @return devuelve el objeto mesa
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
     * @return Devuelve el contenido de todas las mesas
     */

    public List<Mesa> getMesas () {
        return mesas;
    }

    /**
     * @return Devuelve el valor de la caja total
     */

    public double getCaja() {
        return caja;
    }

    /**
     *
     * @param numProducto
     * @param numMesa
     */

    public void addProducto (int numProducto, int numMesa) {


        List<Producto> pedido = new LinkedList<>();

        if (numMesa == getMesa(numMesa).getIdentificadorMesa()) {
                if (numProducto == OP_AÑADIR_CHURRO) {
                    countChurro += interfaz.menuCantidadAñadirProductoMesa();
                    for (int i = 0; i < countChurro; i++) {
                        pedido.add(carta.get(0));
                        getMesa(numMesa).setProductos(pedido);
                    }
                } else if (numProducto == OP_AÑADIR_CAFE_CON_LECHE) {
                    countCafeConLeche += interfaz.menuCantidadAñadirProductoMesa();
                    for (int i = 0; i < countCafeConLeche; i++) {
                        pedido.add(carta.get(1));
                        getMesa(numMesa).setProductos(pedido);
                    }
                } else if (numProducto == OP_AÑADIR_TOSTADA) {
                    countTostada += interfaz.menuCantidadAñadirProductoMesa();
                    for (int i = 0; i < countTostada; i++) {
                        pedido.add(carta.get(2));
                        getMesa(numMesa).setProductos(pedido);
                    }
                } else if (numProducto == OP_AÑADIR_ZUMO_NATURAL) {
                    countZumoNatural += interfaz.menuCantidadAñadirProductoMesa();
                    for (int i = 0; i < countZumoNatural; i++) {
                        pedido.add(carta.get(3));
                        getMesa(numMesa).setProductos(pedido);
                    }
                } else if (numProducto == OP_BORRAR_CUENTA) {
                    getMesa(numMesa).getProductos().clear();
                    System.out.println("Se han borrado los productos correctamente");
                }
        }
    }

    /**
     * Los contadores son para imprimir la cantidad de productos añadidos a x mesa
     */

    int countChurro = 0;
    int countCafeConLeche = 0;
    int countTostada = 0;
    int countZumoNatural = 0;

    /**
     * Este método es para imprimir el resumen del pedido con el formato que pide el ejercicio.
     */

    public void contadorDeProductos () {
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
        System.out.println("Saliendo del menú de añadir productos");
    }



    /**
     *
     * @param numMesa
     */

    public void borrarProductos (int numMesa) {

    }

    /**
     *
     * @param numMesa
     * @return
     */

    public double cobrarMesa (int numMesa) {
        return 1.0;
    }

    /**
     *
     * @return
     */

    public List<Producto> getCarta() {
        return carta;
    }

    /**
     *
     * @return
     */

    public int abrirMesa () {
        mesas.add(new Mesa(countMesas + 1));
        countMesas++;
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
     *
     *
     *
     * MÉTODOS DE INTERFAZ LÓGICA
     *
     *
     *
     */

    /**
     * Este método sirve para imprimir una mesa en particular o todas
     * @param accion Devuelve
     */

    public void imprimirVistasMesas (int accion) {
        if (accion > getCountMesas()) {
            System.out.println("No existe esa mesa");
        } else if (accion == OP_CONSULTAR_TODAS_LAS_MESAS) {
            System.out.println(getMesas());
        } else {
            if (getMesa(accion) == null) {
                System.out.println("La mesa " + accion + " está vacía.");
            } else {
                System.out.println(getMesa(accion));
            }
        }
    }

    /**
     * Menú para seleccionar la mesa en la que se quiere añadir los productos
     */

    public void imprimirSeleccionMesa () {
        System.out.print("Número de mesa [" + NUMERO_MINIMO_MESAS_INICIALES + "-" + getCountMesas() + "]: ");
    }

    public int leerRespuestaMenuSeleccionMesa () { return teclado.nextInt(); }

    public int menuSeleccionMesa () {
        imprimirSeleccionMesa();
        return leerRespuestaMenuSeleccionMesa();
    }

    /**
     * Este método sirve para filtrar si la mesa existe o no, el filtro lo hago mediante el contador, si existe en el contador
     * existe la mesa ya que al crear una mesa nueva se suma 1 al contador.
     * @param accion El parámetro accion indica el número de mesa a buscar
     * @return El número de mesa
     */

    public int imprimirEnseñarMesaSeleccionada (int accion) {
        if (accion > getCountMesas()) {
            System.out.println("No existe esa mesa");
            menuSeleccionMesa();
        } else {
            System.out.println("---------------------------------" +
                    "\n             Mesa " + accion +
                    "\n---------------------------------");
        }
        return accion;
    }

    /**
     * Imprimir el abrir mesa nueva
     */

    public void imprimirAbrirMesaNueva () {
        System.out.println("Se ha abierto correctamente la mesa " + abrirMesa());
    }

    /**
     *
     */

    public void añadirProducto() {
        int numMesa = imprimirEnseñarMesaSeleccionada(menuSeleccionMesa());
        int opcionMenuProducto = 0;
        do {
            opcionMenuProducto = interfaz.menuAñadirProducto();
            if (opcionMenuProducto != OP_TERMINAR_AÑADIR_PRODUCTO) {
                addProducto(opcionMenuProducto, numMesa);
            }
        } while (opcionMenuProducto != OP_TERMINAR_AÑADIR_PRODUCTO);
        contadorDeProductos();
    }
}