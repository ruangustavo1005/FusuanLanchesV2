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
    
}