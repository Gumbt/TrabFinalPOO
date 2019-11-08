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
import persistencia.DBConnection;

public class ContribuinteTableModel extends AbstractTableModel {
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
	    if (coluna < 1) {
	    	return false;
	    } 
	    else {
	    	return true;
	    }
	}
	
	public void setValueAt(Object valor, int linha, int coluna) {
		if(coluna != 0 && coluna != 6 && coluna != 1 ) {
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
				Connection con = DBConnection.faz_conexao();
				String sql = "update contribuinte set nome = ?, cpf = ?, idade = ?,endereco = ?,conta_bancaria = ? where id_contribuinte = ?";
				
				PreparedStatement stmt = con.prepareStatement(sql);
				
				stmt.setString(1, pessoas.get(linha).getNome());
				stmt.setString(2, pessoas.get(linha).getCpf());
				stmt.setInt(3, pessoas.get(linha).getIdade());
				stmt.setString(4, pessoas.get(linha).getEndereco());
				stmt.setInt(5, pessoas.get(linha).getContaBancaria());
				stmt.setInt(6, pessoas.get(linha).getId());
	
				stmt.execute();
				stmt.close();
				con.close();
				
				JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!");
				
				
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
 
	public ContribuinteTableModel(List<Contribuinte> p) {
		pessoas = p;
		
		
	}
}

