package controller;

import dao.Dao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.AbastecimentoItem;
import model.SolicitacaoAbastecimento;
import view.ViewCadastroSolicitacaoAbastecimento;

/**
 *
 * @author Ruan
 */
public class ControllerSolicitacaoAbastecimento extends Controller {

    private static ControllerSolicitacaoAbastecimento instance;
    
    private SolicitacaoAbastecimento solicitacaoAbastecimento;

    private Dao<SolicitacaoAbastecimento> dao;
    
    private ControllerSolicitacaoAbastecimento() {
        this.dao = new Dao<>();
        this.getInstanceView().setaDadosTabelaItens(ControllerItem.getInstance().listar());
        this.adicionaAcoesTela();
    }

    public static ControllerSolicitacaoAbastecimento getInstance() {
        if (instance == null) {
            instance = new ControllerSolicitacaoAbastecimento();
        }
        
        return instance;
    }

    public SolicitacaoAbastecimento getSolicitacaoAbastecimento() {
        return solicitacaoAbastecimento;
    }

    public void setSolicitacaoAbastecimento(SolicitacaoAbastecimento solicitacaoAbastecimento) {
        this.solicitacaoAbastecimento = solicitacaoAbastecimento;
    }
    
    private void adicionaAcoesTela() {
        this.adicionaAcaoAdicionarItem();
        this.adicionaAcaoFinalizar();
        this.adicionaAcaoRemover();
    }
    
    private void adicionaAcaoAdicionarItem() {
        this.getInstanceView().adicionaAcaoAdicionarItem(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indice     = getInstanceView().getTbItens().getSelectedRow(),
                    quantidade = getInstanceView().getQuantidade();
                
                if (indice < 0) {
                    getInstanceView().showMensagem("Selecione um item!");
                }
                else if (quantidade == 0) {
                    getInstanceView().showMensagem("Informe uma quantidade válida!");
                }
                else {
                    AbastecimentoItem abastecimentoItem = new AbastecimentoItem();

                    abastecimentoItem.setItem(getInstanceView().getTableModelItens().get(indice));
                    abastecimentoItem.setQuantidade(quantidade);
                    abastecimentoItem.setSolicitacaoAbastecimento(new SolicitacaoAbastecimento());

                    getInstanceView().getTableModelSolicitacaoItens().add(abastecimentoItem);
                }
            }
        });
    }
    
    private void adicionaAcaoFinalizar() {
        this.getInstanceView().adicionaAcaoFinalizar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (salvar(getInstanceView().getModelFromTela())) {
                    getInstanceView().showMensagem("Solicitação de Abastecimento incluída com sucesso!");
                    getInstanceView().dispose();
                }
                else {
                    getInstanceView().showMensagem("Houve um erro ao cadastrar a solicitação de abastecimento.");
                }
            }
        });
    }
    
    private void adicionaAcaoRemover() {
        this.getInstanceView().adicionaAcaoRemover(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indice = getInstanceView().getTbSolicitacaoItens().getSelectedRow();
                
                if (indice < 0) {
                    getInstanceView().showMensagem("Selecione um item da solicitação!");
                }
                else {
                    getInstanceView().getTableModelSolicitacaoItens().remove(indice);
                }
            }
        });
    }
    
    private boolean salvar(SolicitacaoAbastecimento solicitacaoAbastecimentoNova) {
        solicitacaoAbastecimentoNova.setNumero(this.dao.getLista().size() + 1);
        solicitacaoAbastecimentoNova.setSituacao(SolicitacaoAbastecimento.getListaSituacoes().get(SolicitacaoAbastecimento.SITUACAO_ABERTA));

        for (AbastecimentoItem abastecimentoItem : solicitacaoAbastecimentoNova.getItens()) {
            abastecimentoItem.setSolicitacaoAbastecimento(solicitacaoAbastecimentoNova);
        }

        return this.dao.add(solicitacaoAbastecimentoNova);
    }

    public ArrayList<SolicitacaoAbastecimento> listar() {
        return this.dao.getLista();
    }
    
    @Override
    public void montaTela() {
        getInstanceView().setaDadosComboBoxGerente(ControllerGerente.getInstance().listarGerentes());
        getInstanceView().setaDadosComboBoxFornecedor(ControllerFornecedor.getInstance().listarFornecedores());
        if (this.solicitacaoAbastecimento != null) {
            getInstanceView().setSolicitacaoAbastecimento(this.solicitacaoAbastecimento);
            getInstanceView().setModelTela();
            getInstanceView().habilitaCampos(false);
            this.setaSolicitacaoItensTela();
            this.solicitacaoAbastecimento = null;
        }
        super.montaTela();
    }
    
    private void setaSolicitacaoItensTela() {
        this.solicitacaoAbastecimento.getItens().forEach(item -> {
            getInstanceView().getTableModelSolicitacaoItens().add(item);
        });
    }
    
    @Override
    protected ViewCadastroSolicitacaoAbastecimento getInstanceView() {
        return ViewCadastroSolicitacaoAbastecimento.getInstance();
    }

}