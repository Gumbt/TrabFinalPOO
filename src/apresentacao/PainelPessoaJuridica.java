package apresentacao;
import java.awt.BorderLayout;

import persistencia.DBBusca;
import persistencia.DBCadastro;
import persistencia.DBConnection;
import persistencia.DBDeleta;

import java.awt.EventQueue;
import dados.*;

import javax.swing.DefaultCellEditor;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;

public class PainelPessoaJuridica extends JPanel {

	private JPanel cadastrarPessoaJuridica;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField inputNomeCadPJ;
	private JTextField inputCnpjCadPJ;
	private JTextField inputEndCadPJ;
	private JTextField inputNFuncCadPJ;
	private JTextField searchInput;
	private JTable table;
	JLayeredPane painelCentral;
	private TableModelPJ dataModel;

	/**
	 * Create the frame.
	 */
	public PainelPessoaJuridica() {
		initComponents();
	}
	public void initComponents() {
		setBounds(100, 100, 583, 354);
		setLayout(new BorderLayout(0, 0));
		
		painelCentral = new JLayeredPane();
		add(painelCentral);
		painelCentral.setLayout(new CardLayout(0, 0));
		cadastrarPessoaJuridica = new JPanel();
		painelCentral.add(cadastrarPessoaJuridica, "name_7182598454947182");
		cadastrarPessoaJuridica.setBorder(new EmptyBorder(5, 5, 5, 5));
		cadastrarPessoaJuridica.setLayout(new BorderLayout(0, 0));
		
		JPanel cadastro = new JPanel();
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		cadastrarPessoaJuridica.add(cadastro);
		
		JLabel lblCadastroDeContribuinte = new JLabel("Cadastro de pessoas j\u00FAridicas");
		
		JLabel lblNome = new JLabel("Nome:");
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		
		JLabel lblEndereo = new JLabel("Endereço:");
		
		JLabel lblNumFunc = new JLabel("N. de funcionários:");
		
		inputNomeCadPJ = new JTextField();
		inputNomeCadPJ.setColumns(10);
		
		inputCnpjCadPJ = new JTextField();
		inputCnpjCadPJ.setColumns(10);
		
		inputEndCadPJ = new JTextField();
		inputEndCadPJ.setColumns(10);
		
		inputNFuncCadPJ = new JTextField();
		inputNFuncCadPJ.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				funcCadastraPJ();
			}
		});
		GroupLayout gl_cadastro = new GroupLayout(cadastro);
		gl_cadastro.setHorizontalGroup(
			gl_cadastro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cadastro.createSequentialGroup()
					.addGroup(gl_cadastro.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_cadastro.createSequentialGroup()
							.addGap(103)
							.addComponent(lblCadastroDeContribuinte))
						.addGroup(gl_cadastro.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_cadastro.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCnpj)
								.addComponent(lblNome)
								.addComponent(lblEndereo)
								.addComponent(lblNumFunc))
							.addGap(26)
							.addGroup(gl_cadastro.createParallelGroup(Alignment.LEADING)
								.addComponent(inputNFuncCadPJ, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
								.addComponent(inputEndCadPJ, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
								.addComponent(inputNomeCadPJ, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
								.addComponent(inputCnpjCadPJ, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSalvar))))
					.addContainerGap(114, Short.MAX_VALUE))
		);
		gl_cadastro.setVerticalGroup(
			gl_cadastro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cadastro.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCadastroDeContribuinte)
					.addGap(18)
					.addGroup(gl_cadastro.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(inputNomeCadPJ, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_cadastro.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCnpj)
						.addComponent(inputCnpjCadPJ, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_cadastro.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEndereo)
						.addComponent(inputEndCadPJ, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_cadastro.createParallelGroup(Alignment.BASELINE)
						.addComponent(inputNFuncCadPJ, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNumFunc))
					.addGap(66)
					.addComponent(btnSalvar)
					.addContainerGap(99, Short.MAX_VALUE))
		);
		cadastro.setLayout(gl_cadastro);
		
		JPanel consultarPessoaJuridica = new JPanel();
		painelCentral.add(consultarPessoaJuridica, "name_7183621705109210");
		
		searchInput = new JTextField();
		searchInput.setColumns(10);
		
		JLabel lblConsultarPJ = new JLabel("Consultar pessoas juridicas");
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dataModel = new TableModelPJ(criaListaPJ(searchInput.getText()));			
				table.setModel(dataModel);

			}
		});
		
		
		JLabel lblCnpj_2 = new JLabel("CNPJ:");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletaPJ();
			}
		});
		
		GroupLayout gl_consultarPessoaJuridica = new GroupLayout(consultarPessoaJuridica);
		gl_consultarPessoaJuridica.setHorizontalGroup(
			gl_consultarPessoaJuridica.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_consultarPessoaJuridica.createSequentialGroup()
					.addGroup(gl_consultarPessoaJuridica.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_consultarPessoaJuridica.createSequentialGroup()
							.addGap(133)
							.addComponent(lblConsultarPJ))
						.addGroup(gl_consultarPessoaJuridica.createSequentialGroup()
							.addGap(9)
							.addComponent(lblCnpj_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(searchInput, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnPesquisar)
							.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
							.addComponent(btnRemover))
						.addGroup(gl_consultarPessoaJuridica.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_consultarPessoaJuridica.setVerticalGroup(
			gl_consultarPessoaJuridica.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_consultarPessoaJuridica.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblConsultarPJ)
					.addGap(18)
					.addGroup(gl_consultarPessoaJuridica.createParallelGroup(Alignment.BASELINE)
						.addComponent(searchInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPesquisar)
						.addComponent(lblCnpj_2)
						.addComponent(btnRemover))
					.addGap(11)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(45, Short.MAX_VALUE))
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		dataModel = new TableModelPJ(criaListaPJ(null));
		table.setModel(dataModel);
		consultarPessoaJuridica.setLayout(gl_consultarPessoaJuridica);
		
		JPanel menuLateral = new JPanel();
		add(menuLateral, BorderLayout.WEST);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setBackground(new Color(143, 188, 143));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(cadastrarPessoaJuridica);
			}
		});
		
		JButton btnNewButton_1 = new JButton("Consultar");
		btnNewButton_1.setBackground(new Color(143, 188, 143));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchInput.setText("");
				dataModel = new TableModelPJ(criaListaPJ(searchInput.getText()));
				table.setModel(dataModel);
				
				switchPanels(consultarPessoaJuridica);
			}
		});
		GroupLayout gl_menuLateral = new GroupLayout(menuLateral);
		gl_menuLateral.setHorizontalGroup(
			gl_menuLateral.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_menuLateral.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_menuLateral.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_menuLateral.setVerticalGroup(
			gl_menuLateral.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_menuLateral.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_1)
					.addContainerGap(286, Short.MAX_VALUE))
		);
		menuLateral.setLayout(gl_menuLateral);
	}
	public void funcCadastraPJ() {
		try {
			boolean r = new DBCadastro().cadastroPJ(
					inputNomeCadPJ.getText(),
					inputCnpjCadPJ.getText(),
					inputEndCadPJ.getText(),
					Integer.parseInt(inputNFuncCadPJ.getText())
					);
			
			if(r) {
				JOptionPane.showMessageDialog(null, "Cadastro de pessoa juridica realizado com sucesso!");
				
				inputNomeCadPJ.setText("");
				inputCnpjCadPJ.setText("");
				inputEndCadPJ.setText("");
				inputNFuncCadPJ.setText("");						
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private List<PessoaJuridica> criaListaPJ(String filtroCnpj) {
		List<PessoaJuridica> pessoas = new ArrayList<PessoaJuridica>();
		try {			
			pessoas = new DBBusca().buscaPJ(filtroCnpj,false);
		} catch (SQLException f) {
			// TODO Auto-generated catch block
			f.printStackTrace();
		}
		return pessoas;
	}
	private void deletaPJ() {
		if(table.getSelectedRowCount() == 1 ) {
			int idPJ = (int) table.getModel().getValueAt(table.getSelectedRow(), 0);
			try {
	
				boolean r = new DBDeleta().deletaPJ(idPJ);
				if(r) {
					JOptionPane.showMessageDialog(null, "Pessoa júridica deletada com sucesso",null,JOptionPane.PLAIN_MESSAGE);
					
				}
				
			} catch (SQLException f) {
				// TODO Auto-generated catch block
				f.printStackTrace();
			}
			dataModel = new TableModelPJ(criaListaPJ(searchInput.getText()));			
			table.setModel(dataModel);
		}else {
			JOptionPane.showMessageDialog(null, "Selecione uma pessoa júridica para deletar",null,JOptionPane.WARNING_MESSAGE);
		}
	}

	public void switchPanels(JPanel panel) {
		painelCentral.removeAll();
		painelCentral.add(panel);
		painelCentral.repaint();
		painelCentral.revalidate();
	}
}
