package model;

import java.util.ArrayList;

/**
 * Modelo de comanda
 * @author Ruan
 */
public class Comanda {
    
    private int                    numero;
    private Atendente              atendente;
    private Cliente                cliente;
    private ArrayList<ComandaItem> itens;
    private String                 data;
    private int                    mesa;

    public Comanda() {
    
    }

    public Comanda(int numero, Atendente atendente, Cliente cliente, ArrayList<ComandaItem> itens, String data, int mesa) {
        this.numero = numero;
        this.atendente = atendente;
        this.cliente = cliente;
        this.itens = itens;
        this.data = data;
        this.mesa = mesa;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Atendente getAtendente() {
        return atendente;
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<ComandaItem>getItens() {
        return itens;
    }

    public void setItens(ArrayList<ComandaItem> itens) {
        this.itens = itens;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    @Override
    public String toString() {
        String retorno = "Comanda: Numero: " + numero + ", Atendente: " + atendente + ", Cliente: " + cliente + ", Data: " + data + ", Mesa:" + mesa;

        for (ComandaItem comandaItem : this.getItens()) {
            retorno += '\n' + comandaItem.toString();
        }
        
        return retorno;
    }
    
    
    
}
