package apresentacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dados.Bem;
import dados.Contribuinte;
import dados.Dependente;
import persistencia.DBConnection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;

public class VisualisarBensEDependentes extends JFrame {

	private JPanel contentPane;
	private JTable tabelaBens;
	private JTable tabelaDependentes;
	private BemTableModel dataModelBens;
	private DependenteTableModel dataModelDependentes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualisarBensEDependentes frame = new VisualisarBensEDependentes(1,"teste");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VisualisarBensEDependentes(int idUser,String nomeUser) {
		setResizable(false);
		
		setBounds(100, 100, 571, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblBensDe = new JLabel("Bens de "+nomeUser+": ");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblDependentesDe = new JLabel("Dependentes de "+nomeUser+": ");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
						.addComponent(lblBensDe, Alignment.LEADING)
						.addComponent(lblDependentesDe, Alignment.LEADING))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblBensDe)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblDependentesDe)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(35, Short.MAX_VALUE))
		);
		
		tabelaDependentes = new JTable();
		scrollPane_1.setViewportView(tabelaDependentes);
		
		dataModelDependentes = new DependenteTableModel(criaListaDependente(idUser));
		tabelaDependentes.setModel(dataModelDependentes);
		
		tabelaBens = new JTable();
		scrollPane.setViewportView(tabelaBens);
		panel.setLayout(gl_panel);
		
		dataModelBens = new BemTableModel(criaListaBens(idUser));
		tabelaBens.setModel(dataModelBens);
	}
	private List<Bem> criaListaBens(int idContri) {
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
	private List<Dependente> criaListaDependente(int idContri) {
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
}
