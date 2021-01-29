import java.util.ArrayList;

public class PilaCollections {

    public ArrayList<Integer> pila = new ArrayList<>();

    public void push (Integer elemento) {
        pila.add(elemento);
    }

    public Integer pop () {
        if (pilaVacia()) {
            return null;
        }
        int valor = pila.get(pila.size() - 1);
        pila.remove(pila.size() - 1);

        return valor;
    }

    public Integer top () {
        if (pilaVacia()) {
            return null;
        }
        return pila.get(pila.size() - 1);
    }

    public boolean pilaVacia () {
        return pila.isEmpty();
    }

}