
/**
 * @author Sergio Anaya Marín
 *
 * Aplicacion para simular la gestión de un restaurante
 *
 *
 * Notas:
 * Buenas Mauri o Antonio, me gustaría que me respondierais a algunas dudas si fuera posible
 * ya sea en una nota cuando la correción o por correo electrónico.
 * Estos métodos son métodos de impresión junto a una pequeña parte lógica, este tipo de métodos
 * ¿a que clase pertenecerían?, también he aplicado la forma de interfaz que usamos el año pasado
 * para uno de los ejercicios de Biblioteca en el que se imprime con un método y se recoge la respuesta con otro,
 * me interesaría saber si está correctamente aplicado ya que me gustaría usarlo para futuros ejercicios,
 * se podría aplicar en algun que otro lado pero no he querido hacerlo porque no sé como podría reaccionar
 * a la hora de que le paseis el test a los métodos, muchas gracias.
 */

public class VistaCafeteria {

    /**
     * Instancias
     */

    Interfaz interfaz = new Interfaz();
    Cafeteria cafeteria = new Cafeteria();

    /**
     * Constantes del menú
     */

    final static int OP_NO_DEFINIDA = 0;
    final static int OP_CONSULTAR_MESAS = 1;
    final static int OP_CONSULTAR_CAJA = 2;
    final static int OP_AÑADIR_PRODUCTO = 3;
    final static int OP_COBRAR_MESA = 4;
    final static int OP_ABRIR_MESA = 5;
    final static int OP_TERMINAR = 6;

    final static int NUMERO_MINIMO_MESAS_INICIALES = 1;

    /**
     * Método que imprime el total de la caja
     */

    public void totalCaja () {
        System.out.print("Total: ");
        System.out.print(cafeteria.getCaja() + " €");
    }

    /**
     * Métodos para imprimir la mesa en la que vamos a añadir productos
     */

    public void imprimirSeleccionMesa () {
        System.out.print("Número de mesa [" + NUMERO_MINIMO_MESAS_INICIALES + "-" + cafeteria.getCountMesas() + "]: ");
    }

    public int menuSeleccionMesa () {
        imprimirSeleccionMesa();
        return interfaz.leerRespuestaMenuSeleccionMesa();
    }

    public int imprimirEnseñarMesaSeleccionada (int accion) {
        if (accion > cafeteria.getCountMesas()) {
            interfaz.mensajeMesaNoExiste();
        } else {
            System.out.println("---------------------------------" +
                    "\n             Mesa " + accion +
                    "\n---------------------------------");
        }
        return accion;
    }

    /**
     * Método para hacer un búcle para añadir los productos y también para filtrar en caso de que la mesa no exista
     */

    public void añadirProducto () {

        /**
         *  Esta línea imprime la cabecera de la mesa seleccionada en la que añadir los productos
         */

        int numMesa = imprimirEnseñarMesaSeleccionada(menuSeleccionMesa());

        int opcionMenu = 0;

        /**
         * Búcle para el menú de añadir los productos
         */

        if (numMesa <= cafeteria.getCountMesas()) {
            do {
                opcionMenu = interfaz.menuAñadirProducto();
                if (opcionMenu != cafeteria.OP_TERMINAR_AÑADIR_PRODUCTO) {
                    cafeteria.addProducto(opcionMenu, numMesa);
                }
            } while (opcionMenu != cafeteria.OP_TERMINAR_AÑADIR_PRODUCTO && opcionMenu != cafeteria.OP_BORRAR_CUENTA);
            cafeteria.resumenPedido(numMesa);
        }
    }

    /**
     * Métodos para imprimir la mesa en la que vamos a cobrar
     */

    public void imprimirSeleccionMesaACobrar () {
        System.out.print("Número de mesa que desea cobrar [" + NUMERO_MINIMO_MESAS_INICIALES + "-" + cafeteria.getCountMesas() + "]: ");
    }

    public int menuSeleccionMesaACobrar () {
        imprimirSeleccionMesaACobrar();
        return interfaz.leerRespuestaMenuCobrarMesa();
    }

    /**
     * Método para cobrar e imprimir la mesa
     */

    public void cuentaResumen () {
        int numMesa = menuSeleccionMesaACobrar();

        if (numMesa <= cafeteria.getCountMesas()) {

            double total = cafeteria.cobrarMesa(numMesa);

            if (total == 0.0) {
                System.out.println("La mesa está vacía.");
            } else {
                System.out.println("---------------------------------" +
                        "\n             Mesa " + numMesa +
                        "\n---------------------------------");
                System.out.println("Cuenta:\n");
                cafeteria.resumenPedido(numMesa);
                System.out.print(total);
                System.out.print(" €");
                cafeteria.borrarProductos(numMesa);
            }

        } else {
            interfaz.mensajeMesaNoExiste();
        }
    }

    /**
     * Método que añade una nueva mesa
     */

    public void mesaNueva () {

        String respuesta = interfaz.abrirMesa().toLowerCase();

        if (respuesta.equals("s")) {
            System.out.print("Se ha abierto correctamente la mesa ");
            System.out.print(cafeteria.abrirMesa());
        } else if (respuesta.equals("n")) {
            interfaz.mensajeNoAbrirMesa();
        } else interfaz.mensajeControlDeEntradaAbrirMesa();
    }

    /**
     * Método que tiene la lógica del menú
     * @param accion Este parámetro indica la acción a realizar
     */


    public void programaPrincipal (int accion) {
        switch (accion) {
            case OP_CONSULTAR_MESAS:
                System.out.println(cafeteria.getMesas());
                break;
            case OP_CONSULTAR_CAJA:
                totalCaja();
                break;
            case OP_AÑADIR_PRODUCTO:
                añadirProducto();
                break;
            case OP_COBRAR_MESA:
                cuentaResumen();
                break;
            case OP_ABRIR_MESA:
                mesaNueva();
                break;
        }
    }

    public static void main(String[] args) {

        /**
         * Instancias
         */

        VistaCafeteria vistaCafeteria = new VistaCafeteria();
        Interfaz interfaz = new Interfaz();
        Cafeteria cafeteria = new Cafeteria();

        /**
         * Llamada al método para abrir las mesas iniciales
         */

        cafeteria.abrirMesasIniciales(interfaz.menuNumeroMesasAbiertas());

        /**
         * Búcle del menú
         */

        int accion = OP_NO_DEFINIDA;

        do {
            accion = interfaz.menuPrincipal();
            if (accion != OP_TERMINAR) vistaCafeteria.programaPrincipal(accion);
        } while (accion != OP_TERMINAR);

    }
}