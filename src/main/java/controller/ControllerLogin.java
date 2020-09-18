package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Usuario;
import view.ViewIndex;
import view.ViewLogin;

/**
 * Controlador das rotinas de login do sistema
 * @author Ruan
 */
public class ControllerLogin extends Controller {

    private static ControllerLogin instance;

    private static Usuario usuarioLogado;

    private ControllerLogin() {
        this.adicionaAcoesTela();
    }

    public static ControllerLogin getInstance() {
        if (instance == null) {
            instance = new ControllerLogin();
        }
        
        return instance;
    }
    
    /**
     * Adiciona as ações na tela
     */
    private void adicionaAcoesTela() {
        this.adicionaAcaoEntrarTela();
        this.adicionaAcaoCadastroTela();
    }
    
    /**
     * Adiciona a ação de click de entrar no sistema
     */
    private void adicionaAcaoEntrarTela() {
        this.getInstanceView().adicionaAcaoBotaoEntrar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Usuario usuario = getInstanceView().getModelFromTela();
                        usuario = validaLogin(usuario);
                
                if (usuario != null) {
                    setUsuarioLogado(usuario);
                    
                    if (usuario.isGerente()) {
                        ControllerMenu.getInstance().montaTela();
                    }
                    else if (usuario.isFornecedor()) {
                        ControllerConsultaSolicitacaoAbastecimento.getInstance().montaTela();
                    }
                    else if (usuario.isAtendente()) {
                        ControllerMenu.getInstance().montaTela();
                    }
                    else if (usuario.isCliente()) {
                        getInstanceView().showMensagem("Seu usuário não pode utilizar o sistema ainda! Aguarde por novas atualizações!");
                    }
                    
                    getInstanceView().dispose();
                }
                else {
                    getInstanceView().showMensagemDadosIncorretos();
                }
            }
        });
    }
    
    /**
     * Adiciona ação de click de cadastro de usuário
     */
    private void adicionaAcaoCadastroTela(){
        this.getInstanceView().adicionaAcaoBotaoCadastro(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControllerUsuario.getInstance().montaTela();
            }
        });
    }
    
    public static Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public static void setUsuarioLogado(Usuario usuarioLogado) {
        if (usuarioLogado != null) {
            ViewIndex.getInstance().setUsuarioTela(usuarioLogado.getPessoa().getNome());
        }
        ControllerLogin.usuarioLogado = usuarioLogado;
    }

    private Usuario validaLogin(Usuario usuario) {
        return ControllerUsuario.getInstance().getUsuarios().get(usuario.getLogin());
    }

    @Override
    protected ViewLogin getInstanceView() {
        return ViewLogin.getInstance();
    }
    
}