package controller;

import dao.Dao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Comanda;
import model.ComandaItem;
import model.Item;
import view.ViewEditarItensComanda;

/**
 *
 * @author Ruan
 */
public class ControllerEditarItensComanda extends Controller {

    static private ControllerEditarItensComanda instance;

    private Comanda comanda; 
    private Dao<ComandaItem> daoComandaItem;

    public ControllerEditarItensComanda() {
        this.daoComandaItem = new Dao(ComandaItem.class);
        this.adicionaAcoes();
    }
    
    private void adicionaAcoes() {
        this.adicionaAcaoAdicionarItem();
        this.adicionaAcaoRemoverItem();
        this.adicionaAcaoAdicionarQuantidade();
        this.adicionaAcaoRemoverQuantidade();
        this.adicionaAcaoSalvar();
    }
    
    private void adicionaAcaoAdicionarItem() {
        getInstanceView().adicionaAcaoAdicionarItem(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Item item = getInstanceView().getItemSelecionado();
                int quantidade = getInstanceView().getQuantidadeAdicionar();
                ComandaItem comandaItem = new ComandaItem(item, comanda, quantidade);
                getInstanceView().getTableModelItens().add(comandaItem);
            }
        });
    }
    
    private void adicionaAcaoRemoverItem() {
        getInstanceView().adicionaAcaoRemoverItem(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (getInstanceView().temComandaItemSelecionado()) {
                    getInstanceView().getTableModelItens().remove(getInstanceView().getComandaItemSelecionado());
                }
                else {
                    getInstanceView().showMensagem("Selecione um item!");
                }
            }
        });
    }
    
    private void adicionaAcaoAdicionarQuantidade() {
        getInstanceView().adicionaAcaoAdicionarQuantidade(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (getInstanceView().temComandaItemSelecionado()) {
                    ComandaItem comandaItem = getInstanceView().getComandaItemSelecionado();
                    int quantidade = getInstanceView().getQuantidadeEditar();
                    comandaItem.setQuantidade(comandaItem.getQuantidade() + quantidade);
                    getInstanceView().getTableModelItens().update(getInstanceView().getTableModelItens().indexOf(comandaItem));
                }
                else {
                    getInstanceView().showMensagem("Selecione um item!");
                }
            }
        });
    }
    
    private void adicionaAcaoRemoverQuantidade() {
        getInstanceView().adicionaAcaoRemoverQuantidade(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (getInstanceView().temComandaItemSelecionado()) {
                    ComandaItem comandaItem = getInstanceView().getComandaItemSelecionado();
                    int quantidade = getInstanceView().getQuantidadeEditar();
                    if (comandaItem.getQuantidade() >= quantidade) {
                        comandaItem.setQuantidade(comandaItem.getQuantidade() - quantidade);
                        getInstanceView().getTableModelItens().update(getInstanceView().getTableModelItens().indexOf(comandaItem));
                    }
                    else {
                        getInstanceView().showMensagem("Quantidade inválida!");
                    }
                }
                else {
                    getInstanceView().showMensagem("Selecione um item!");
                }
            }
        });
    }
    
    private void adicionaAcaoSalvar() {
        getInstanceView().adicionaAcaoSalvar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean sucesso = true;
                for (ComandaItem comandaItem : comanda.getItens()) {
                    if (!daoComandaItem.remove(comandaItem)) {
                        getInstanceView().showMensagem("Houve um erro ao editar o item \"" + comandaItem.getItem().getNome() + "\"!");
                        sucesso = false;
                        break;
                    }
                }
                for (ComandaItem comandaItem : getInstanceView().getTableModelItens().getModelos()) {
                    if (!daoComandaItem.add(comandaItem) ){
                        getInstanceView().showMensagem("Houve um erro ao editar o item \"" + comandaItem.getItem().getNome() + "\"!");
                        sucesso = false;
                        break;
                    }
                }
                if (sucesso) {
                    getInstanceView().showMensagem("Itens editados com sucesso!");
                    getInstanceView().dispose();
                    comanda.setItens(getInstanceView().getTableModelItens().getModelos());
                    ControllerMenu.getInstance().getInstanceView().getTableModelComanda().remove(comanda);
                    ControllerMenu.getInstance().getInstanceView().getTableModelComanda().add(comanda);
                }
            }
        });
    }
    
    public static ControllerEditarItensComanda getInstance(Comanda comanda) {
        if (instance == null) {
            instance = new ControllerEditarItensComanda();
        }
        instance.setComanda(comanda);
        return instance;
    }

    public Comanda getComanda() {
        return comanda;
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }
    
    @Override
    protected ViewEditarItensComanda getInstanceView() {
        return ViewEditarItensComanda.getInstance();
    }

    @Override
    public void montaTela() {
        getInstanceView().setComanda(this.getComanda());
        getInstanceView().setItensComboBox(ControllerItem.getInstance().getItens().get());
        super.montaTela();
    }
    
}