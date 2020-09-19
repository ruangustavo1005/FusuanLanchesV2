package view;

import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import model.Comanda;
import model.ComandaItem;
import model.Item;
import util.NumberUtils;

/**
 *
 * @author Ruan
 */
public class ViewEditarItensComanda extends View {

    static private ViewEditarItensComanda instance;
    
    private Comanda comanda;
    
    public ViewEditarItensComanda() {
        this.tableModelItens = new TableModelPadrao<>(new ComandaItem());
        this.formataCampo(txtQuantidadeEditar,    "###", '0');
        this.formataCampo(txtQuantidadeAdicionar, "###", '0');
        initComponents();
    }

    @Override
    public void setVisible(boolean b) {
        if (b) {
            this.tableModelItens.setModelos(comanda.getItens());
        }
        super.setVisible(b);
    }

    public static ViewEditarItensComanda getInstance() {
        if (instance == null) {
            instance = new ViewEditarItensComanda();
        }
        return instance;
    }

    public Comanda getComanda() {
        return comanda;
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        btnRemoverItem = new javax.swing.JButton();
        cbxItens = new javax.swing.JComboBox<>();
        btnAdicionarItem = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtQuantidadeEditar = new javax.swing.JFormattedTextField();
        btnAdiconarQuantidade = new javax.swing.JButton();
        btnRemoverQuantidade = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtQuantidadeAdicionar = new javax.swing.JFormattedTextField();
        jSeparator2 = new javax.swing.JSeparator();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edição dos itens da comanda");

        jTable.setModel(tableModelItens);
        jScrollPane1.setViewportView(jTable);

        btnRemoverItem.setText("Remover item");

        btnAdicionarItem.setText("Adicionar item");

        jLabel1.setText("Alterar quantidades:");

        btnAdiconarQuantidade.setText("Adicionar");

        btnRemoverQuantidade.setText("Diminuir");

        jLabel2.setText("Quantidade:");

        btnSalvar.setText("Salvar alterações");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxItens, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdicionarItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtQuantidadeEditar)
                    .addComponent(btnRemoverItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQuantidadeAdicionar))
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdiconarQuantidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRemoverQuantidade))
                            .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbxItens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtQuantidadeAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdicionarItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemoverItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQuantidadeEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdiconarQuantidade)
                            .addComponent(btnRemoverQuantidade))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void run() {
        getInstance().setVisible(true);
    }

    public TableModelPadrao<ComandaItem> getTableModelItens() {
        return tableModelItens;
    }

    public JTable getjTable() {
        return jTable;
    }

    public void setItensComboBox(List<Item> itens) {
        itens.forEach((Item item) -> {
            cbxItens.addItem(item);
        });
    }
    
    public void setTableModelItens(TableModelPadrao<ComandaItem> tableModelItens) {
        this.tableModelItens = tableModelItens;
    }

    public void setjTable(JTable jTable) {
        this.jTable = jTable;
    }

    public boolean temComandaItemSelecionado() {
        return this.jTable.getSelectedRow() != -1;
    }

    public ComandaItem getComandaItemSelecionado() {
        return this.tableModelItens.get(this.jTable.getSelectedRow());
    }
    
    public Item getItemSelecionado() {
        return (Item) this.cbxItens.getSelectedItem();
    }

    public int getQuantidadeAdicionar() {
        return NumberUtils.parseInt(txtQuantidadeAdicionar.getText());
    }

    public int getQuantidadeEditar() {
        return NumberUtils.parseInt(txtQuantidadeEditar.getText());
    }
    
    public void adicionaAcaoAdicionarItem(ActionListener actionListener) {
        this.btnAdicionarItem.addActionListener(actionListener);
    }
    
    public void adicionaAcaoRemoverItem(ActionListener actionListener) {
        this.btnRemoverItem.addActionListener(actionListener);
    }
    
    public void adicionaAcaoAdicionarQuantidade(ActionListener actionListener) {
        this.btnAdiconarQuantidade.addActionListener(actionListener);
    }
    
    public void adicionaAcaoRemoverQuantidade(ActionListener actionListener) {
        this.btnRemoverQuantidade.addActionListener(actionListener);
    }
    
    public void adicionaAcaoSalvar(ActionListener actionListener) {
        this.btnSalvar.addActionListener(actionListener);
    }
    
    private TableModelPadrao<ComandaItem> tableModelItens;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarItem;
    private javax.swing.JButton btnAdiconarQuantidade;
    private javax.swing.JButton btnRemoverItem;
    private javax.swing.JButton btnRemoverQuantidade;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<Item> cbxItens;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable;
    private javax.swing.JFormattedTextField txtQuantidadeAdicionar;
    private javax.swing.JFormattedTextField txtQuantidadeEditar;
    // End of variables declaration//GEN-END:variables
}
