import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LeerFichero {

    public static void main(String[] args) throws IOException {

        File fichero = new File("archivoLee.txt");
        Scanner leerFichero = new Scanner(fichero);
        String linea;

        while (leerFichero.hasNextLine()) {
            linea = leerFichero.nextLine();
            System.out.println(linea);
        }

        System.out.println("Se puede leer el fichero: " + fichero.canRead());
        System.out.println("Se puede escribir en el fichero: " + fichero.canWrite());
        // fichero.createNewFile(); - Si no está el fichero lo crea
        // fichero.delete(); - Borra el fichero
        System.out.println("El fichero existe: " + fichero.exists());
        System.out.println("Nombre del fichero: " + fichero.getName());
        System.out.println("Ruta del fichero: " + fichero.getAbsolutePath());
        System.out.println("Longitud del fichero en Bytes: " + fichero.length());

        leerFichero.close();

    }

}
