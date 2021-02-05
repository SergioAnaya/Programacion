public class Nodo {

    private int valor;
    private Nodo hijoIzquierdo;
    private Nodo hijoDerecho;

    public Nodo(int valor) {
        this.valor = valor;
        hijoIzquierdo = null;
        hijoDerecho = null;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Nodo getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(Nodo hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public Nodo getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(Nodo hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    // AÑADIR NODO

    public void addValor (int valor) {
        if (valor < this.valor) {
            if (hijoIzquierdo != null) {
                hijoIzquierdo.addValor(valor);
            } else {
                hijoIzquierdo = new Nodo(valor);
            }
        } else {
            if (hijoDerecho != null) {
                hijoDerecho.addValor(valor);
            } else {
                hijoDerecho = new Nodo(valor);
            }
        }
    }

    // BUSCAR NODO

    public boolean inArbol (int valor) {

        if (valor == this.valor) return true;
        else if (valor < this.valor) {
            if (hijoIzquierdo == null) return false;
            else return hijoIzquierdo.inArbol(valor);
        } else if (valor > this.valor) {
            if (hijoDerecho == null) return false;
            else return hijoDerecho.inArbol(valor);
        }
        return false;
    }

    // IMPRIMIR NODOS

    // Nodo Izq - Nodo Contenedor - Nodo Der

    public void recorridoEnOrden () {
        if (hijoIzquierdo != null) {
            hijoIzquierdo.recorridoEnOrden();
        }
        System.out.println(valor);
        if (hijoDerecho != null) {
            hijoDerecho.recorridoEnOrden();
        }
    }

    // En otro Orden
    // Nodo Contenedor - Nodo Izq - Nodo Der

    public void recorridoEnOrden2 () {
        System.out.println(valor);
        if (hijoIzquierdo != null) {
            hijoIzquierdo.recorridoEnOrden2();
        }
        if (hijoDerecho != null) {
            hijoDerecho.recorridoEnOrden2();
        }
    }

    /*Busqué info para ver como podía hacerlo más visual, (Operador condicional ternario)
    si se cumple el booleano left en este caso, se realiza la primera expresión ("|--") y
    si no se cumple se realiza la segunda expresión ("\\--")*/

    public void pintar () {
        pintar("", this, false);
    }

    public void pintar (String prefijo, Nodo a, boolean left) {
        if (a != null) {
            System.out.println(prefijo + (left ? "|──" : "\\──") + a.valor);
            pintar(prefijo + (left ? "|   " : "    "), a.hijoIzquierdo, true);
            pintar(prefijo + (left ? "|   " : "    "), a.hijoDerecho, false);

        }
    }

    @Override
    public String toString() {
        return "Nodo " +
                "[Valor = " + valor +
                ", hijoIzquierdo = " + hijoIzquierdo +
                ", hijoDerecho = " + hijoDerecho +
                ']';
    }
}