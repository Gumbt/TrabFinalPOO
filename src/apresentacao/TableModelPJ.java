package apresentacao;




import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import dados.PessoaJuridica;
import persistencia.DBAlterar;

public class TableModelPJ extends AbstractTableModel {
	List<PessoaJuridica> pj;
	private String[] colunas = {"Id", "CNPJ", "Nome", "Endereço",
			"N. Func"};
	
	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		return pj.size();
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
		switch (coluna) {
			case 2:
				pj.get(linha).setNomePJ((String)valor);
				break;
			case 3:
				pj.get(linha).setEndereco((String)valor);
				break;
			case 4:
				pj.get(linha).setNumFuncionarios((int)valor);
				break;
			}
		try {

			boolean r = new DBAlterar().alteraPJ(
					pj.get(linha).getNomePJ(),
					pj.get(linha).getEndereco(),
					pj.get(linha).getNumFuncionarios(),
					pj.get(linha).getId()
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

	@Override
	public Object getValueAt(int linha, int coluna) {
        switch(coluna){
        	case 0: return pj.get(linha).getId();
	        case 1: return pj.get(linha).getCnpj();
	        case 2: return pj.get(linha).getNomePJ();
	        case 3: return pj.get(linha).getEndereco();
	        case 4: return pj.get(linha).getNumFuncionarios();
        }   
        return null;
	}

    public String getColumnName(int num){
        return this.colunas[num];
    }
 
	public TableModelPJ(List<PessoaJuridica> p) {
		pj = p;
		
		
	}
}

