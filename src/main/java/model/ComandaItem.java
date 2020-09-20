package model;

import interfaces.ListagemAdicional;
import interfaces.ListagemMaqueada;
import interfaces.ListagemParcial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Modelo de relacionamento de item x comanda
 * @author Ruan
 */
@Entity
@Table(name = "tbcomandaitem")
public class ComandaItem implements ListagemParcial, Serializable, ListagemAdicional, ListagemMaqueada {
    
    @Id
    @ManyToOne
    private Item    item;
    @Id
    @ManyToOne
    private Comanda comanda;
    private int     quantidade;
    
    public ComandaItem() {
    }

    public ComandaItem(Item item, Comanda comanda, int quantidade) {
        this.item = item;
        this.comanda = comanda;
        this.quantidade = quantidade;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Comanda getComanda() {
        return comanda;
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public float getValorItem() {
        return this.getQuantidade() * this.getItem().getValor();
    }

    @Override
    public String toString() {
        return "ComandaItem: Item: " + item + ", Comanda: " + comanda + ", Quantidade: " + quantidade;
    }

    @Override
    public ArrayList<String> getCamposIgnorar() {
        ArrayList<String> campos = new ArrayList<>();
        campos.add("comanda");
        return campos;
    }

    @Override
    public ArrayList<String> getCamposAdicionar() {
        ArrayList<String> campos = new ArrayList<>();
        campos.add("valorItem");
        return campos;
    }

    @Override
    public HashMap<String, String> getTitulosColunas() {
        HashMap<String, String> titulos = new HashMap<>();
        titulos.put("valorItem", "Valor");
        return titulos;
    }
       
}