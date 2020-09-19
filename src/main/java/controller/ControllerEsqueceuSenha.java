package controller;

import dao.Dao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Usuario;
import util.MD5;
import view.ViewEsqueceuSenha;

/**
 * Controller de esquecimento da senha
 * @author Leonardo
 */
public class ControllerEsqueceuSenha extends Controller {
    
    private static ControllerEsqueceuSenha instance;
    
    private Usuario usuarioOld;
    
    private Dao<Usuario> usuarios;

    public ControllerEsqueceuSenha() {
        usuarios = new Dao<>(Usuario.class);
        this.adicionaAcoesTela();
    }

    public Usuario getUsuarioOld() {
        return usuarioOld;
    }
    
    public void setUsuarioOld(Usuario usuarioOld) {
        this.usuarioOld = usuarioOld;
    }
    
    public static ControllerEsqueceuSenha getInstance() {
        if (instance == null) {
            instance = new ControllerEsqueceuSenha();
        }
        return instance;
    }

    @Override
    protected ViewEsqueceuSenha getInstanceView() {
        return ViewEsqueceuSenha.getInstance();
    }
    
    /**
     * Adiciona as ações na tela
     */
    private void adicionaAcoesTela() {
        this.adicionaAcaoConfirmar();
    }
    
    /**
     * Adiciona o click de confirmar na tela
     */
    private void adicionaAcaoConfirmar() {
        this.getInstanceView().adicionaAcaoConfirmar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(MD5.md5(getInstanceView().getSenha()).equals(MD5.md5(getInstanceView().getConfirmSenha()))) {
                    atualizaSenha();
                    getInstanceView().showMensagem("Senha alterada com sucesso!");
                    getInstanceView().dispose();
                } else {
                    getInstanceView().showMensagem("As senhas devem ser iguais!");
                }
            }
        });
    }
    
    /**
     * Atualiza a senha do usuário
     */
    private void atualizaSenha() {
        this.getUsuarioOld().setSenha(getInstanceView().getSenha());
        this.usuarios.update(this.getUsuarioOld());
    }
    
}