package model;

import interfaces.ListagemParcial;
import java.util.ArrayList;

/**
 * Modelo de relacionamento de item x comanda
 * @author Ruan
 */
public class ComandaItem implements ListagemParcial {
    
    private Item    item;
    private Comanda comanda;
    private int     quantidade;
    
    /**
     * Cada item da comanda vai ter seu valor por que podem ser adicioandos descontos na hora da venda.
     * O valor do item que é salvo nele é apenas o valor base pra este.
     */
//    private float   valor;

    public ComandaItem() {
    }

    public ComandaItem(Item item, Comanda comanda, int quantidade/*, float valor*/) {
        this.item = item;
        this.comanda = comanda;
        this.quantidade = quantidade;
//        this.valor = valor;
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

//    public float getValor() {
//        return valor;
//    }
//
//    public void setValor(float valor) {
//        this.valor = valor;
//    }

    @Override
    public String toString() {
        return "ComandaItem: Item: " + item + ", Comanda: " + comanda + ", Quantidade: " + quantidade/* + ", Valor: " + valor*/;
    }

    @Override
    public ArrayList<String> getCamposIgnorar() {
        ArrayList<String> campos = new ArrayList<>();
        campos.add("comanda");
        return campos;
    }
       
}