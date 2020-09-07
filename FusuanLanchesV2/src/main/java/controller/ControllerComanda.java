package controller;

import dao.Dao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.Comanda;
import model.ComandaItem;
import model.Item;
import view.ViewCadastroComanda;

/**
 * Controller da comanda
 * @author Leonardo Alex Fusinato <leonardo.fusinato@edu.udesc.br>
 */
public class ControllerComanda extends Controller{

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
        comandas = new Dao<>();
        this.adicionaAcoesTela();
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }
    
    /**
     * Adiciona as ações na tela
     */
    private void adicionaAcoesTela() {
        this.adicionaAcaoAddItem();
        this.adicionaAcaoRemoveItem();
        this.adicionaAcaoCadastrar();
    }
    
    /**
     * Adiciona a ação de adicionar o item
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
                    getInstanceView().showMensagem("Informe uma quantidade válida!");
                } else {
                    Item item = ControllerItem.getInstance().getItens().getLista().get(indice);
                    ComandaItem comandaItem = new ComandaItem();
                    comandaItem.setItem(item);
                    comandaItem.setQuantidade(quantidade);
                    comandaItem.setComanda(new Comanda());
//                    comandaItem.setValor(item.getValor()); 

                    getInstanceView().getTableModelComandaItem().getModelos().add(comandaItem);
                    getInstanceView().getTableModelComandaItem().fireTableRowsInserted(indice, indice);
                }
            }
        });
    }
    
    /**
     * Adiciona a ação para remover o item
     */
    private void adicionaAcaoRemoveItem() {
        this.getInstanceView().adicionaAcaoRemoveItem(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int indice = getInstanceView().getListaItens().getSelectedIndex();
                
                if (indice < 0) {
                    getInstanceView().showMensagem("Selecione um item da solicitação!");
                }
                else {
                    getInstanceView().getTableModelComandaItem().remove(indice);
                }
            }
        });
    }
    
    /**
     * Adiciona a ação de cadastrar a comanda
     */
    private void adicionaAcaoCadastrar() {
        this.getInstanceView().adicionaAcaoCadastrar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Comanda comanda = getInstanceView().getModelFromTela();
                if(salvar(comanda)){
                    getInstanceView().showMensagem("Comanda incluída com sucesso!");
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
            this.comanda = null;
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
     * Retorna se foi possível salvar 
     */
    private boolean salvar(Comanda comanda) { 
        comanda.setNumero(this.comandas.getLista().size() + 1);
        comanda.setAberto(true);
        comanda.getItens().forEach(comandaItem -> {
            comandaItem.setComanda(comanda);
        });
        return this.comandas.add(comanda);
    }
    
    public ArrayList<Comanda> listar() {
        return this.comandas.getLista();
    }
    
    public ArrayList<Comanda> listarAbertas() {
        ArrayList<Comanda> abertas = new ArrayList<>();
        for(Comanda comanda : this.comandas.getLista()){
            if(comanda.getAberto()){
                abertas.add(comanda);
            }
        }
        return abertas;
    }

    public Comanda getComanda(int i) {
        return this.comandas.get(i);
    }
    
}