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
import persistencia.DBConnection;

public class BemTableModel extends AbstractTableModel {
	List<Bem> bens;
	private String[] colunas = {"Id", "Nome", "Tipo", "Valor"};
	
	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		return bens.size();
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
				bens.get(linha).setNome((String)valor);
				break;
			case 2:
				bens.get(linha).setTipo((String)valor);
				break;
			case 3:
				bens.get(linha).setValor((float)valor);
				break;
		}
		try {
			Connection con = DBConnection.faz_conexao();
			String sql = "update bem set nome = ?, tipo = ?, valor = ? where id_bem = ?";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, bens.get(linha).getNome());
			stmt.setString(2, bens.get(linha).getTipo());
			stmt.setFloat(3, bens.get(linha).getValor());

			stmt.setInt(4, bens.get(linha).getId());

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
        	case 0: return bens.get(linha).getId();
	        case 1: return bens.get(linha).getNome();
	        case 2: return bens.get(linha).getTipo();
	        case 3: return bens.get(linha).getValor();
        }   
        return null;
	}

    public String getColumnName(int num){
        return this.colunas[num];
    }
 
	public BemTableModel(List<Bem> p) {
		bens = p;
		
		
	}
}

