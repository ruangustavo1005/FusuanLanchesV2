package controller;

import dao.Dao;
import java.util.ArrayList;
import model.Atendente;

/**
 * Controlador do atendente
 * @author Leonardo Alex Fusinato <leonardo.fusinato@edu.udesc.br>
 */
public class ControllerAtendente extends ControllerPessoa {
    
    public static ControllerAtendente instance;
    
    public Dao<Atendente> atendentes;

    private ControllerAtendente() {
        atendentes = new Dao<>();
    }
    
    public static ControllerAtendente getInstance() {
        if (instance == null) {
            instance = new ControllerAtendente();
        }
        return instance;
    }
    
    public ArrayList<Atendente> listarAtendentes() {
        return this.atendentes.getLista();
    }

    public Dao<Atendente> getAtendentes() {
        return atendentes;
    }
    
    public boolean salvarAtendente(Atendente atendente) {
        return atendentes.add(atendente);
    }
    
}