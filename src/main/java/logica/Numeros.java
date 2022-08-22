package logica;

import java.util.HashMap;

public class Numeros {
    //El hashmap para el numero que utilizaremos solo para el metodo numero aleatorio
    public HashMap<Integer,String> numeros = new HashMap<Integer,String>();
    //El hashmap para el numero que utlizaremos para los demas metodos que tiene clave String y valor String
    public HashMap<String,String> numeros_verificados = new HashMap<String,String>();

    //Contructor para el numero que se utilizara en numero aleatorio
    public Numeros(){
        numeros.put(0,"0");
        numeros.put(1,"1");
        numeros.put(2,"2");
        numeros.put(3,"3");
        numeros.put(4,"4");
        numeros.put(5,"5");
        numeros.put(6,"6");
        numeros.put(7,"7");
        numeros.put(8,"8");
        numeros.put(9,"9");
    }

    //Constructor para los numeros que se utilizara para verificar numero, mostrar numero, etc
    public Numeros(int x){
        numeros_verificados.put("245","0");
        numeros_verificados.put("1","1");
        numeros_verificados.put("12","2");
        numeros_verificados.put("14","3");
        numeros_verificados.put("145","4");
        numeros_verificados.put("15","5");
        numeros_verificados.put("124","6");
        numeros_verificados.put("1245","7");
        numeros_verificados.put("125","8");
        numeros_verificados.put("24","9");
    }

    //verificara si el numero que pasaron en el paramentro es la clave que tenemos en el segundo constructor
    public String verificar(String numero){
        return numeros_verificados.get(numero);
    }

    //metodo que retornara un boolean si el numero es igual a la clave que tenemos en el segundo constructor
    public boolean esVerdadero(String clave){//1
        for (String numero: numeros_verificados.keySet()) {
            if(numero.equals(clave)){
                return false;
            }
        }
        return true;
    }

    //metodo que retornara un String para mostrar cualquier numero con la ayuda de Math random
    public String numeros_aleatorios(){
        return numeros.get((int)(Math.random()*10));
    }
}
