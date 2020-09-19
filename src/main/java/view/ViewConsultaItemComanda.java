package view;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTable;
import model.ComandaItem;

/**
 * View de consulta dos itens da comanda
 * @author Leonardo <leonardo.fusinato@edu.udesc.br>
 */
public class ViewConsultaItemComanda extends View {

     private static ViewConsultaItemComanda instance;
    
    public ViewConsultaItemComanda() {
        this.tableModel = new TableModelPadrao(new ComandaItem());
        initComponents();
    }
    
    public static ViewConsultaItemComanda getInstance() {
        if (instance == null) {
            instance = new ViewConsultaItemComanda();
        }
        
        return instance;
    }
    
    public void setDadosTableModel(ArrayList dados) {
        this.tableModel.setModelos(dados);
    }
    
    public void adicionaAcaoAdicionarItem(ActionListener actionListener) {
      this.btnAdicionar.addActionListener(actionListener);
    }
    
    public void adicionaAcaoRemover(ActionListener actionListener) {
      this.btnRemover.addActionListener(actionListener);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbItensComanda = new javax.swing.JTable();
        btnRemover = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbItensComanda.setModel(tableModel);
        jScrollPane1.setViewportView(tbItensComanda);

        btnRemover.setText("Remover");

        btnAdicionar.setText("Adicionar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemover)
                    .addComponent(btnAdicionar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbItensComanda;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        ViewConsultaItemComanda.getInstance().setVisible(true);
    }
    
    public JTable getTable() {
        return tbItensComanda;
    }
    
    public TableModelPadrao<ComandaItem> getTableModel() {
        return this.tableModel;
    }
    
    private TableModelPadrao<ComandaItem> tableModel;
    
}