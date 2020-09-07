package model;

import interfaces.ListagemParcial;
import java.util.ArrayList;
import java.util.HashMap;
import util.Lista;

/**
 * Modelo de uma solicitação de abastecimento dos suprimentos à um fornecedor
 * @author Ruan
 */
public class SolicitacaoAbastecimento implements ListagemParcial {

    public static final int SITUACAO_ABERTA    = 1,
                            SITUACAO_ATENDIDA  = 2,
                            SITUACAO_VENCIDA   = 3,
                            SITUACAO_CANCELADA = 4;
    
    private int                          numero;
    private Gerente                      gerente;
    private Fornecedor                   fornecedor;
    private ArrayList<AbastecimentoItem> itens;
    private String                       data;
    private String                       dataLimite;
    private Lista                        situacao;
    
    public SolicitacaoAbastecimento() {
        this.gerente    = new Gerente();
        this.fornecedor = new Fornecedor();
        this.itens      = new ArrayList<>();
        this.situacao   = new Lista();
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

    public Lista getSituacao() {
        return situacao;
    }

    public void setSituacao(Lista situacao) {
        this.situacao = situacao;
    }
    
    public boolean isSituacaoAberta() {
        return this.getSituacao().getCodigo() == SolicitacaoAbastecimento.SITUACAO_ABERTA;
    }
    
    public boolean isSituacaoAtendida() {
        return this.getSituacao().getCodigo() == SolicitacaoAbastecimento.SITUACAO_ATENDIDA;
    }
    
    public boolean isSituacaoVencida() {
        return this.getSituacao().getCodigo() == SolicitacaoAbastecimento.SITUACAO_VENCIDA;
    }
    
    public boolean isSituacaoCancelada() {
        return this.getSituacao().getCodigo() == SolicitacaoAbastecimento.SITUACAO_CANCELADA;
    }
    
    public static HashMap<Integer, Lista> getListaSituacoes() {
        HashMap<Integer, Lista> situacoes = new HashMap<>();
        situacoes.put(SolicitacaoAbastecimento.SITUACAO_ABERTA,    new Lista(SolicitacaoAbastecimento.SITUACAO_ABERTA,    "Aberta"));
        situacoes.put(SolicitacaoAbastecimento.SITUACAO_ATENDIDA,  new Lista(SolicitacaoAbastecimento.SITUACAO_ATENDIDA,  "Atendida"));
        situacoes.put(SolicitacaoAbastecimento.SITUACAO_VENCIDA,   new Lista(SolicitacaoAbastecimento.SITUACAO_VENCIDA,   "Vencida"));
        situacoes.put(SolicitacaoAbastecimento.SITUACAO_CANCELADA, new Lista(SolicitacaoAbastecimento.SITUACAO_CANCELADA, "Cancelada"));
        return situacoes;
    }

    @Override
    public String toString() {
        return numero + " - " + fornecedor + "(" + data + " - " + dataLimite + ", " + situacao + ")";
    }

    @Override
    public ArrayList<String> getCamposIgnorar() {
        ArrayList<String> campos = new ArrayList<>();
        campos.add("SITUACAO_ABERTA");
        campos.add("SITUACAO_ATENDIDA");
        campos.add("SITUACAO_VENCIDA");
        campos.add("SITUACAO_CANCELADA");
        campos.add("itens");
        return campos;
    }
    
}