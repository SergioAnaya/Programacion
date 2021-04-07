import java.util.Scanner;

/**
 * @Author Sergio Anaya Marín
 */

public class Notas {

    Scanner teclado = new Scanner(System.in);

    private final static int NUEVA_NOTA = 1;
    private final static int MOSTRAR_NOTAS = 2;
    private final static int MEDIA_NOTAS = 3;
    private final static int OP_TERMINAR = 4;

    private double notas[] = new double[100];
    private int indice = 0;

    private void imprimirMenu () {
        System.out.print(
                "\n1. Introducir nueva nota." +
                "\n2. Mostrar todas las notas." +
                "\n3. Calcular la nota media." +
                "\n4. Finalizar." +
                "\nOpción: ");
    }

    private int leerOpcionMenu () {
        return teclado.nextInt();
    }

    private double leerNota () {
        return teclado.nextDouble();
    }

    public int leerMenu () {
        imprimirMenu();
        return leerOpcionMenu();
    }

    public void addNota () {
        double nota = leerNota();
        if (nota <= 10) {
            notas[indice] = nota;
            indice++;
        } else System.out.println("Introduce una nota entre 0 y 10");
    }

    public void leerNotas () {
        for (int i = 0; i < indice; i++)  {
            System.out.print(notas[i] + ", ");
        }
    }

    public double calcularNotaMedia () {
        int count = 0;
        double notaMedia = 0;
        for (int i = 0; i < indice; i++) {
            count++;
            notaMedia += notas[i];
        }
        return notaMedia = notaMedia / count;
    }

    public void programaPrincipal (int opcion) {
        switch (opcion) {
            case NUEVA_NOTA: addNota();
            break;
            case MOSTRAR_NOTAS: leerNotas();
            break;
            case MEDIA_NOTAS:
                System.out.println(calcularNotaMedia());
        }
    }

    public static void main(String[] args) {

        Notas notas = new Notas();

        int opcion = 0;

        do {
            opcion = notas.leerMenu();
            if (opcion != OP_TERMINAR) notas.programaPrincipal(opcion);
        } while (opcion != OP_TERMINAR);

    }
}
