package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class DBAlterar {

	private Connection con;
	
	public DBAlterar(){
		try {
			con = DBConnection.faz_conexao();
					
		} catch (SQLException f) {
			// TODO Auto-generated catch block
			f.printStackTrace();
		}
	}
	public boolean alteraContribuinte(String nome,String cpf, int idade, String endereco, int contaBancaria, int id) throws SQLException {
		String sql = "update contribuinte set nome = ?, cpf = ?, idade = ?,endereco = ?,conta_bancaria = ? where id_contribuinte = ?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setString(1, nome);
		stmt.setString(2, cpf);
		stmt.setInt(3, idade);
		stmt.setString(4, endereco);
		stmt.setInt(5, contaBancaria);
		stmt.setInt(6, id);

		stmt.execute();
		stmt.close();
		con.close();
		return true;
	}
	public boolean alteraPJ(String nome, String endereco, int numFunc, int id) throws SQLException {
		String sql = "update pessoa_juridica set nome_pj = ?, endereco = ?,num_funcionarios = ? where id_pessoajuridica = ?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setString(1, nome);
		stmt.setString(2, endereco);
		stmt.setInt(3, numFunc);
		stmt.setInt(4, id);

		stmt.execute();
		stmt.close();
		con.close();
		return true;
	}
	public boolean alteraBem(String nome,String tipo, float valor, int id) throws SQLException {
		String sql = "update bem set nome = ?, tipo = ?, valor = ? where id_bem = ?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setString(1, nome);
		stmt.setString(2, tipo);
		stmt.setFloat(3, valor);
		stmt.setInt(4, id);

		stmt.execute();
		stmt.close();
		con.close();
		return true;
	}
	public boolean alteraDependente(String nome, int idade, String endereco, int id) throws SQLException {
		String sql = "update dependente set nome = ?, idade = ?, endereco = ? where id_dependente = ?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setString(1, nome);
		stmt.setInt(2, idade);
		stmt.setString(3, endereco);

		stmt.setInt(4, id);

		stmt.execute();
		stmt.close();
		con.close();
		return true;
	}
}
