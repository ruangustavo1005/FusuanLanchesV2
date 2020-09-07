package view;

import java.util.ArrayList;
import model.Usuario;

/**
 * View de consulta do usuário
 * @author Leonardo Alex Fusinato <leonardo.fusinato@edu.udesc.br>
 */
public class ViewConsultaUsuario extends View {

    public static ViewConsultaUsuario instance;
    
    public static ViewConsultaUsuario getInstance() {
        if(instance == null) {
            instance = new ViewConsultaUsuario();
        }
        return instance;
    }
    
    private ViewConsultaUsuario() {
        this.tableModel = new TableModelPadrao(new Usuario());
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableUsuarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Usuários");

        tableUsuarios.setModel(tableModel);
        jScrollPane1.setViewportView(tableUsuarios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 791, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private TableModelPadrao<Usuario> tableModel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableUsuarios;
    // End of variables declaration//GEN-END:variables

    
    @Override
    public void run() {
        getInstance().setVisible(true);
    }
    
    public void setDadosTableModel(ArrayList<Usuario> usuarios) {
        this.tableModel.setModelos(usuarios);
    }
    
}