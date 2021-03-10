package Persistencia;

import Modelo.Plato;

import java.io.*;
import java.util.List;

public class CSVReader {

    private final static String SEPARADOR = ";";
    private final static char COMILLAS = '"';

    private List<Plato> read () throws IOException {
        List<Plato> platos;

        String dir = System.getProperty("user.dir");
        BufferedReader lectorCSV = null;
        try {
            lectorCSV = new BufferedReader(new FileReader(dir + File.separator
                    + "datos.csv"));
            String linea = lectorCSV.readLine();
            while (null != linea){
                String[] campos = linea.split(SEPARADOR);
                campos = eliminarComillas(campos);
                linea = lectorCSV.readLine();
                platos = campos;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            lectorCSV.close();
        }

        return platos;
    }

    private static String[] eliminarComillas (String[] campos) {
        String result[] = new String[campos.length];
        for (int i=0;i<result.length;i++){
            result[i] = campos[i].replaceAll("^"+COMILLAS,
                    "").replaceAll(COMILLAS+"$", "");
        }
        return result;
    }

}
