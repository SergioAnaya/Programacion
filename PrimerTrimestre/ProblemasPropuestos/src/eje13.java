import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class eje13 {

    public static void main(String[] args) throws ParseException {

        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce la fecha (formato dd/mm/yyyy):\n");
        String fechateclado = teclado.next();

        String year = fechateclado.substring(6,10);
        int yearInt = Integer.parseInt(year);

        Date fechaConcreta = new SimpleDateFormat("dd/MM/yyyy").parse(fechateclado);

        String fechaNueva = new SimpleDateFormat("\ndd MMMM yyyy").format(fechaConcreta);

        System.out.println(fechaNueva.replace(" ", " de "));

        if ((yearInt % 4 == 0) && (yearInt % 100 != 0) && (yearInt % 400 == 0)) {
            System.out.println("\nAño bisiesto");
        } else {
            System.out.println("\nAño no bisiesto");
        }


    }
}
