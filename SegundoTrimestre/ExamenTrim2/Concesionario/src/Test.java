import Modelo.Vendedor;
import Persistencia.LectorVendedores;

public class Test {

    public static void main(String[] args) {

        Concesionario concesionario = new Concesionario();
        concesionario.cargaDatos();

        //System.out.println(concesionario.getVendedores());

        //System.out.println(concesionario.getVehiculos());

        //System.out.println(concesionario.getVehiculosVendidos());

        //System.out.println(concesionario.getVehiculosDisponibles());

        /*Vendedor vendedor = new Vendedor(1, "paco", "perez");
        System.out.println(concesionario.getVehiculosPorVendedor(vendedor));*/

        //System.out.println(concesionario.getTotalVentas());

        //System.out.println(concesionario.getVentasPorVendedor(vendedor));

        System.out.println(concesionario.getMaximoVendedor());

    }

}
