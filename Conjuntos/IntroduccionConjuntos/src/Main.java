import java.util.Comparator;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        String [] objetos = {"Libro", "Coche", "Pelota", "Avión", "Nevera"};
        String [] personas = {"Jose", "Pepe", "Francisco", "Paco", "Maria"};

        TreeSet<String> conj1, conj2;

        conj1 = new TreeSet<String>();
        conj2 = new TreeSet<String>(new Compara());

        for (String elem:objetos) {
            conj1.add(elem);
        }
        for (String elem:objetos) {
            conj2.add(elem);
        }

    }


}

public class Compara implements Comparator {
    public int compare (Object o1, Object o2) {
        String s1 = (String)o1;
        String s2 = (String)o2;
        return s1.compareTo(s2);
    }
}
