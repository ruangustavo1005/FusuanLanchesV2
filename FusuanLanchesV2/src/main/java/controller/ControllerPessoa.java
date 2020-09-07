package controller;

import dao.Dao;
import exceptions.ExceptionMetodoNaoImplementado;
import java.util.ArrayList;
import model.Pessoa;
import view.View;

/**
 * Controlador da pessoa
 * @author Leonardo Alex Fusinato <leonardo.fusinato@edu.udesc.br>
 */
public class ControllerPessoa extends Controller  {
    
    public static ControllerPessoa instance;
    
    public static ControllerPessoa getInstance() {
        if (instance == null) {
            instance = new ControllerPessoa();
        }
        return instance;
    }

    protected ControllerPessoa() {
        
    }
    
    @Override
    protected View getInstanceView() throws ExceptionMetodoNaoImplementado {
        throw new ExceptionMetodoNaoImplementado("getInstanceView", this.getClass().getName());
    }
    
    public ArrayList<Pessoa> listar() {
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        pessoas.addAll(ControllerCliente.getInstance().listarClientes());
        pessoas.addAll(ControllerAtendente.getInstance().listarAtendentes());
        pessoas.addAll(ControllerFornecedor.getInstance().listarFornecedores());
        pessoas.addAll(ControllerGerente.getInstance().listarGerentes());
        return pessoas;
    }
    
}