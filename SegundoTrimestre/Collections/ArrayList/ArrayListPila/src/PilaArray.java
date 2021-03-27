public class PilaArray {

    private final static int TAM_PILA = 100; // 100 elementos de máximo

    private Integer [] arr;
    private int tope;

    public PilaArray () {
        arr = new Integer[TAM_PILA];
        tope = -1;
    }

    public void push (int elemento) {
        tope++;
        arr[tope] = elemento;
    }

    public Integer pop () {
        tope--;
        return arr[tope + 1];
    }

    public Integer top () {
        return arr[tope];
    }

    public boolean pilaVacia () {
        return (tope == -1);
    }

}