package model;

import interfaces.ListagemParcial;
import java.util.ArrayList;
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
public class Comanda implements ListagemParcial {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    
    @Override
    public ArrayList<String> getCamposIgnorar() {
        ArrayList<String> campos = new ArrayList<>();
        campos.add("aberto");
        campos.add("itens");
        return campos;
    }
    
}