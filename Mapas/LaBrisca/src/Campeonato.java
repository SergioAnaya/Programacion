import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Campeonato {

    HashMap<String, Jugador> partidas;

    final String nombreArchivo = "Jugadores.csv";

    public Campeonato() {
        partidas = new HashMap<String, Jugador>();
    }

    public void leerArchivo (String archivo) throws Exception {

        File fichero = new File(archivo);

        Scanner lectorF;
        String linea;

        lectorF = new Scanner(fichero);

        while (lectorF.hasNextLine()) {
            linea = lectorF.nextLine();
            String [] jugador = linea.split(",");
            partidas.put(jugador[0], new Jugador(jugador[0], jugador[1], jugador[2], Integer.parseInt(jugador[3]), Integer.parseInt(jugador[4])));
        }
    }

    public void guardarDatos (String archivo) throws IOException {
        FileWriter fichero = new FileWriter(nombreArchivo);

        for (String nickName : partidas.keySet()) {
            fichero.write(partidas.get(nickName)).toCSVLine();
        }
    }

    public void anotarVictoria () {
        // Hacer este método
    }

    public void anotarResultado (String nombre) {
        partidas.get(nombre).anotarVictoria();
    }

    public int partidasTotales () {
        int total = 0;
        for (String nickName : partidas.keySet()) {
            total += partidas.get(nickName).getPartidasGanadas();
        }
        return total;
    }


    public Jugador jugadorGanador () {
        String ganador = "";
        int mayor = -1;

        for (String nickName : partidas.keySet()) {
            if (partidas.get(nickName).getPartidasGanadas() > mayor) {
                ganador = nickName;
                mayor = partidas.get(nickName).getPartidasGanadas();
            }
        }
        return partidas.get(ganador);
    }

}