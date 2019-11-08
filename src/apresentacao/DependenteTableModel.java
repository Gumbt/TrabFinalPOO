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

import dados.Bem;
import dados.Contribuinte;
import dados.Dependente;
import persistencia.DBConnection;

public class DependenteTableModel extends AbstractTableModel {
	List<Dependente> dependentes;
	private String[] colunas = {"Id", "Nome", "Cpf", "Idade", "Endereço"};
	
	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		return dependentes.size();
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
		switch (coluna) {
			case 1:
				dependentes.get(linha).setNome((String)valor);
				break;
			case 3:
				dependentes.get(linha).setIdade((int)valor);
				break;
			case 4:
				dependentes.get(linha).setEndereco((String)valor);
				break;
		}
		try {
			Connection con = DBConnection.faz_conexao();
			String sql = "update dependente set nome = ?, idade = ?, endereco = ? where id_dependente = ?";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, dependentes.get(linha).getNome());
			stmt.setInt(2, dependentes.get(linha).getIdade());
			stmt.setString(3, dependentes.get(linha).getEndereco());

			stmt.setInt(4, dependentes.get(linha).getId());

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

	@Override
	public Object getValueAt(int linha, int coluna) {
        switch(coluna){
        	case 0: return dependentes.get(linha).getId();
	        case 1: return dependentes.get(linha).getNome();
	        case 2: return dependentes.get(linha).getCpf();
	        case 3: return dependentes.get(linha).getIdade();
	        case 4: return dependentes.get(linha).getEndereco();
        }   
        return null;
	}

    public String getColumnName(int num){
        return this.colunas[num];
    }
 
	public DependenteTableModel(List<Dependente> p) {
		dependentes = p;
		
		
	}
}

