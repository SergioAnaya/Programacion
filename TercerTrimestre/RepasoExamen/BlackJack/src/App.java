import blackjack.Jugador;
import vista.Principal;

import javax.swing.*;

public class App {

    public static void main(String[] args) {

        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");
        JFrame frame = new JFrame("BlackJack");
        frame.setContentPane(new Principal(jugador1,jugador2).getPanel());
        frame.pack();
        frame.setVisible(true);
    }
}
