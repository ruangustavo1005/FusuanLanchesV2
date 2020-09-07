package model;

/**
 * Modelo de pessoa gerenciadora
 * @author Ruan
 */
public class Gerente extends Pessoa{

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