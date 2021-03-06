package controller;

import dao.Dao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.Item;
import view.ViewCadastroItem;

/**
 * Controller do Item
 * @author Leonardo Alex Fusinato <leonardo.fusinato@edu.udesc.br>
 */
public class ControllerItem extends Controller {

    private static ControllerItem instance;
    
    private Item item;
    
    private Dao<Item> itens;

    private ControllerItem() {
        itens = new Dao<>(Item.class);
        this.adicionaAcoesTela();
    }
    
    public static ControllerItem getInstance() {
        if (instance == null) {
            instance = new ControllerItem();
        }
        return instance;
    }
    
    /**
     * Adiciona as a��es na tela
     */
    private void adicionaAcoesTela() {
        this.adicionaAcaoCadastrar();
    }
    
    /**
     * Adiciona a a��o para cadastrar o item
     */
    private void adicionaAcaoCadastrar() {
        getInstanceView().adicionaAcaoCadastrar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(salvar()) {
                    getInstanceView().showMensagem("Item adicionado com sucesso!");
                    getInstanceView().dispose();
                } else {
                    getInstanceView().showMensagem("Houve um erro ao cadastrar o item");
                }
            }
        });
    }
    
    @Override
    protected ViewCadastroItem getInstanceView() {
        return ViewCadastroItem.getInstance();
    }
    
    /**
     * Salva o item no ArrayList
     * @return boolean
     */
    private boolean salvar() {
        return this.itens.add(this.getInstanceView().getModelFromTela());
    }
    
    public ArrayList<Item> listar() {
        return this.itens.get();
    }   

    public Dao<Item> getItens() {
        return itens;
    }
    
}