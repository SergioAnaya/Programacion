import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RankingPilotos {

    private ArrayList<Piloto> pilotos = new ArrayList<Piloto>();

    public void añadirPiloto (Piloto piloto, int posicionDeSalida) {
        pilotos.add(piloto);
    }

    public boolean adelantarPiloto(String nombrePiloto){

        int posicion = encontrarPiloto(nombrePiloto);

        if (pilotos.get(posicion).isDescalificado()) return false;
        else return intercambiarPosicion(posicion,posicion-1);

    }

    public boolean retrasarPiloto(String nombrePiloto){
        int posicion = encontrarPiloto(nombrePiloto);

        if (posicion < pilotos.size() - 1 && !pilotos.get(posicion + 1).isDescalificado())
            return intercambiarPosicion(posicion, posicion + 1);

        else return false;
    }

    public void descalificarPiloto(String nombrePiloto){
        int item = encontrarPiloto(nombrePiloto);
        if (item >= 0) {
            Piloto p =  pilotos.get(item);
            p.setDescalificado(true);
            pilotos.add(p);
            pilotos.remove(item);
        }
    }

    public void ordenarPilotosPorPosicionDeSalida(){
        Collections.sort(pilotos, comparadorPosicionSalida);
    }

    public void ordenarPilotosPorNombre(){
        Collections.sort(pilotos, comparadorNombre);
    }


    private int encontrarPiloto(String nombre){
        for (int i = 0; i < pilotos.size(); i++)
        { if (pilotos.get(i).getNombre().equals(nombre)) return i; }
        return -1;
    }

    private boolean intercambiarPosicion(int pilotoA,int pilotoB){
        Piloto aux = pilotos.get(pilotoA);
        pilotos.set(pilotoA,pilotos.get(pilotoB));
        pilotos.set(pilotoB,aux);
        return true;
    }

    // COMPARADORES

    Comparator<Piloto> comparadorPosicionSalida = new Comparator<Piloto>(){
        @Override
        public int compare(Piloto uno, Piloto dos) {
            if (uno.getPosicionDeSalida() < dos.getPosicionDeSalida()) return -1;
            else if (uno.getPosicionDeSalida() == dos.getPosicionDeSalida()) return 0;
            else return 1;
        }
    };

    Comparator<Piloto> comparadorNombre = new Comparator<Piloto>(){
        @Override
        public int compare(Piloto uno, Piloto dos) {
            return uno.getNombre().compareTo(dos.getNombre());
        }
    };

    @Override
    public String toString() {
        return "\n*********** Lista Pilotos ***********\n\n" +
                pilotos;
    }
}
