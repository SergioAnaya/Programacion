package vista;

import blackjack.Jugador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Principal {
    private JPanel pnlMain;

    private JPanel pnlNombreJugador1;
    private JPanel pnlNombreJugador2;

    private JList lstJugador1;
    private JList lstJugador2;

    private JButton btnNuevaPartida;

    private JLabel lblJugador1;
    private JLabel lblJugador2;

    private JButton btnCambiarNombreJugador1;
    private JButton btnCambiarNombreJugador2;

    private JLabel lblPtosJugador1;
    private JLabel lblPtosJugador2;

    private JButton btnTiradaJugador1;
    private JButton btnTiradaJugador2;

    private JTextField txtGanador;

    private ModeloListaTiradas modeloLista1, modeloLista2;
    private Jugador jugador1, jugador2;

    public Principal () {};

    public Principal(Jugador jugador1, Jugador jugador2){
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        modeloLista1 = new ModeloListaTiradas(jugador1);
        modeloLista2 = new ModeloListaTiradas(jugador2);
        lstJugador1.setModel(modeloLista1);
        lstJugador2.setModel(modeloLista2);

        btnCambiarNombreJugador1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CambiarNombre cambiarNombre = new CambiarNombre();
                if (cambiarNombre.OkPressed()) {
                    String nombreJugador = cambiarNombre.getNuevoNombre();
                    lblJugador1.setText(nombreJugador);
                    jugador1.setNombre(nombreJugador);
                    cambiarNombre.dispose();
                }
            }
        });

        btnCambiarNombreJugador2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CambiarNombre cambiarNombre = new CambiarNombre();
                if (cambiarNombre.OkPressed()) {
                    String nombreJugador = cambiarNombre.getNuevoNombre();
                    lblJugador2.setText(nombreJugador);
                    jugador2.setNombre(nombreJugador);
                    cambiarNombre.dispose();
                }
            }
        });

        btnTiradaJugador1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListCellForm listCellForm = new ListCellForm();
                lstJugador1.setCellRenderer(listCellForm);
                modeloLista1.addTirada();
                lblPtosJugador1.setText(String.valueOf(jugador1.suma()));
                if (jugador1.tieneTirada()==false){
                    btnTiradaJugador1.setEnabled(false);
                }
                if (!btnTiradaJugador1.isEnabled() && !btnTiradaJugador2.isEnabled()) {
                    generarGanador();
                }
            }
        });

        btnTiradaJugador2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListCellForm listCellForm = new ListCellForm();
                lstJugador2.setCellRenderer(listCellForm);
                modeloLista2.addTirada();
                lblPtosJugador2.setText(String.valueOf(jugador2.suma()));
                if (jugador2.tieneTirada()==false){
                    btnTiradaJugador2.setEnabled(false);
                }
                if (!btnTiradaJugador1.isEnabled() && !btnTiradaJugador2.isEnabled()) {
                    generarGanador();
                }
            }
        });

        btnNuevaPartida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modeloLista1.removeTirada();
                lblPtosJugador1.setText(String.valueOf(""));
                btnTiradaJugador1.setEnabled(true);
                pnlNombreJugador1.setBackground(Color.gray);
                modeloLista2.removeTirada();
                lblPtosJugador2.setText(String.valueOf(""));
                btnTiradaJugador2.setEnabled(true);
                pnlNombreJugador2.setBackground(Color.gray);
                txtGanador.setText("");
            }
        });

    }

    public void generarGanador() {

        if (jugador1.suma() > jugador2.suma() || (jugador2.suma() > 21 && jugador1.suma() <= 21)) {
            txtGanador.setText(jugador1.getNombre());
            pnlNombreJugador1.setBackground(Color.green);
            pnlNombreJugador2.setBackground(Color.gray);
        } else if (jugador1.suma() < jugador2.suma() || (jugador2.suma() <= 21 && jugador1.suma() > 21)) {
            txtGanador.setText(jugador2.getNombre());
            pnlNombreJugador1.setBackground(Color.gray);
            pnlNombreJugador2.setBackground(Color.green);
        } else {
            txtGanador.setText("EMPATE");
            pnlNombreJugador1.setBackground(Color.DARK_GRAY);
            pnlNombreJugador2.setBackground(Color.DARK_GRAY);
        }
    }


    public Container getPanel() {
        return pnlMain;
    }
}
