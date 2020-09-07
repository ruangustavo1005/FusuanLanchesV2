package controller;

import view.ViewConsultaUsuario;

/**
 * Controlador da consulta dos usuários
 * @author Leonardo Alex Fusinato <leonardo.fusinato@edu.udesc.br>
 */
public class ControllerConsultaUsuarios extends Controller {
    
    private static ControllerConsultaUsuarios instance;

    public ControllerConsultaUsuarios() {
        
    }
    
    public static ControllerConsultaUsuarios getInstance() {
        if (instance == null) {
            instance = new ControllerConsultaUsuarios();
        }
        return instance;
    }
    
    @Override
    public void montaTela() {
        this.getInstanceView().setDadosTableModel(ControllerUsuario.getInstance().listar());
        super.montaTela();
    }
    
    @Override
    protected ViewConsultaUsuario getInstanceView() {
        return ViewConsultaUsuario.getInstance();
    }
    
}