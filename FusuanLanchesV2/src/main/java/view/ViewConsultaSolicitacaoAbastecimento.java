/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import javax.swing.JTable;
import model.SolicitacaoAbastecimento;

/**
 *
 * @author Ruan
 */
public class ViewConsultaSolicitacaoAbastecimento extends View {

    private static ViewConsultaSolicitacaoAbastecimento instance;
    
    private ViewConsultaSolicitacaoAbastecimento() {
        this.tableModel = new TableModelPadrao(new SolicitacaoAbastecimento());
        initComponents();
    }

    public static ViewConsultaSolicitacaoAbastecimento getInstance() {
        if (instance == null) {
            instance = new ViewConsultaSolicitacaoAbastecimento();
        }
        
        return instance;
    }

    public void setDadosTableModel(ArrayList<SolicitacaoAbastecimento> SolicitacaoAbastecimento) {
        this.tableModel.setModelos(SolicitacaoAbastecimento);
    }
    
    public void adicionaAcaoDuploCliqueRegistro(MouseAdapter mouseAdapter) {
        this.tbSolocitacaoAbastecimento.addMouseListener(mouseAdapter);
    }

    public JTable getTbSolocitacaoAbastecimento() {
        return tbSolocitacaoAbastecimento;
    }

    public TableModelPadrao<SolicitacaoAbastecimento> getTableModel() {
        return tableModel;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbSolocitacaoAbastecimento = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de solicitações de abastecimento");

        tbSolocitacaoAbastecimento.setModel(tableModel);
        jScrollPane1.setViewportView(tbSolocitacaoAbastecimento);

        jLabel1.setText("* Duplo clique sobre o registro para mais informações");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 911, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void run() {
        getInstance().setVisible(true);
    }

    private TableModelPadrao<SolicitacaoAbastecimento> tableModel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbSolocitacaoAbastecimento;
    // End of variables declaration//GEN-END:variables
}
