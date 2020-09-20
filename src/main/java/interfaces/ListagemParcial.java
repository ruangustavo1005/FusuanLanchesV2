package interfaces;

import java.util.ArrayList;

/**
 * Inteface para listagens não completas de modelos
 * @author Ruan
 */
public interface ListagemParcial {
    
    /**
     * Array com o nome dos atributos que não devem se listados pelo TableModel
     */
    public ArrayList<String> getCamposIgnorar();
    
}