package model;

/**
 * Modelo padrão de pessoa
 * @author Ruan
 */
public abstract class Pessoa {
    
    private String cpfCnpj;
    private String nome;
    private String email;

    public Pessoa() {
        
    }

    public Pessoa(String cpfCnpj, String nome, String email) {
        this.cpfCnpj = cpfCnpj;
        this.nome = nome;
        this.email = email;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "cpfCnpj=" + cpfCnpj + ", nome=" + nome + ", email=" + email + '}';
    }

}