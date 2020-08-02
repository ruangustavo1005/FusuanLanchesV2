package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Usuario;
import util.MD5;
import view.ViewLogin;

/**
 * Controlador das rotinas de login do sistema
 * @author Ruan
 */
public class ControllerLogin extends Controller {

    private static Usuario usuarioLogado;
    
    private ViewLogin viewLogin;

    public ControllerLogin() {
        this.viewLogin = new ViewLogin();
        this.adicionaAcoesTela();
    }
    
    @Override
    public void montaTela() {
        this.viewLogin.setVisible(true);
    }
    
    private void adicionaAcoesTela() {
        this.adicionaAcaoEntrarTela();
    }
    
    private void adicionaAcaoEntrarTela() {
        this.viewLogin.adicionaAcaoBotaoEntrar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Usuario usuario = getViewLogin().getModelFromTela();
                if (validaLogin(usuario)) {
//                  Acho que seria mas persistir antes pra salvar os dados da pessoa, que são mais importantes.
                    usuarioLogado = usuario;
                    getViewLogin().setVisible(false);
                }
                else {
                    getViewLogin().showMensagemDadosIncorretos();
                }
            }
        });
    }
    
    public static Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public static void setUsuarioLogado(Usuario usuarioLogado) {
        ControllerLogin.usuarioLogado = usuarioLogado;
    }

    public ViewLogin getViewLogin() {
        return viewLogin;
    }
    
    private boolean validaLogin(Usuario usuario) {
        boolean retorno = false;
        
        if (usuario.getLogin().equals("123") && usuario.getSenha().equals(MD5.md5("123"))) {
            retorno = true;
        }
        
        return retorno;
    }
    
}
