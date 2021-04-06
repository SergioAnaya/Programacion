package Modelo;

public class Torre {

    int x;
    int y;

    public Torre(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void moverArriba () {
       y++;
    }

    public void moverAbajo () {
        y--;
    }

    public void moverIzquierda () {
        x--;
    }

    public void moverDerecha () {
        x++;
    }



}
