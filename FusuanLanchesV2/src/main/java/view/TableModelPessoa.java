package view;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Pessoa;

/**
 *
 * @author Ruan
 */
public class TableModelPessoa extends AbstractTableModel {

    private ArrayList<Pessoa> pessoas;

    public TableModelPessoa() {
        this.pessoas = new ArrayList<>();
    }

    public TableModelPessoa(ArrayList<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
    
    @Override
    public int getRowCount() {
        return this.pessoas.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object retorno = null;
        
        Pessoa pessoa = this.pessoas.get(rowIndex);
        
        switch (columnIndex) {
            case 0 : {
                retorno = pessoa.getCpfCnpj();
            } break;
            case 1 : {
                retorno = pessoa.getNome();
            } break;
            case 2 : {
                retorno = pessoa.getEmail();
            } break;
        }
        
        return retorno;
    }

    @Override
    public String getColumnName(int column) {
        String retorno = "";
        
        switch (column) {
            case 0 : {
                retorno = "CPF/CNPJ";
            } break;
            case 1 : {
                retorno = "Nome";
            } break;
            case 2 : {
                retorno = "E-mail";
            } break;
        }
        
        return retorno;
    }
    
}