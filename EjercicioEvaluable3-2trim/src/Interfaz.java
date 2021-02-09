import java.util.Scanner;

public class Interfaz {

    Scanner teclado = new Scanner(System.in);

    public final static int OP_NO_DEFINIDA = 0;
    public final static int OP_CONSULTAR_MESAS = 1;
    public final static int OP_CONSULTAR_RECUENTO_CAJA_ACTUAL = 2;
    public final static int OP_AÑADIR_PRODUCTO_A_MESA = 3;
    public final static int OP_COBRAR_MESA = 4;
    public final static int OP_ABRIR_MESA = 5;
    public final static int OP_TERMINAR = 6;

    public final static int OP_BORRAR_CUENTA = -1;
    public final static int OP_AÑADIR_CHURRO = 1;
    public final static int OP_AÑADIR_CAFE_CON_LECHE = 2;
    public final static int OP_AÑADIR_TOSTADA = 3;
    public final static int OP_AÑADIR_ZUMO_NATURAL = 4;

    int countMesas = 0;

    public int getCountMesas() {
        return countMesas;
    }

    public void menuNumeroMesasAbiertas () {
        System.out.print("Número de mesas abiertas: ");
    }

    public int leerRespuestaMenuNumeroMesasAbiertas () {
        return teclado.nextInt();
    }

    public void respuestaMenuNumeroMesasAbiertas () {
        menuNumeroMesasAbiertas();
        for (int i = 0; i < leerRespuestaMenuNumeroMesasAbiertas(); i++) {
            countMesas++;
        }
    }

    public void menuPrincipal () {
        System.out.println("\n********************************************" +
                "\n1. Consultar mesas" +
                "\n2. Consultar el recuente de caja actual" +
                "\n3. Añadir producto a una mesa" +
                "\n4. Cobrar mesa" +
                "\n5. Abrir mesa" +
                "\n6. Salir" +
                "\n********************************************");
    }

    public int leerRespuestaMenuPrincipal () {return teclado.nextInt();}

    public void menuSeleccionMesa () {
        System.out.print("Número de mesa: ");
    }

    public int leerRespuestaMenuSeleccionMesa () {return teclado.nextInt();}

    public void enseñarMesaSeleccionada () {
        System.out.println("---------------------------------" +
                "\n\tMesa " + leerRespuestaMenuSeleccionMesa());
    }

    public void menuAñadirProductoAMesa () {
            System.out.print("Número de producto [0 -> terminar. -1 -> borrar cuenta]");
    }

    public int leerRespuestaMenuAñadirProductosAMesa () {return teclado.nextInt();}

}