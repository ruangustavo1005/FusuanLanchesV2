package model;

import interfaces.ListagemAdicional;
import interfaces.ListagemParcial;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Modelo de comanda
 * @author Ruan
 */
@Entity
@Table(name = "tbcomanda")
public class Comanda implements ListagemParcial, ListagemAdicional, Comparator<Comanda> {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int                    numero;
    @ManyToOne
    private Atendente              atendente;
    @ManyToOne
    private Cliente                cliente;
    @OneToMany(mappedBy = "comanda", cascade = CascadeType.ALL)
    private List<ComandaItem> itens;
    private String                 data;
    private int                    mesa;
    private boolean                aberto;

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

    public List<ComandaItem>getItens() {
        return itens;
    }

    public void setItens(List<ComandaItem> itens) {
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

    public boolean getAberto() {
        return aberto;
    }

    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }
    
    public void fecha() {
        this.setAberto(false);
    }
    
    @Override
    public String toString() {
        return numero + "";
    }
 
    public float getValorFinal() {
        float valor = 0;    
        for (ComandaItem item : this.getItens()) {
            valor += item.getQuantidade() * item.getItem().getValor();
        }
        return valor;
    }
    
    static public float getValorFinal(List<ComandaItem> itens) {
        Comanda comanda = new Comanda();
        comanda.setItens(itens);
        float valor = comanda.getValorFinal();
        return valor;
    }
    
    @Override
    public ArrayList<String> getCamposIgnorar() {
        ArrayList<String> campos = new ArrayList<>();
        campos.add("aberto");
        campos.add("itens");
        return campos;
    }

    @Override
    public ArrayList<String> getCamposAdicionar() {
        ArrayList<String> campos = new ArrayList<>();
        campos.add("valorFinal");
        return campos;
    }

    @Override
    public int compare(Comanda c1, Comanda c2) {
        if(c2.getNumero() > c1.getNumero()) {
            return 1;
        } else if(c2.getNumero() < c1.getNumero()) {
            return -1;
        }
        return 0;
    }
    
}