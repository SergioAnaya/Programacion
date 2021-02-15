import java.util.Scanner;

/**
 * Esta clase contiene lo relacionado a imprimir la interfaz
 */

public class Interfaz {

    Scanner teclado = new Scanner(System.in);

    /**
     * Menú para pedir cuantas mesas iniciales queremos
     */

    public void imprimirNumeroMesasAbiertas () {
        System.out.print("Número de mesas abiertas: ");
    }

    public int leerRespuestaMenuNumeroMesasAbiertas () {
        return teclado.nextInt();
    }

    public int menuNumeroMesasAbiertas () {
        imprimirNumeroMesasAbiertas();
        return leerRespuestaMenuNumeroMesasAbiertas();
    }

    /**
     * Menú principal de la aplicación
     */

    public void imprimirMenuPrincipal () {
        System.out.println("\n********************************************" +
                "\n1. Consultar mesas" +
                "\n2. Consultar el recuento de caja actual" +
                "\n3. Añadir producto a una mesa" +
                "\n4. Cobrar mesa" +
                "\n5. Abrir mesa" +
                "\n6. Salir" +
                "\n********************************************");
    }

    public int leerRespuestaMenuPrincipal () { return teclado.nextInt(); }

    public int menuPrincipal () {
        imprimirMenuPrincipal();
        return leerRespuestaMenuPrincipal();
    }

    /**
     * Menú para consultar mesas, he modificado un poco el mecanismo para elegir si quieres ver 1 mesa en particular o todas a la vez con la opción 0
     */

    public void imprimirConsultarMesas () {
        System.out.print("Si desea consultar una mesa en específico indique el número de mesa, si desea consultar todas introduce 0: ");
    }

    public int leerRespuestaConsultarMesas () { return teclado.nextInt(); }

    public int menuConsultarMesas () {
        imprimirConsultarMesas();
        return leerRespuestaConsultarMesas();
    }

    /**
     * Menú para añadir producto
     */

    public void imprimirAñadirProductoAMesa () {
            System.out.print("Número de producto [0 -> terminar. -1 -> borrar cuenta]: ");
    }

    public int leerRespuestaMenuAñadirProductosAMesa () { return teclado.nextInt(); }

    public int menuAñadirProducto () {
        imprimirAñadirProductoAMesa();
        return leerRespuestaMenuAñadirProductosAMesa();
    }

    public void imprimirCantidadAñadirProductoMesa () {
        System.out.print("Cantidad: ");
    }

    public int leerRespuestaCantidadAñadirProductoMesa () { return teclado.nextInt(); }

    public int menuCantidadAñadirProductoMesa () {
        imprimirCantidadAñadirProductoMesa();
        return leerRespuestaCantidadAñadirProductoMesa();
    }
}