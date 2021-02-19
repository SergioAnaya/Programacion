public class Main {

    public static void main(String[] args) throws Exception {

        Campeonato campeonato = new Campeonato();

        campeonato.leerArchivo("Jugadores.csv");

        System.out.println(campeonato.partidas.get("Jesfly").toString());

    }

}
