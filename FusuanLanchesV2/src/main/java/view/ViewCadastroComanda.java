package view;

import exceptions.ExceptionMetodoNaoImplementado;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import model.Atendente;
import model.Cliente;
import model.Comanda;
import model.ComandaItem;
import model.Item;
import util.NumberUtils;

/**
 * View da comanda
 *
 * @author Leonardo Alex Fusinato <leonardo.fusinato@edu.udesc.br>
 */
public class ViewCadastroComanda extends View {

    public static ViewCadastroComanda instance;
    
    private Comanda comanda;

    private ViewCadastroComanda() {
        this.tableModelComandaItem = new TableModelPadrao(new ComandaItem());
        initComponents();
        this.formataCampos();
    }
    
    /**
     * Formata os campos da tela
     */
    private void formataCampos() {
        this.formataCampo(txtMesa,   "###",      '0');
        this.formataCampo(txtData,   CAMPO_DATA, '0');
    }
    
    @Override
    public Comanda getModelFromTela() {
        this.comanda = new Comanda();
        this.comanda.setCliente((Cliente) this.listCliente.getSelectedItem());
        this.comanda.setAtendente((Atendente) this.listAtendente.getSelectedItem());
        this.comanda.setData(this.txtData.getText());
        this.comanda.setMesa(NumberUtils.parseInt(this.txtMesa.getText()));
        this.comanda.setItens(this.tableModelComandaItem.getModelos());
        return this.comanda;
    }

    @Override
    public void setModelTela() {
        this.txtData.setText(comanda.getData());
        this.txtMesa.setText(String.valueOf(comanda.getMesa()));
        this.listAtendente.setSelectedItem(this.comanda.getAtendente());
        this.listCliente.setSelectedItem(this.comanda.getCliente());
        this.tableModelComandaItem.setModelos(this.comanda.getItens());
    }
    
    /**
     * Define se habilita ou desabilita os campos
     */
    public void habilitaCampos(boolean habilita) {
        this.txtData.setEditable(habilita);
        this.txtMesa.setEditable(habilita);
        this.txtQuantidade.setEditable(habilita);
        this.listAtendente.setEditable(habilita);
        this.listCliente.setEditable(habilita);
        this.listItens.setEditable(habilita);
        this.btnAddItem.setEnabled(habilita);
        this.btnCadastrar.setEnabled(habilita);
        this.btnRemover.setEnabled(habilita);
    }

    @Override
    protected void clearAll() {
        super.clearAll(); 
        this.tableModelComandaItem = new TableModelPadrao(new ComandaItem());
        this.tbComandaItem.setModel(this.tableModelComandaItem);
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }
    
    /**
     * Adiciona a ação de adicionar item na comanda
     */
    public void adicionaAcaoAddItem(ActionListener actionListener) {
        this.btnAddItem.addActionListener(actionListener);
    }
    
    /**
     * Adiciona a ação de remover o item da comanda
     */
    public void adicionaAcaoRemoveItem(ActionListener actionListener) {
        this.btnRemover.addActionListener(actionListener);
    }
    
    /**
     * Adiciona a ação de cadastrar a comanda
     */
    public void adicionaAcaoCadastrar(ActionListener actionListener) {
        this.btnCadastrar.addActionListener(actionListener);
    }
    
    /**
     * Seta a lista dos itens
     */
    public void setListaItens(ArrayList<Item> itens) {
        for (Item item : itens) {
            this.listItens.addItem(item);
        }
    }
    
    /**
     * Seta a lista dos atendentes
     */
    public void setListaAtendentes(ArrayList<Atendente> atendentes) {
        for(Atendente atendente : atendentes) {
            this.listAtendente.addItem(atendente);
        }
    }
    
    /**
     * Seta a lista de clientes
     */
    public void setListaClientes(ArrayList<Cliente> clientes) {
        for(Cliente cliente : clientes) {
            this.listCliente.addItem(cliente);
        }
    }

    public static ViewCadastroComanda getInstance(){
        if (instance == null) {
            instance = new ViewCadastroComanda();
        }
        return instance;
    }
    
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        listAtendente = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        listCliente = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtData = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbComandaItem = new javax.swing.JTable();
        listItens = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        btnRemover = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnAddItem = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtMesa = new javax.swing.JFormattedTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Comanda");

        jLabel2.setText("Atendente:");

        jLabel3.setText("Cliente:");

        jLabel4.setText("Data:");

        txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        jLabel5.setText("Itens da Comanda");

        btnCadastrar.setText("Cadastrar");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tbComandaItem.setModel(tableModelComandaItem);
        jScrollPane2.setViewportView(tbComandaItem);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel6.setText("Item");

        jLabel7.setText("Quantidade");

        btnRemover.setText("Remover");

        btnAddItem.setText("Adicionar");

        jLabel8.setText("Mesa:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(listItens, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnAddItem))
                                            .addComponent(jLabel7))
                                        .addGap(18, 18, 18)))
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnRemover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnCadastrar)))
                            .addComponent(jLabel6)))
                    .addComponent(jSeparator1))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(288, 288, 288)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtData))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(listAtendente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(listCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(227, 227, 227))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txtMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(listAtendente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(50, 50, 50)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(listItens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddItem)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnRemover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private TableModelPadrao<ComandaItem> tableModelComandaItem;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddItem;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<Atendente> listAtendente;
    private javax.swing.JComboBox<Cliente> listCliente;
    private javax.swing.JComboBox<Item> listItens;
    private javax.swing.JTable tbComandaItem;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JFormattedTextField txtMesa;
    private javax.swing.JFormattedTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables

    public int getQuantidade() {
        return NumberUtils.parseInt(this.txtQuantidade.getText());
    }
    
    public JComboBox<Item> getListaItens() {
        return this.listItens;
    }
    
    public TableModelPadrao<ComandaItem> getTableModelComandaItem() {
        return tableModelComandaItem;
    }
    
    @Override
    public void run() {
        getInstance().setVisible(true);
    }

}