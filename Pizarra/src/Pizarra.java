public class Pizarra {

    // Ejercicio 2 EXTENDIDO

    int [][] matriz = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };

    public int [][] getMatriz () {
        return this.matriz;
    }

    public int media () {
        int suma = 0;
        for (int fila = 0; fila < getMatriz().length; fila++ ) {
            for (int columna = 0; columna < getMatriz().length; columna++) {
                suma += getMatriz()[fila][columna];
            }
        }
        return suma / (getMatriz().length * getMatriz().length);
    }

    public static void main(String[] args) {
        Pizarra pizarra = new Pizarra();

        System.out.println(pizarra.media());
    }


}
