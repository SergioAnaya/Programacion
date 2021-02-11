import java.util.*;
import java.text.Normalizer;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce la frase: ");
        String frase = teclado.nextLine();
        String fraseFiltrada = Normalizer.normalize(frase, Normalizer.Form.NFD); // Normalizer transforma (x, con x forma) en este caso la forma es Canonical Descomposition
        fraseFiltrada = fraseFiltrada.toLowerCase().replaceAll("[\\p{InCombiningDiacriticalMarks}\\n]",""); // Frase sin acentuaciones ni saltos de frase
        fraseFiltrada = fraseFiltrada.replaceAll("[_:;ºª¡'!$%&/=*+`^ç¨´.,-]", ""); // Frase sin carácteres especiales
        fraseFiltrada = fraseFiltrada.replaceAll("[\\[\\](){}]",""); // Frase sin paréntesis, corchetes y llaves

        int contadorPalabras = 0;

        // Creo un array con las partes separadas (El delimitador de las palabras es espacio en blanco)

        String [] partes = fraseFiltrada.split(" ");

        // Luego creo un HashSet y le agrego un array transformado a lista

        HashSet<String> fraseSalida = new HashSet<>(Arrays.asList(partes));

        // Iterador para contar las palabras

        Iterator<String> it = fraseSalida.iterator();
        while (it.hasNext()) {
            contadorPalabras++;
            it.next();
        }

        // Lo añado a un TreeSet para que se ordene

        TreeSet myTreeSet = new TreeSet();
        myTreeSet.addAll(fraseSalida);
        System.out.println(myTreeSet);

        System.out.println("Hay " + contadorPalabras + " palabras en total.");
    }
}