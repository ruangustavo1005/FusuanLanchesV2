package controller;

import dao.Dao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.Atendente;
import model.Cliente;
import model.Fornecedor;
import model.Gerente;
import model.Usuario;
import util.MD5;
import view.ViewCadastroUsuario;

/**
 * Controlador das rotinas de usu�rio do sistema
 * @author Ruan
 */
public class ControllerUsuario extends Controller {
    
    private static ControllerUsuario instance;
    
    private Usuario usuario;
    
    private Dao<Usuario> usuarios;

    private ControllerUsuario() {
        usuarios = new Dao<>(Usuario.class);
        this.adicionaAcoesTela();
    }

    public static ControllerUsuario getInstance() {
        if (instance == null) {
            instance = new ControllerUsuario();
        }
        return instance;
    }
    
    /**
     * Adiciona as a��es na tela
     */
    private void adicionaAcoesTela(){
        this.adicionaAcaoCadastrar();
        this.adicionaAcaoCancelar();
    }
    
    /**
     * Adiciona a a��o de cadastrar na tela
     */
    private void adicionaAcaoCadastrar() {
        this.getInstanceView().adicionaAcaoBotaoCadastrar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(senhasIguais()){
                    if(salvar()){
                        getInstanceView().showMensagem("Usu�rio adicionado com sucesso!");
                        getInstanceView().dispose();
                    }else{
                        getInstanceView().showMensagem("Houve um erro ao cadastrar o usu�rio");
                    }
                }else{
                    getInstanceView().showMensagem("As senhas devem ser iguais!");
                }
            }
        });
    }
    
    /**
     * Valida se as senhas s�o iguais
     */
    private boolean senhasIguais() {
        return getInstanceView().getModelFromTela().getSenha().equals(MD5.md5(getInstanceView().getSenhaConfirmacao()));
    }
    
    /**
     * Adiciona a a��o de cancelar na tela
     */
    private void adicionaAcaoCancelar(){
        this.getInstanceView().adicionaAcaoBotaoCancelar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                getInstanceView().setVisible(false);
            }
        });
    }

    @Override
    public void montaTela() {
        this.setDadosComboBoxTipoUsuario();
        super.montaTela();
    }

    private void setDadosComboBoxTipoUsuario() {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Cliente");
        lista.add("Fornecedor");
        lista.add("Gerente");
        lista.add("Atendente");
        getInstanceView().setDadosComboBoxTipoUsuario(lista);
    }
    
    @Override
    protected ViewCadastroUsuario getInstanceView() {
        return ViewCadastroUsuario.getInstance();
    }
    
    /**
     * Salva o item no ArrayList
     * @return boolean
     */
    private boolean salvar() {
        boolean retorno = false;
        
        Usuario usuario = this.getInstanceView().getModelFromTela();
        
        if (usuario.isCliente()) {
            retorno = ControllerCliente.getInstance().salvarCliente((Cliente) usuario.getPessoa());
        }
        else if (usuario.isGerente()) {
            retorno = ControllerGerente.getInstance().salvarGerente((Gerente) usuario.getPessoa());
        }
        else if (usuario.isFornecedor()) {
            retorno = ControllerFornecedor.getInstance().salvarFornecedor((Fornecedor) usuario.getPessoa());
        }
        else if (usuario.isAtendente()) {
            retorno = ControllerAtendente.getInstance().salvarAtendente((Atendente) usuario.getPessoa());
        }
        
        if (retorno) {
            retorno = this.usuarios.add(usuario);
        }
        
        return retorno;
    }
    
    public ArrayList<Usuario> listar() {
        return this.usuarios.get();
    }

    public Dao<Usuario> getUsuarios() {
        return usuarios;
    }

}