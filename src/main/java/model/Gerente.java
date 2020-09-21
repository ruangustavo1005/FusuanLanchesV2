package model;

import javax.persistence.Entity;

/**
 * Modelo de pessoa gerenciadora
 * @author Ruan
 */
@Entity
public class Gerente extends Pessoa {

    public Gerente() {
        
    }
    
    public Gerente(String cpfCnpj, String nome, String email) {
        super(cpfCnpj, nome, email);
    }
    
    @Override
    public String toString() {
        return super.toString();
    }
    
}