package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Comanda;
import util.NumberUtils;
import view.ViewIndex;

/**
 * Controller do index - menu
 * @author Leonardo Alex Fusinato <leonardo.fusinato@edu.udesc.br>
 */
public class ControllerMenu extends Controller {

    private static ControllerMenu instance;
    
    private ControllerMenu() {
        this.adicionaAcoesTela();
    }

    public static ControllerMenu getInstance() {
        if (instance == null) {
            instance = new ControllerMenu();
        }
        
        return instance;
    }

    @Override
    public void montaTela() {
        this.getInstanceView().setDadosTableModel(ControllerComanda.getInstance().listarAbertas());
        super.montaTela(); 
    }
    
    public void atualizarConsultaComanda(Comanda comanda) {
        getInstanceView().getTableModelComanda().add(comanda);
    }
    
    /**
     * Adiciona as a��es na tela
     */
    private void adicionaAcoesTela() {
        this.adicionaAcaoItemMenuCadastroUsuario();
        this.adicionaAcaoNovaComanda();
        this.adicionaAcaoItemMenuCadastroItem();
        this.adicionaAcaoConfiguracoes();
        this.adicionaAcaoConsultarItens();
        this.adicionaAcaoConsultarUsuarios();
        this.adicionaAcaoConsultarPessoas();
        this.adicionaAcaoCadastroSolicitacaoAbastecimento();
        this.adicionaAcaoConsultaSolicitacoesAbastecimento();
        this.adicionaAcaoConsultaComandas();
        this.adicionaAcaoVisualizarComanda();
        this.adicionaAcaoRemoverComanda();
        this.adicionaAcaoFecharComanda();
        this.adicionaAcaoLogout();
        this.adicionaAcaoEditarItens();
    }
    
    /**
     * Adiciona a a��o de nova comanda
     */
    private void adicionaAcaoNovaComanda(){
        this.getInstanceView().adicionaAcaoNovaComanda(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControllerComanda.getInstance().montaTela();
            }
        });
    }
    
    /**
     * Adiciona a a��o do item menu de cadastro de usu�rio
     */
    private void adicionaAcaoItemMenuCadastroUsuario(){
        this.getInstanceView().adicionaAcaoItemMenuCadastroUsuario(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControllerUsuario.getInstance().montaTela();
            }
        });
    }
    
    /**
     * Adiciona a a��o do item menu de cadastro do item
     */
    private void adicionaAcaoItemMenuCadastroItem() {
        this.getInstanceView().adicionaAcaoItemMenuCadastroItem(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControllerItem.getInstance().montaTela();
            }
        });
    }

    /**
     * Adiciona a a��o do bot�o de editar configuraç�s
     */
    private void adicionaAcaoConfiguracoes() {
        this.getInstanceView().adicionaAcaoConfiguracoes(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControllerConfiguracoes.getInstance().montaTela();
            }
        });
    }

    /**
     * Adiciona a a��o do bot�o de consultar itens
     */
    private void adicionaAcaoConsultarItens() {
        this.getInstanceView().adicionaAcaoConsultaItem(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControllerConsultaItem.getInstance().montaTela();
            }
        });
    }
    
    /**
     * Adiciona a a��o do bot�o de consultar usu�rios
     */
    private void adicionaAcaoConsultarUsuarios() {
        this.getInstanceView().adicionaAcaoConsultaUsuarios(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControllerConsultaUsuarios.getInstance().montaTela();
            }
        });
    }
    
    /**
     * Adiciona a a��o de consulta de pessoas
     */
    private void adicionaAcaoConsultarPessoas() {
        this.getInstanceView().adicionaAcaoConsultaPessoas(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControllerConsultaPessoa.getInstance().montaTela();
            }
        });
    }

    /**
     * Adiciona a a��o do bot�o de cadastrar solicitaç�s de abastecimento
     */
    private void adicionaAcaoCadastroSolicitacaoAbastecimento() {
        this.getInstanceView().adicionaAcaoCadastroSolicitacaoAbastecimento(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControllerSolicitacaoAbastecimento.getInstance().montaTela();
            }
        });
    }
    
    /**
     * Adiciona a a��o do bot�o de consultar solicitaç�s de abastecimento
     */
    private void adicionaAcaoConsultaSolicitacoesAbastecimento() {
        this.getInstanceView().adicionaAcaoConsultaSolicitacoesAbastecimento(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControllerConsultaSolicitacaoAbastecimento.getInstance().montaTela();
            }
        });
    }
    
    /**
     * Adiciona a a��o do bot�o de consultar as comandas
     */
    private void adicionaAcaoConsultaComandas() {
        this.getInstanceView().adicionaAcaoConsultaComandas(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControllerConsultaComanda.getInstance().montaTela();
            }
        });
    }
    
    private void adicionaAcaoVisualizarComanda() {
        getInstanceView().adicionaAcaoVisualizarComanda(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewIndex view = getInstanceView();
                    
                int indiceSelecionado = view.getTbComanda().getSelectedRow();
                    
                ControllerComanda controllerComanda = ControllerComanda.getInstance();
                    
                Comanda comanda = view.getTableModelComanda().getModelos().get(indiceSelecionado);
                    
                controllerComanda.setComanda(comanda);
                controllerComanda.montaTela();
            }
        });
    }

    /**
     * Adiciona a a��o de remover a comanda
     */
    private void adicionaAcaoRemoverComanda() {
        getInstanceView().adicionaAcaoRemoverComanda(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indice = getInstanceView().getTbComanda().getSelectedRow();
                
                if (indice < 0) {
                    getInstanceView().showMensagem("Selecione uma comanda!");
                }
                else {
                    Comanda comanda = getInstanceView().getTableModelComanda().get(indice);
                    ControllerComanda.getInstance().removerComanda(comanda);
                }
            }
        });
    }
            
    private void adicionaAcaoFecharComanda() {
        getInstanceView().adicionaAcaoFecharComanda(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewIndex view = getInstanceView();
                int indiceSelecionado = view.getTbComanda().getSelectedRow();
                if (indiceSelecionado < 0) {
                    view.showMensagem("Selecione uma comanda para fechar!");
                }
                else if (JOptionPane.showConfirmDialog(view, "Deseja fechar a comanda selecionada?") == JOptionPane.YES_OPTION) {
                    Comanda comanda = view.getTableModelComanda().get(indiceSelecionado);
                    ControllerComanda.getInstance().fechaComanda(comanda);
                    view.showMensagem("Valor final da comanda: R$ " + NumberUtils.formataValor(comanda.getValorFinal()));
                    view.getTableModelComanda().remove(indiceSelecionado);
                }
            }
        });
    }
    
    /**
     * Adiciona a a��o do bot�o de sair (logout)
     */
    private void adicionaAcaoLogout() {
        this.getInstanceView().adicionaAcaoLogout(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getInstanceView().dispose();
                ControllerLogin.setUsuarioLogado(null);
                ControllerLogin.getInstance().montaTela();
            }
        });
    }
    
    private void adicionaAcaoEditarItens() {
        this.getInstanceView().adicionaAcaoEditarItens(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (getInstanceView().temComandaSelecionada()) {
                    ControllerEditarItensComanda.getInstance(getInstanceView().getComandaSelecionada()).montaTela();
                }
                else {
                    getInstanceView().showMensagem("Selecione uma comanda para editar seus itens!");
                }
            }
        });
    }
    
    @Override
    protected ViewIndex getInstanceView() {
        return ViewIndex.getInstance();
    }
    
}
