package grafica;

import logica.Nivel01;
import logica.Nivel02;
import logica.Nivel03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Ventana2 extends JFrame implements ActionListener{

    private JButton btnNivel1 = new JButton("Nivel 1");
    private JButton btnNivel2 = new JButton("Nivel 2");
    private JButton btnNivel3 = new JButton("Nivel 3");
    private JButton btnTutorial = new JButton("Tutorial");
    private JButton btnLibreria = new JButton("Libreria");
    private JButton btnatrasLibreria = new JButton();
    private JButton btnatrasNivel1 = new JButton();
    private JButton btnatrasNivel2 = new JButton();
    private JButton btnatrasNivel3 = new JButton();

    private JButton[] botonesNiveles = new JButton[3];
    private JButton[] botonesExtra = new JButton[2];

    // declaracion de objetos de los paneles
    private PanelNorte panelNorth = new PanelNorte();
    private PanelCentro panelCenter = new PanelCentro();
    private PanelLibrero panellibreria = new PanelLibrero();

    // declaracion de objetos de las clases Niveles del 1 al 3
    private Nivel01 nivel1 = new Nivel01();
    private Nivel02 nivel2 = new Nivel02();
    private Nivel03 nivel3 = new Nivel03();

    //Carga la ventana opciones
    public Ventana2() {
        setTitle("Braille");
        setSize(500, 500);
        //agrupa en un vector de Jbutton los botones niveles
        botonesNiveles[0] = btnNivel1;
        botonesNiveles[1] = btnNivel2;
        botonesNiveles[2] = btnNivel3;
        //agrupa en un vector de Jbutton los botones tutorial y libreria
        botonesExtra[0] = btnTutorial;
        botonesExtra[1] = btnLibreria;

        btnLibreria.addActionListener(this);
        btnatrasLibreria.addActionListener(this);
        btnatrasNivel1.addActionListener(this);
        btnatrasNivel2.addActionListener(this);
        btnatrasNivel3.addActionListener(this);
        btnTutorial.addActionListener(this);
        btnNivel1.addActionListener(this);
        btnNivel2.addActionListener(this);
        btnNivel3.addActionListener(this);

        iniciarComponentes();

        addPosiciones();//Primero se carga los botones
        panelCenter.imagenFondo();//Luego el fondo
    }

    //Carga en la ventana los paneles norte y el centro
    public void iniciarComponentes() {
        panelNorth.setPreferredSize(new Dimension(60, 60));
        add(panelNorth, BorderLayout.NORTH);
        add(panelCenter, BorderLayout.CENTER);
    }

    //Se colocan las posiciones de los botones en el panel centro
    private void addPosiciones() {
        int x = 30;
        int y = 100;
        for (int i = 0; i < botonesNiveles.length; i++) {
            botonesNiveles[i].setBounds(x, y, 120, 80);
            y += 100;
            panelCenter.add(botonesNiveles[i]);
        }

        int equis = 330;
        int ye = 100;
        for (int i = 0; i < botonesExtra.length; i++) {
            botonesExtra[i].setBounds(equis, ye, 120, 80);
            ye += 100;
            panelCenter.add(botonesExtra[i]);
        }
    }

    //ubicacion de un boton en el panel libreria
    public void colocarBotonAtras() {
        ImageIcon imagen = new ImageIcon("Imagenes/flechaAtras.png");
        btnatrasLibreria.setBounds(10, 10, 30, 30);
        btnatrasLibreria.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(btnatrasLibreria.getWidth(), btnatrasLibreria.getHeight(), Image.SCALE_SMOOTH)));
        btnatrasLibreria.setBorderPainted(false);//desaparecer el borde del boton
        btnatrasLibreria.setContentAreaFilled(false);//desaparecer el fondo del boton
        panellibreria.add(btnatrasLibreria);
    }

    //ubicacion de un boton en el panel nivel1
    public void colocarBotonAtras1() {
        btnatrasNivel1.setBounds(300, 250, 150, 30);
        btnatrasNivel1.setText("SALIR");
        btnatrasNivel1.setFont(new Font("Arial Black",1,20));
        nivel1.add(btnatrasNivel1);
    }

    //ubicacion de un boton en el panel nivel2
    public void colocarBotonAtras2() {
        btnatrasNivel2.setBounds(10, 10, 80, 30);
        btnatrasNivel2.setText("Menu Principal");
        btnatrasNivel2.setFont(new Font("Arial Black",1,8));
        btnatrasNivel2.setMargin(new Insets(0,0,0,0));
        nivel2.add(btnatrasNivel2);
    }

    //ubicacion de un boton en el panel nivel3
    public void colocarBotonAtras3() {
        btnatrasNivel3.setBounds(25, 300, 100, 60);
        btnatrasNivel3.setText("Menu Principal");
        btnatrasNivel3.setFont(new Font("Arial Black",1,8));
        btnatrasNivel3.setMargin(new Insets(0,0,0,0));
        nivel3.add(btnatrasNivel3);
    }

    //Visibiliza el panel librero con la ayuda del boton libreria
    public void visibilizarPanelLibrero() {
        panelNorth.setVisible(false);
        panelCenter.setVisible(false);
        panellibreria.setVisible(true);
        this.getContentPane().add(panellibreria);
        colocarBotonAtras();
    }

    //Visibiliza el panel opciones con la ayuda del boton atras tanto en el nivel 1,2,3
    public void visibilizarPanelPrincipal() {
        panellibreria.setVisible(false);
        panelNorth.setVisible(true);
        panelCenter.setVisible(true);
        nivel1.setVisible(false);
        nivel2.setVisible(false);
        nivel3.setVisible(false);
    }

    //Visibiliza el panel del nivel1 con la ayuda del boton nivel 1
    public void visibilizarElNivel1(){
        panelNorth.setVisible(false);
        panelCenter.setVisible(false);
        panellibreria.setVisible(false);
        nivel1.setVisible(true);
        nivel1.letraAleatoria();
        colocarBotonAtras1();
        add(nivel1);////Reemplaza lo anterior con este nivel en la ventana opciones
    }

    //Visibiliza el panel del nivel2 con la ayuda del boton nivel 2
    public void visibilizarElNivel2(){
        panelNorth.setVisible(false);
        panelCenter.setVisible(false);
        panellibreria.setVisible(false);
        nivel1.setVisible(false);
        nivel2.setVisible(true);
        colocarBotonAtras2();
        add(nivel2);////Reemplaza lo anterior con este nivel en la ventana opciones
    }

    //Visibiliza el panel del nivel3 con la ayuda del boton nivel 3
    public void visibilizarElNivel3(){
        panelNorth.setVisible(false);
        panelCenter.setVisible(false);
        panellibreria.setVisible(false);
        nivel1.setVisible(false);
        nivel2.setVisible(false);
        nivel3.setVisible(true);
        nivel3.leer();
        colocarBotonAtras3();
        add(nivel3);//Reemplaza lo anterior con este nivel en la ventana opciones
    }

    //metodo para irse a ver el video en youtube
    public void mostrarEnlace() {
        try {
            Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=m9KFEv-9vzc"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    //Oyente de acciones de cada boton
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLibreria) {
            visibilizarPanelLibrero();
        }
        if (e.getSource() == btnatrasLibreria) {
            visibilizarPanelPrincipal();
        }
        if (e.getSource() == btnTutorial) {
            mostrarEnlace();
        }
        if(e.getSource() == btnNivel1){
            visibilizarElNivel1();
        }
        if(e.getSource() == btnNivel2){
            visibilizarElNivel2();
        }
        if(e.getSource() == btnNivel3){
            visibilizarElNivel3();
        }
        if(e.getSource() == btnatrasNivel1){
            visibilizarPanelPrincipal();
        }
        if(e.getSource() == btnatrasNivel2){
            visibilizarPanelPrincipal();
        }
        if(e.getSource() == btnatrasNivel3){
            visibilizarPanelPrincipal();
        }
    }
}
