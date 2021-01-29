package miExamen;

import java.util.Arrays;
import java.util.Scanner;

public class Parray {

    Scanner teclado = new Scanner(System.in);

    int [] array = {2,5,3,4};
    int [] array2 = {2,6,3,4};

    public int [] longitudArray (int longitud) {
        System.out.println("¿Cuántos valores desea ingresar?");
        int[] datos = new int[longitud];

        return datos;
    }

    public void valoresArray (int [] array) {
        this.array = array;
    }

    public int count (int [] array) {
        int contador = 0;
        for (int x:array)
            contador++;
        return contador;
        }

    public int getIndex (int valor) {
        return array[valor];
    }

    public int setIndex (int posicion, int valorCambiar) {
        return array[posicion] = valorCambiar;
    }

    public void inArray (int valor) {
        boolean boleano = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == valor) {
                System.out.println("Si está en el array");
                boleano = true;
            }
        }
        if(boleano == false) {
            System.out.println("No está en el array");
        }
    }

    public void arrayFill (int longitud, int comienzo, int valor) {
        int [] array2 = new int [longitud];
        for (int i = comienzo;i < array2.length; i++) {
            array2[i] = valor;
            System.out.println(array2[i]);
        }
    }

    public void arrayReverse (int [] array) {
        Arrays.sort(array);

        for (int i = array.length - 1; i >= 0 ; i--) {
            System.out.println("Indice  " + i + " =" + array[i]);
        }
    }


    // no está acabado
    public void arrayDiff (int [] array, int [] array2) {

        for (int i = 0; i < array.length; i++){
            for (int x = 0; x < array2.length; x++) {
                if (array[i] != array2[x]) {
                    System.out.println(array[x]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Parray main = new Parray();


        //System.out.println("Contador valores array:" + main.count(main.array));
        //System.out.println("Buscar por posición: " + main.getIndex(1));
        //System.out.println("Cambiar Valor: " + main.setIndex(1, 3));
        //main.inArray(3);
        //main.arrayFill(4, 0, 1);
        //main.arrayReverse(main.array);
        main.arrayDiff(main.array, main.array2);


    }

}
