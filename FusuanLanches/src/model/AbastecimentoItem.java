package model;

/**
 * Modelo de relacionamento soclitação de abastecimento x item
 * @author Ruan
 */
public class AbastecimentoItem {
    
    private Item    item;
    private Comanda comanda;
    private int     quantidade;

    public AbastecimentoItem() {
        
    }

    public AbastecimentoItem(Item item, Comanda comanda, int quantidade) {
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

    @Override
    public String toString() {
        return "Abastecimento x Item: " + "Item: " + item + ", Comanda: " + comanda + ", Quantidade: " + quantidade;
    }
}
