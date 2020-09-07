package controller;

import dao.Dao;
import java.util.ArrayList;
import model.Fornecedor;

/**
 * Controlador do fornecedor
 * @author Leonardo Alex Fusinato <leonardo.fusinato@edu.udesc.br>
 */
public class ControllerFornecedor extends ControllerPessoa{
    
    public static ControllerFornecedor instance;
    
    public Dao<Fornecedor> fornecedores;

    private ControllerFornecedor() {
        fornecedores = new Dao<>();
    }
    
    public static ControllerFornecedor getInstance() {
        if (instance == null) {
            instance = new ControllerFornecedor();
        }
        return instance;
    }
    
    public ArrayList<Fornecedor> listarFornecedores() {
        return this.fornecedores.getLista();
    }

    public Dao<Fornecedor> getFornecedores() {
        return fornecedores;
    }
    
    public boolean salvarFornecedor(Fornecedor fornecedor) {
        return fornecedores.add(fornecedor);
    }
    
}