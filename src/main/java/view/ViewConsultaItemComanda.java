package view;

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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbItensComanda = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbItensComanda.setModel(tableModel);
        jScrollPane1.setViewportView(tbItensComanda);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
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