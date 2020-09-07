package model;


/**
 * Modelo de item (comida, bebeida, etc.)
 * @author Ruan
 * @todo poderia ter um relaciomamento direto com os fornecedores, pra salvar quais fornecedores vendem tal produto
 *       assim podia facilitar o processo de solicitação de abastecimento
 */
public class Item {
    
    private int    codigo;
    private String nome;
    private float  valor;
    private int    estoque;
    private String validade;

    public Item() {
    }

    public Item(int codigo, String nome, float valor, int estoque, String validade) {
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
        this.estoque = estoque;
        this.validade = validade;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    @Override
    public String toString() {
        return nome + " - (" + codigo + ")";
    }
    
}