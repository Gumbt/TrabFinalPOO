package apresentacao;



import java.util.List;
import javax.swing.table.AbstractTableModel;
import dados.NotaFiscal;


public class TableModelNotaFiscal extends AbstractTableModel {
	List<NotaFiscal> notafiscal;
	private String[] colunas = {"Id", "Descrição", "Num. Protoc.", "Valor", "CNPJ"};
	
	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		return notafiscal.size();
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
        	case 0: return notafiscal.get(linha).getId();
	        case 1: return notafiscal.get(linha).getDescricao();
	        case 2: return notafiscal.get(linha).getNumProtocolo();
	        case 3: return notafiscal.get(linha).getValor();
	        case 4: return notafiscal.get(linha).getCnpj();
        }   
        return null;
	}

    public String getColumnName(int num){
        return this.colunas[num];
    }
 
	public TableModelNotaFiscal(List<NotaFiscal> p) {
		notafiscal = p;
		
		
	}
}

