package model;

/**
 * Modelo de pessoa atendente
 * @author Ruan
 */
public class Atendente extends Pessoa {
    
    public Atendente() {
        
    }
    
    public Atendente(String cpfCnpj, String nome, String email) {
        super(cpfCnpj, nome, email);
    }
    
    @Override
    public String toString() {
        return super.toString();
    }
    
}