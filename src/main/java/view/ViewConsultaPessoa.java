package view;

import java.util.ArrayList;
import model.Pessoa;

/**
 * View de consulta da pessoa
 * @author Leonardo Alex Fusinato <leonardo.fusinato@edu.udesc.br>
 */
public class ViewConsultaPessoa extends View {
    
    public static ViewConsultaPessoa instance;

    private ViewConsultaPessoa(ArrayList<Pessoa> lista) {
        this.tableModelPessoa = new TableModelPessoa(lista);
        initComponents();
    }
    
    public static ViewConsultaPessoa getInstance(ArrayList<Pessoa> lista) {
        if (instance == null) {
            instance = new ViewConsultaPessoa(lista);
        }
        else {
            instance.setDadosTableModelPessoa(lista);
        }
        
        return instance;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbPessoas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Pessoas");

        tbPessoas.setModel(tableModelPessoa);
        jScrollPane1.setViewportView(tbPessoas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void setDadosTableModelPessoa(ArrayList<Pessoa> lista) {
        if (lista.size() > 0) {
            this.tableModelPessoa = new TableModelPessoa(lista);
        }
    }
    
    private TableModelPessoa tableModelPessoa;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbPessoas;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        instance.setVisible(true);
    }
    
}