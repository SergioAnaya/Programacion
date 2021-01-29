package Correcion;

public class Parray {

    private int [] array;

    public Parray (int longitud) {

    }

    public Parray (int [] arrayParametro) {
        this.array = new int[arrayParametro.length];
        for (int i = 0; i < arrayParametro.length; i++) {
            this.array[i] = arrayParametro[i];
        }
    }

    public int count () {
        return this.array.length;
    }

    public int getIndex (int indice) {
        return array[indice];
    }

    public void setIndex (int indice, int valor)  {
        if (indice < this.count() && indice >= 0) this.array[indice] = valor;

    }

    /* setIndex con excepción

    public void setIndex (int indice, int valor) throws Exception {
        if (indice < this.count() && indice >= 0) this.array[indice] = valor;
        else throw new Exception("Indice fuera de límite");

    }*/

    public boolean in_array (int needle) {
        boolean encontrado = false;

        for (int i = 0; i < this.count(); i++) { // Se aprovecha el Count como si fuera .lenght
            if (this.getIndex(i) == needle) return true;
        }
        return encontrado;
    }

    public void array_fill (int start_index, int num, int value) {
        for (int i = start_index; i < num + start_index; i++) {
            this.setIndex(i, value); // Con este método se rellena el array directamente ya que cambia cada valor del array por el ingresador por parámetro
        }
    }

    public String mostrar () {
        String contenido = "";
        for (int valor : this.array) {
            contenido += valor + ", ";
        }
        return contenido;
    }



    public static void main(String[] args) throws Exception {

        Parray a = new Parray(5);
        System.out.println(a.mostrar());

        int [] arrayIni = {1, 3, 5, 7, 9, 2, 4, 8, 6, 8};

        Parray p = new Parray(arrayIni);
        System.out.println(p.mostrar());

        arrayIni[0] = -99;
        System.out.println(p.mostrar());

        System.out.println("Longitud: " + p.count());

        System.out.println(p.getIndex(3));

        p.setIndex(2, 3);












    }
}
