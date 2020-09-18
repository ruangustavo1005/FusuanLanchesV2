package controller;

import dao.Dao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.Configuracoes;
import view.ViewConfiguracoes;

/**
 *
 * @author Ruan
 */
public class ControllerConfiguracoes extends Controller {

    private static ControllerConfiguracoes instance;

    private Dao<Configuracoes> configuracoes;
    
    private ControllerConfiguracoes() {
        this.configuracoes = new Dao<>(Configuracoes.class);
        this.adicionaAcoes();
    }

    public static ControllerConfiguracoes getInstance() {
        if (instance == null) {
            instance = new ControllerConfiguracoes();
        }
        
        return instance;
    }
    
    public void setModelTe1a() {
        
    }
    
    @Override
    protected ViewConfiguracoes getInstanceView() {
        ViewConfiguracoes view = ViewConfiguracoes.getInstance();
        ArrayList<Configuracoes> configuracoes = this.configuracoes.get();
        if (configuracoes.size() > 0) {
            ViewConfiguracoes.getInstance().setConfiguracoes(configuracoes.get(0));
            ViewConfiguracoes.getInstance().setModelTela();
        }
        return ViewConfiguracoes.getInstance();
    }
    
    private void adicionaAcoes() {
        this.adicionaAcaoSalvar();
    }
    
    private void adicionaAcaoSalvar() {
        this.getInstanceView().adicionaAcaoBotaoSalvar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (salvar()) {
                    getInstanceView().showMensagem("Configuracoes salvas com sucesso!");
                    getInstanceView().setVisible(false);
                }
                else {
                    getInstanceView().showMensagem("Houve um erro ao salvar suas configurações.");
                }
            }
        });
    }
    
    private boolean salvar() {
        boolean retorno;
        Configuracoes configuracoes = this.getInstanceView().getModelFromTela();
        if (this.configuracoes.get(configuracoes.getId()) != null) {
            retorno = this.configuracoes.update(configuracoes);
        }
        else {
            retorno = this.configuracoes.add(configuracoes);
        }
        return retorno;
    }
    
}