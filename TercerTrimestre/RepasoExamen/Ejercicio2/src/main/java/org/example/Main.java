package org.example;

import org.example.visual.numeros;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        numeros numeros = new numeros();

        JFrame frame = new JFrame("numeros");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(numeros.getPanel());
        frame.pack();
        frame.setVisible(true);

    }
}