import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class TestTiempoOperaciones {

    /*long instanteInicio = System.currentTimeMillis();
    long tiempoEjecucion = System.currentTimeMillis() - instanteInicio;*/

    public final static int INICIO_LISTA = 0;
    public final static int MITAD_LISTA = 1;

    private List<Integer> lista;

    public TestTiempoOperaciones(List<Integer> lista) {
        this.lista = lista;
    }

    public long insertarElementos(int numElementos) {
        long instanteInicio = System.currentTimeMillis();
        for (int i = 1; i <= numElementos; i++) {
            lista.add(i);
        }
        long tiempoEjecucion = System.currentTimeMillis() - instanteInicio;

        return tiempoEjecucion;
    }

    public long borrarElementosMitadDeLista (int numElementos) {
        int mitadLista = lista.size() / 2;
        long instanteInicio = System.currentTimeMillis();
        for (int i = 1; i <= numElementos; i++) {
            lista.remove(mitadLista);
        }
        long tiempoEjecucion = System.currentTimeMillis() - instanteInicio;

        return tiempoEjecucion;
    }

    public long borrarElementosInicioDeLista (int numElementos) {
        long instanteInicio = System.currentTimeMillis();
        for (int i = 1; i <= numElementos; i++) {
            lista.remove(0);
        }
        long tiempoEjecucion = System.currentTimeMillis() - instanteInicio;

        return tiempoEjecucion;
    }

    public long insertarEnInicioDeLista (int numElementos) {
        long instanteInicio = System.currentTimeMillis();
        for (int i = 1; i <= numElementos; i++) {
            lista.add(i);
        }
        long tiempoEjecucion = System.currentTimeMillis() - instanteInicio;

        return tiempoEjecucion;
    }

    public long insertarEnMitadDeLista (int numElementos) {
        int mitadLista = lista.size() / 2;
        long instanteInicio = System.currentTimeMillis();
        for (int i = 1; i <= numElementos; i++) {
            lista.add(mitadLista, i);
        }
        long tiempoEjecucion = System.currentTimeMillis() - instanteInicio;

        return tiempoEjecucion;
    }

    public long recorrerLista() {
        long instanteInicio = System.currentTimeMillis();
        Iterator<Integer> it = lista.iterator();
        while (it.hasNext()) it.next();
        long tiempoEjecucion = System.currentTimeMillis() - instanteInicio;

        return tiempoEjecucion;
    }

    public long ordenarLista() {
        long instanteInicio = System.currentTimeMillis();

        Comparator<Integer> comparador = Collections.reverseOrder();
        Collections.sort(lista, comparador);

        long tiempoEjecucion = System.currentTimeMillis() - instanteInicio;

        return tiempoEjecucion;
    }

}