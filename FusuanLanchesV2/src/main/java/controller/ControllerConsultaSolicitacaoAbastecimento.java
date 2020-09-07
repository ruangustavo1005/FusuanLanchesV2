package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import model.SolicitacaoAbastecimento;
import util.DateUtils;
import view.ViewConsultaSolicitacaoAbastecimento;

/**
 *
 * @author Ruan
 */
public class ControllerConsultaSolicitacaoAbastecimento extends Controller {

    private static ControllerConsultaSolicitacaoAbastecimento instance;

    private ControllerConsultaSolicitacaoAbastecimento() {
        this.setDadosTableModel();
        this.adicionaAcaoDuploCliqueRegistro();
    }

    public static ControllerConsultaSolicitacaoAbastecimento getInstance() {
        if (instance == null) {
            instance = new ControllerConsultaSolicitacaoAbastecimento();
        }
        
        return instance;
    }
    
    private void adicionaAcaoDuploCliqueRegistro() {
        getInstanceView().adicionaAcaoDuploCliqueRegistro(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    ViewConsultaSolicitacaoAbastecimento view = getInstanceView();
                    
                    int indiceSelecionado = view.getTbSolocitacaoAbastecimento().getSelectedRow();
                    
                    ControllerSolicitacaoAbastecimento controllerSolicitacaoAbastecimento = ControllerSolicitacaoAbastecimento.getInstance();
                    
                    SolicitacaoAbastecimento solicitacaoAbastecimento = view.getTableModel().getModelos().get(indiceSelecionado);
                    
                    controllerSolicitacaoAbastecimento.setSolicitacaoAbastecimento(solicitacaoAbastecimento);
                    controllerSolicitacaoAbastecimento.montaTela();
                }
            }
            
        });
    }
    
    private void setDadosTableModel() {
        ArrayList<SolicitacaoAbastecimento> solicitacoes = ControllerSolicitacaoAbastecimento.getInstance().listar();
        
//      Ondernando pela data limite
        Collections.sort(solicitacoes, new Comparator<SolicitacaoAbastecimento>() {
            @Override
            public int compare(SolicitacaoAbastecimento s1, SolicitacaoAbastecimento s2) {
                if (DateUtils.dataToInt(s1.getDataLimite()) > DateUtils.dataToInt(s2.getDataLimite())) {
                    return 1;
                }
                else if (DateUtils.dataToInt(s1.getDataLimite()) < DateUtils.dataToInt(s2.getDataLimite())) {
                    return -1;
                }
                return 0;
            }
        });
        
        getInstanceView().setDadosTableModel(solicitacoes);
    }
    
    @Override
    protected ViewConsultaSolicitacaoAbastecimento getInstanceView() {
        return ViewConsultaSolicitacaoAbastecimento.getInstance();
    }
    
}