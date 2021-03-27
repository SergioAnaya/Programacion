import java.io.FileWriter;
import java.io.IOException;

public class EscribeFichero {

    public static void main(String[] args) throws IOException {

        FileWriter fichero = new FileWriter("archivoEscribe.txt");

        fichero.write("Buenas tardes\n");
        fichero.write("Buenos días");

        fichero.close();

    }
}
