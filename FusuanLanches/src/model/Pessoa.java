package model;

/**
 * Modelo padrão de pessoa
 * @author Ruan
 */
public abstract class Pessoa {
    
    private String cpfCnpj;
    private String nome;

    public Pessoa() {
        
    }

    public Pessoa(String cpfCnpj, String nome) {
        this.cpfCnpj = cpfCnpj;
        this.nome = nome;
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

    @Override
    public String toString() {
        return "Pessoa: CPF/CNPJ: " + cpfCnpj + ", Nome: " + nome;
    }
    
}