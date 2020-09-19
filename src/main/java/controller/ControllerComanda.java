package controller;

import dao.Dao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.Comanda;
import model.ComandaItem;
import model.Item;
import util.NumberUtils;
import view.ViewCadastroComanda;

/**
 * Controller da comanda
 * @author Leonardo Alex Fusinato <leonardo.fusinato@edu.udesc.br>
 */
public class ControllerComanda extends Controller {

    private static ControllerComanda instance;
    
    private Comanda comanda;
    
    private Dao<Comanda> comandas;
    
    @Override
    protected ViewCadastroComanda getInstanceView() {
        return ViewCadastroComanda.getInstance();
    }
    
    public static ControllerComanda getInstance() {
        if(instance == null){
            instance = new ControllerComanda();
        }
        return instance;
    }

    private ControllerComanda() {
        comandas = new Dao<>(Comanda.class);
        this.adicionaAcoesTela();
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }
    
    /**
     * Adiciona as a��es na tela
     */
    private void adicionaAcoesTela() {
        this.adicionaAcaoAddItem();
        this.adicionaAcaoRemoveItem();
        this.adicionaAcaoCadastrar();
    }
    
    public boolean removerComanda(Comanda comanda) {
        return this.comandas.remove(comanda);
    }
    
    public boolean fechaComanda(Comanda comanda) {
        comanda.fecha();
        return this.comandas.update(comanda);
    }
    
    /**
     * Adiciona a a��o de adicionar o item
     */
    private void adicionaAcaoAddItem() {
        this.getInstanceView().adicionaAcaoAddItem(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int indice     = getInstanceView().getListaItens().getSelectedIndex(),
                    quantidade = getInstanceView().getQuantidade();
                
                if (indice < 0) {
                    getInstanceView().showMensagem("Selecione um item!");
                }
                else if(quantidade <= 0) {
                    getInstanceView().showMensagem("Informe uma quantidade v�lida!");
                } else {
                    Item item = (Item) getInstanceView().getListaItens().getSelectedItem();
                    ComandaItem comandaItem = new ComandaItem();
                    comandaItem.setItem(item);
                    comandaItem.setQuantidade(quantidade);
                    comandaItem.setComanda(new Comanda());

                    getInstanceView().getTableModelComandaItem().getModelos().add(comandaItem);
                    getInstanceView().getTableModelComandaItem().fireTableRowsInserted(indice, indice);
                    
                    getInstanceView().setTotal(Comanda.getValorFinal(getInstanceView().getTableModelComandaItem().getModelos()));
                }
            }
        });
    }
    
    /**
     * Adiciona a a��o para remover o item
     */
    private void adicionaAcaoRemoveItem() {
        this.getInstanceView().adicionaAcaoRemoveItem(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int indice = getInstanceView().getListaItens().getSelectedIndex();
                
                if (indice < 0) {
                    getInstanceView().showMensagem("Selecione um item da solicita��o!");
                }
                else {
                    getInstanceView().getTableModelComandaItem().remove(indice);
                    getInstanceView().setTotal(Comanda.getValorFinal(getInstanceView().getTableModelComandaItem().getModelos()));
                }
            }
        });
    }
    
    /**
     * Adiciona a a��o de cadastrar a comanda
     */
    private void adicionaAcaoCadastrar() {
        this.getInstanceView().adicionaAcaoCadastrar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Comanda comanda = getInstanceView().getModelFromTela();
                if(salvar(comanda)){
                    getInstanceView().showMensagem("Comanda inclu�da com sucesso! Valor Final: R$ " + NumberUtils.formataValor(comanda.getValorFinal()));
                    ControllerMenu.getInstance().atualizarConsultaComanda(comanda);
                    getInstanceView().dispose();
                } else {
                    getInstanceView().showMensagem("Houve um erro ao cadastrar a comanda.");
                }
            } 
        });
    }

    @Override
    public void montaTela() {
        this.setListasTela();
        if(this.comanda != null) {
            getInstanceView().setComanda(this.comanda); 
            getInstanceView().setModelTela();
            getInstanceView().habilitaCampos(false);
            getInstanceView().setTotal(comanda.getValorFinal());
            this.comanda = null;
        }
        else {
            getInstanceView().habilitaCampos(true);
        }
        super.montaTela();
    }
    
    /**
     * Seta as listas nos campos
     */
    private void setListasTela(){
        this.setaListaAtendentes();
        this.setaListaItens();
        this.setaListaClientes();
    }
    
    /**
     * Seta a lista dos atendentes
     */
    private void setaListaAtendentes() {
        getInstanceView().setListaAtendentes(ControllerAtendente.getInstance().listarAtendentes());
    }
    
    /**
     * Seta a lista dos itens
     */
    private void setaListaItens(){
        getInstanceView().setListaItens(ControllerItem.getInstance().listar());
    }
    
    /**
     * Seta a lista de clientes
     */
    private void setaListaClientes() {
        getInstanceView().setListaClientes(ControllerCliente.getInstance().listarClientes());
    }
    
    /**
     * Retorna se foi poss�vel salvar 
     */
    private boolean salvar(Comanda comanda) { 
        comanda.setAberto(true);
        comanda.getItens().forEach(comandaItem -> {
            comandaItem.setComanda(comanda);
        });
        return this.comandas.add(comanda);
    }
    
    public ArrayList<Comanda> listar() {
        return this.comandas.get();
   }
    
    public ArrayList<Comanda> listarAbertas() {
        ArrayList<Comanda> abertas = new ArrayList<>();
        for (Comanda comanda : this.comandas.get()) {
            if (comanda.getAberto()) {
                abertas.add(comanda);
            }
        }
        return abertas;
    }

    public Comanda getComanda(int i) {
        return this.comandas.get(i);
    }
    
    public Dao<Comanda> getComandas() {
        return comandas;
    }
    
}