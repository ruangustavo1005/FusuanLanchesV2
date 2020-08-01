package model;

/**
 * Modelo de usuário geral do sistema
 * O nível de acesso e privilégios são definidos por seu privilégios
 * @author Ruan
 */
public class Usuario {
    
    private Pessoa pessoa;
    private int    login;
    private String senha;

    public Usuario() {
        
    }
    
    public Usuario(Pessoa pessoa, int login, String senha) {
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

    public int getLogin() {
        return login;
    }

    public void setLogin(int login) {
        this.login = login;
    }

    /**
     * @todo criptografar
     */
//    public String getSenha() {
//        return senha;
//    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario: Login: " + login;
    }
    
}