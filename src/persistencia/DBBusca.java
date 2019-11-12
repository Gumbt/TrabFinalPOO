package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dados.Bem;
import dados.Contracheque;
import dados.Contribuinte;
import dados.Dependente;
import dados.NotaFiscal;
import dados.PessoaJuridica;


public class DBBusca {

	private Connection con;
	
	public DBBusca(){
		try {
			con = DBConnection.faz_conexao();
					
		} catch (SQLException f) {
			// TODO Auto-generated catch block
			f.printStackTrace();
		}
	}
	public List<Contribuinte> buscaContribuintes(String filtroCpf,boolean order) throws SQLException {
		List<Contribuinte> pessoas = new ArrayList<Contribuinte>();
		String sql;
		String orderby;
		if(order) {
			orderby = "nome ASC";
		}else {
			orderby = "id_contribuinte DESC";
		}
		if(filtroCpf == null || filtroCpf == "") {
			sql = "select * from contribuinte order by "+orderby;				
		}else {
			sql = "select * from contribuinte where cpf like '%"+filtroCpf+"%' order by "+orderby;
		}
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
		ResultSet rs = stmt.executeQuery();
		while(rs.next())
        {
			Contribuinte p = new Contribuinte();
			p.setId(Integer.parseInt(rs.getString("id_contribuinte")));
			p.setCpf(rs.getString("cpf"));
			p.setNome(rs.getString("nome"));
			p.setEndereco(rs.getString("endereco"));
			p.setIdade(Integer.parseInt(rs.getString("idade")));
			p.setContaBancaria(Integer.parseInt(rs.getString("conta_bancaria")));
			pessoas.add(p);
        }	
		con.close();
		stmt.close();
		return pessoas;
	}
	public List<PessoaJuridica> buscaPJ(String filtroCnpj,boolean order) throws SQLException {
		List<PessoaJuridica> pessoas = new ArrayList<PessoaJuridica>();
		String sql;
		String orderby;
		if(order) {
			orderby = "nome_pj ASC";
		}else {
			orderby = "id_pessoajuridica DESC";
		}
		if(filtroCnpj == null || filtroCnpj == "") {
			sql = "select * from pessoa_juridica order by "+orderby;				
		}else {
			sql = "select * from pessoa_juridica where cnpj like '%"+filtroCnpj+"%' order by "+orderby;
		}
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
		ResultSet rs = stmt.executeQuery();
		while(rs.next())
        {
			PessoaJuridica p = new PessoaJuridica();
			p.setId(Integer.parseInt(rs.getString("id_pessoajuridica")));
			p.setCnpj(rs.getString("cnpj"));
			p.setNomePJ(rs.getString("nome_pj"));
			p.setEndereco(rs.getString("endereco"));
			p.setNumFuncionarios(Integer.parseInt(rs.getString("num_funcionarios")));
			pessoas.add(p);
        }	
		con.close();
		stmt.close();
		return pessoas;
	}
	public List<Bem> listaBens(int idContri) throws SQLException {
		List<Bem> bens = new ArrayList<Bem>();
		try {
			String sql;
			Connection con = DBConnection.faz_conexao();

			sql = "select * from bem where id_contribuinte = "+idContri+" order by id_bem DESC";				

			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
            {
				Bem p = new Bem();
				p.setId(Integer.parseInt(rs.getString("id_bem")));
				p.setNome(rs.getString("nome"));
				p.setTipo(rs.getString("tipo"));
				p.setValor(Float.parseFloat(rs.getString("valor")));
				bens.add(p);
            }
			stmt.close();
			con.close();		
		} catch (SQLException f) {
			// TODO Auto-generated catch block
			f.printStackTrace();
		}
		return bens;
	}
	public List<Dependente> listaDependente(int idContri) throws SQLException {
		List<Dependente> dependentes = new ArrayList<Dependente>();
		try {
			String sql;
			Connection con = DBConnection.faz_conexao();

			sql = "select * from dependente where id_contribuinte = "+idContri+" order by id_dependente DESC";				

			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
            {
				Dependente p = new Dependente();
				p.setId(Integer.parseInt(rs.getString("id_dependente")));
				p.setNome(rs.getString("nome"));
				p.setCpf(rs.getString("cpf"));
				p.setIdade(Integer.parseInt(rs.getString("idade")));
				p.setEndereco(rs.getString("endereco"));
				dependentes.add(p);
            }
			stmt.close();
			con.close();		
		} catch (SQLException f) {
			// TODO Auto-generated catch block
			f.printStackTrace();
		}
		return dependentes;
	}
	public List<Contracheque> listaContracheque(String cpfContri) throws SQLException {
		List<Contracheque> cc = new ArrayList<Contracheque>();
		try {
			String sql1;
			int idContri = 0;
			sql1 = "select * from contribuinte where cpf = '"+cpfContri+"'";
			PreparedStatement stmt1 = con.prepareStatement(sql1);
			ResultSet rs1 = stmt1.executeQuery();
			while(rs1.next())
            {
				idContri = rs1.getInt("id_contribuinte");
            }
			String sql;
			sql = "select * from contracheque where id_contribuinte = "+idContri+" order by id_contracheque DESC";				
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
            {
				Contracheque p = new Contracheque();
				p.setId(Integer.parseInt(rs.getString("id_contracheque")));
				p.setDescricao(rs.getString("descricao"));
				p.setNumProtocolo(rs.getInt("num_protoc"));
				p.setCnpj(rs.getString("cnpj"));
				p.setValor(rs.getFloat("valor"));
				cc.add(p);
            }
			stmt.close();
			con.close();		
		} catch (SQLException f) {
			// TODO Auto-generated catch block
			f.printStackTrace();
		}
		return cc;
	}
	public List<NotaFiscal> listaNotaFiscal(String cpfContri) throws SQLException {
		List<NotaFiscal> cc = new ArrayList<NotaFiscal>();
		try {
			String sql1;
			int idContri = 0;
			sql1 = "select * from contribuinte where cpf = '"+cpfContri+"'";
			PreparedStatement stmt1 = con.prepareStatement(sql1);
			ResultSet rs1 = stmt1.executeQuery();
			while(rs1.next())
            {
				idContri = rs1.getInt("id_contribuinte");
            }
			String sql;
			sql = "select * from nota_fiscal where id_contribuinte = "+idContri+" order by id_notafiscal DESC";				
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
            {
				NotaFiscal p = new NotaFiscal();
				p.setId(Integer.parseInt(rs.getString("id_notafiscal")));
				p.setDescricao(rs.getString("descricao"));
				p.setNumProtocolo(rs.getInt("num_protoc"));
				p.setCnpj(rs.getString("cnpj"));
				p.setValor(rs.getFloat("valor"));
				cc.add(p);
            }
			stmt.close();
			con.close();		
		} catch (SQLException f) {
			// TODO Auto-generated catch block
			f.printStackTrace();
		}
		return cc;
	}
}
