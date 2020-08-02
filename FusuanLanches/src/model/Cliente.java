package model;


/**
 * Modelo de pessoa cliente
 * @author Ruan
 */
public class Cliente extends Pessoa {
    
    private String dataNascimento;

    public Cliente() {
    
    }

    public Cliente(String dataNascimento, String cpfCnpj, String email, String nome) {
        super(cpfCnpj, nome, email);
        this.dataNascimento = dataNascimento;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Cliente: Data de nascimento: " + dataNascimento;
    }
    
}