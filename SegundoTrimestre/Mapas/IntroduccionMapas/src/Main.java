import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        HashMap<String, Integer> miMapa = new HashMap<String, Integer>();

        miMapa.put("Lunes", 1800);
        miMapa.put("Martes", 2000);
        miMapa.put("Miércoles", 900);
        miMapa.put("Jueves", 1200);
        miMapa.put("Viernes", 500);
        miMapa.put("Sábado", 1000);
        miMapa.put("Domingo", 800);

        System.out.println(miMapa.toString());

        System.out.println("El Viernes tomé " + miMapa.get("Viernes") + " calorías.");

        System.out.println("La tabla contiene la clave Viernes " + miMapa.containsKey("Viernes"));
        miMapa.remove("Domingo");
        System.out.println("La tabla contiene el valor 800 " + miMapa.containsValue(800));


        /*HashMap<Punto, Persona> mapaPrueba = new HashMap<Punto, Persona>();

        Punto punto = new Punto(2, -1);
        Persona persona = new Persona("Sergio", "Málaga", "1999");
        mapaPrueba.put(punto, persona);

        Persona resultado;
        resultado = mapaPrueba.get(new Punto(2, -1));*/
    }
}
