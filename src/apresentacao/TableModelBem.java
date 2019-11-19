package apresentacao;



import java.util.List;
import javax.swing.table.AbstractTableModel;
import dados.Bem;

public class TableModelBem extends AbstractTableModel {
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
	    if (coluna < 10) {
	    	return false;
	    } 
	    else {
	    	return true;
	    }
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
 
	public TableModelBem(List<Bem> p) {
		bens = p;
		
		
	}
}

