import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> arrayList = new ArrayList<>();

        List<Integer> linkedList = new LinkedList<>();

        TestTiempoOperaciones testTiempoOperaciones = new TestTiempoOperaciones(arrayList);

        System.out.println("***** ArrayList *****\n");

        System.out.println("Tiempo en insertar 1 millón de elementos: " + testTiempoOperaciones.insertarElementos(100000));

        System.out.println("Tiempo en borrar 50 mil de elementos en mitad de la lista: " + testTiempoOperaciones.borrarElementosMitadDeLista(50000, TestTiempoOperaciones.MITAD_LISTA));

        System.out.println("Tiempo en borrar 50 mil de elementos desde el inicio de la lista: " + testTiempoOperaciones.borrarElementosInicioDeLista(50000, TestTiempoOperaciones.INICIO_LISTA));

        System.out.println("Insertar 50 mil elementos al inicio de la lista: " + testTiempoOperaciones.insertarEnInicioDeLista(50000, TestTiempoOperaciones.INICIO_LISTA));

        System.out.println("Insertar 50 mil elementos en mitad de la lista: " + testTiempoOperaciones.insertarEnMitadDeLista(50000, TestTiempoOperaciones.MITAD_LISTA));

        System.out.println("Tiempo recorrido de la lista: " + testTiempoOperaciones.recorrerLista());

        System.out.println("Tiempo en ordenar la lista: " + testTiempoOperaciones.ordenarLista());



        TestTiempoOperaciones testTiempoOperaciones2 = new TestTiempoOperaciones(linkedList);

        System.out.println("\n***** LinkedList *****\n");

        System.out.println("Tiempo en insertar 1 millón de elementos: " + testTiempoOperaciones2.insertarElementos(100000));

        System.out.println("Tiempo en borrar 50 mil elementos en mitad de la lista: " + testTiempoOperaciones2.borrarElementosMitadDeLista(50000, TestTiempoOperaciones.MITAD_LISTA));

        System.out.println("Tiempo en borrar 50 mil elementos desde el inicio de la lista: " + testTiempoOperaciones2.borrarElementosInicioDeLista(50000, TestTiempoOperaciones.INICIO_LISTA));

        System.out.println("Insertar 50 mil elementos al inicio de la lista: " + testTiempoOperaciones2.insertarEnInicioDeLista(50000, TestTiempoOperaciones.INICIO_LISTA));

        System.out.println("Insertar 50 mil elementos en mitad de la lista: " + testTiempoOperaciones2.insertarEnMitadDeLista(50000, TestTiempoOperaciones.MITAD_LISTA));

        System.out.println("Tiempo recorrido de la lista: " + testTiempoOperaciones2.recorrerLista());

        System.out.println("Tiempo en ordenar la lista: " + testTiempoOperaciones2.ordenarLista());

    }
}