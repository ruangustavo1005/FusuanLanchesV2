package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Comanda;
import view.ViewIndex;

/**
 * Controller do index
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
     * Adiciona as ações na tela
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
        this.adicionaAcaoVisualizarComanda();
        this.adicionaAcaoRemoverComanda();
        this.adicionaAcaoFecharComanda();
        this.adicionaAcaoLogout();
    }
    
    /**
     * Adiciona a ação de nova comanda
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
     * Adiciona a ação do item menu de cadastro de usuário
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
     * Adiciona a ação do item menu de cadastro do item
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
     * Adiciona a ação do botão de editar configurações
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
     * Adiciona a ação do botão de consultar itens
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
     * Adiciona a ação do botão de consultar usuários
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
     * Adiciona a ação de consulta de pessoas
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
     * Adiciona a ação do botão de cadastrar solicitações de abastecimento
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
     * Adiciona a ação do botão de consultar solicitações de abastecimento
     */
    private void adicionaAcaoConsultaSolicitacoesAbastecimento() {
        this.getInstanceView().adicionaAcaoConsultaSolicitacoesAbastecimento(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControllerConsultaSolicitacaoAbastecimento.getInstance().montaTela();
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
     * Adiciona a ação de remover a comanda
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
                    getInstanceView().getTableModelComanda().remove(indice);
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
                    ControllerComanda.getInstance().getComanda(indiceSelecionado).setAberto(false);
                    view.getTableModelComanda().remove(indiceSelecionado);
                }
            }
        });
    }
    
    /**
     * Adiciona a ação do botão de sair (logout)
     */
    private void adicionaAcaoLogout() {
        this.getInstanceView().adicionaAcaoLogout(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getInstanceView().dispose();
                ControllerLogin.getInstance().setUsuarioLogado(null);
                ControllerLogin.getInstance().montaTela();
            }
        });
    }
    
    @Override
    protected ViewIndex getInstanceView() {
        return ViewIndex.getInstance();
    }
    
}
