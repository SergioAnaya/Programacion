import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Archivo {

    private final static String SEPARADOR = ",";

    public List<String []> leerArchivo (String fichero) throws Exception {

        String dir = System.getProperty("user.dir");

        BufferedReader lectorCSV = null;
        List<String []> filas = new ArrayList<>();

        lectorCSV = new BufferedReader(new FileReader(dir + File.separator + fichero));

        String linea = lectorCSV.readLine();

        while (linea != null) {
            String [] campos = linea.split(SEPARADOR);
            filas.add(campos);
            linea = lectorCSV.readLine();
        }
        lectorCSV.close();
        return filas;

        /**
         * Main para leer archivo
         */

        /*List<String []> filas = archivo.leerArchivo("Jugadores.csv");

        for (String [] campos : filas) {
            System.out.println(Arrays.toString(campos));
        }*/
    }

}
