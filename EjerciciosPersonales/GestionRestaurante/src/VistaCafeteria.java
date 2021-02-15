/**
 * @author Sergio Anaya Marín
 *
 * Esta clase contiene las llamadas a los métodos para mostrar la interfaz
 */


public class VistaCafeteria {

    Cafeteria cafeteria = new Cafeteria();
    Interfaz interfaz = new Interfaz();

    /**
     * Constantes del menú principal
     */

    public final static int OP_NO_DEFINIDA = 0;
    public final static int OP_CONSULTAR_MESAS = 1;
    public final static int OP_CONSULTAR_RECUENTO_CAJA_ACTUAL = 2;
    public final static int OP_AÑADIR_PRODUCTO_A_MESA = 3;
    public final static int OP_COBRAR_MESA = 4;
    public final static int OP_ABRIR_MESA = 5;
    public final static int OP_TERMINAR = 6;

    public void programaPrincipal(int accion) {
        switch (accion) {
            case OP_CONSULTAR_MESAS:
                cafeteria.imprimirVistasMesas(interfaz.menuConsultarMesas());
                break;
            case OP_CONSULTAR_RECUENTO_CAJA_ACTUAL:
                System.out.println(cafeteria.getCaja());
                break;
            case OP_AÑADIR_PRODUCTO_A_MESA:
                cafeteria.añadirProducto();
                break;
            case OP_ABRIR_MESA:
                cafeteria.imprimirAbrirMesaNueva();

        }
    }

    public static void main(String[] args) {
        VistaCafeteria vistaCafeteria = new VistaCafeteria();
        Interfaz interfaz = new Interfaz();
        Cafeteria cafeteria = new Cafeteria();

        int accion = OP_NO_DEFINIDA;

        cafeteria.abrirMesasIniciales(interfaz.menuNumeroMesasAbiertas());

        do {
            accion = interfaz.menuPrincipal();
            if (accion != OP_TERMINAR) {
                vistaCafeteria.programaPrincipal(accion);
            }
        } while (accion != OP_TERMINAR);

    }
}