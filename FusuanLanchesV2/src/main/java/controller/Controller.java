package controller;

import exceptions.ExceptionMetodoNaoImplementado;
import view.View;

/**
 * Controlador padrão do sistema
 * @author Ruan
 */
public abstract class Controller {
    
    protected abstract View getInstanceView() throws ExceptionMetodoNaoImplementado;
    
    public void montaTela(){
        try {
            this.getInstanceView().setVisible(true);
        } catch (ExceptionMetodoNaoImplementado ex) {
            
        }
    }
    
}