import java.util.ArrayList;

public class Ficha2 {

    private int x = 0;
    private int y = 0;

    ArrayList<Integer> Done = new ArrayList();
    ArrayList<Integer> Undone = new ArrayList<>();

    public Ficha2 () {}

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moverArriba (int numVeces) {
        for (int i = 0; i < numVeces; i++) {
            Done.add(0);
            y++;
            Undone.clear();
        }
    }

    public void moverAbajo (int numVeces) {
        for (int i = 0; i < numVeces; i++) {
            Done.add(1);
            y--;
            Undone.clear();
        }
    }

    public void moverIzquierda (int numVeces) {
        for (int i = 0; i < numVeces; i++) {
            Done.add(2);
            x--;
            Undone.clear();
        }
    }

    public void moverDerecha (int numVeces) {
        for (int i = 0; i < numVeces; i++) {
            Done.add(3);
            x++;
            Undone.clear();
        }
    }

    public boolean undo (int numUndo) {
        if (numUndo <= Done.size()) {
            for (int i = 0; i < numUndo; i++) {
                int valor = Done.get(Done.size() - 1);
                if (valor == 0) { // 0 es para arriba
                    y--;
                    Done.remove(Done.size() - 1);
                    Undone.add(0, 0);
                } else if (valor == 1) { // 1 es para abajo
                    y++;
                    Done.remove(Done.size() - 1);
                    Undone.add(0, 1);
                } else if (valor == 2) { // 2 es para izquierda
                    x++;
                    Done.remove(Done.size() - 1);
                    Undone.add(0, 2);
                } else if (valor == 3) { // 3 es para derecha
                    x--;
                    Done.remove(Done.size() - 1);
                    Undone.add(0, 3);
                } else System.out.println("No se ha podido RETROCEDER");
            }
        } return false;
    }

    public boolean redo (int numRedo) {
        if (numRedo <= Undone.size()) {
            for (int i = 0; i < numRedo; i++) {
                int valor = Undone.get(0);
                if (valor == 0) { // 0 es para arriba
                    y++;
                    Done.add(0);
                    Undone.remove(0);
                } else if (valor == 1) { // 1 es para abajo
                    y--;
                    Done.add(1);
                    Undone.remove(0);
                } else if (valor == 2) { // 2 es para izquierda
                    x--;
                    Done.add(2);
                    Undone.remove(0);
                } else if (valor == 3) { // 3 es para derecha
                    x++;
                    Done.add(3);
                    Undone.remove(0);
                } else System.out.println("No se ha podido REHACER");
            } return true;
        } return false;
    }



    // toString
    public void mostrar () {
        System.out.println("\nPosición de la ficha: " + getX() + "," + getY());
        System.out.println("Done: " + Done);
        System.out.println("Undone: " + Undone);
    }
}