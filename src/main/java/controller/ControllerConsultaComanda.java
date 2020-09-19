package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Comanda;
import view.ViewConsultaComanda;

/**
 * Controller de consulta das comandas
 * @author Leonardo <leonardo.fusinato@edu.udesc.br>
 */
public class ControllerConsultaComanda extends Controller {
 
    private static ControllerConsultaComanda instance;

    public ControllerConsultaComanda() {
        
    }
    
    public static ControllerConsultaComanda getInstance() {
        if (instance == null) {
            instance = new ControllerConsultaComanda();
        }
        return instance;
    }
    
    @Override
    protected ViewConsultaComanda getInstanceView() {
        return ViewConsultaComanda.getInstance();
    }
    
    @Override
    public void montaTela() {
        this.getInstanceView().setDadosTableModel(ControllerComanda.getInstance().listar());
        this.adicionaAcoesTela();
        super.montaTela();
    }
    
    private void adicionaAcoesTela() {
        this.adicionaAcaoRemover();
        this.adicionaAcaoConsultarItens();
    }
    
    private void adicionaAcaoRemover() {
        getInstanceView().adicionaAcaoRemover(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indice = getInstanceView().getTable().getSelectedRow();
                if (JOptionPane.showConfirmDialog(getInstanceView(), "Deseja remover a comanda \"" + getComandaFromIndice(indice).getNumero() + "\"?") == JOptionPane.YES_OPTION) {
                    if(indice >= 0) {
                        if (ControllerComanda.getInstance().getComandas().remove(getComandaFromIndice(indice))) {
                            getInstanceView().getTableModel().remove(indice);
                            getInstanceView().showMensagem("Comanda removida com sucesso!");
                        }
                    } else {
                        getInstanceView().showMensagem("Selecione uma comanda para remover!");
                    }
                }
            }
        });
    }
    
    private void adicionaAcaoConsultarItens() {
       getInstanceView().adicionaAcaoConsultaItens(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               int indice = getInstanceView().getTable().getSelectedRow();
               if(indice >= 0) {
                   ControllerConsultaItemComanda.getInstance().setComanda(getComandaFromIndice(indice));
                   ControllerConsultaItemComanda.getInstance().montaTela();
                } else {
                    getInstanceView().showMensagem("Selecione uma comanda para consultar os itens!");
                }
           }
       }); 
    }
    
    /**
     * Retorna o objeto da comanda conforme o índice da tabela de consulta
     */
    private Comanda getComandaFromIndice(int indice){
        Comanda comanda = getInstanceView().getTableModel().get(indice);
        return comanda;
    }
    
}