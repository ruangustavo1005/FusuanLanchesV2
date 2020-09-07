package controller;

import view.ViewConsultaItem;

/**
 *
 * @author Ruan
 */
public class ControllerConsultaItem extends Controller {

    private static ControllerConsultaItem instance;

    private ControllerConsultaItem() {
        
    }

    public static ControllerConsultaItem getInstance() {
        if (instance == null) {
            instance = new ControllerConsultaItem();
        }
        
        return instance;
    }

    @Override
    public void montaTela() {
        this.getInstanceView().setDadosTableModel(ControllerItem.getInstance().listar());
        super.montaTela();
    }
    
    @Override
    protected ViewConsultaItem getInstanceView() {
        return ViewConsultaItem.getInstance();
    }
    
}