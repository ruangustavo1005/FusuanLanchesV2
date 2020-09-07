package exceptions;

/**
 * Exceção para disparar de métodos não implementados (mas que não precisam de implementação)
 * @author Ruan
 */
public class ExceptionMetodoNaoImplementado extends Exception {

    public ExceptionMetodoNaoImplementado(String metodo, String classe) {
        super("Método "+metodo+" não implementado na classe "+classe+"!");
    }
    
}
