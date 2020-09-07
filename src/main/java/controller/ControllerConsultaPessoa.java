package controller;

import view.ViewConsultaPessoa;

/**
 * Controlador da consulta das pessoas
 * @author Leonardo Alex Fusinato <leonardo.fusinato@edu.udesc.br>
 */
public class ControllerConsultaPessoa extends Controller {

    private static ControllerConsultaPessoa instance;

    private ControllerConsultaPessoa() {
        
    }
    
    public static ControllerConsultaPessoa getInstance() {
        if (instance == null) {
            instance = new ControllerConsultaPessoa();
        }
        return instance;
    }
    
    @Override
    public void montaTela() {
        super.montaTela();
        this.getInstanceView().setDadosTableModelPessoa(ControllerPessoa.getInstance().listar());
    }
    
    @Override
    protected ViewConsultaPessoa getInstanceView() {
        return ViewConsultaPessoa.getInstance(ControllerPessoa.getInstance().listar());
    }

}