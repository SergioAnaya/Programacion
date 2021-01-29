import java.util.Scanner;

public class eje4 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        int estudiantemañana, estudiantetarde, estudiantenoche;
        int edad;

        System.out.println("¿Cuántos estudiantes de turno de mañana?: ");
        estudiantemañana = teclado.nextInt();
        System.out.println("Introduce las edades de los estudiantes: ");
        for (int i = 0; i < estudiantemañana; i++) {
            edad = teclado.nextInt();
            sum1 = sum1 + edad;
        }
        System.out.println("¿Cuántos estudiantes de turno de tarde?: ");
        estudiantetarde = teclado.nextInt();
        System.out.println("Introduce las edades de los estudiantes: ");
        for (int i = 0; i < estudiantetarde; i++) {
            edad = teclado.nextInt();
            sum2 = sum2 + edad;
        }
        System.out.println("¿Cuántos estudiantes de turno de noche?: ");
        estudiantenoche = teclado.nextInt();
        System.out.println("Introduce las edades de los estudiantes: ");
        for (int i = 0; i < estudiantenoche; i++) {
            edad = teclado.nextInt();
            sum3 = sum3 + edad;
        }

        int media1 = (sum1 / estudiantemañana);
        int media2 = (sum2 / estudiantetarde);
        int media3 = (sum3 / estudiantenoche);

        System.out.println("Promedios: " +
                "\n Promedio edad en turno de mañana: " + media1 +
                "\n Promedio edad en turno de tarde: " + media2 +
                "\n Promedio edad en turno de noche: " + media3);
        if (sum1 > sum3 && sum1 > sum2) {
            System.out.println("\n El turno de mañana tiene mayor promedio de edad");
        } else if (sum2 > sum3) {
            System.out.println("\n El turno de tarde tiene mayor promedio de edad");
        } else {
            System.out.println("\n El turno de noche tiene mayor promedio de edad");
        }
    }
}
