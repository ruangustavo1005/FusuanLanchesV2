package model;

import java.util.ArrayList;

/**
 * Modelo de uma solicitação de abastecimento dos suprimentos à um fornecedor
 * @author Ruan
 */
public class SolicitacaoAbastecimento {

    private int                          numero;
    private Gerente                      gerente;
    private Fornecedor                   fornecedor;
    private ArrayList<AbastecimentoItem> itens;
    private String                       data;
    private String                       dataLimite;
    
    public SolicitacaoAbastecimento() {
        
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public ArrayList<AbastecimentoItem> getItens() {
        return itens;
    }

    public void setItens(ArrayList<AbastecimentoItem> itens) {
        this.itens = itens;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(String dataLimite) {
        this.dataLimite = dataLimite;
    }

    @Override
    public String toString() {
        String retorno = "Solicitacao de Abastecimento: Numero: " + numero + ", Gerente: " + gerente + ", Fornecedor: " + fornecedor + ", Data: " + data + ", Data Limite: " + dataLimite;
        
        for (AbastecimentoItem abastecimentoItem : this.getItens()) {
            retorno += '\n' + abastecimentoItem.toString();
        }
        
        return retorno;
    }
    
}
