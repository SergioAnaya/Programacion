
/**
 * @author Sergio Anaya Marín
 *
 * Aplicacion para simular la gestión de un restaurante
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
            menuSeleccionMesa();
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
         * Esta línea imprime la cabecera de la mesa seleccionada en la que añadir los productos
         */

        int numMesa = imprimirEnseñarMesaSeleccionada(menuSeleccionMesa());

        /**
         * Búcle para el menú de añadir los productos
         */

        if (numMesa > cafeteria.getCountMesas() || numMesa < -1) {
            interfaz.mensajeMesaNoExiste();
        } else {
            int opcionMenu = 0;

            do {
                opcionMenu = interfaz.menuAñadirProducto();
                if (opcionMenu != cafeteria.OP_TERMINAR_AÑADIR_PRODUCTO) {
                    cafeteria.addProducto(opcionMenu, numMesa);
                }
            } while (opcionMenu != cafeteria.OP_TERMINAR_AÑADIR_PRODUCTO && opcionMenu != cafeteria.OP_BORRAR_CUENTA);
            cafeteria.contadorProductos();
        }
    }

    /**
     * Método que imprime el total de la caja
     */

    public void totalCaja () {
        interfaz.mensajeTotalDeCaja();
        System.out.print(cafeteria.getCaja());
    }

    public void mesaNueva () {
        interfaz.mensajeMesaNuevaAbierta();
        cafeteria.abrirMesa();
    }

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
            case OP_ABRIR_MESA:
                mesaNueva();
                break;

        }
    }

    public static void main(String[] args) {

        VistaCafeteria vistaCafeteria = new VistaCafeteria();
        Interfaz interfaz = new Interfaz();
        Cafeteria cafeteria = new Cafeteria();

        cafeteria.abrirMesasIniciales(interfaz.menuNumeroMesasAbiertas());


        int accion = OP_NO_DEFINIDA;

        do {
            accion = interfaz.menuPrincipal();
            if (accion != OP_TERMINAR) vistaCafeteria.programaPrincipal(accion);
        } while (accion != OP_NO_DEFINIDA);

    }
}