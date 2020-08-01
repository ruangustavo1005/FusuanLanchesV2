package model;


/**
 * Modelo de logs do sistema
 * @author Ruan
 */
public class Log {
    
    private Usuario usuario;
    private int     tipo;
    private String  comando;
    private String  data;
    private boolean sucesso;

    public Log() {
        
    }

    public Log(Usuario usuario, int tipo, String comando, String data, boolean sucesso) {
        this.usuario = usuario;
        this.tipo = tipo;
        this.comando = comando;
        this.data = data;
        this.sucesso = sucesso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getComando() {
        return comando;
    }

    public void setComando(String comando) {
        this.comando = comando;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isSucesso() {
        return sucesso;
    }

    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }

    @Override
    public String toString() {
        return "Log: Tipo: " + tipo + ", Data: " + data + ", Comando: " + comando;
    }
    
}