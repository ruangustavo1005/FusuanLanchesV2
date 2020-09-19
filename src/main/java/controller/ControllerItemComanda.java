package controller;

import dao.DaoComandaItem;
import java.util.ArrayList;
import model.Comanda;
import model.ComandaItem;
import view.ViewCadastroComandaItem;

/**
 * Controller dos itens da comanda
 * @author Leonardo
 */
public class ControllerItemComanda extends Controller {
    
    private static ControllerItemComanda instance;
    
    private ComandaItem comandaItem;
    
    private DaoComandaItem itensComanda;

    @Override
    protected ViewCadastroComandaItem getInstanceView() {
        return ViewCadastroComandaItem.getInstance();
    }
    
    public static ControllerItemComanda getInstance() {
        if(instance == null){
            instance = new ControllerItemComanda();
        } 
        return instance;
    }
    
    private ControllerItemComanda () {
        itensComanda = new DaoComandaItem();
    }
    
    public ArrayList<ComandaItem> listar(Comanda comanda) {
        return this.itensComanda.getItensFromComanda(comanda);
   }
    
    public DaoComandaItem getItensComanda() {
        return itensComanda;
    }
    
}