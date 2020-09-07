package controller;

import dao.Dao;
import java.util.ArrayList;
import model.Cliente;

/**
 * Controlador do cliente
 * @author Leonardo Alex Fusinato <leonardo.fusinato@edu.udesc.br>
 */
public class ControllerCliente extends ControllerPessoa {
    
    public static ControllerCliente instance;
    
    public Dao<Cliente> clientes;

    private ControllerCliente() {
        clientes = new Dao<>();
    }
    
    public static ControllerCliente getInstance() {
        if (instance == null) {
            instance = new ControllerCliente();
        }
        return instance;
    }
    
    public ArrayList<Cliente> listarClientes(){
        return this.clientes.getLista();
    }

    public Dao<Cliente> getClientes() {
        return clientes;
    }
    
    public boolean salvarCliente(Cliente cliente) {
        return clientes.add(cliente);
    }
    
}