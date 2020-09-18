package interfaces;

import model.Item;

/**
 *
 * @author Ruan
 */
public interface VerificaUsabilidadeItem {
    
    /**
     * Fun��o que verifica se o item � utilizado por algum relacionamento externo
     * @param item item que ser� procurado
     * @return boolean se o item � utilizado ou n�o
     */
    public boolean usaItem(Item item);
    
}