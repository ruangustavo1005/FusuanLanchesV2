package interfaces;

import java.util.HashMap;

/**
 * Interface para listagens com t�tulos n�o din�micos, utilizada para "maquear" os dados
 * @author Ruan
 */
public interface ListagemMaqueada {
    
    /**
     * Map na estrutura ["nomeDoAtributo" => "Novo T�tulo"]
     * Trata os campos adicionais que forem trazidos pela interface ListagemAdicional
     * @see ListagemAdicional
     */
    public HashMap<String, String> getTitulosColunas();
    
}