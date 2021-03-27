import java.util.ArrayList;
import java.util.Iterator;

public class Intro {
    public static void main(String[] args) {
       /* ArrayList<Integer> lista = new ArrayList<>(); // El indice empieza en 0

        // Calcular tamaño

        System.out.println(lista.size());

        // Introducir algo, por defecto se introduce al final

        lista.add(1);
        lista.add(3);
        lista.add(0, 3);

        System.out.println(lista.size());

        // Introducir algo en una posición determinada

        lista.add(1,2);
        System.out.println(lista);

        // Introducir elemento machacando el anterior

        lista.set(2, 4);
        System.out.println(lista);

        // get

        System.out.println(lista.get(0));

        // Se elimina esa posición y todos los elementos se mueven a la izquierda

        System.out.println(lista.remove(0)); // Con el sout muestra el que se borra

        // Recorrer la lista 1 a 1, next pasa al siguiente elemento y lo muestra

        Iterator<Integer> it = lista.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // Unir listas

        ArrayList<Integer> lista2 = new ArrayList<>();
        lista2.add(100);
        lista2.add(200);
        lista2.add(300);

        lista.addAll(lista2);

        System.out.println(lista);

        // ForEach

        lista.forEach(p -> {p++;});
        System.out.println(lista);



        // RemoveIf

        lista2.removeIf(p -> p < 10);

        // Primera posición de ese elemento

        System.out.println(lista.indexOf(100));

        // Última posición de ese elemento

        System.out.println(lista.lastIndexOf(100));*/

        // Ordenar según criterio

        String cadena1 = "";
        String cadena2 = "";

        cadena1.equals(cadena2);

        Reporte reporte1 = new Reporte("Málaga", 33, "13/01/2021");
        Reporte reporte2 = new Reporte("Sevilla", 33, "23/01/2021");

        System.out.println(reporte1.equals(reporte2));


    }
}