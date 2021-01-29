public class Main {

    public static void main(String[] args) {

        Nodo arbol = new Nodo(3);

        arbol.addValor(1);
        arbol.addValor(5);
        arbol.addValor(2);


        if (arbol.inArbol(20)) {
            System.out.println("\nEse nodo SI existe en el árbol\n");
        } else System.out.println("\nEse nodo NO existe en el árbol\n");

        arbol.recorridoEnOrden();
        // arbol.recorridoEnOrden2();

        System.out.println("\n");

        arbol.pintar(); // A la hora de pintar los nodos izquierdos tienen la barra | y los derechos \
    }
}
