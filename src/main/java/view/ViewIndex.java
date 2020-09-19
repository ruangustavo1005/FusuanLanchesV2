package view;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTable;
import model.Comanda;

/**
 * Tela principal do sistema
 * @author Ruan
 */
public class ViewIndex extends View {

    private static ViewIndex instance;
    
    private ViewIndex() {
        this.tableModelComanda = new TableModelPadrao(new Comanda());
        initComponents();
    }

    public static ViewIndex getInstance() {
        if (instance == null) {
            instance = new ViewIndex();
        }
        return instance;
    }
    
    /**
     * Adiciona o item de cadastro de usuário no menu
     */
    public void adicionaAcaoItemMenuCadastroUsuario(ActionListener actionListener) {
        this.imCadastroUsuario.addActionListener(actionListener);
    }
    
    /**
     * Adiciona o item de cadastro do item no menu
     */
    public void adicionaAcaoItemMenuCadastroItem(ActionListener actionListener) {
        this.imCadastroItem.addActionListener(actionListener);
    }
    
    /**
     * Adiciona a ação de nova comanda
     */
    public void adicionaAcaoNovaComanda(ActionListener actionListener){
        this.btnNovaComanda.addActionListener(actionListener);
    }
    
    /**
     * Adiciona a ação de editar configuraçãos
     */
    public void adicionaAcaoConfiguracoes(ActionListener actionListener){
        this.imConfiguracoes.addActionListener(actionListener);
    }
    
    /**
     * Adiciona a ação de consultar itens
     */
    public void adicionaAcaoConsultaItem(ActionListener actionListener){
        this.imConsultaItem.addActionListener(actionListener);
    }
    
    /**
     * Adiciona a ação de consultar os usuários
     */
    public void adicionaAcaoConsultaUsuarios(ActionListener actionListener){
        this.imConsultaUsuario.addActionListener(actionListener);
    }
    
    /**
     * Adiciona a ação de consultar as pessoas
     */
    public void adicionaAcaoConsultaPessoas(ActionListener actionListener){
        this.imConsultarPessoas.addActionListener(actionListener);
    }
    
    /**
     * Adiciona a ação de consultar as comandas
     */
    public void adicionaAcaoConsultaComandas(ActionListener actionListener){
        this.imConsultaComanda.addActionListener(actionListener);
    }
    
    /**
     * Adiciona a ação de cadastrar solicitação de abastecimento
     */
    public void adicionaAcaoCadastroSolicitacaoAbastecimento(ActionListener actionListener){
        this.btnCadastroSolicitacaoAbastecimento.addActionListener(actionListener);
    }
    
    /**
     * Adiciona a aç de consultar as solicitações de abastecimento
     */
    public void adicionaAcaoConsultaSolicitacoesAbastecimento(ActionListener actionListener){
        this.imConsultaSolicitacoesAbastecimento.addActionListener(actionListener);
    }
    
    /**
     * Adiciona a ação de visualizar comanda
     */
    public void adicionaAcaoVisualizarComanda(ActionListener actionListener){
        this.btnVisualizar.addActionListener(actionListener);
    }
    
    /**
     * Adiciona a ação de remover comanda
     */
    public void adicionaAcaoRemoverComanda(ActionListener actionListener){
        this.btnRemover.addActionListener(actionListener);
    }
    
    /**
     * Adiciona a ação de fechar comanda
     */
    public void adicionaAcaoFecharComanda(ActionListener actionListener){
        this.btnFechar.addActionListener(actionListener);
    }
    
    /**
     * Adiciona a ação de logout
     */
    public void adicionaAcaoLogout(ActionListener actionListener){
        this.imLogout.addActionListener(actionListener);
    }
    
