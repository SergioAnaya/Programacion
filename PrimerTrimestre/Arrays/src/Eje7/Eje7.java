package Eje7;

public class Eje7 {

    public static void main(String[] args) {

        int [][] array = {{1, 2}, {4, 5, 6}};

        for (int i = 0; i < array.length; i++) {
            for (int x = 0; x < array[i].length; x++) {
                System.out.print(array[i][x]);
            }
        }
    }
}
