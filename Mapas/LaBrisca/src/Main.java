import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception { // RECREAR CON OPENCSV

        Scanner teclado = new Scanner(System.in);

        Persona persona;

        ObjectOutputStream fichero = new ObjectOutputStream(new FileOutputStream("Jugadores.csv"));
        Archivo archivo = new Archivo();

        System.out.print("Introduce la cantidad de jugadores: ");
        int numJugadores = teclado.nextInt();

        for (int i = 0; i <= numJugadores; i++) {
            System.out.print("NickName: ");
            String nickName = teclado.next();
            System.out.print("Nombre: ");
            String nombre = teclado.next();
            System.out.print("Apellidos: ");
            String apellidos = teclado.next();
            System.out.print("Edad: ");
            int edad = teclado.nextInt();

            persona = new Persona(nickName, nombre, apellidos, edad);

            System.out.println("hola");

            fichero.writeObject(persona);
        }
        fichero.close();


        List<String []> filas = archivo.leerArchivo("Jugadores.csv");

        for (String [] campos : filas) {
            System.out.println(Arrays.toString(campos));
        }

    }

}
