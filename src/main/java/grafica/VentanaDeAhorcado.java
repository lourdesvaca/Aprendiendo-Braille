package grafica;

import logica.Nivel03;

import javax.swing.*;
import java.awt.*;

public class VentanaDeAhorcado extends JFrame {

    //jlabel para poner las 6 imagenes del ahorcado
    JLabel imagen1 = new JLabel();
    int x=6;

    //contructor de la Ventana Ahorcado
    public VentanaDeAhorcado() {
        setTitle("AHORCADO");
        setSize(300, 300);
        setLocation(120,200);
        setResizable(false);
        setLayout(null);
    }

    //Reinicio para poder mostrar nuevamente la primer imagen que se mostrara en pantalla es decir la cabeza
    public void reinicio(){
        x=6;
    }

    //si x es igual a cero solo se mostrara el muñeco completo y no se va a ir al else para que no ocurra el error
    public void seleccionar(){
        if(x==0){
            this.x=0;
        } else {
            this.x--;
        }
        colocarImagen();
    }

    //metodo de colocar imagen con la ayuda de switch
    public void colocarImagen() {
        imagen1.setBounds(0, 0, this.getWidth(), this.getHeight());
        switch (x) {
            case 5:
                ImageIcon foto1 = new ImageIcon("ImagenesAhorcado/1.png");
                imagen1.setIcon(new ImageIcon(foto1.getImage().getScaledInstance(imagen1.getWidth(), imagen1.getHeight(), Image.SCALE_SMOOTH)));
                break;
            case 4:
                ImageIcon foto2 = new ImageIcon("ImagenesAhorcado/2.png");
                imagen1.setIcon(new ImageIcon(foto2.getImage().getScaledInstance(imagen1.getWidth(), imagen1.getHeight(), Image.SCALE_SMOOTH)));
                break;
            case 3:
                ImageIcon foto3 = new ImageIcon("ImagenesAhorcado/3.png");
                imagen1.setIcon(new ImageIcon(foto3.getImage().getScaledInstance(imagen1.getWidth(), imagen1.getHeight(), Image.SCALE_SMOOTH)));
                break;
            case 2:
                ImageIcon foto4 = new ImageIcon("ImagenesAhorcado/4.png");
                imagen1.setIcon(new ImageIcon(foto4.getImage().getScaledInstance(imagen1.getWidth(), imagen1.getHeight(), Image.SCALE_SMOOTH)));
                break;
            case 1:
                ImageIcon foto5 = new ImageIcon("ImagenesAhorcado/5.png");
                imagen1.setIcon(new ImageIcon(foto5.getImage().getScaledInstance(imagen1.getWidth(), imagen1.getHeight(), Image.SCALE_SMOOTH)));
                break;
            case 0:
                ImageIcon foto6 = new ImageIcon("ImagenesAhorcado/6.png");
                imagen1.setIcon(new ImageIcon(foto6.getImage().getScaledInstance(imagen1.getWidth(), imagen1.getHeight(), Image.SCALE_SMOOTH)));
                JOptionPane.showMessageDialog(null,"Perdiste Vuelve a iniciar");
                break;
        }
        add(imagen1);
    }
}
