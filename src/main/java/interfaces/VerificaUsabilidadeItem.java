package interfaces;

import model.Item;

/**
 *
 * @author Ruan
 */
public interface VerificaUsabilidadeItem {
    
    /**
     * Função que verifica se o item é utilizado por algum relacionamento externo
     * @param item item que será procurado
     * @return boolean se o item é utilizado ou não
     */
    public boolean usaItem(Item item);
    
}