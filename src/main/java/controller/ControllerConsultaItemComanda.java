package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Comanda;
import model.ComandaItem;
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
        this.adicionaAcoesTela();
        super.montaTela();
    }
    
    private void adicionaAcoesTela() {
        this.adicionaAcaoAdicionarItemComanda();
        this.adicionaAcaoRemoverItemComanda();
    }
    
    private void adicionaAcaoRemoverItemComanda() {
        this.getInstanceView().adicionaAcaoRemover(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indice = getInstanceView().getTable().getSelectedRow();
                ComandaItem comandaItem = getInstanceView().getTableModel().get(indice);
                if (JOptionPane.showConfirmDialog(getInstanceView(), "Deseja remover o item \"" + comandaItem.getItem().getCodigo()+ "\"?") == JOptionPane.YES_OPTION) {
                    if(indice >= 0) {
                        if (ControllerItemComanda.getInstance().getItensComanda().remove(comandaItem)) {
                            getInstanceView().getTableModel().remove(indice);
                            getInstanceView().showMensagem("Item da comanda removido com sucesso!");
                        }
                    } else {
                        getInstanceView().showMensagem("Selecione um item para remover!");
                    }
                }
            }
        });
    }
    
    private void adicionaAcaoAdicionarItemComanda() {
        this.getInstanceView().adicionaAcaoAdicionarItem(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControllerItemComanda.getInstance().montaTela();
            }
        });
    }
    
}