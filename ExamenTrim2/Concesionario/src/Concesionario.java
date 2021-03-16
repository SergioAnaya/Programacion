import Modelo.Vehiculo;
import Modelo.Vendedor;
import Modelo.Venta;
import Persistencia.LectorVehiculos;
import Persistencia.LectorVendedores;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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

    private Map<String, Integer> matriculasVentas;

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
     * Método para llenar las listas
     */

    public void cargaDatos () {

        /**
         * Estos métodos leen los archivos y los vuelcan a las listas correspondientes
         */

        LectorVendedores lectorVendedores = new LectorVendedores(ARCHIVO_VENDEDORES);
        vendedores = lectorVendedores.read();

        LectorVehiculos lectorVehiculos = new LectorVehiculos(ARCHIVO_VEHICULOS);
        vehiculos = lectorVehiculos.read();

        /**
         * Esta línea sirve para leer y volcar las matrículas de los vehículos vendidos
         */

        matriculasVentas = lectorVendedores.mapaMatriculasVentas();

    }

    /**
     * Métodos examen
     */

    public List<Vehiculo> getVehiculosVendidos () {
        List<Vehiculo> listavehiculosVendidos = new LinkedList<>();

        for (String matricula : matriculasVentas.keySet()) {
            for (Vehiculo vehiculo : vehiculos) {
                if (matricula.equals(vehiculo.getMatricula())) {
                    listavehiculosVendidos.add(vehiculo);
                }
            }
        }
        return listavehiculosVendidos;
    }

    public List<Vehiculo> getVehiculosDisponibles() {
        List<Vehiculo> listaVehiculosVendidos = new LinkedList<>();

        getVehiculos().removeAll(getVehiculosVendidos());
        listaVehiculosVendidos.addAll(getVehiculos());

        return listaVehiculosVendidos;
    }

    public List<Vehiculo> getVehiculosPorVendedor(Vendedor vendedor) {
        List<Vehiculo> listavehiculosVendidosPorVendedor = new LinkedList<>();

        for (Vendedor vendedor1 : vendedores) {
            for (Vehiculo vehiculo : vehiculos) {
                if (vendedor1.equals(vendedor)) {
                    listavehiculosVendidosPorVendedor.add(vehiculo);
                }
            }
        }
        return listavehiculosVendidosPorVendedor;
    }

    public double getTotalVentas() {
        double total = 0;

        for (Vehiculo vehiculo : getVehiculosVendidos()) {
            int precios = Integer.parseInt(vehiculo.getPrecio());
            total += precios;
        }
        return total;
    }

    public double getVentasPorVendedor(Vendedor vendedor) {
        double total = 0;

        for (Vehiculo vehiculo : getVehiculosPorVendedor(vendedor)) {
            int precios = Integer.parseInt(vehiculo.getPrecio());
            total += precios;
        }
        return total;
    }

    /*public Vendedor getMaximoVendedor() {

        return vendedor;
    }*/

    /*public Vendedor getMinimoVendedor() {
        return vendedor;
    }*/

    /**
     * No sabía exactamente el porque boolean, lo he planteado así
     */

    public boolean vender(Vehiculo vehiculo, Vendedor vendedor) {

        boolean respuestaVenta = false;

        if (vehiculo.equals(getVehiculosDisponibles()) && vendedor.equals(vendedores)) {
            Venta venta = new Venta(vehiculo,vendedor);
            ventas.add(venta);
            respuestaVenta = true;

            matriculasVentas.put(vehiculo.getMatricula(), vendedor.getId());
        }
        return respuestaVenta;
    }

    /**
     * Métodos profesor
     */
   
    public Vendedor getVendedor(int id)
    {
        for (Vendedor vendedor:getVendedores()) {
            if (vendedor.getId()==id) return vendedor;
        }
        return null;
    }

    public Vehiculo getVehiculo(String matricula)
    {
        for (Vehiculo vehiculo:getVehiculos()) {
            if (vehiculo.getMatricula().equals(matricula)){
                return vehiculo;
            }
        }
        return null;
    }
}