    public void setUsuarioTela(String usuarioLogado) {
        this.lbUsuario.setText(usuarioLogado);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jMenuItem2 = new javax.swing.JMenuItem();
        btnNovaComanda = new javax.swing.JButton();
        btnCadastroSolicitacaoAbastecimento = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbComanda = new javax.swing.JTable();
        btnVisualizar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnFechar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbUsuario = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCadastros = new javax.swing.JMenu();
        imCadastroUsuario = new javax.swing.JMenuItem();
        imCadastroItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        imConsultaItem = new javax.swing.JMenuItem();
        imConsultaUsuario = new javax.swing.JMenuItem();
        imConsultarPessoas = new javax.swing.JMenuItem();
        imConsultaSolicitacoesAbastecimento = new javax.swing.JMenuItem();
        imConsultaComanda = new javax.swing.JMenuItem();
        mnOutros = new javax.swing.JMenu();
        imConfiguracoes = new javax.swing.JMenuItem();
        imLogout = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jLabel2.setText("jLabel2");

        jButton1.setText("jButton1");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fusuan Lanches");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnNovaComanda.setText("Nova Comanda");

        btnCadastroSolicitacaoAbastecimento.setText("Nova Solicitação de Abastecimento");

        tbComanda.setModel(tableModelComanda);
        jScrollPane1.setViewportView(tbComanda);

        btnVisualizar.setText("Visualizar");

        btnRemover.setText("Remover");

        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnFechar.setText("Fechar");

        jLabel1.setText("Usuário:");

        lbUsuario.setText("user");

        menuCadastros.setText("Cadastros");

        imCadastroUsuario.setText("Usuário");
        menuCadastros.add(imCadastroUsuario);

        imCadastroItem.setText("Item");
        menuCadastros.add(imCadastroItem);

        jMenuBar1.add(menuCadastros);

        jMenu2.setText("Consultas");

        imConsultaItem.setText("Itens");
        jMenu2.add(imConsultaItem);

        imConsultaUsuario.setText("Usuários");
        jMenu2.add(imConsultaUsuario);

        imConsultarPessoas.setText("Pessoas");
        jMenu2.add(imConsultarPessoas);

        imConsultaSolicitacoesAbastecimento.setText("Solicitações de abastecimento");
        jMenu2.add(imConsultaSolicitacoesAbastecimento);

        imConsultaComanda.setText("Comandas");
        jMenu2.add(imConsultaComanda);

        jMenuBar1.add(jMenu2);

        mnOutros.setText("Outros");

        imConfiguracoes.setText("Configurações");
        mnOutros.add(imConfiguracoes);

        imLogout.setText("Sair");
        mnOutros.add(imLogout);

        jMenuBar1.add(mnOutros);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovaComanda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFechar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVisualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemover)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCadastroSolicitacaoAbastecimento)
                        .addGap(159, 159, 159))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCadastroSolicitacaoAbastecimento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovaComanda)
                    .addComponent(btnRemover)
                    .addComponent(btnVisualizar)
                    .addComponent(btnFechar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(lbUsuario))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private TableModelPadrao<Comanda> tableModelComanda;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastroSolicitacaoAbastecimento;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnNovaComanda;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnVisualizar;
    private javax.swing.JMenuItem imCadastroItem;
    private javax.swing.JMenuItem imCadastroUsuario;
    private javax.swing.JMenuItem imConfiguracoes;
    private javax.swing.JMenuItem imConsultaComanda;
    private javax.swing.JMenuItem imConsultaItem;
    private javax.swing.JMenuItem imConsultaSolicitacoesAbastecimento;
    private javax.swing.JMenuItem imConsultaUsuario;
    private javax.swing.JMenuItem imConsultarPessoas;
    private javax.swing.JMenuItem imLogout;
    private javax.swing.JButton jButton1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbUsuario;
    private javax.swing.JMenu menuCadastros;
    private javax.swing.JMenu mnOutros;
    private javax.swing.JTable tbComanda;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        getInstance().setVisible(true);
    }

    public TableModelPadrao<Comanda> getTableModelComanda() {
        return tableModelComanda;
    }
    
    public JTable getTbComanda() {
        return tbComanda;
    }
    
    /**
     * Seta os dados na consulta das comandas
     */
    public void setDadosTableModel(ArrayList<Comanda> comandas) {
        this.tableModelComanda.setModelos(comandas);
    }
    
}