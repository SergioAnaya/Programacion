import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Ficha ficha = new Ficha();

        ficha.moverArriba(5);
        ficha.mostrar();
        ficha.moverDerecha(6);
        ficha.mostrar();
        ficha.moverAbajo(2);
        ficha.mostrar();
        ficha.moverIzquierda(4);
        ficha.mostrar();

        System.out.println("\n***** Undo *****\n");

        System.out.println(ficha.undo(7));
        ficha.mostrar();

        System.out.println("\n***** Redo *****\n");

        System.out.println(ficha.redo(3));
        ficha.mostrar();
        System.out.println("\n");

        ficha.moverArriba(1);
        ficha.mostrar();
        System.out.println("\n");

        System.out.println(ficha.redo(1));
        ficha.mostrar();
        System.out.println("\n");
    }
}
