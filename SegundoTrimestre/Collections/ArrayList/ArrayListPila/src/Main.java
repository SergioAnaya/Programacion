public class Main {

    /*Una pila donde no se ha insertado nada, está vacía (pilaVacia == true).
    Al insertar (push) los valores 1, 2 y 3:
            1. La cima (top) devuelve 3
            2. La cima (pop) devuelve 3
            3. La cima (top) devuelve 2
            4. La cima (pop) devuelve 2
            5. La cima (pop) devuelve 1
            6. la pila está vacía (pilaVacia == true)*/

    public static void main(String[] args) {

        PilaArray pilaArray = new PilaArray();
        PilaCollections pilaCollections = new PilaCollections();

        // ArrayList

        pilaCollections.push(1);
        pilaCollections.push(2);
        pilaCollections.push(3);

        System.out.println("ArrayList -- Al insertar (push) los valores 1, 2 y 3:");
        System.out.println("\n1. La cima (top) devuelve 3");
        System.out.println("pilaCollections.top() == " + pilaCollections.top());

        System.out.println("\n2. La cima (pop) devuelve 3");
        System.out.println("pilaCollections.pop() == " + pilaCollections.pop());

        System.out.println("\n3. La cima (top) devuelve 2");
        System.out.println("pilaCollections.top() == " + pilaCollections.top());

        System.out.println("\n4. La cima (pop) devuelve 2");
        System.out.println("pilaCollections.pop() == " + pilaCollections.pop());

        System.out.println("\n5. La cima (pop) devuelve 1");
        System.out.println("pilaCollections.pop() == " + pilaCollections.pop());

        System.out.println("\n6. La pila está vacía");
        System.out.println(pilaCollections.pilaVacia());


        // Array

        int [] arr = {0};

        pilaArray.push(1);
        pilaArray.push(2);
        pilaArray.push(3);

        System.out.println("\nArray -- Al insertar (push) los valores 1, 2 y 3:");
        System.out.println("\n1. La cima (top) devuelve 3");
        System.out.println("pilaArray.top() == " + pilaArray.top());

        System.out.println("\n2. La cima (pop) devuelve 3");
        System.out.println("pilaArray.pop() == " + pilaArray.pop());

        System.out.println("\n3. La cima (top) devuelve 2");
        System.out.println("pilaArray.top() == " + pilaArray.top());

        System.out.println("\n4. La cima (pop) devuelve 2");
        System.out.println("pilaArray.pop() == " + pilaArray.pop());

        System.out.println("\n5. La cima (pop) devuelve 1");
        System.out.println("pilaArray.pop() == " + pilaArray.pop());

        System.out.println("\n6. La pila está vacía");
        System.out.println(pilaArray.pilaVacia());

    }

}