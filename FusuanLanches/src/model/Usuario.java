package model;

import util.MD5;

/**
 * Modelo de usuário geral do sistema
 * O nível de acesso e privilégios são definidos por seu privilégios
 * @author Ruan
 */
public class Usuario {
    
    private Pessoa pessoa;
    private String login;
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

    @Override
    public String toString() {
        return "Usuario: Login: " + login;
    }
    
}