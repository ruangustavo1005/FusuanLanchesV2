package interfaces;

import java.util.List;
import model.ComandaItem;

/**
 *
 * @author Ruan
 */
public interface ListagemAdicional {
    
    /**
     * Array com o nome dos métodos que demonstrarão dados adicionais na consulta
     * @see ComandaItem
     */
    public List<String> getCamposAdicionar();
    
}