package grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame {

    private JLabel lblFondo = new JLabel();
    private JLabel lblUsuario = new JLabel();

    private JButton btnSalir = new JButton("Salir");
    private JButton btnIniciar = new JButton("Iniciar");

    // carga la venta inicial junto con los botones con sus funcionalidades
    public Ventana (){
        setTitle("Proyecto Braille");
        setSize(400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setUndecorated(false);//Para desaparecer los botones minimizar, maximizar y cerrar
        setResizable(false);

        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ventana2 v = new Ventana2();
                v.setLocationRelativeTo(null);
                v.setVisible(true);
            }
        });

        iniciarComponentes();
        setVisible(true);
    }

    //cargan el fondo, la ubicacion de los botones y la foto del usuario
    public void iniciarComponentes() {
        addFondoUsuario();
        agregarBotones();
        addFondo();
    }

    //la ubicacion de los botones
    public void agregarBotones() {
        int x = 130;
        int y = 200;

        btnIniciar.setBounds(x,y,150,50);
        btnIniciar.setBackground(Color.GREEN);
        btnIniciar.setMargin(new Insets(0,0,0,0));
        btnIniciar.setFont(new Font("Arial Black",1,20));

        btnSalir.setBounds(x,y+80,150,50);
        btnSalir.setBackground(Color.RED);
        btnSalir.setMargin(new Insets(0,0,0,0));
        btnSalir.setFont(new Font("Arial Black",1,20));

        add(btnIniciar);
        add(btnSalir);
    }

    //cargan el fondo
    public void addFondo() {
        ImageIcon imagencito = new ImageIcon("Imagenes/Fondo.jpg");
        lblFondo.setBounds(0, 0, this.getWidth(), this.getHeight());
        lblFondo.setIcon(new ImageIcon(imagencito.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_SMOOTH)));
        add(lblFondo);
    }

    //foto del usuario
    public void addFondoUsuario(){
        ImageIcon usuario = new ImageIcon("Imagenes/Usuario.png");
        lblUsuario.setBounds(155,60, 100,100);
        lblUsuario.setIcon(new ImageIcon(usuario.getImage().getScaledInstance(lblUsuario.getWidth(), lblUsuario.getHeight(), Image.SCALE_SMOOTH)));
        add(lblUsuario);
    }

    //el metodo principal
    public static void main(String[] args) {
        Ventana miVentana = new Ventana();
    }
}
