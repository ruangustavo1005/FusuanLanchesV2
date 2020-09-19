package controller;

import model.Comanda;
import view.ViewConsultaItemComanda;

/**
 * Controller da consulta dos itens da comanda
 * @author Leonardo <leonardo.fusinato@edu.udesc.br>
 */
public class ControllerConsultaItemComanda extends Controller {
    
    private static ControllerConsultaItemComanda instance;
    
    private Comanda comanda;

    public ControllerConsultaItemComanda() {
        
    }
    
    public static ControllerConsultaItemComanda getInstance() {
        if (instance == null) {
            instance = new ControllerConsultaItemComanda(); 
        }
        return instance;
    }
    
    @Override
    protected ViewConsultaItemComanda getInstanceView() {
        return ViewConsultaItemComanda.getInstance().getInstance().getInstance();
    }

    public Comanda getComanda() {
        return comanda;
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }
    
    @Override
    public void montaTela() {
        this.getInstanceView().setDadosTableModel(ControllerItemComanda.getInstance().listar(this.getComanda()));
        super.montaTela();
    }
    
}