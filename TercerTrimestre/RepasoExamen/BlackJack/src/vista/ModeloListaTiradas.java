package vista;

import blackjack.Jugador;

import javax.swing.*;

public class ModeloListaTiradas extends AbstractListModel<Integer> {
    private Jugador jugador;

    public ModeloListaTiradas(Jugador jugador){
        this.jugador = jugador;
    }

    @Override
    public int getSize() {
        return jugador.getTiradas().size();
    }

    @Override
    public Integer getElementAt(int index) {
        return jugador.getTiradas().get(index);
    }

    public boolean addTirada(){
        boolean añadido=jugador.tirar();
        if (añadido){
            fireIntervalAdded(this,jugador.getTiradas().size()-1,jugador.getTiradas().size()-1);
        }
        return añadido;
    }

    public void removeTirada(){
        jugador.nuevaPartida();
        fireIntervalRemoved(this,0,10);

    }
}