package blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Jugador {
    private String nombre;
    private List<Integer> tiradas;

    public Jugador(String nombre){
        tiradas = new ArrayList<>();
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean tirar(){
        if (tieneTirada()){
            int tirada = ThreadLocalRandom.current().nextInt(1, 10);
            tiradas.add(tirada);
            return true;
        }
        return false;
    }

    public int suma(){
        int total = 0;
        for (Integer numero : tiradas){
            total += numero;
        }
        return total;
    }

    public void nuevaPartida(){
        tiradas.clear();
    }

    public List<Integer> getTiradas(){
        return tiradas;
    }

    public boolean tieneTirada() {
        return suma() < 16;
    }
}
