package grafica;

import javax.swing.*;
import java.awt.*;

public class PanelLibrero extends JPanel {

    private JLabel foto1 = new JLabel();
    private JLabel foto2 = new JLabel();

    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JTabbedPane pestañas = new JTabbedPane();

    public PanelLibrero(){
        setBackground(new Color(64,64,64));
        setLayout(null);

        agregarPestañas();
        colocarFoto1();
        colocarFoto2();
    }

    private void agregarPestañas(){
        pestañas.setBounds(0,50,480,400);
        pestañas.add("Braille abc",panel1);
        pestañas.add("Braille numeros",panel2);
        add(pestañas);
    }
    private void colocarFoto1(){
        ImageIcon imagenfoto1 = new ImageIcon("Imagenes/abcBraille.png");
        foto1.setBounds(0,0,pestañas.getWidth()-30, pestañas.getHeight()-30);
        foto1.setIcon(new ImageIcon(imagenfoto1.getImage().getScaledInstance(foto1.getWidth(),foto1.getHeight(),Image.SCALE_SMOOTH)));
        panel1.add(foto1);
    }
    private void colocarFoto2(){
        ImageIcon imagenfoto2 = new ImageIcon("Imagenes/numerosBraille.jpg");
        foto2.setBounds(0,0,pestañas.getWidth()-30,pestañas.getHeight()-30);
        foto2.setIcon(new ImageIcon(imagenfoto2.getImage().getScaledInstance(foto2.getWidth(),foto2.getHeight(),Image.SCALE_SMOOTH)));
        panel2.add(foto2);
    }

}
