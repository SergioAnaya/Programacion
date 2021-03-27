import java.util.Scanner;

public class eje1 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int base;
        int altura;
        int superficie;
        int contador = 0;

        System.out.println("Cuantos pares de números desea insertar: ");
        int npares = teclado.nextInt();

        for (int i = 1; i <= npares; i++) {
            System.out.println("\nIntroduce la altura del triángulo número " + i);
            altura = teclado.nextInt();
            System.out.println("\nIntroduce la base del triángulo número " + i);
            base = teclado.nextInt();
            superficie = (altura * base) / 2;
            if (superficie > 12) {
                contador++;
            }
            System.out.println("\nTriángulo número " + i);
            System.out.println("Base: " + base);
            System.out.println("Altura " + altura);
            System.out.println("Superficie " + superficie);
        }
        System.out.println("\nNúmero de triángulos con superficie mayor a 12: "+ contador);
    }
}
