package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dados.Contribuinte;


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
	public List<Contribuinte> buscaContribuintes(String filtroCpf) throws SQLException {
		List<Contribuinte> pessoas = new ArrayList<Contribuinte>();
		String sql;
		if(filtroCpf == null || filtroCpf == "") {
			sql = "select * from contribuinte order by id_contribuinte DESC";				
		}else {
			sql = "select * from contribuinte where cpf like '%"+filtroCpf+"%' order by id_contribuinte DESC";
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
	
}
