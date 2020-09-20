package model;

import interfaces.ListagemMaqueada;
import java.util.HashMap;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Modelo de item (comida, bebida, etc.)
 * @author Ruan
 */

@Entity
@Table(name="tbitem")
public class Item implements ListagemMaqueada {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
        return "(" + codigo + ") - " +nome;
    }
    
    @Override
    public HashMap<String, String> getTitulosColunas() {
        HashMap<String, String> titulos = new HashMap<>();
        titulos.put("codigo", "Código");
        return titulos;
    }
    
}