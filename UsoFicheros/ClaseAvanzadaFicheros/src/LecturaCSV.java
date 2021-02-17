import java.util.Arrays;
import java.util.List;

public class LecturaCSV {

    public static void main(String[] args) throws Exception {

        LectorCSV lectorCSV = new LectorCSV();

        List<String []> filas = lectorCSV.leerCSV("prueba.csv");

        for (String[] campos : filas) {
            System.out.println(Arrays.toString(campos));
        }

    }

}
