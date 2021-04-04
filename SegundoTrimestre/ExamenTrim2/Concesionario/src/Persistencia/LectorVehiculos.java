package Persistencia;

import Modelo.Vehiculo;
import Modelo.Vendedor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class LectorVehiculos {

    /**
     * Variables
     */

    private final static char SEPARADOR = ';';
    private List<Vehiculo> listaVehiculos;

    /**
     * Constructor
     */

    public LectorVehiculos (String nombreArchivo) {

        String dir = System.getProperty("user.dir");
        Scanner lectorCSV;

        listaVehiculos = new LinkedList<>();

        try {
            lectorCSV = new Scanner(new File(dir + File.separator + nombreArchivo)).useDelimiter("\n");

            while (lectorCSV.hasNext()) {
                String[] campos = lectorCSV.next().split(String.valueOf(SEPARADOR));
                String marca = campos[0];
                String modelo = campos[1];
                String km = campos[2];
                String matricula = campos[3];
                String precio = campos[4];
                Vehiculo vehiculo = new Vehiculo(marca, modelo, Integer.parseInt(km), matricula, Double.parseDouble(precio));
                listaVehiculos.add(vehiculo);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Getters
     */

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }
}