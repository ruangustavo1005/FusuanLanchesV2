package interfaces;

import java.util.ArrayList;

/**
 * Inteface para listagens n�o completas de modelos
 * @author Ruan
 */
public interface ListagemParcial {
    
    /**
     * Array com o nome dos atributos que n�o devem se listados pelo TableModel
     */
    public ArrayList<String> getCamposIgnorar();
    
}