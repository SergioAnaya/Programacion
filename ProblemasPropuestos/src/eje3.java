public class eje3 {

    public static void main(String[] args) {

        for (int i = 1; i <= 9; i++) {
            for (int x = 0; x < 9 - i; x++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
