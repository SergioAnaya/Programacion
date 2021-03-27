package Eje8;

public class Eje8 {

    public static void main(String[] args) {

        int [][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 8}};

        int a = array[0][0];
        int b = array[0][1];
        int c = array[0][2];
        int d = array[1][0];
        int e = array[1][1];
        int f = array[1][2];
        int g = array[2][0];
        int h = array[2][1];
        int i = array[2][2];
        int detA = (a * e * i) + (b * f * g) + (c * d * h) - (a * f * h) - (b * d * i) - (c * e * g);

        System.out.println(detA);
    }
}
