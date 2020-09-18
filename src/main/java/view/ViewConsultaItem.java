package view;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTable;
import model.Item;

/**
 *
 * @author Ruan
 */
public class ViewConsultaItem extends View {

    private static ViewConsultaItem instance;

    private ViewConsultaItem() {
        this.tableModel = new TableModelPadrao(new Item());
        initComponents();
    }

    public static ViewConsultaItem getInstance() {
        if (instance == null) {
            instance = new ViewConsultaItem();
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
        jTable1 = new javax.swing.JTable();
        btnRemoverItem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Itens");

        jTable1.setModel(tableModel);
        jScrollPane1.setViewportView(jTable1);

        btnRemoverItem.setText("Remover item");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRemoverItem)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRemoverItem)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void run() {
        ViewConsultaItem.getInstance().setVisible(true);
    }

    public void adicionaAcaoRemoverTela(ActionListener actionListener) {
        this.btnRemoverItem.addActionListener(actionListener);
    }

    public TableModelPadrao<Item> getTableModel() {
        return this.tableModel;
    }

    public JTable getTable() {
        return jTable1;
    }
    
    private TableModelPadrao<Item> tableModel;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRemoverItem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
