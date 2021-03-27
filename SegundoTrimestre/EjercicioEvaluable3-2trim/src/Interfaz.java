import java.util.Scanner;

/**
 * Esta clase contiene lo relacionado a imprimir la interfaz y recoger respuestas
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
     * Recoge la respuesta de la mesa que vamos a cobrar
     */

    public int leerRespuestaMenuCobrarMesa () { return teclado.nextInt(); }

    /**
     * Métodos para imprimir si queremos abrir la mesa junto a los mensajes de control de error
     */

    public void mensajeAbrirMesa () {
        System.out.print("¿Abrir nueva mesa [s]/n?");
    }

    public String leerAbrirMesa () { return teclado.next(); }

    public String abrirMesa () {
        mensajeAbrirMesa();
        return leerAbrirMesa();
    }

    public void mensajeNoAbrirMesa () {
        System.out.println("No se ha abierto ninguna mesa.");
    }

    public void mensajeControlDeEntradaAbrirMesa () {
        System.out.println("Debes introducir la opción 's' o 'n'.");
    }

    /**
     * Método de mensaje de error
     */

    public void mensajeMesaNoExiste () { System.out.println("Esa mesa no existe."); }
}