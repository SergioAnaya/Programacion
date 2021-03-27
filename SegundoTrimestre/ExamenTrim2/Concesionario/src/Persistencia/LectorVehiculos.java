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
    private String nombreArchivo;

    /**
     * Constructor
     */

    public LectorVehiculos (String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    /**
     * Método para leer el archivo csv
     */

    public List<Vehiculo> read () {
        String dir = System.getProperty("user.dir");
        Scanner lectorCSV;
        List<Vehiculo> listaVehiculos = new LinkedList<>();

        try {
            lectorCSV = new Scanner(new File(dir + File.separator + nombreArchivo)).useDelimiter("\n");

            while (lectorCSV.hasNext()) {
                String[] campos = lectorCSV.next().split(";");
                String marca = campos[0];
                String modelo = campos[1];
                String km = campos[2];
                String matricula = campos[3];
                String precio = campos[4];
                Vehiculo vehiculo = new Vehiculo(marca, modelo, km, matricula, precio);
                listaVehiculos.add(vehiculo);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listaVehiculos;
    }
}
