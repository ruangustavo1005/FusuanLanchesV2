package model;

import interfaces.ListagemParcial;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import util.MD5;

/**
 * Modelo de usuário geral do sistema
 * @author Ruan
 */
@Entity
@Table(name = "tbusuario")
public class Usuario implements ListagemParcial {
    
    @Id
    @Column(unique = true)
    private String login;
    @ManyToOne
    private Pessoa pessoa;
    private String senha;

    public Usuario() {
        
    }
    
    public Usuario(Pessoa pessoa, String login, String senha) {
        this.pessoa = pessoa;
        this.login = login;
        this.senha = senha;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = MD5.md5(senha);
    }

    public boolean isCliente() {
        return this.pessoa instanceof Cliente;
    }

    public boolean isGerente() {
        return this.pessoa instanceof Gerente;
    }

    public boolean isFornecedor() {
        return this.pessoa instanceof Fornecedor;
    }

    public boolean isAtendente() {
        return this.pessoa instanceof Atendente;
    }
    
    @Override
    public String toString() {
        return "Usuario: Login: " + login;
    }

    @Override
    public ArrayList<String> getCamposIgnorar() {
        ArrayList<String> campos = new ArrayList<>();
        campos.add("senha");
        return campos;
    }
    
}