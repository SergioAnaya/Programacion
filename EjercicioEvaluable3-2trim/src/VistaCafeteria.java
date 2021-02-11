public class VistaCafeteria {

    Cafeteria cafeteria = new Cafeteria();
    Interfaz interfaz = new Interfaz();

    public void programaPrincipal (int accion) {
        switch (accion) {
            case Interfaz.OP_CONSULTAR_MESAS:
                interfaz.imprimirVistasMesas(interfaz.menuConsultarMesas());
                break;
            case Interfaz.OP_CONSULTAR_RECUENTO_CAJA_ACTUAL:
                System.out.println(cafeteria.getCaja());
                break;
            case Interfaz.OP_ABRIR_MESA:
                interfaz.imprimirAbrirMesaNueva();

        }
    }

    public static void main(String[] args) {
        VistaCafeteria vistaCafeteria = new VistaCafeteria();
        Interfaz interfaz = new Interfaz();
        Mesa mesa = new Mesa();
        Cafeteria cafeteria = new Cafeteria();
        Producto producto = new Producto();

        int accion = interfaz.OP_NO_DEFINIDA;

        interfaz.menuNumeroMesasAbiertas(); // funciona

        do {
            accion = interfaz.menuPrincipal();
            if (accion != interfaz.OP_TERMINAR) {
                vistaCafeteria.programaPrincipal(accion);
            }
        } while (accion != interfaz.OP_TERMINAR);



        /*interfaz.menuSeleccionMesa(); // funciona*/

        /*interfaz.imprimirSeleccionMesa();
        interfaz.imprimirEnseñarMesaSeleccionada(interfaz.leerRespuestaMenuSeleccionMesa());*/

    }
}