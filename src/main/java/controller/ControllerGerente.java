package controller;

import dao.Dao;
import java.util.ArrayList;
import model.Gerente;

/**
 * Controlador do gerente
 * @author Leonardo Alex Fusinato <leonardo.fusinato@edu.udesc.br>
 */
public class ControllerGerente extends ControllerPessoa {
    
    public static ControllerGerente instance;
    
    public Dao<Gerente> gerentes;

    private ControllerGerente() {
        gerentes = new Dao<>(Gerente.class);
    }
    
    public static ControllerGerente getInstance() {
        if (instance == null) {
            instance = new ControllerGerente();
        }
        return instance;
    }
    
    public ArrayList<Gerente> listarGerentes() {
        return this.gerentes.get();
    }

    public Dao<Gerente> getGerentes() {
        return gerentes;
    }
    
    public boolean salvarGerente(Gerente gerente) {
        return gerentes.add(gerente);
    }
    
}