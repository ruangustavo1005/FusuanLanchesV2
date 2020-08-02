package model;

/**
 * Modelo de pessoa fornecedora de suprimentos
 * @author Ruan
 */
public class Fornecedor extends Pessoa{
    
    private String telefone;

    public Fornecedor() {
        
    }

    public Fornecedor(String telefone, String cpfCnpj, String nome, String email) {
        super(cpfCnpj, nome, email);
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Fornecedor{" + "telefone=" + telefone + '}';
    }
    
}
