package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * Modelo padrão de pessoa
 * @author Ruan
 */
@Entity
@Table(name = "tbpessoa")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Pessoa {
    
    @Id
    @Column(unique = true)
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
        return cpfCnpj + " - " + nome;
    }

}