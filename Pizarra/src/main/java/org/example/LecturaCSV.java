package org.example;

import java.io.*;
import java.util.Arrays;

public class LecturaCSV {

    private final static String  SEPARADOR = ";";
    private final static char COMILLAS = '"';

    String nombreArchivo = "archivoCSV.csv";

    public void read () throws IOException {
        String dir = System.getProperty("user.dir");
        BufferedReader lectorCSV = null;
        try {
            lectorCSV = new BufferedReader(new FileReader(dir + File.separator + nombreArchivo));
            String linea = lectorCSV.readLine();
            while (null != linea){
                String[] campos = linea.split(SEPARADOR);
                //campos = eliminarComillas(campos);
                System.out.println(Arrays.toString(campos));
                linea = lectorCSV.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            lectorCSV.close();
        }
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
