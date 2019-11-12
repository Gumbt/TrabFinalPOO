package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DBCadastro {

	private Connection con;
	
	public DBCadastro(){
		try {
			con = DBConnection.faz_conexao();
					
		} catch (SQLException f) {
			// TODO Auto-generated catch block
			f.printStackTrace();
		}
	}
	public boolean cadastroContribuinte(String nome,String cpf,int idade,String endereco,int contabancaria) throws SQLException {
		String sql = "insert into contribuinte(nome, cpf, idade,endereco,conta_bancaria) values (?, ?, ?, ?, ?)";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setString(1, nome);
		stmt.setString(2, cpf);
		stmt.setInt(3, idade);
		stmt.setString(4, endereco);
		stmt.setInt(5, contabancaria);

		stmt.execute();
		stmt.close();
		con.close();
		return true;
	}
	public boolean cadastroBem(String nome,String tipo,float valor,int idContribuinte) throws SQLException {
		String sql = "insert into bem(nome, tipo, valor,id_contribuinte) values (?, ?, ?, ?)";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setString(1, nome);
		stmt.setString(2, tipo);
		stmt.setFloat(3, valor);
		stmt.setInt(4, idContribuinte);

		stmt.execute();
		stmt.close();
		con.close();
		return true;
	}
	public boolean cadastroDependente(String nome,String cpf,int idade,String endereco,int idContribuinte) throws SQLException {
		String sql = "insert into dependente(nome, cpf, idade,endereco,id_contribuinte) values (?, ?, ?, ?, ?)";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setString(1, nome);
		stmt.setString(2, cpf);
		stmt.setInt(3, idade);
		stmt.setString(4, endereco);
		stmt.setInt(5, idContribuinte);

		stmt.execute();
		stmt.close();
		con.close();
		return true;
	}
	public boolean cadastroPJ(String nome,String cnpj,String endereco,int nfunc) throws SQLException {
		String sql = "insert into pessoa_juridica(nome_pj, cnpj, endereco,num_funcionarios) values (?, ?, ?, ?)";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setString(1, nome);
		stmt.setString(2, cnpj);
		stmt.setString(3, endereco);
		stmt.setInt(4, nfunc);

		stmt.execute();
		stmt.close();
		con.close();
		return true;
	}
	public boolean cadastroContracheque(int numProtoc, float valorReceita, String descricao, int idContr, String cnpj, int idPJ) throws SQLException {
		String sql = "insert into contracheque(descricao, valor, num_protoc, cnpj, id_pessoajuridica, id_contribuinte) values (?, ?, ?, ?, ?, ?)";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setString(1, descricao);
		stmt.setFloat(2, valorReceita);
		stmt.setInt(3, numProtoc);
		stmt.setString(4, cnpj);
		stmt.setInt(5, idPJ);
		stmt.setInt(6, idContr);

		stmt.execute();
		stmt.close();
		con.close();
		
		return true;
	}
	public boolean cadastroNotaFiscal(int numProtoc, float valorReceita, String descricao, int idContr, String cnpj, int idPJ) throws SQLException {
		String sql = "insert into nota_fiscal(descricao, valor, num_protoc, cnpj, id_pessoajuridica, id_contribuinte) values (?, ?, ?, ?, ?, ?)";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setString(1, descricao);
		stmt.setFloat(2, valorReceita);
		stmt.setInt(3, numProtoc);
		stmt.setString(4, cnpj);
		stmt.setInt(5, idPJ);
		stmt.setInt(6, idContr);

		stmt.execute();
		stmt.close();
		con.close();
		
		return true;
	}
}
