package interfaces;

import java.util.ArrayList;
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
    public ArrayList<String> getCamposAdicionar();
    
}