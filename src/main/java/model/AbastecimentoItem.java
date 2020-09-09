package model;

import interfaces.ListagemParcial;
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Modelo de relacionamento soclitação de abastecimento x item
 * @author Ruan
 */
@Entity
@Table(name = "tbabastecimentoitem")
public class AbastecimentoItem implements ListagemParcial, Serializable {
    
    @Id
    @ManyToOne
    private Item                     item;
    @Id
    @ManyToOne
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