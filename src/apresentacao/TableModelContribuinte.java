package apresentacao;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import dados.Contribuinte;
import persistencia.DBAlterar;
import persistencia.DBCadastro;
import persistencia.DBConnection;

public class TableModelContribuinte extends AbstractTableModel {
	List<Contribuinte> pessoas;
	private String[] colunas = {"Id", "CPF", "Nome", "Endereço",
			"Idade","Conta Bancaria","Ação"};
	
	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		return pessoas.size();
	}
	
	public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
	
	public boolean isCellEditable(int linha, int coluna) {
	    if (coluna < 1 || coluna == 1) {
	    	return false;
	    } 
	    else {
	    	return true;
	    }
	}
	
	public void setValueAt(Object valor, int linha, int coluna) {
		if(coluna != 6) {
			switch (coluna) {
			case 2:
				pessoas.get(linha).setNome((String)valor);
				break;
			case 3:
				pessoas.get(linha).setEndereco((String)valor);
				break;
			case 4:
				pessoas.get(linha).setIdade((int)valor);
				break;
			case 5:
				pessoas.get(linha).setContaBancaria((int)valor);
				break;
			}
			try {
	
				boolean r = new DBAlterar().alteraContribuinte(
						pessoas.get(linha).getNome(),
						pessoas.get(linha).getCpf(),
						pessoas.get(linha).getIdade(),
						pessoas.get(linha).getEndereco(),
						pessoas.get(linha).getContaBancaria(),
						pessoas.get(linha).getId()
						);
				if(r) {
					
					JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!");
				}
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    fireTableCellUpdated(linha, coluna);
		}
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
        switch(coluna){
        	case 0: return pessoas.get(linha).getId();
	        case 1: return pessoas.get(linha).getCpf();
	        case 2: return pessoas.get(linha).getNome();
	        case 3: return pessoas.get(linha).getEndereco();
	        case 4: return pessoas.get(linha).getIdade();
	        case 5: return pessoas.get(linha).getContaBancaria();
        }   
        return null;
	}

    public String getColumnName(int num){
        return this.colunas[num];
    }
 
	public TableModelContribuinte(List<Contribuinte> p) {
		pessoas = p;
		
		
	}
}

