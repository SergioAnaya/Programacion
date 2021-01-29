package Ejercicio2;

public class Eje2 {

    /*public int euclides (int a, int b) {
        if (a == b) return a;
        if (a > b) return euclides(a-b, b);
        else return euclides(a, b-a);
    }*/ // Ejemplo profesor

    public int mcd (int a, int b) {
        if (b == 0) return a;
        else return mcd(b, a%b);
    }

    public static void main(String[] args) {
        Eje2 eje2 = new Eje2();

        int resultado = eje2.mcd(412, 184);

        System.out.println("MCD: "+ resultado );
    }

}
