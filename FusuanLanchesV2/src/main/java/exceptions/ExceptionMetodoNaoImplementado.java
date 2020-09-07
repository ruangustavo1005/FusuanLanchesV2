package exceptions;

/**
 * ExceÁ„o para disparar de m√©todos n„o implementados (mas que n√„ precisam de implementa√ßÁ)
 * @author Ruan
 */
public class ExceptionMetodoNaoImplementado extends Exception {

    public ExceptionMetodoNaoImplementado(String metodo, String classe) {
        super("M√©todo "+metodo+" n„o implementado na classe "+classe+"!");
    }
    
}
