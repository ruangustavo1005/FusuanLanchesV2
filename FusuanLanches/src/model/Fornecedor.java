package model;

/**
 * Modelo de pessoa fornecedora de suprimentos
 * @author Ruan
 */
public class Fornecedor extends Pessoa{
    
    private String email;
    private String telefone;

    public Fornecedor() {
        
    }

    public Fornecedor(String email, String telefone, String cpfCnpj, String nome) {
        super(cpfCnpj, nome);
        this.email = email;
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Fornecedor: Email: " + email + ", Telefone: " + telefone;
    }
    
}
