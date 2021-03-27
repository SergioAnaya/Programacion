
import java.util.Scanner;

/**
 * @author Sergio Anaya Marin
 */



public class VistaConcesionario {

    Concesionario concesionario;
    Scanner entrada;

    public VistaConcesionario(Concesionario concesionario)
    {
        this.concesionario=concesionario;
        entrada = new Scanner(System.in);
    }

    public Concesionario getConcesionario() {
        return concesionario;
    }

    public void menu()
    {
        System.out.println("----- CONCESIONARIO POLITECNICO ------");
        System.out.println("  1 - LISTA DE VEHICULOS VENDIDOS");
        System.out.println("  2 - LISTA DE VEHICULOS EN STOCK");
        System.out.println("  3 - LISTA DE VEHICULOS VENDIDOS POR VENDEDOR");
        System.out.println("  4 - TOTAL VENTAS");
        System.out.println("  5 - TOTAL VENTAS POR VENDEDOR");
        System.out.println("  6 - VENDEDOR TOP VOLUMEN VENTAS");
        System.out.println("  7 - VENDEDOR MÍNIMO VOLUMEN VENTAS");
        System.out.println("  8 - VENDER VEHICULO");
        System.out.println("");
        System.out.println("  0 - SALIR");
        System.out.print("  ELEGIR OPCION : ");
    }

    public int leerOpcionMenu()
    {
        return entrada.nextInt();
    }


    public void ejecuta(int opcion)
    {
        switch (opcion)
        {

            case 1:
                System.out.println("-------------");
                System.out.println("Devuelve la lista de vehículos que han sido vendidos");
                System.out.println("concesionario.getVehiculosVendidos()");
                System.out.println();
                System.out.println(getConcesionario().getVehiculosVendidos());
                System.out.println("");
                break;
            case 2:
                System.out.println("-------------");
                System.out.println("Devuelve la lista de vehículos que no han sido vendidos todavía");
                System.out.println("List<Vehiculo> getVehiculosDisponibles()");
                System.out.println();
                System.out.println(getConcesionario().getVehiculosDisponibles());
                System.out.println();
                break;
            case 3:
                System.out.println("Devuelve la lista de vehículos vendidos por un vendedor");
                System.out.println("List<Vehiculo> getVehiculosPorVendedor(Vendedor vendedor)");
                System.out.println(getConcesionario().getVendedores());
                System.out.print("Elija un Vendedor (id) :");
                System.out.println(getConcesionario().getVehiculosPorVendedor(getConcesionario().getVendedor(entrada.nextInt())));
                System.out.println();
                break;
            case 4:
                System.out.println("-------------");
                System.out.println("Devuelve un double con la suma total de las ventas de todos los vendedores");
                System.out.println("double getTotalVentas()");
                System.out.println();
                System.out.println("TOTAL VENTAS : "+getConcesionario().getTotalVentas());
                System.out.println();
                break;
            case 5:
                System.out.println("-------------");
                System.out.println("Devuelve un double con la suma vendida por un vendedor");
                System.out.println("double getVentasPorVendedor(Vendedor vendedor)");
                System.out.println();
                System.out.println(getConcesionario().getVendedores());
                System.out.print("Elija un Vendedor (id) :");
                System.out.println(getConcesionario().getVentasPorVendedor(getConcesionario().getVendedor(entrada.nextInt())));
                System.out.println();
                break;
            case 6:
                System.out.println("-------------");
                System.out.println("Devuelve el vendedor que más ha vendido");
                System.out.println("Vendedor getMaximoVendedor()");
                System.out.println();
                System.out.println("VENDEDOR TOP VENTAS : "+getConcesionario().getMaximoVendedor());
                System.out.println();
                break;
            case 7:
                System.out.println("-------------");
                System.out.println("Devuelve el vendedor que menos ha vendido");
                System.out.println("Vendedor getMinimoVendedor()");
                System.out.println();
                System.out.println("VENDEDOR MÍNIMO VOLUMEN VENTAS : "+getConcesionario().getMinimoVendedor());
                System.out.println();
                break;
            case 8:
                System.out.println("-------------");
                System.out.println(" Si el vehículo está disponible lo añade a las ventas de un vendedor.\n" +
                        "       Después el vehículo ya no estará disponible. Devuelve true si el vehículo está disponible,\n" +
                        "       y false si el vehículo no existe o bien ya ha sido vendido.");
                System.out.println("boolean vender(Vehiculo vehiculo, Vendedor vendedor)");
                System.out.println();
                System.out.println(getConcesionario().getVendedores());
                System.out.print("Elija un Vendedor (id) :");
                int vendedor = entrada.nextInt();
                System.out.println(getConcesionario().getVehiculos());
                System.out.print("Elija un Vehiculo (Matricula) :");
                String matricula = entrada.next();
                if (getConcesionario().vender(getConcesionario().getVehiculo(matricula),getConcesionario().getVendedor(vendedor)))
                    System.out.println("Vehiculo Matricula "+matricula+" vendido correctamente");
                else
                    System.out.println("Vehiculo no existente o no disponible en stock");
                System.out.println();
                break;
        }

    }

    public static void main(String[] args) {

        VistaConcesionario vista = new VistaConcesionario(new Concesionario());

        int opcion;
        do {
            vista.menu();
            opcion = vista.leerOpcionMenu();
            vista.ejecuta(opcion);
        } while (opcion!=0);

        System.out.println("\nHasta Pronto!!");

    }

}
