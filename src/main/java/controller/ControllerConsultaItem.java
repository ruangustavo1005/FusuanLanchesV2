package controller;

import dao.DaoComandaItem;
import dao.DaoSolicitacaoItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Item;
import view.ViewConsultaItem;

/**
 *
 * @author Ruan
 */
public class ControllerConsultaItem extends Controller {

    private static ControllerConsultaItem instance;

    private final DaoSolicitacaoItem daoSolicitacaoItem;
    private final DaoComandaItem     daoComandaItem;
    
    private ControllerConsultaItem() {
        this.daoSolicitacaoItem = new DaoSolicitacaoItem();
        this.daoComandaItem     = new DaoComandaItem();
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
        this.adicionaAcoesTela();
        super.montaTela();
    }
    
    private void adicionaAcoesTela() {
        this.adicionaAcaoRemoverTela();
    }
    
    private void adicionaAcaoRemoverTela() {
        getInstanceView().adicionaAcaoRemoverTela(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indice = getInstanceView().getTable().getSelectedRow();
                ControllerConsultaItem me = getInstance();
                if (indice >= 0) {
                    Item item = getInstanceView().getTableModel().get(indice);
                    if (JOptionPane.showConfirmDialog(getInstanceView(), "Deseja remover o item \"" + item.getNome() + "\"?") == JOptionPane.YES_OPTION) {
                        if (me.isItemUtilizadoEmSolicitacao(item)) {
                            getInstanceView().showMensagem("O item não pode ser excluído pois já foi utilizado em uma solicitação de abastecimento!");
                        }
                        else if (me.isItemUtilizadoEmComanda(item)) {
                            getInstanceView().showMensagem("O item não pode ser excluído pois já foi utilizado em uma comanda!");
                        }
                        else if (ControllerItem.getInstance().getItens().remove(item)) {
                            getInstanceView().getTableModel().remove(indice);
                            getInstanceView().showMensagem("Item removido com sucesso!");
                        }
                        else {
                            getInstanceView().showMensagem("Houve um erro ao remover o item");
                        }
                    }
                }
                else {
                    getInstanceView().showMensagem("Selecione um item para remover!");
                }
            }
        });
    }
    
    public boolean isItemUtilizadoEmSolicitacao(Item item) {
        return this.daoSolicitacaoItem.usaItem(item);
    }
    
    public boolean isItemUtilizadoEmComanda(Item item) {
        return this.daoComandaItem.usaItem(item);
    }
    
    @Override
    protected ViewConsultaItem getInstanceView() {
        return ViewConsultaItem.getInstance();
    }
    
}