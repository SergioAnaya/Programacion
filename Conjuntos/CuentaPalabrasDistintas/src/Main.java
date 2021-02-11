import java.text.Normalizer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce la frase: ");
        String frase = teclado.nextLine();
        String fraseFiltrada = Normalizer.normalize(frase, Normalizer.Form.NFD); // Normalizer transforma (x, con x forma) en este caso la forma es Canonical Descomposition
        fraseFiltrada = fraseFiltrada.toLowerCase().replaceAll("[\\p{InCombiningDiacriticalMarks}]"," ");
        fraseFiltrada = fraseFiltrada.replaceAll(",\\n", "");

        // Creo un array con las partes separadas (El delimitador de las palabras es espacio en blanco)

        String [] partes = fraseFiltrada.split(" ");

        // Luego creo un HashSet y le agrego un array transformado a lista

        HashSet<String> fraseSalida = new HashSet<>(Arrays.asList(partes));


        for (int i = 0; i < partes.length; i++) {
            System.out.println(partes[i]);
        }
        System.out.println(fraseSalida);
    }
}