package Ejercicio3;

public class Eje3 {

    public boolean comparaArrayRecursivo (int [] array1, int [] array2, int posicion) {
        int arr1 = array1.length;
        int arr2 = array2.length;

        if (arr1 == arr2) {
            if (posicion == -1) return true;
            if (array1[posicion] == array2[posicion]) return true && comparaArrayRecursivo(array1, array2, -1);
            else return false;
        }
        else return false;
    }

    public static void main(String[] args) {

        Eje3 eje3 = new Eje3();

        boolean resultado;

        int [] a = {39, 37, 11, 6, 2};
        int [] b = {39, 37, 11, 6, 1};

        resultado = eje3.comparaArrayRecursivo(a, b, a.length-1);

        if (resultado) System.out.println("Son iguales");
        else System.out.println("No son iguales");



    }

}
