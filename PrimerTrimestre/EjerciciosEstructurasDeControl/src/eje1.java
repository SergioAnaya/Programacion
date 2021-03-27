import java.util.Scanner;

public class eje1 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("¿Cuántos número desea mostrar?");
        int num = teclado.nextInt();
        int num1 = 1;
        int num2;
        int fib = 0;

        for (int i = 1; i <= num; i++) {
            num2 = fib;
            fib = num1 + fib;
            num1 = num2;
            System.out.println(num1);
        }

    }

}
