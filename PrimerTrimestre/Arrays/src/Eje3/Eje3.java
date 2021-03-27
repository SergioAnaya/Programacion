package Eje3;

import java.util.Arrays;

public class Eje3 {

    static int array1 [] = {1, 2, 3};
    static int [] array2 = array1;
    static int array3 [] = {1, 2, 3, 4};
    static int [] array4 = array1;
    static int [] array5 = array1;
    static int array6 [] = {1, 2, 2};


    public static void comparar () {

        if (Arrays.equals(array1, array2)) {
            System.out.println("Los arrays " + Arrays.toString(array1) + " y " + Arrays.toString(array2) + " son iguales");
        } else System.out.println("Los arrays " + Arrays.toString(array1) + " y " + Arrays.toString(array2) + " no son iguales");

        if (Arrays.equals(array3, array4)) {
            System.out.println("Los arrays " + Arrays.toString(array3) + " y " + Arrays.toString(array4) + " son iguales");
        } else System.out.println("Los arrays " + Arrays.toString(array3) + " y " + Arrays.toString(array4) + " no son iguales");

        if (Arrays.equals(array5, array6)) {
            System.out.println("Los arrays " + Arrays.toString(array5) + " y " + Arrays.toString(array6) + " son iguales");
        } else System.out.println("Los arrays " + Arrays.toString(array5) + " y " + Arrays.toString(array6) + " no son iguales");

    }

    public static void main(String[] args) {
        Eje3 main = new Eje3();

        main.comparar();

    }
}