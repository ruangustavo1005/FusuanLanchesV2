package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Modelo de logs do sistema
 * @author Ruan
 */
@Entity
@Table(name = "tblog")
public class Log {
    
    static public final int TIPO_SUCESSO = 1,
                            TIPO_ERRO    = 2,
                            TIPO_ALERTA  = 3;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int     codigo;
    @ManyToOne
    private Usuario usuario;
    private int     tipo;
    private String  comando;
    private String  descricao;
    private String  data;
    private boolean sucesso;

    public Log() {
        
    }

    public Log(Usuario usuario, int tipo, String comando, String decricao, String data, boolean sucesso) {
        this.usuario = usuario;
        this.tipo = tipo;
        this.comando = comando;
        this.descricao = decricao;
        this.data = data;
        this.sucesso = sucesso;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getComando() {
        return comando;
    }

    public void setComando(String comando) {
        this.comando = comando;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isSucesso() {
        return sucesso;
    }

    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }

    @Override
    public String toString() {
        return "Log(" + this.codigo + "): Tipo: " + tipo + ", Data: " + data + ", Comando: " + comando + ", Descrição: " + descricao;
    }
    
}