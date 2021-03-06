package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Usuario;
import util.MD5;
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
     * Adiciona as a��es na tela
     */
    private void adicionaAcoesTela() {
        this.adicionaAcaoEntrarTela();
        this.adicionaAcaoCadastroTela();
        this.adicionaAcaoEsqueceuSenha();
    }
    
    /**
     * Adiciona a a��o de click de entrar no sistema
     */
    private void adicionaAcaoEntrarTela() {
        this.getInstanceView().adicionaAcaoBotaoEntrar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Usuario usuarioTela = getInstanceView().getModelFromTela();
                Usuario usuario = validaLogin(usuarioTela);
                
                if (usuario != null && usuarioTela.getSenha().equals(usuario.getSenha())) {
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
                        getInstanceView().showMensagem("Seu usu�rio n�o pode utilizar o sistema ainda! Aguarde por novas atualiza��es!");
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
     * Adiciona a��o de click de cadastro de usu�rio
     */
    private void adicionaAcaoCadastroTela() {
        this.getInstanceView().adicionaAcaoBotaoCadastro(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControllerUsuario.getInstance().montaTela();
            }
        });
    }
    
    /**
     * Adiciona a��o de esquecimento da senha
     */
    private void adicionaAcaoEsqueceuSenha() {
        this.getInstanceView().adicionaAcaoEsqueceuSenha(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Usuario usuarioTela = getInstanceView().getModelFromTela();
                if(!usuarioTela.getLogin().isEmpty()) {
                    Usuario usuario = validaLogin(usuarioTela);
                    if(usuario != null) {
                        ControllerEsqueceuSenha.getInstance().setUsuarioOld(usuario);
                        ControllerEsqueceuSenha.getInstance().montaTela();
                    } else {
                        getInstanceView().showMensagem("Usu�rio n�o encontrado");
                    }
                } else {
                    getInstanceView().showMensagem("Informe o login!");
                }
                
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