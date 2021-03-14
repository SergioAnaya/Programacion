package Persistencia;

import Modelo.Empleado;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SueldoBase {

    /**
     * Variables
     */

    private final static char SEPARADOR = ';';
    private String nombreArchivo;

    /**
     * Constructor
     */

    public SueldoBase (String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    /**
     * Método para leer el documento y llenar el mapa con el, con el método getTipoEmpleadoFromEtiqueta se cambia el nombre del tipo
     * por un int para usarse como indice del mapa para facilitar su uso en el código y a la hora de escribir el documento se vuelve a cambiar
     * el formato con el método getEtiquetaEmpleadoFromTipo
     */

    public Map<Integer, Double> read () {
        String dir = System.getProperty("user.dir");
        Scanner lectorCSV;
        Map<Integer,Double> sueldosBase = new HashMap<>();

        try {
            lectorCSV = new Scanner(new File(dir + File.separator + nombreArchivo)).useDelimiter("\n");

            while (lectorCSV.hasNext()) {
                String[] campos = lectorCSV.next().split(";");
                int tipoEmpleado = getTipoEmpleadoFromEtiqueta(campos[0]);
                sueldosBase.put(tipoEmpleado, Double.parseDouble(campos[1]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return sueldosBase;
    }

    /**
     * Método para cambiar la String del sueldo por un int para usarlo como indice en un mapa
     */

    private int getTipoEmpleadoFromEtiqueta (String etiquetaTipoEmpleado) {
        switch (etiquetaTipoEmpleado) {
            case "comisionado": return Empleado.COMISIONADO;
            case "por_horas": return Empleado.POR_HORAS;
            case "asalariado": return Empleado.ASALARIADO;
            default: return -1;
        }
    }

    /**
     * Método para cambiar el indice del mapa por el String del tipo de empleo
     */

    private String getEtiquetaEmpleadoFromTipo (int tipoEmpleado) {
        switch (tipoEmpleado) {
            case Empleado.COMISIONADO: return "comisionado";
            case Empleado.POR_HORAS: return "por_horas";
            case Empleado.ASALARIADO: return "asalariado";
        }
        return null;
    }

    /**
     * Método para escribir el sueldo en el documento CSV
     */

    public void writeSueldoBase (Map<Integer, Double> sueldosBase) {
        try {
            FileWriter fileWriter = new FileWriter(nombreArchivo);
            fileWriter.flush();
            for (int tipoEmpleado : sueldosBase.keySet()) {
                String etiquetaTipoEmpleado = getEtiquetaEmpleadoFromTipo(tipoEmpleado);
                fileWriter.write(etiquetaTipoEmpleado + ";" + sueldosBase.get(tipoEmpleado) + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}