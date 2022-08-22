package grafica;

import javax.swing.*;
import java.awt.*;

public class PanelNorte extends JPanel {

    private JLabel lblTitulo = new JLabel("BIENVENIDOS");

    public PanelNorte() {
        setBackground(new Color(0, 0, 53));
        titulo();
    }

    public void titulo() {
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Arial Black", 1, 20));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblTitulo);
    }
}
