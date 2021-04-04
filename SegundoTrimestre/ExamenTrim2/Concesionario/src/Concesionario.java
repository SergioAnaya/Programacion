import Modelo.Vehiculo;
import Modelo.Vendedor;
import Modelo.Venta;
import Persistencia.LectorVehiculos;
import Persistencia.LectorVendedores;

import java.util.*;

public class Concesionario {

    /**
     * Constantes
     */

    private final static String ARCHIVO_VENDEDORES = "vendedores.xml";
    private final static String ARCHIVO_VEHICULOS = "vehiculos.csv";

    /**
     * Variables
     */

    private List<Vehiculo> vehiculos;
    private List<Vendedor> vendedores;
    private List<Venta> ventas;

    /**
     * Getters y Setters
     */

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public List<Vendedor> getVendedores() {
        return vendedores;
    }

    public void setVendedores(List<Vendedor> vendedores) {
        this.vendedores = vendedores;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    /**
     * Constructor
     */

    public Concesionario () {

        /**
         * Se rellenan las listas
         */

        LectorVendedores lectorVendedores = new LectorVendedores(ARCHIVO_VENDEDORES);
        vendedores = lectorVendedores.getListaVendedores();

        LectorVehiculos lectorVehiculos = new LectorVehiculos(ARCHIVO_VEHICULOS);
        vehiculos = lectorVehiculos.getListaVehiculos();

        ventas = buildVentas(lectorVendedores.getMapaVentas());

    }

    /**
     * Método para construir la lista de ventas
     */

    private List<Venta> buildVentas (Map<Vendedor, List<String>> ventasVendedor) {

        ventas = new ArrayList<>();

        for (Vendedor vendedor : ventasVendedor.keySet()) {
            for (String matricula : ventasVendedor.get(vendedor)) {
                ventas.add(new Venta(vendedor, getVehiculo(matricula)));
            }
        }

        return ventas;

    }

    /**
     * Métodos examen
     */

    /**
     * Método que devuelve la lista de vehiculos vendidos
     */

    public List<Vehiculo> getVehiculosVendidos () {

        List<Vehiculo> listaVehiculosVendidos = new LinkedList<>();

        for (Venta venta : getVentas()) {
            listaVehiculosVendidos.add(venta.getVehiculo());
        }

        return listaVehiculosVendidos;
    }

    /**
     * Método que devuelve la lista de vehiculos disponibles
     */

    public List<Vehiculo> getVehiculosDisponibles () {

        List<Vehiculo> listaVehiculos = vehiculos;
        List<Vehiculo> listaVehiculosVendidos = getVehiculosVendidos();

        listaVehiculos.removeAll(listaVehiculosVendidos);

        return listaVehiculos;

    }

    /**
     *
     */

    public List<Vehiculo> getVehiculosPorVendedor (Vendedor vendedor) {

        List<Vehiculo> vehiculos = new LinkedList<Vehiculo>();

        for (Venta venta : getVentas()) {
            if (venta.getVendedor().equals(vendedor)) {
                vehiculos.add(venta.getVehiculo());
            }
        }

        return vehiculos;

    }

    /**
     *
     */

    public double getTotalVentas () {

        double total = 0;

        for (Vehiculo vehiculo : getVehiculos()) {
            total += vehiculo.getPrecio();
        }

        return total;

    }

    /**
     *
     */

    public double getVentasPorVendedor (Vendedor vendedor) {

        double total = 0;

        for (Vehiculo vehiculo : getVehiculosPorVendedor(vendedor)) {
            total += vehiculo.getPrecio();
        }

        return total;

    }

    /**
     *
     */

    public Vendedor getMaximoVendedor() {

        Integer maximo = Integer.MIN_VALUE;
        Vendedor vendedor = null;

        for (Vendedor vendedor1 : getVendedores()) {
            if (getVentasPorVendedor(vendedor) > maximo) {
                maximo = (int) getVentasPorVendedor(vendedor);
                vendedor = vendedor1;
            }
        }

        return vendedor;

    }

    /**
     *
     */

    public Vendedor getMinimoVendedor() {

        Integer minimo = Integer.MAX_VALUE;
        Vendedor vendedor = null;

        for (Vendedor vendedor1 : getVendedores()) {
            if (getVentasPorVendedor(vendedor) < minimo) {
                minimo = (int) getVentasPorVendedor(vendedor);
                vendedor = vendedor1;
            }
        }

        return vendedor;

    }

    public boolean vender (Vehiculo vehiculo, Vendedor vendedor) {

        if (getVehiculosDisponibles().contains(vehiculo)) {
            getVentas().add(new Venta(vendedor, vehiculo));
            return true;
        } else return false;

    }

    /**
     * Métodos profesor
     */

    public Vendedor getVendedor (int id) {
        for (Vendedor vendedor:getVendedores()) {
            if (vendedor.getId()==id) return vendedor;
        }

        return null;
    }

    public Vehiculo getVehiculo (String matricula) {

        for (Vehiculo vehiculo:getVehiculos()) {
            if (vehiculo.getMatricula().equals(matricula)){
                return vehiculo;
            }
        }

        return null;
    }
}