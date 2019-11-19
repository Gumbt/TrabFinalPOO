package apresentacao;



import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import dados.Dependente;
import persistencia.DBAlterar;

public class TableModelDependente extends AbstractTableModel {
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
	    if (coluna < 1 || coluna == 2) {
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
			boolean r = new DBAlterar().alteraDependente(
					dependentes.get(linha).getNome(),
					dependentes.get(linha).getIdade(),
					dependentes.get(linha).getEndereco(),
					dependentes.get(linha).getId()
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
 
	public TableModelDependente(List<Dependente> p) {
		dependentes = p;
		
		
	}
}

