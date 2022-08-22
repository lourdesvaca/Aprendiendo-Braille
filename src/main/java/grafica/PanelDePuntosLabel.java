package grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelDePuntosLabel extends JPanel implements MouseListener {

    //6 puntos label
    private JLabel lblredondo1 = new JLabel("1");
    private JLabel lblredondo2 = new JLabel("2");
    private JLabel lblredondo3 = new JLabel("3");
    private JLabel lblredondo4 = new JLabel("4");
    private JLabel lblredondo5 = new JLabel("5");
    private JLabel lblredondo6 = new JLabel("6");

    //array de label
    private JLabel[] array_labels = new JLabel[6];

    //contructor de label para que pueda interactuar en las letras
    public PanelDePuntosLabel() {
        setBackground(Color.gray);
        setLayout(null);
        colocarelSetbounds(140, 80);

        array_labels[0] = lblredondo1;
        array_labels[1] = lblredondo2;
        array_labels[2] = lblredondo3;
        array_labels[3] = lblredondo4;
        array_labels[4] = lblredondo5;
        array_labels[5] = lblredondo6;

        lblredondo1.addMouseListener(this);
        lblredondo2.addMouseListener(this);
        lblredondo3.addMouseListener(this);
        lblredondo4.addMouseListener(this);
        lblredondo5.addMouseListener(this);
        lblredondo6.addMouseListener(this);

        colocar_labelNivel1();
    }

    //contructor de label para que no pueda interactuar y tiene los colores predefinidos ya que el #
    public PanelDePuntosLabel(int x){
        setBackground(Color.gray);
        setLayout(null);
        colocarelSetbounds(140,80);

        array_labels[0] = lblredondo1;
        array_labels[1] = lblredondo2;
        array_labels[2] = lblredondo3;
        array_labels[3] = lblredondo4;
        array_labels[4] = lblredondo5;
        array_labels[5] = lblredondo6;
        colocar_labelNivel1();

        lblredondo3.setOpaque(true);
        lblredondo3.setBackground(Color.RED);
        lblredondo4.setOpaque(true);
        lblredondo4.setBackground(Color.RED);
        lblredondo5.setOpaque(true);
        lblredondo5.setBackground(Color.RED);
        lblredondo6.setOpaque(true);
        lblredondo6.setBackground(Color.RED);
    }

    //metodo para colocar en cualquier posicion el panel de label
    public void colocarelSetbounds(int x, int y){
        setBounds(x, y, 130, 220);
    }

    //colocar la ubicacion del label
    public void colocar_labelNivel1(){
        int x = 10;
        int y = 10;
        for (int i = 0; i < array_labels.length; i++) {//6
            array_labels[i].setBounds(x, y, 50, 50);
            array_labels[i].setOpaque(true);
            array_labels[i].setBackground(Color.YELLOW);
            array_labels[i].setHorizontalAlignment(SwingConstants.CENTER);
            add(array_labels[i]);
            y += 70;
            if (i == 2) {
                x = 70;
                y = 10;
            }
        }
    }

    //metodo que retornara el array de label para poder utilizarlo como en la longitud que tiene y para
    //utilizarlo en el color
    public JLabel[] getArray_labels() {
        return array_labels;
    }

    //colores aleatorio para el jlabel letra
    public void colores_Aleatorios(){
        int resultado;
        for (int i = 0; i < array_labels.length; i++) {
            resultado = (int)(Math.random()*2);//0 Color rojo 1 Color amarillo
            if(resultado == 0) {
                array_labels[i].setBackground(Color.RED);
            } else {
                array_labels[i].setBackground(Color.YELLOW);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == lblredondo1) {
            if (lblredondo1.getBackground() != Color.RED) {
                lblredondo1.setBackground(Color.RED);
            } else {
                lblredondo1.setBackground(Color.YELLOW);
            }
        }
        if (e.getSource() == lblredondo2) {
            if (lblredondo2.getBackground() != Color.RED) {
                lblredondo2.setBackground(Color.RED);
            } else {
                lblredondo2.setBackground(Color.yellow);
            }
        }
        if (e.getSource() == lblredondo3) {
            if (lblredondo3.getBackground() != Color.RED) {
                lblredondo3.setBackground(Color.RED);
            } else {
                lblredondo3.setBackground(Color.yellow);
            }
        }
        if (e.getSource() == lblredondo4) {
            if (lblredondo4.getBackground() != Color.RED) {
                lblredondo4.setBackground(Color.RED);
            } else {
                lblredondo4.setBackground(Color.yellow);
            }
        }
        if (e.getSource() == lblredondo5) {
            if (lblredondo5.getBackground() != Color.RED) {
                lblredondo5.setBackground(Color.RED);
            } else {
                lblredondo5.setBackground(Color.yellow);
            }
        }
        if (e.getSource() == lblredondo6) {
            if (lblredondo6.getBackground() != Color.RED) {
                lblredondo6.setBackground(Color.RED);
            } else {
                lblredondo6.setBackground(Color.yellow);
            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
