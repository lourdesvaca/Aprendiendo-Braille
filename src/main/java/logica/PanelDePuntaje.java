package logica;

import javax.swing.*;
import java.awt.*;

public class PanelDePuntaje extends JPanel{

    private JLabel textoPuntaje = new JLabel("Tu puntaje es: ");
    private JLabel puntaje = new JLabel("0");
    private int x = 0;

    public PanelDePuntaje(){
        setLayout(null);
        setBackground(Color.GRAY);
        colocarSetBounds(30,300);
        initComponents();
    }

    //ubicacion del texto puntaje y del puntaje 0
    public void initComponents(){
        textoPuntaje.setBounds(10,10,200,50);
        textoPuntaje.setFont(new Font("Arial Black",1,14));
        puntaje.setBounds(135,10,40,50);
        puntaje.setFont(new Font("Arial Black",1,14));
        add(textoPuntaje);
        add(puntaje);
    }

    //metodo para poder moverlo a una nueva posicion
    public void colocarSetBounds(int x,int y){
        setBounds(x,y,160,50);
    }

    //metodo para poder aumentar el puntaje en +1
    public void aumentoPuntaje(){
        x++;
        puntaje.setText(""+x);
    }
}
