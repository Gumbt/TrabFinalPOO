package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DBDeleta {

	private Connection con;
	
	public DBDeleta(){
		try {
			con = DBConnection.faz_conexao();
					
		} catch (SQLException f) {
			// TODO Auto-generated catch block
			f.printStackTrace();
		}
	}
	public boolean deletaBem(int idBem) throws SQLException {
		String sql = "delete from bem where id_bem = ?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setInt(1, idBem);

		stmt.execute();
		stmt.close();
		con.close();
		
		return true;
	}
	public boolean deletaDependente(int idDependente) throws SQLException {
		String sql = "delete from dependente where id_dependente = ?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setInt(1, idDependente);

		stmt.execute();
		stmt.close();
		con.close();
		
		return true;
	}
	public boolean deletaPJ(int idPJ) throws SQLException {
		String sql = "delete from pessoa_juridica where id_pessoajuridica = ?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setInt(1, idPJ);

		stmt.execute();
		stmt.close();
		con.close();
		
		return true;
	}
	
}
