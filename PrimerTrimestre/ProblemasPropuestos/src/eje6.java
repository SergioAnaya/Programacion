public class eje6 {

    public static void main(String[] args) {

        int i , k, suma;

        for (i = 2; i < 1000; i++) {
            suma = 0;
            for (k = 1; k < i; k++) {
                if (i % k == 0) {
                    suma = suma + k;
                }
            }
            if (i == suma) {
                System.out.println(i);
            }
        }
    }
}
