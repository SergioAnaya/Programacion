package org.example.visual;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class numeros {
    private JPanel panel1;
    private JTextField textField1;
    private JSpinner spinner1;
    private JButton btnSumar;
    private JButton btnRestar;

    private int total = 0;

    public numeros () {
        btnSumar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                total = total + (int) spinner1.getValue();
                textField1.setText(String.valueOf(total));
            }
        });

        btnRestar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                total = total - (int) spinner1.getValue();
                textField1.setText(String.valueOf(total));
            }
        });
    }

    public JPanel getPanel () {
        return panel1;
    }

}
