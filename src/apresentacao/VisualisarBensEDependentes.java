package apresentacao;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dados.Bem;
import dados.Dependente;
import persistencia.DBBusca;
import persistencia.DBDeleta;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VisualisarBensEDependentes extends JFrame {

	/**
	 * 
	 */
	private JPanel contentPane;
	private JTable tabelaBens;
	private JTable tabelaDependentes;
	private TableModelBem dataModelBens;
	private TableModelDependente dataModelDependentes;
	private int idUsuario;


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
		
		idUsuario = idUser;
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblBensDe = new JLabel("Bens de "+nomeUser+": ");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblDependentesDe = new JLabel("Dependentes de "+nomeUser+": ");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletaBem();
			}
		});
		
		JButton btnRemover_1 = new JButton("Remover");
		btnRemover_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletaDependente();
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addComponent(lblBensDe)
							.addPreferredGap(ComponentPlacement.RELATED, 343, Short.MAX_VALUE)
							.addComponent(btnRemover))
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addComponent(lblDependentesDe)
							.addPreferredGap(ComponentPlacement.RELATED, 302, Short.MAX_VALUE)
							.addComponent(btnRemover_1)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBensDe)
						.addComponent(btnRemover))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDependentesDe)
						.addComponent(btnRemover_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(45, Short.MAX_VALUE))
		);
		
		tabelaDependentes = new JTable();
		scrollPane_1.setViewportView(tabelaDependentes);
		
		dataModelDependentes = new TableModelDependente(criaListaDependente(idUser));
		tabelaDependentes.setModel(dataModelDependentes);
		
		tabelaBens = new JTable();
		scrollPane.setViewportView(tabelaBens);
		panel.setLayout(gl_panel);
		
		dataModelBens = new TableModelBem(criaListaBens(idUser));
		tabelaBens.setModel(dataModelBens);
	}
	private List<Bem> criaListaBens(int idContri) {
		List<Bem> bens = new ArrayList<Bem>();
		try {
			bens = new DBBusca().listaBens(idContri);
			
		} catch (SQLException f) {
			// TODO Auto-generated catch block
			f.printStackTrace();
		}
		return bens;
	}
	private List<Dependente> criaListaDependente(int idContri) {
		List<Dependente> dependentes = new ArrayList<Dependente>();
		try {
			dependentes = new DBBusca().listaDependente(idContri);
			
		} catch (SQLException f) {
			// TODO Auto-generated catch block
			f.printStackTrace();
		}
		return dependentes;
	}
	private void deletaBem() {
		if(tabelaBens.getSelectedRowCount() == 1 ) {
			int idBem = (int) tabelaBens.getModel().getValueAt(tabelaBens.getSelectedRow(), 0);
			try {
	
				boolean r = new DBDeleta().deletaBem(idBem);
				if(r) {
					JOptionPane.showMessageDialog(null, "Bem deletado com sucesso",null, JOptionPane.PLAIN_MESSAGE, null);
					
				}
				
			} catch (SQLException f) {
				// TODO Auto-generated catch block
				f.printStackTrace();
			}
			dataModelBens = new TableModelBem(criaListaBens(idUsuario));
			tabelaBens.setModel(dataModelBens);
		}else {
			JOptionPane.showMessageDialog(null, "Selecione um bem para deletar",null,JOptionPane.WARNING_MESSAGE);
		}
	}
	private void deletaDependente() {
		if(tabelaDependentes.getSelectedRowCount() == 1 ) {
			int idDependente = (int) tabelaDependentes.getModel().getValueAt(tabelaDependentes.getSelectedRow(), 0);
			try {
	
				boolean r = new DBDeleta().deletaDependente(idDependente);
				if(r) {
					JOptionPane.showMessageDialog(null, "Dependente deletado com sucesso",null,JOptionPane.PLAIN_MESSAGE);
					
				}
				
			} catch (SQLException f) {
				// TODO Auto-generated catch block
				f.printStackTrace();
			}
			dataModelDependentes = new TableModelDependente(criaListaDependente(idUsuario));
			tabelaDependentes.setModel(dataModelDependentes);
		}else {
			JOptionPane.showMessageDialog(null, "Selecione um dependente para deletar",null,JOptionPane.WARNING_MESSAGE);
		}
	}
}
