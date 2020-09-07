package view;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTable;
import model.AbastecimentoItem;
import model.Fornecedor;
import model.Gerente;
import model.Item;
import model.SolicitacaoAbastecimento;
import util.NumberUtils;

/**
 * View de cadastro de solicitação de abastecimento
 * @author Ruan
 */
public class ViewCadastroSolicitacaoAbastecimento extends View {

    private static ViewCadastroSolicitacaoAbastecimento instance;
    
    private SolicitacaoAbastecimento solicitacaoAbastecimento;
    
    private ViewCadastroSolicitacaoAbastecimento() {
        this.tableModelItens            = new TableModelPadrao(new Item());
        this.tableModelSolicitacaoItens = new TableModelPadrao(new AbastecimentoItem());
        initComponents();
        this.formataCampos();
    }

    public static ViewCadastroSolicitacaoAbastecimento getInstance() {
        if (instance == null) {
            instance = new ViewCadastroSolicitacaoAbastecimento();
        }
        return instance;
    }
    
    @Override
    public SolicitacaoAbastecimento getModelFromTela() {
        this.solicitacaoAbastecimento = new SolicitacaoAbastecimento();
        this.solicitacaoAbastecimento.setData(this.txtData.getText());
        this.solicitacaoAbastecimento.setDataLimite(this.txtDataLimite.getText());
        this.solicitacaoAbastecimento.setFornecedor((Fornecedor) this.cbFornecedor.getSelectedItem());
        this.solicitacaoAbastecimento.setGerente((Gerente) this.cbGerente.getSelectedItem());
        this.solicitacaoAbastecimento.setItens(this.tableModelSolicitacaoItens.getModelos());
        return this.solicitacaoAbastecimento;
    }

    public void setaDadosTabelaItens(ArrayList<Item> itens) {
        this.tableModelItens.setModelos(itens);
    }

    public void setaDadosTabelaSolicitacaoItens(ArrayList<AbastecimentoItem> solicitacaoItens) {
        this.tableModelSolicitacaoItens.setModelos(solicitacaoItens);
    }

    public void setaDadosComboBoxGerente(ArrayList<Gerente> gerentes) {
        gerentes.forEach(gerente -> {
            this.cbGerente.addItem(gerente);
        });
    }

    public void setaDadosComboBoxFornecedor(ArrayList<Fornecedor> fornecedores) {
        fornecedores.forEach(fornecedor -> {
            this.cbFornecedor.addItem(fornecedor);
        });
    }

    public SolicitacaoAbastecimento getSolicitacaoAbastecimento() {
        return solicitacaoAbastecimento;
    }

    public void setSolicitacaoAbastecimento(SolicitacaoAbastecimento solicitacaoAbastecimento) {
        this.solicitacaoAbastecimento = solicitacaoAbastecimento;
    }
    
    private void formataCampos() {
        this.formataCampo(txtQuantidade, CAMPO_CODIGO, '0');
        this.formataCampo(txtData,       CAMPO_DATA,   '0');
        this.formataCampo(txtDataLimite, CAMPO_DATA,   '0');
    }

    @Override
    public void setModelTela() {
        this.cbFornecedor.setSelectedItem(this.solicitacaoAbastecimento.getFornecedor());
        this.cbGerente.setSelectedItem(this.solicitacaoAbastecimento.getGerente());
        this.txtData.setText(this.solicitacaoAbastecimento.getData());
        this.txtDataLimite.setText(this.solicitacaoAbastecimento.getDataLimite());
    }
    
    public void habilitaCampos(boolean habilita) {
        this.cbFornecedor.setEnabled(habilita);
        this.cbGerente.setEnabled(habilita);
        this.txtData.setEnabled(habilita);
        this.txtDataLimite.setEnabled(habilita);
        this.txtQuantidade.setEnabled(habilita);
        this.btnAdicionarItem.setEnabled(habilita);
        this.btnRemover.setEnabled(habilita);
        this.btnFinalizar.setEnabled(habilita);
    }

    @Override
    public void dispose() {
        super.dispose();
        this.solicitacaoAbastecimento = null;
        this.habilitaCampos(true);
    }
    
    @Override
    protected void clearAll() {
        super.clearAll();   
        this.tableModelSolicitacaoItens = new TableModelPadrao(new AbastecimentoItem());
        this.tbSolicitacaoItens.setModel(this.tableModelSolicitacaoItens);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbItens = new javax.swing.JTable();
        btnAdicionarItem = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbSolicitacaoItens = new javax.swing.JTable();
        btnRemover = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JFormattedTextField();
        btnFinalizar = new javax.swing.JButton();
        panelDadosGerais = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cbGerente = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        cbFornecedor = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtData = new javax.swing.JFormattedTextField();
        txtDataLimite = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nova solicitação de abastecimento");

        tbItens.setModel(tableModelItens);
        jScrollPane1.setViewportView(tbItens);

        btnAdicionarItem.setText("Adicionar");

        tbSolicitacaoItens.setModel(tableModelSolicitacaoItens);
        jScrollPane2.setViewportView(tbSolicitacaoItens);

        btnRemover.setText("Remover");

        jLabel2.setText("Quantidade:");

        btnFinalizar.setText("Finalizar");

        jLabel3.setText("Gerente responsável:");

        jLabel1.setText("Fornecedor:");

        jLabel4.setText("Data:");

        jLabel5.setText("Data limite:");

        javax.swing.GroupLayout panelDadosGeraisLayout = new javax.swing.GroupLayout(panelDadosGerais);
        panelDadosGerais.setLayout(panelDadosGeraisLayout);
        panelDadosGeraisLayout.setHorizontalGroup(
            panelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDadosGeraisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbFornecedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbGerente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelDadosGeraisLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDadosGeraisLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDataLimite, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelDadosGeraisLayout.setVerticalGroup(
            panelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDadosGeraisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbGerente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtDataLimite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setText("Itens disponíveis:");

        jLabel7.setText("Itens adicionados:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRemover)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFinalizar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAdicionarItem))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(panelDadosGerais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelDadosGerais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionarItem)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnFinalizar)
                    .addComponent(btnRemover))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void run() {
        getInstance().setVisible(true);
    }

    public void adicionaAcaoAdicionarItem(ActionListener actionListener) {
        this.btnAdicionarItem.addActionListener(actionListener);
    }
    
    public void adicionaAcaoFinalizar(ActionListener actionListener) {
        this.btnFinalizar.addActionListener(actionListener);
    }
    
    public void adicionaAcaoRemover(ActionListener actionListener) {
        this.btnRemover.addActionListener(actionListener);
    }

    public TableModelPadrao<Item> getTableModelItens() {
        return tableModelItens;
    }

    public TableModelPadrao<AbastecimentoItem> getTableModelSolicitacaoItens() {
        return tableModelSolicitacaoItens;
    }

    public JTable getTbItens() {
        return tbItens;
    }

    public JTable getTbSolicitacaoItens() {
        return tbSolicitacaoItens;
    }

    public int getQuantidade() {
        return NumberUtils.parseInt(this.txtQuantidade.getText());
    }
    
    private TableModelPadrao<Item>              tableModelItens;
    private TableModelPadrao<AbastecimentoItem> tableModelSolicitacaoItens;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarItem;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JComboBox<Fornecedor> cbFornecedor;
    private javax.swing.JComboBox<Gerente> cbGerente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelDadosGerais;
    private javax.swing.JTable tbItens;
    private javax.swing.JTable tbSolicitacaoItens;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JFormattedTextField txtDataLimite;
    private javax.swing.JFormattedTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables
}
