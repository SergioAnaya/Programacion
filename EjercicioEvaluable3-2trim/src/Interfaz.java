import java.util.Scanner;

public class Interfaz {

    Scanner teclado = new Scanner(System.in);
    Cafeteria cafeteria = new Cafeteria();

    // Constantes del menú principal

    public final static int OP_NO_DEFINIDA = 0;
    public final static int OP_CONSULTAR_MESAS = 1;
    public final static int OP_CONSULTAR_RECUENTO_CAJA_ACTUAL = 2;
    public final static int OP_AÑADIR_PRODUCTO_A_MESA = 3;
    public final static int OP_COBRAR_MESA = 4;
    public final static int OP_ABRIR_MESA = 5;
    public final static int OP_TERMINAR = 6;

    // Constantes para añadir los productos

    public final static int OP_BORRAR_CUENTA = -1;
    public final static int OP_AÑADIR_CHURRO = 1;
    public final static int OP_AÑADIR_CAFE_CON_LECHE = 2;
    public final static int OP_AÑADIR_TOSTADA = 3;
    public final static int OP_AÑADIR_ZUMO_NATURAL = 4;
    public final static int OP_TERMINAR_AÑADIR_PRODUCTO = 0;

    // Constantes para indicar el número mínimo de mesas iniciales

    public final static int NUMERO_MINIMO_MESAS_INICIALES = 1;

    // Constante para consultar todas las mesas

    public final static int OP_CONSULTAR_TODAS_LAS_MESAS = 0;

    // Menú de mesas iniciales

    public void imprimirNumeroMesasAbiertas () {
        System.out.print("Número de mesas abiertas: ");
    }

    public int leerRespuestaMenuNumeroMesasAbiertas () {
        return teclado.nextInt();
    }

    public void menuNumeroMesasAbiertas () {
        imprimirNumeroMesasAbiertas();
        cafeteria.abrirMesasIniciales(leerRespuestaMenuNumeroMesasAbiertas());
    }

    // Menú principal del a aplicación

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

    // Menú para consultar mesas, he modificado un poco el mecanismo para elegir si quieres ver 1 mesa en particular o todas a la vez

    public void imprimirConsultarMesas () {
        System.out.print("Si desea consultar una mesa en específico indique el número de mesa, si desea consultar todas introduce 0: ");
    }

    public int leerRespuestaConsultarMesas () { return teclado.nextInt(); }

    public int menuConsultarMesas () {
        imprimirConsultarMesas();
        return leerRespuestaConsultarMesas();
    }

    public void imprimirVistasMesas (int accion) {
        if (accion > cafeteria.getCountMesas()) {
            System.out.println("No existe esa mesa");
        } else if (accion == OP_CONSULTAR_TODAS_LAS_MESAS) {
            System.out.println(cafeteria.getMesas());
        } else {
            if (cafeteria.getMesa(accion) == null) {
                System.out.println("La mesa " + accion + " está vacía.");
            } else {
                System.out.println(cafeteria.getMesa(accion));
            }
        }
    }

    // Menú de selección de mesa a la hora de añadir productos

    public void imprimirSeleccionMesa () {
        System.out.print("Número de mesa [" + NUMERO_MINIMO_MESAS_INICIALES + "-" + cafeteria.getCountMesas() + "]: ");
    }

    public int leerRespuestaMenuSeleccionMesa () { return teclado.nextInt(); }

    public void imprimirEnseñarMesaSeleccionada (int accion) {

        if (accion > cafeteria.getCountMesas()) {
            System.out.println("No existe esa mesa");
            menuSeleccionMesa();
        } else {
            System.out.println("---------------------------------" +
                    "\n             Mesa " + accion +
                    "\n---------------------------------");
        }
    }

    public void menuSeleccionMesa () {
        imprimirSeleccionMesa();
        imprimirEnseñarMesaSeleccionada(leerRespuestaMenuSeleccionMesa());

    }

    // Menú para añadir producto

    public void imprimirAñadirProductoAMesa () {
            System.out.print("Número de producto [0 -> terminar. -1 -> borrar cuenta]");
    }

    public int leerRespuestaMenuAñadirProductosAMesa () { return teclado.nextInt(); }

    // Imprimir el abrir 1 mesa nueva

    public void imprimirAbrirMesaNueva () {
        System.out.println("Se ha abierto correctamente la mesa " + cafeteria.abrirMesa());
    }
}