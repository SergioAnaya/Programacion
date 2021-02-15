import java.util.Scanner;

/**
 * Esta clase contiene lo relacionado a imprimir la interfaz
 */

public class Interfaz {

    /**
     * Instancias
     */

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
     * Recoge la respuesta de la mesa donde vamos a añadir los productos
     */

    public int leerRespuestaMenuSeleccionMesa () { return teclado.nextInt(); }

    /**
     * Métodos para imprimir el menú de añadir un nuevo producto y recoger el resultado
     */

    public void imprimirAñadirProductoAMesa () {
        System.out.print("Número de producto [0 -> terminar. -1 -> borrar cuenta]: ");
    }

    public int leerRespuestaMenuAñadirProductosAMesa () { return teclado.nextInt(); }

    public int menuAñadirProducto () {
        imprimirAñadirProductoAMesa();
        return leerRespuestaMenuAñadirProductosAMesa();
    }

    /**
     * Método de mensaje de nueva mesa abierta
     */

    public void mensajeMesaNuevaAbierta () {
        System.out.println("Se ha abierto correctamente la mesa ");
    }

    /**
     * Método de mensaje de error
     */

    public void mensajeMesaNoExiste () {
        System.out.println("Esa mesa no existe.");
    }

    /**
     * Método de mensaje de para el total de la caja
     */

    public void mensajeTotalDeCaja () {
        System.out.print("Total: ");
    }


}