package model;

import interfaces.ListagemParcial;
import java.util.ArrayList;

/**
 * Modelo de relacionamento soclitação de abastecimento x item
 * @author Ruan
 */
public class AbastecimentoItem implements ListagemParcial {
    
    private Item                     item;
    private SolicitacaoAbastecimento solicitacaoAbastecimento;
    private int                      quantidade;

    public AbastecimentoItem() {
        
    }

    public AbastecimentoItem(Item item, SolicitacaoAbastecimento solicitacaoAbastecimento, int quantidade) {
        this.item = item;
        this.solicitacaoAbastecimento = solicitacaoAbastecimento;
        this.quantidade = quantidade;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public SolicitacaoAbastecimento getSolicitacaoAbastecimento() {
        return solicitacaoAbastecimento;
    }

    public void setSolicitacaoAbastecimento(SolicitacaoAbastecimento solicitacaoAbastecimento) {
        this.solicitacaoAbastecimento = solicitacaoAbastecimento;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return quantidade + " " + item;
    }

    @Override
    public ArrayList<String> getCamposIgnorar() {
        ArrayList<String> camposIgnorar = new ArrayList<>();
        camposIgnorar.add("solicitacaoAbastecimento");
        return camposIgnorar;
    }

}