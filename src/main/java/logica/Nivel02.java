package logica;

import grafica.PanelDePuntosLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Nivel02 extends JPanel {

    // Declaracion del Panel de Puntos label (6) que se puede interactuar (cambiar color)
    private PanelDePuntosLabel panel_braille_letra = new PanelDePuntosLabel();
    // Declaracion del Panel de Puntos label (6) que no se puede interactuar (no se cambia el color) esta predefinido
    private PanelDePuntosLabel panel_braille_numero = new PanelDePuntosLabel(1);

    //Declaración del textField para que el usuario ingrese una letra
    private JTextField letra_usuario = new JTextField();

    //Declaracion del objeto de puntos del usuario
    private PanelDePuntaje puntaje = new PanelDePuntaje();

    private JButton btnCambiar = new JButton("Cambio");

    private int x = 0;

    private Letras letra1 = new Letras(1);
    private Numeros numero1 = new Numeros(1);

    public Nivel02() {
        setLayout(null);
        setBackground(Color.gray);

        letra_usuario.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (x != 0) {// 0 es diferente de 0 es false son iguales se va al else
                        verificar_Numeros();
                    } else {
                        verificar_letraUsuario();
                    }
                }
            }
        });

        btnCambiar.addActionListener(e -> {
            if (x == 0) {//0 == 0 es correcto se viene al if y sumara 1 al x
                colocar_jlabelNumeros();
                verificacion_de_colores_numeros();//verificara el color correcto si es que esta en la libreria
                panel_braille_numero.setVisible(true);
                x++;
            } else {
                panel_braille_numero.setVisible(false);
                x = 0;
            }
        });

        colocarPuntajes();
        initComponents();
    }

    //colocar el panel puntaje en el panel nivel2
    public void colocarPuntajes() {
        add(puntaje);
    }

    //colocar en el panel nivel2 el braille numeros
    public void colocar_jlabelNumeros() {
        panel_braille_numero.colocarelSetbounds(80, 60);
        add(panel_braille_numero);
        repaint();
    }

    //ubicacion del braille, ubicacion de la letra del usuario y la ubicacion del boton cambiar
    public void initComponents() {
        panel_braille_letra.colocarelSetbounds(200, 60);
        add(panel_braille_letra);
        cambiarColoryVerificar();

        letra_usuario.setBounds(200, 300, 50, 50);
        letra_usuario.setFont(new Font("Arial Black", 1, 30));
        add(letra_usuario);

        btnCambiar.setBounds(300, 300, 80, 50);
        add(btnCambiar);
    }

    //metodo para cambiar el color y verificara si esta en la libreria para el braille letras
    public void cambiarColoryVerificar2() {
        panel_braille_letra.colores_Aleatorios();
        verificacion_de_colores_numeros();
    }

    //metodo para cambiar el color y verificara si esta en la libreria  para el braille numeros
    public void cambiarColoryVerificar() {
        panel_braille_letra.colores_Aleatorios();
        verificacion_Colores_letras();
    }

    //concatenar los texto que tienen cada jlabel de color rojo
    public String la_clave() {
        String clave = "";
        for (int i = 0; i < panel_braille_letra.getArray_labels().length; i++) {
            if (panel_braille_letra.getArray_labels()[i].getBackground() == Color.RED) {
                clave += panel_braille_letra.getArray_labels()[i].getText();
            }
        }
        return clave;
    }

    //verificara si la clave que mostro de color rojo es correcto
    public void verificacion_Colores_letras(){
        String key = la_clave();
        if(letra1.esVerdadero(key)){
            System.err.println("Entro al if se cambiara el color y verificara");
            cambiarColoryVerificar();
        }else {
            System.out.println("El color es correcto ya que esta en la libreria");
        }
    }

    //verificara si la clave que mostro de color rojo es correcto (numeros)
    public void verificacion_de_colores_numeros() {
        String key = la_clave();
        if(numero1.esVerdadero(key)){
            System.err.println("Entro al if se cambiara el color y verificara");
            cambiarColoryVerificar2();
        }else {
            System.out.println("El color es correcto ya que esta en la libreria");
        }
    }

    //aumentara el puntaje
    public void aumentoPuntaje() {
        JOptionPane.showMessageDialog(null, "Felicidades");
        if (x != 0) {
            verificacion_de_colores_numeros();
        } else {
            cambiarColoryVerificar();
        }
        puntaje.aumentoPuntaje();
    }


    // verificara si la letra que puso el usuario es igual a la clave que dio el color rojo (letra)
    public void verificar_letraUsuario() {
        String esVerdadero = letra1.verificar(la_clave());
        if (esVerdadero.equals(letra_usuario.getText())) {
            aumentoPuntaje();
        }
    }
    // verificara si la letra que puso el usuario es igual a la clave que dio el color rojo (#)
    public void verificar_Numeros() {
        String esVerdadero = numero1.verificar(la_clave());
        if (esVerdadero.equals(letra_usuario.getText())) {
            aumentoPuntaje();
            panel_braille_letra.colores_Aleatorios();
            verificacion_de_colores_numeros();
        }
    }
}