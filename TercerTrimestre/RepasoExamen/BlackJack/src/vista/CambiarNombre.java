package vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CambiarNombre extends JDialog {
    private JPanel pnlPrincipal;
    private JLabel lblNuevoNombre;
    private JButton btnOk;
    private JButton btnCancel;
    private JTextField txtFieldNuevoNombre;

    private String nuevoNombre;
    private boolean okPressed = false;

    public CambiarNombre () {

        setContentPane(pnlPrincipal);
        setModal(true);
        getRootPane().setDefaultButton(btnOk);

        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onOk();
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        pack();
        setVisible(true);
    }

    private void onOk () {
        nuevoNombre = txtFieldNuevoNombre.getText();
        okPressed = true;
        setVisible(false);
    }

    public void onCancel () {
        setVisible(false);
    }

    public String getNuevoNombre () { return nuevoNombre; }

    public boolean OkPressed () { return okPressed; }
}
