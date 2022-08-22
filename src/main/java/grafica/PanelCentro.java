package grafica;

import javax.swing.*;
import java.awt.*;

public class PanelCentro extends JPanel {

    private JLabel lblImagen = new JLabel();

    public PanelCentro(){
        setBackground(Color.RED);
        setLayout(null);
    }

    public void imagenFondo(){
        ImageIcon imagen = new ImageIcon("Imagenes/fondoVentana2.jpg");
        lblImagen.setBounds(0,0,485,402);
        lblImagen.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(lblImagen.getWidth(),lblImagen.getHeight(),Image.SCALE_SMOOTH)));
        add(lblImagen);
    }
}
