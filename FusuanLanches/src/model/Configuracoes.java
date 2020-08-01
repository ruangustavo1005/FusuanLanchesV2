package model;

/**
 * Modelo das configurações do sistema.
 * @author Ruan
 */
public class Configuracoes {
    
    private float valorGasto;
    private int   visitas;
    private float descontoValorGasto;
    private float descontoVisitas;
    private float descontoAniversario;
    private float descontoPagamentoVista;

    public Configuracoes() {
    
    }

    public Configuracoes(float valorGasto, int visitas, float descontoValorGasto, float descontoVisitas, float descontoAniversario, float descontoPagamentoVista) {
        this.valorGasto = valorGasto;
        this.visitas = visitas;
        this.descontoValorGasto = descontoValorGasto;
        this.descontoVisitas = descontoVisitas;
        this.descontoAniversario = descontoAniversario;
        this.descontoPagamentoVista = descontoPagamentoVista;
    }

    public float getValorGasto() {
        return valorGasto;
    }

    public void setValorGasto(float valorGasto) {
        this.valorGasto = valorGasto;
    }

    public int getVisitas() {
        return visitas;
    }

    public void setVisitas(int visitas) {
        this.visitas = visitas;
    }

    public float getDescontoValorGasto() {
        return descontoValorGasto;
    }

    public void setDescontoValorGasto(float descontoValorGasto) {
        this.descontoValorGasto = descontoValorGasto;
    }

    public float getDescontoVisitas() {
        return descontoVisitas;
    }

    public void setDescontoVisitas(float descontoVisitas) {
        this.descontoVisitas = descontoVisitas;
    }

    public float getDescontoAniversario() {
        return descontoAniversario;
    }

    public void setDescontoAniversario(float descontoAniversario) {
        this.descontoAniversario = descontoAniversario;
    }

    public float getDescontoPagamentoVista() {
        return descontoPagamentoVista;
    }

    public void setDescontoPagamentoVista(float descontoPagamentoVista) {
        this.descontoPagamentoVista = descontoPagamentoVista;
    }

    @Override
    public String toString() {
        return "Configuracoes{" + "valorGasto=" + valorGasto + ", visitas=" + visitas + ", descontoValorGasto=" + descontoValorGasto + ", descontoVisitas=" + descontoVisitas + ", descontoAniversario=" + descontoAniversario + ", descontoPagamentoVista=" + descontoPagamentoVista + '}';
    }
    
}