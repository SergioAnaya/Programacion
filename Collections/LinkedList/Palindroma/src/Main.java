import java.text.Normalizer;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        LinkedList<Character> cola = new LinkedList<>();
        LinkedList<Character> pila = new LinkedList<>();

        int countLetras = 0;
        int countEspaciosEnBlanco = 0;

        System.out.println("Introduce la frase: ");
        String frase = teclado.nextLine();
        String fraseFiltrada = Normalizer.normalize(frase, Normalizer.Form.NFD); // Normalizer transforma (x, con x forma) en este caso la forma es Canonical Descomposition
        fraseFiltrada = fraseFiltrada.toLowerCase().replaceAll("[\\s+\\p{InCombiningDiacriticalMarks},]",""); // Sin espacios ni comas y en minusculas

        // Añadir la frase filtrada sa la cola y la lista

        for (int i = 0; i < fraseFiltrada.length(); i++) {
            cola.add(fraseFiltrada.charAt(i));
            pila.add(fraseFiltrada.charAt(i));
        }

        // Contador de Letras y Espacios en Blanco

        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == ' ') {
                countEspaciosEnBlanco++;
                countLetras--;
            }
            if (frase.charAt(i) == ',') {
                countLetras--;
            }
             countLetras++;
        }

        // Comprobar si es palindrome o no

        boolean palindrome = true;

        while (!cola.isEmpty()) {
            if (pila.pop() != cola.remove(pila.size())) {
                palindrome = false;
            }
        }

        System.out.println("\nLa Frase: " + frase + "\nLa frase tiene: " + countLetras + " letras" + " y " + countEspaciosEnBlanco + " espacios en blanco");
        if (palindrome) {
            System.out.println("\nLa frase es palindrome");
        } else System.out.println("\nLa frase no es palindrome");

    }
}