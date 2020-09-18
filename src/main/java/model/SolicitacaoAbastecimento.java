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
 * Modelo de uma solicitação de abastecimento dos suprimentos à um fornecedor
 * @author Ruan
 */
@Entity
@Table(name = "tbsolicitacaoabastecimento")
public class SolicitacaoAbastecimento implements ListagemParcial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int                     numero;
    @ManyToOne
    private Gerente                 gerente;
    @ManyToOne
    private Fornecedor              fornecedor;
    @OneToMany(mappedBy = "solicitacaoAbastecimento", cascade = CascadeType.ALL)
    private List<AbastecimentoItem> itens;
    private String                  data;
    private String                  dataLimite;
    private String                  situacao;
    
    public SolicitacaoAbastecimento() {
        this.gerente    = new Gerente();
        this.fornecedor = new Fornecedor();
        this.itens      = new ArrayList<>();
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

    public List<AbastecimentoItem> getItens() {
        return itens;
    }

    public void setItens(List<AbastecimentoItem> itens) {
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

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
    public boolean isSituacaoAberta() {
        return this.getSituacao().equalsIgnoreCase("Aberta");
    }
    
    public boolean isSituacaoAtendida() {
        return this.getSituacao().equalsIgnoreCase("Atendida");
    }
    
    public boolean isSituacaoVencida() {
        return this.getSituacao().equalsIgnoreCase("Vencida");
    }
    
    public boolean isSituacaoCancelada() {
        return this.getSituacao().equalsIgnoreCase("Cancelada");
    }
    
    public static List<String> getListaSituacoes() {
        ArrayList<String> situacoes = new ArrayList<>();
        situacoes.add("Aberta");
        situacoes.add("Atendida");
        situacoes.add("Vencida");
        situacoes.add("Cancelada");
        return situacoes;
    }

    @Override
    public String toString() {
        return numero + " - " + fornecedor + "(" + data + " - " + dataLimite + ", " + situacao + ")";
    }

    @Override
    public ArrayList<String> getCamposIgnorar() {
        ArrayList<String> campos = new ArrayList<>();
        campos.add("itens");
        return campos;
    }
    
}