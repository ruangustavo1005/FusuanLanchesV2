package exceptions;

/**
 * Exce��o para disparar de métodos n�o implementados (mas que n�� precisam de implementaç�)
 * @author Ruan
 */
public class ExceptionMetodoNaoImplementado extends Exception {

    public ExceptionMetodoNaoImplementado(String metodo, String classe) {
        super("Método "+metodo+" n�o implementado na classe "+classe+"!");
    }
    
}
