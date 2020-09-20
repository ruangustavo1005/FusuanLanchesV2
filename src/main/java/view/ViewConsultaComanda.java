package view;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTable;
import model.Comanda;

/**
 * View de consulta da comanda
 * @author Leonardo <leonardo.fusinato@edu.udesc.br>
 */
public class ViewConsultaComanda extends View {
    
    private static ViewConsultaComanda instance;

    public ViewConsultaComanda() {
        this.tableModel = new TableModelPadrao(new Comanda());
        initComponents();
    }
    
    public static ViewConsultaComanda getInstance() {
        if (instance == null) {
            instance = new ViewConsultaComanda();
        }
        
        return instance;
    }
    
    public void setDadosTableModel(ArrayList dados) {
        this.tableModel.setModelos(dados);
    }
    
   public void adicionaAcaoRemover(ActionListener actionListener) {
      this.btnRemover.addActionListener(actionListener);
   }
   
   public void adicionaAcaoConsultaItens(ActionListener actionListener) {
      this.btnItensComanda.addActionListener(actionListener);
   }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbComandas = new javax.swing.JTable();
        btnRemover = new javax.swing.JButton();
        btnItensComanda = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Comandas");

        tbComandas.setModel(tableModel);
        jScrollPane1.setViewportView(tbComandas);

        btnRemover.setText("Remover");

        btnItensComanda.setText("Itens");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnItensComanda, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemover)
                    .addComponent(btnItensComanda))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void run() {
        ViewConsultaComanda.getInstance().setVisible(true);
    }
    
    public JTable getTable() {
        return tbComandas;
    }
    
    public TableModelPadrao<Comanda> getTableModel() {
        return this.tableModel;
    }
    
    private TableModelPadrao<Comanda> tableModel;
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnItensComanda;
    private javax.swing.JButton btnRemover;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbComandas;
    // End of variables declaration//GEN-END:variables

}