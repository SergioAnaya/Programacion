import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LectorCSV {

    private final static String SEPARADOR = ",";
    private final static char COMILLAS = '"';

    public List<String[]> leerCSV (String fichero) throws Exception {

        String dir = System.getProperty("user.dir");
        BufferedReader lectorCSV = null;

        List<String []> filas = new ArrayList<>();

        lectorCSV = new BufferedReader(new FileReader(dir + File.separator + fichero));
        String linea = lectorCSV.readLine();

        while (null != linea) {
            String[] campos = linea.split(SEPARADOR);
            campos = eliminarComillasEnExtremos(campos);
            filas.add(campos);
            linea = lectorCSV.readLine();
        }
        lectorCSV.close();
        return filas;
    }

    private static String [] eliminarComillasEnExtremos (String [] campos) {
        String resultado[] = new String[campos.length];

        for (int i = 0; i <  resultado.length; i++) {
            resultado[i] = campos[i].replaceAll("^" + COMILLAS, "").replaceAll(COMILLAS + "$", "");
        }
        return resultado;
    }

}
