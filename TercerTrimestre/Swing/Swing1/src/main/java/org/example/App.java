package org.example;

import org.example.logica.Personas;
import org.example.vista.Ventana;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        Personas personas = new Personas();
        Ventana ventana = new Ventana(personas);

        JFrame frame = new JFrame("Ventana");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(ventana.getPanel());

        /*Toolkit toolkit = Toolkit.getDefaultToolkit();
        int height = toolkit.getScreenSize().height;
        int width = toolkit.getScreenSize().width;*/

        frame.pack();
        frame.setVisible(true);

    }

}
