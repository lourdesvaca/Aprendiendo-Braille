package logica;

import java.util.HashMap;

public class Letras {

    //El hashmap para la letra que utilizaremos solo para el metodo letra aleatorio
    public HashMap<Integer, String> letra = new HashMap<Integer, String>();
    //El hashmap para la letra que utlizaremos para los demas metodos que tiene clave String y valor String
    public HashMap<String, String> letra_verificada = new HashMap<String, String>();

    //Constructor para las letras que se utilizare en letra aleatoria
    public Letras() {
        letra.put(0, "a");
        letra.put(1, "b");
        letra.put(2, "c");
        letra.put(3, "d");
        letra.put(4, "e");
        letra.put(5, "f");
        letra.put(6, "g");
        letra.put(7, "h");
        letra.put(8, "i");
        letra.put(9, "j");
        letra.put(10, "k");
        letra.put(11, "l");
        letra.put(12, "m");
        letra.put(13, "n");
        letra.put(14, "o");
        letra.put(15, "p");
        letra.put(16, "q");
        letra.put(17, "r");
        letra.put(18, "s");
        letra.put(19, "t");
        letra.put(20, "u");
        letra.put(21, "v");
        letra.put(22, "w");
        letra.put(23, "x");
        letra.put(24, "y");
        letra.put(25, "z");
        letra.put(26, "?");
    }

    //Constructor para las letras que se utilizara para verificar letra, mostrar letra, etc
    public Letras(int x) {
        letra_verificada.put("1", "a");//Key - valor
        letra_verificada.put("12", "b");//Key - valor
        letra_verificada.put("14", "c");
        letra_verificada.put("145", "d");
        letra_verificada.put("15", "e");
        letra_verificada.put("124", "f");
        letra_verificada.put("1245", "g");
        letra_verificada.put("125", "h");
        letra_verificada.put("24", "i");
        letra_verificada.put("245", "j");
        letra_verificada.put("13", "k");
        letra_verificada.put("123", "l");
        letra_verificada.put("134", "m");
        letra_verificada.put("1345", "n");
        letra_verificada.put("135", "o");
        letra_verificada.put("1234", "p");
        letra_verificada.put("12345", "q");
        letra_verificada.put("1235", "r");
        letra_verificada.put("234", "s");
        letra_verificada.put("2345", "t");
        letra_verificada.put("136", "u");
        letra_verificada.put("1236", "v");
        letra_verificada.put("2456", "w");
        letra_verificada.put("1346", "x");
        letra_verificada.put("13456", "y");
        letra_verificada.put("1356", "z");
        letra_verificada.put("26", "?");

    }


    //verificara si la letra que pasaron en el paramentro es la clave que tenemos en el segundo constructor
    public String verificar(String letra) {
        /*String clave = letra_verificada.get("clave");
        return clave == null ? "" : clave;*/
        return letra_verificada.get(letra);
    }

    //metodo que retornara un boolean si la letra es igual a la clave que tenemos en el segundo constructor
    public boolean esVerdadero(String clave){//1
        for (String letra: letra_verificada.keySet()) {
            if(letra.equals(clave)){
                return false;
            }
        }
        return true;
    }

    //metodo que retornara un String para mostrar cualquier letra con la ayuda de Math random
    public String letraAleatoria() {
        return letra.get((int) (Math.random() * 27));
    }

}
