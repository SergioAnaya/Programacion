public class Main {

    public static void main(String[] args) throws Exception {

        Campeonato campeonato = new Campeonato();

        campeonato.leerArchivo("Jugadores.csv");
        System.out.println(campeonato.partidas.toString());

        campeonato.anotarResultado("Jesfly");
        campeonato.anotarResultado("Harry");
        campeonato.anotarResultado("Jesfly");
        campeonato.anotarResultado("Jesfly");
        campeonato.anotarResultado("Peter");
        campeonato.anotarResultado("Jesfly");
        campeonato.anotarResultado("Jesfly");

        System.out.println("Partidas juadas hasta el momento = " + campeonato.partidasTotales());

        System.out.println("El Jugador en primera posición del campeonato es "+campeonato.jugadorGanador().getNombreApellido());

        campeonato.guardarDatos(campeonato.nombreArchivo);

    }
}