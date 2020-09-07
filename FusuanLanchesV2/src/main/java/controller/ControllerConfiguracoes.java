package controller;

import dao.Dao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        this.configuracoes = new Dao<>();
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
        if (configuracoes.getLista().size() > 0) {
            return this.configuracoes.remove(configuracoes.get(0))
                && this.configuracoes.add(this.getInstanceView().getModelFromTela());
        }
        else {
            return this.configuracoes.add(this.getInstanceView().getModelFromTela());
        }
    }
    
}