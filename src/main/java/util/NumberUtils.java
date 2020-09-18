package util;

/**
 * Classe de funções (in)úteis para trabalhar com números
 * @author Ruan
 */
public class NumberUtils {
    
    public static int parseInt(String s) {
        String replace = s.trim();
        return replace.equals("") ? 0 : Integer.parseInt(replace);
    }
    
    public static float parseFloat(String s) {
        String replace = s.replace(",", ".").trim();
        return (float) (replace.equals("") ? 0.0 : Float.parseFloat(replace));
    }
    
    public static String formataValor(float valor) {
        return formataValor(valor, 2);
    }
    
    public static String formataValor(float valor, int decimais) {
        String retorno = String.valueOf(((int) (valor * (Math.pow(10, decimais)))) / (Math.pow(10, decimais))).replace(".", ",");
        return retorno;
    }
    
}