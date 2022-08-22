package logica;

import grafica.PanelDePuntosLabel;
import grafica.VentanaDeAhorcado;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class Nivel03 extends JPanel {

    //declaracion de label letra
    private PanelDePuntosLabel los_Label = new PanelDePuntosLabel();
    //declaracion de palabra escondida con guiones bajos _ _ _ _ _ _ _ _ _
    private JLabel palabra = new JLabel();
    //palabra completa del palabra.txt
    private String palabraCompleta;
    //boton verificar para añadir letra
    private JButton btnVerificar = new JButton("VERIFICAR");
    //declaracion de la ventana para el ahorcado
    private VentanaDeAhorcado ahorcado = new VentanaDeAhorcado();
    //declaracion del objeto letra para las claves
    private Letras letra = new Letras(1);

    public Nivel03() {
        setLayout(null);
        setBackground(Color.gray);

        btnVerificar.addActionListener(e -> {
            mandar_letra();
        });
        colocar_labels();
        colocar_palabra();
        colocar_verificacion();
    }

    //lo pondra al medio el label de letra
    public void colocar_labels() {
        los_Label.colocarelSetbounds(160, 75);
        add(los_Label);
    }
    //lo colocara arriba de los label
    public void colocar_palabra() {
        palabra.setBounds(90, 10, 300, 50);
        palabra.setFont(new Font("Arial Black", Font.BOLD, 20));
        palabra.setForeground(Color.WHITE);
        palabra.setHorizontalAlignment(SwingConstants.CENTER);
        add(palabra);
    }

    //ubicacion del boton verificar
    public void colocar_verificacion() {
        btnVerificar.setBounds(300, 300, 100, 60);
        add(btnVerificar);
    }

    //concatenara la clave de los label color rojo
    public String clave() {
        String clave = "";
        for (int i = 0; i < los_Label.getArray_labels().length; i++) {
            if (los_Label.getArray_labels()[i].getBackground() == Color.RED) {
                clave += los_Label.getArray_labels()[i].getText();
            }
        }
        return clave;
    }

    //manda la letra que representa los label seleccionados
    public void mandar_letra() {
        String clave = clave();
        try {
            verificarLetra(letra.verificar(clave));
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "NO EXISTE ESOS PUNTOS");
        }
    }

    //arrayList para ponerlo en una lista las palabras que pusimos en el blog de notas
    ArrayList<String> palabras_txt = new ArrayList<>();
    //metodo leer txt del blog de notas
    public void leer() {
        try {
            almacen.delete(0,almacen.length());//eliminar la palabra del almacen
            ahorcado.reinicio();//comenzara con la cabecita
            lista_letra_repetida.clear();//limpiara la letra repetida para comenzar denuevo
            File file = new File("Palabra.txt");//Buscara el file palabra.txt
            FileReader lector = new FileReader(file);
            BufferedReader buffer = new BufferedReader(lector);
            String texto = buffer.readLine();//leera la primera linea
            while(texto!=null){
                palabras_txt.add(texto);//añadira el texto al arraylist
                texto=buffer.readLine();//leera la siguiente linea
            }
            String visual = "";
            palabraCompleta = elegir_Palabratxt();//eligira cualquier palabra del blog de notas
            for (int i = 0; i < palabraCompleta.length(); i++) {
                almacen = almacen.append("_");//añadira el almacen con guiones bajos
                visual += "_ ";//cosa visual para los guiones
            }
            palabra.setText(visual);//el label de palabra se mostrara asi _ _ _ _ _
            buffer.close();//si o si cerrar
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // palabra aleatoria del blog de notas
    public String elegir_Palabratxt() {
        int aleatorio = (int)(Math.random()*palabras_txt.size());
        return palabras_txt.get(aleatorio);
    }
    //
    String almacenDeString;
    StringBuilder almacen_nuevo = new StringBuilder();
    StringBuilder almacen = new StringBuilder();
    char caracter;
    boolean bien = false;
    ArrayList<String> lista_letra_repetida = new ArrayList<>();

    public void verificarLetra(String letra) {
        for (int i = 0; i < lista_letra_repetida.size(); i++) {
            if(lista_letra_repetida.get(i).equals(letra)){
                ahorcado.setVisible(true);
                ahorcado.seleccionar();
                JOptionPane.showMessageDialog(null, "Ya existe esa letra");
                return;
            }
        }
        for (int i = 1; i < palabraCompleta.length() + 1; i++) {
            boolean existe = false;
            caracter = palabraCompleta.toUpperCase().charAt(i - 1);//b
            almacenDeString = String.valueOf(almacen);
            if (String.valueOf(caracter).equals(letra.toUpperCase())) {
                bien = true;
                if (existe != true) {
                    almacen = almacen.deleteCharAt(i - 1).insert(i - 1, caracter);
                    lista_letra_repetida.add(letra);
                }
            }
            String valor = String.valueOf(almacen);
            almacen_nuevo = almacen_nuevo.delete(0, almacen_nuevo.length());
            almacen_nuevo = almacen_nuevo.append(String.valueOf(almacen).replace("", " "));
            palabra.setText(String.valueOf(almacen_nuevo));
            if (valor.equals(palabraCompleta.toUpperCase())) {
                JOptionPane.showMessageDialog(null, "FELICIDADES GANASTE");
                return;
            }
        }
        if(bien != true){
            ahorcado.setVisible(true);
            ahorcado.seleccionar();
            JOptionPane.showMessageDialog(null, "Te Equivocaste");
        }
        bien = false;
    }
}
