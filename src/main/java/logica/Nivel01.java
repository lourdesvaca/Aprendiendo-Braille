package logica;

import grafica.PanelDePuntosLabel;

import javax.swing.*;
import java.awt.*;

public class Nivel01 extends JPanel {

    // Declaracion del Panel de Puntos label (6) que se puede interactuar (cambiar color)
    private PanelDePuntosLabel panelParaLosPuntos = new PanelDePuntosLabel();
    // Declaracion del Panel de Puntos label (6) que no se puede interactuar (no se cambia el color) esta predefinido
    private PanelDePuntosLabel panelParaLosPuntos2 = new PanelDePuntosLabel(1);

    // Declaracion de la clase letra para utilizarlo en letra aleatoria
    private Letras letra_implementada = new Letras();
    // Declaracion de la clase letra para las claves
    private Letras letra_implementada1 = new Letras(1);

    // Declaracion de la clase numero para utilizarlo en numero aleatorio
    private Numeros numero = new Numeros();
    // Declaracion de la clase numero para las claves
    private Numeros numero1 = new Numeros(1);


    private Color color = Color.GRAY;


    private JLabel texto = new JLabel("TRADUCELO EN LA REPRESENTACION BRAILLE");
    private JLabel letra = new JLabel();


    private JButton btnVerificar = new JButton("VERIFICAR");
    private JButton btnCambiar = new JButton("Cambio");


    private PanelDePuntaje puntaje_jugador = new PanelDePuntaje();

    private int x = 0;


    public Nivel01() {
        setBackground(color);
        setLayout(null);
        interfaz();

        btnVerificar.addActionListener(e -> {
            verificar();//verificar primero la letra
            verificar1();//verifica de segundo el número
        });
        colocarPuntosBraille();
        btnCambiar.addActionListener(e -> {
            if (x == 0) {// 0 == 0 entonces carga el label de #
                colocarPuntosBraille2();
                x++;
            } else {// 1 != 0 entonces carga el label de letra
                colocarPuntosBraille();
                x = 0;
            }
        });
    }

    //coloca el punto braille de letra y no muestra el punto label de números
    public void colocarPuntosBraille() {
        add(panelParaLosPuntos);
        panelParaLosPuntos2.setVisible(false);
        letraAleatoria();
    }

    //coloca el punto braille de número y también el de letras
    public void colocarPuntosBraille2() {
        panelParaLosPuntos2.colocarelSetbounds(20, 80);
        panelParaLosPuntos2.setVisible(true);
        add(panelParaLosPuntos2);
        numeroAleatorio();
        repaint();
    }

    //Colocar en cada posicion los el titulo, la letra, los botones
    public void interfaz() {
        texto.setBounds(10, 10, 350, 70);
        texto.setHorizontalAlignment(SwingConstants.CENTER);
        texto.setForeground(Color.WHITE);
        texto.setFont(new Font("Arial Black", Font.BOLD, 12));
        add(texto);

        letra.setBounds(300, 100, 100, 100);
        letra.setOpaque(true);
        letra.setBackground(Color.RED);
        letra.setFont(new Font("Arial Black", Font.BOLD, 30));
        letra.setHorizontalAlignment(SwingConstants.CENTER);
        letra.setForeground(Color.WHITE);
        add(letra);


        btnVerificar.setBackground(Color.CYAN);
        btnVerificar.setBounds(300, 300, 150, 30);
        btnVerificar.setFont(new Font("Arial Black", Font.BOLD, 20));
        btnVerificar.setMargin(new Insets(0, 0, 0, 0));
        add(btnVerificar);

        btnCambiar.setBackground(Color.CYAN);
        btnCambiar.setBounds(300, 350, 150, 30);
        btnCambiar.setFont(new Font("Arial Black", Font.BOLD, 20));
        btnCambiar.setMargin(new Insets(0, 0, 0, 0));
        add(btnCambiar);

        add(puntaje_jugador);
    }

    // se va a la clase letra y se va al método letraAleatoria, y muestra la letra aleatoria
    public void letraAleatoria() {
        letra.setText(letra_implementada.letraAleatoria());
    }

    // se va a la clase Numeros y se va al método númeroAleatorio, y muestra el número aleatorio
    public void numeroAleatorio() {
        letra.setText(numero.numeros_aleatorios());
    }

    //mostrar la siguiente letra y aumenta un puntaje
    public void pasarSiguiente() {
        JOptionPane.showMessageDialog(null, "FELICIDADES");
        letraAleatoria();
        puntaje_jugador.aumentoPuntaje();
    }

    //mostrar el siguiente numero y aumenta un puntaje
    public void pasarSiguiente(int x) {
        JOptionPane.showMessageDialog(null, "FELICIDADES");
        numeroAleatorio();
        puntaje_jugador.aumentoPuntaje();
    }

    //concatena el texto de los jLabels si es que están pintados de rojo
    public String la_clave() {
        String clave = "";
        for (int i = 0; i < panelParaLosPuntos.getArray_labels().length; i++) {//0 - 6
            if (panelParaLosPuntos.getArray_labels()[i].getBackground() == Color.RED) {
                clave += panelParaLosPuntos.getArray_labels()[i].getText();
            }
        }
        return clave;
    }

    //verifica la letra
    public void verificar() {
        try{
            String esVerdadero = letra_implementada1.verificar(la_clave());//135
            if (esVerdadero.equals(letra.getText())) {
                pasarSiguiente();
            }
        }catch(Exception e){

        }
    }

    //verifica el número
    public void verificar1() {
        try{
            String esVerdadero = numero1.verificar(la_clave());
            if (esVerdadero.equals(letra.getText())) {
                pasarSiguiente(1);
            }
        }catch(Exception ex){

        }
    }
}
