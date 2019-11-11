package apresentacao;
import java.awt.BorderLayout;

import persistencia.DBBusca;
import persistencia.DBCadastro;
import persistencia.DBConnection;
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

public class PainelContribuinte extends JPanel {

	private JPanel cadastrarContribuinte;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField inputNomeCadCont;
	private JTextField inputCpfCadCont;
	private JTextField inputIdadeCadCont;
	private JTextField inputEndCadCont;
	private JTextField inputContBanCadCont;
	private JTextField searchInput;
	private JTable table;
	JLayeredPane painelCentral;
	private JTextField nomeCadBem;
	private JTextField tipoCadBem;
	private JTextField valorCadBem;
	private JTextField nomeCadDep;
	private JTextField cpfCadDep;
	private JTextField idadeCadDep;
	private JTextField endCadDep;
	private TableModelContribuinte dataModel;
	private JComboBox comboBoxCadBem;
	private JComboBox comboBoxCadDep;

	/**
	 * Create the frame.
	 */
	public PainelContribuinte() {
		initComponents();
	}
	public void initComponents() {
		setBounds(100, 100, 583, 354);
		setLayout(new BorderLayout(0, 0));
		
		painelCentral = new JLayeredPane();
		add(painelCentral);
		painelCentral.setLayout(new CardLayout(0, 0));
		cadastrarContribuinte = new JPanel();
		painelCentral.add(cadastrarContribuinte, "name_7182598454947182");
		cadastrarContribuinte.setBorder(new EmptyBorder(5, 5, 5, 5));
		cadastrarContribuinte.setLayout(new BorderLayout(0, 0));
		
		JPanel cadastro = new JPanel();
		
		JLabel label = new JLabel("Nome:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("CPF:");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("Endere\u00E7o:");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel label_3 = new JLabel("Idade:");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel label_4 = new JLabel("Conta bancaria:");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JButton button = new JButton("Salvar");
		cadastrarContribuinte.add(cadastro);
		
		JLabel lblCadastroDeContribuinte = new JLabel("Cadastro de contribuinte");
		
		JLabel lblNome = new JLabel("Nome:");
		
		JLabel lblCpf = new JLabel("CPF:");
		
		JLabel lblIdade = new JLabel("Idade:");
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		
		JLabel lblContaBancaria = new JLabel("Conta bancaria:");
		
		inputNomeCadCont = new JTextField();
		inputNomeCadCont.setColumns(10);
		
		inputCpfCadCont = new JTextField();
		inputCpfCadCont.setColumns(10);
		
		inputIdadeCadCont = new JTextField();
		inputIdadeCadCont.setColumns(10);
		
		inputEndCadCont = new JTextField();
		inputEndCadCont.setColumns(10);
		
		inputContBanCadCont = new JTextField();
		inputContBanCadCont.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				funcCadastraContribuinte();
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
							.addGap(126)
							.addComponent(btnSalvar))
						.addGroup(gl_cadastro.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_cadastro.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCpf)
								.addComponent(lblNome)
								.addComponent(lblIdade)
								.addComponent(lblEndereo)
								.addComponent(lblContaBancaria))
							.addGap(16)
							.addGroup(gl_cadastro.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_cadastro.createSequentialGroup()
									.addGap(10)
									.addGroup(gl_cadastro.createParallelGroup(Alignment.LEADING)
										.addComponent(inputIdadeCadCont, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
										.addComponent(inputContBanCadCont, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
										.addComponent(inputEndCadCont, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_cadastro.createSequentialGroup()
									.addGap(10)
									.addGroup(gl_cadastro.createParallelGroup(Alignment.LEADING)
										.addComponent(inputNomeCadCont, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
										.addComponent(inputCpfCadCont, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))))))
					.addContainerGap(37, GroupLayout.PREFERRED_SIZE))
		);
		gl_cadastro.setVerticalGroup(
			gl_cadastro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cadastro.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCadastroDeContribuinte)
					.addGap(18)
					.addGroup(gl_cadastro.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(inputNomeCadCont, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_cadastro.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCpf)
						.addComponent(inputCpfCadCont, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_cadastro.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdade)
						.addComponent(inputIdadeCadCont, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_cadastro.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEndereo)
						.addComponent(inputEndCadCont, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_cadastro.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblContaBancaria)
						.addComponent(inputContBanCadCont, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
					.addComponent(btnSalvar)
					.addGap(39))
		);
		cadastro.setLayout(gl_cadastro);
		
		JPanel consultarContribuinte = new JPanel();
		painelCentral.add(consultarContribuinte, "name_7183621705109210");
		
		searchInput = new JTextField();
		searchInput.setColumns(10);
		
		JLabel lblConsultarContribuintes = new JLabel("Consultar contribuintes");
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dataModel = new TableModelContribuinte(criaListaContribuinte(searchInput.getText()));
				
				table.setModel(dataModel);
				TableColumn colunaEstado = table.getColumnModel().getColumn(6);
				TableCellRenderer testBtn = new JTableButtonRenderer(table,6,"Ver +");
				colunaEstado.setCellRenderer(testBtn);
			}
		});
		dataModel = new TableModelContribuinte(criaListaContribuinte(null));
		
		JLabel lblCpf_2 = new JLabel("CPF:");
		
		JScrollPane scrollPane = new JScrollPane();
		
		GroupLayout gl_consultarContribuinte = new GroupLayout(consultarContribuinte);
		gl_consultarContribuinte.setHorizontalGroup(
			gl_consultarContribuinte.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_consultarContribuinte.createSequentialGroup()
					.addGroup(gl_consultarContribuinte.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_consultarContribuinte.createSequentialGroup()
							.addGap(133)
							.addComponent(lblConsultarContribuintes))
						.addGroup(gl_consultarContribuinte.createSequentialGroup()
							.addGap(9)
							.addComponent(lblCpf_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(searchInput, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnPesquisar))
						.addGroup(gl_consultarContribuinte.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_consultarContribuinte.setVerticalGroup(
			gl_consultarContribuinte.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_consultarContribuinte.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblConsultarContribuintes)
					.addGap(18)
					.addGroup(gl_consultarContribuinte.createParallelGroup(Alignment.BASELINE)
						.addComponent(searchInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPesquisar)
						.addComponent(lblCpf_2))
					.addGap(11)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(45, Short.MAX_VALUE))
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(dataModel);
		consultarContribuinte.setLayout(gl_consultarContribuinte);
		
		JPanel cadastrarBens = new JPanel();
		painelCentral.add(cadastrarBens, "name_7288855328182789");
		
		JLabel lblCadastroDeBens = new JLabel("Cadastro de bens");
		
		JLabel lblNome_1 = new JLabel("Nome:");
		
		nomeCadBem = new JTextField();
		nomeCadBem.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo:");
		
		tipoCadBem = new JTextField();
		tipoCadBem.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor:");
		
		valorCadBem = new JTextField();
		valorCadBem.setColumns(10);
		
		JLabel lblContribuinte = new JLabel("Contribuinte:");
		
		comboBoxCadBem = new JComboBox();
		
		JButton btnSalvar_1 = new JButton("Salvar");
		btnSalvar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				funcCadastraBem();
			}
		});
		GroupLayout gl_cadastrarBens = new GroupLayout(cadastrarBens);
		gl_cadastrarBens.setHorizontalGroup(
			gl_cadastrarBens.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cadastrarBens.createSequentialGroup()
					.addGroup(gl_cadastrarBens.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_cadastrarBens.createSequentialGroup()
							.addGap(102)
							.addComponent(lblCadastroDeBens))
						.addGroup(gl_cadastrarBens.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_cadastrarBens.createParallelGroup(Alignment.LEADING)
								.addComponent(lblContribuinte)
								.addComponent(lblNome_1)
								.addComponent(lblValor)
								.addComponent(lblTipo))
							.addGap(18)
							.addGroup(gl_cadastrarBens.createParallelGroup(Alignment.LEADING)
								.addComponent(tipoCadBem, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
								.addComponent(valorCadBem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxCadBem, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
								.addComponent(nomeCadBem, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_cadastrarBens.createSequentialGroup()
							.addGap(111)
							.addComponent(btnSalvar_1)))
					.addContainerGap(55, Short.MAX_VALUE))
		);
		gl_cadastrarBens.setVerticalGroup(
			gl_cadastrarBens.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cadastrarBens.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCadastroDeBens)
					.addGap(18)
					.addGroup(gl_cadastrarBens.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome_1)
						.addComponent(nomeCadBem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_cadastrarBens.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTipo)
						.addComponent(tipoCadBem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_cadastrarBens.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblValor)
						.addComponent(valorCadBem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_cadastrarBens.createParallelGroup(Alignment.LEADING)
						.addComponent(lblContribuinte)
						.addComponent(comboBoxCadBem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(49)
					.addComponent(btnSalvar_1)
					.addContainerGap(51, Short.MAX_VALUE))
		);
		cadastrarBens.setLayout(gl_cadastrarBens);
		
		JPanel cadastrarDependente = new JPanel();
		painelCentral.add(cadastrarDependente, "name_7289327109052029");
		
		JLabel lblCadastrarDependente = new JLabel("Cadastrar dependente");
		
		JLabel lblNome_2 = new JLabel("Nome:");
		
		JLabel lblCpf_1 = new JLabel("CPF:");
		
		JLabel lblIdade_1 = new JLabel("Idade:");
		
		JLabel lblEndereo_1 = new JLabel("Endere\u00E7o:");
		
		JLabel lblContribuinte_1 = new JLabel("Contribuinte:");
		
		nomeCadDep = new JTextField();
		nomeCadDep.setColumns(10);
		
		cpfCadDep = new JTextField();
		cpfCadDep.setColumns(10);
		
		idadeCadDep = new JTextField();
		idadeCadDep.setColumns(10);
		
		endCadDep = new JTextField();
		endCadDep.setColumns(10);
		
		comboBoxCadDep = new JComboBox();
		
		JButton btnSalvar_2 = new JButton("Salvar");
		btnSalvar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				funcCadastraDependente();
			}
		});
		GroupLayout gl_cadastrarDependente = new GroupLayout(cadastrarDependente);
		gl_cadastrarDependente.setHorizontalGroup(
			gl_cadastrarDependente.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cadastrarDependente.createSequentialGroup()
					.addGroup(gl_cadastrarDependente.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_cadastrarDependente.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_cadastrarDependente.createParallelGroup(Alignment.LEADING)
								.addComponent(lblContribuinte_1)
								.addComponent(lblNome_2)
								.addComponent(lblCpf_1)
								.addComponent(lblIdade_1)
								.addComponent(lblEndereo_1))
							.addGap(18)
							.addGroup(gl_cadastrarDependente.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_cadastrarDependente.createSequentialGroup()
									.addGap(30)
									.addComponent(lblCadastrarDependente))
								.addComponent(endCadDep, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxCadDep, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
								.addComponent(idadeCadDep, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
								.addComponent(cpfCadDep, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
								.addComponent(nomeCadDep, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_cadastrarDependente.createSequentialGroup()
							.addGap(102)
							.addComponent(btnSalvar_2)))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		gl_cadastrarDependente.setVerticalGroup(
			gl_cadastrarDependente.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cadastrarDependente.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCadastrarDependente)
					.addGap(18)
					.addGroup(gl_cadastrarDependente.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome_2)
						.addComponent(nomeCadDep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_cadastrarDependente.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCpf_1)
						.addComponent(cpfCadDep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_cadastrarDependente.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdade_1)
						.addComponent(idadeCadDep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_cadastrarDependente.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEndereo_1)
						.addComponent(endCadDep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_cadastrarDependente.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblContribuinte_1)
						.addComponent(comboBoxCadDep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnSalvar_2)
					.addContainerGap(44, Short.MAX_VALUE))
		);
		cadastrarDependente.setLayout(gl_cadastrarDependente);
		
		JPanel menuLateral = new JPanel();
		add(menuLateral, BorderLayout.WEST);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setBackground(new Color(143, 188, 143));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(cadastrarContribuinte);
			}
		});
		
		JButton btnNewButton_1 = new JButton("Consultar");
		btnNewButton_1.setBackground(new Color(143, 188, 143));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchInput.setText("");
				dataModel = new TableModelContribuinte(criaListaContribuinte(searchInput.getText()));
				table.setModel(dataModel);
				
				TableColumn colunaEstado = table.getColumnModel().getColumn(6);//cria os botoes de ver +
				TableCellRenderer testBtn = new JTableButtonRenderer(table,6,"Ver +");
				colunaEstado.setCellRenderer(testBtn);
				
				switchPanels(consultarContribuinte);
			}
		});
		
		JButton btnCadastroDeBens = new JButton("Cadastro bens");
		btnCadastroDeBens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizaComboBox(comboBoxCadBem);
				switchPanels(cadastrarBens);
			}
		});
		btnCadastroDeBens.setBackground(new Color(143, 188, 143));
		
		JButton btnCadastroDependente = new JButton("Cadastro dependente");
		btnCadastroDependente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizaComboBox(comboBoxCadDep);
				switchPanels(cadastrarDependente);
			}
		});
		btnCadastroDependente.setBackground(new Color(143, 188, 143));
		GroupLayout gl_menuLateral = new GroupLayout(menuLateral);
		gl_menuLateral.setHorizontalGroup(
			gl_menuLateral.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_menuLateral.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_menuLateral.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCadastroDeBens, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
						.addComponent(btnCadastroDependente))
					.addContainerGap())
		);
		gl_menuLateral.setVerticalGroup(
			gl_menuLateral.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_menuLateral.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCadastroDeBens)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCadastroDependente)
					.addGap(9)
					.addComponent(btnNewButton_1)
					.addContainerGap(220, Short.MAX_VALUE))
		);
		menuLateral.setLayout(gl_menuLateral);
	}
	public void funcCadastraContribuinte() {
		try {
			boolean r = new DBCadastro().cadastroContribuinte(
					inputNomeCadCont.getText(),
					inputCpfCadCont.getText(),
					Integer.parseInt(inputIdadeCadCont.getText()),
					inputEndCadCont.getText(),
					Integer.parseInt(inputContBanCadCont.getText())
					);
			
			if(r) {
				JOptionPane.showMessageDialog(null, "Cadastro de contribuinte realizado com sucesso!");
				
				inputNomeCadCont.setText("");
				inputCpfCadCont.setText("");
				inputIdadeCadCont.setText("");
				inputEndCadCont.setText("");
				inputContBanCadCont.setText("");						
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void funcCadastraBem() {
		try {
			Contribuinte contri = (Contribuinte) comboBoxCadBem.getSelectedItem();
			boolean r = new DBCadastro().cadastroBem(
					nomeCadBem.getText(),
					tipoCadBem.getText(),
					Float.parseFloat(valorCadBem.getText()),
					contri.getId()
					);
			if(r) {
				JOptionPane.showMessageDialog(null, "Cadastro de bem realizado com sucesso!");
				
				nomeCadBem.setText("");
				tipoCadBem.setText("");
				valorCadBem.setText("");
				comboBoxCadBem.setSelectedIndex(0);	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void funcCadastraDependente() {
		try {
			Contribuinte contri = (Contribuinte) comboBoxCadDep.getSelectedItem();
			boolean r = new DBCadastro().cadastroDependente(
					nomeCadDep.getText(),
					cpfCadDep.getText(),
					Integer.parseInt(idadeCadDep.getText()),
					endCadDep.getText(),
					contri.getId()
					);
			if(r) {
				
				JOptionPane.showMessageDialog(null, "Cadastro de dependente realizado com sucesso!");
				
				nomeCadDep.setText("");
				cpfCadDep.setText("");
				idadeCadDep.setText("");
				endCadDep.setText("");
				comboBoxCadDep.setSelectedIndex(0);			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private List<Contribuinte> criaListaContribuinte(String filtroCpf) {
		List<Contribuinte> pessoas = new ArrayList<Contribuinte>();
		try {			
			pessoas = new DBBusca().buscaContribuintes(filtroCpf,false);
		} catch (SQLException f) {
			// TODO Auto-generated catch block
			f.printStackTrace();
		}
		return pessoas;
	}
	public void atualizaComboBox(JComboBox<Contribuinte> comboBox) {
		comboBox.removeAllItems();
		List<Contribuinte> pessoas = new ArrayList<Contribuinte>();
		try {
			pessoas = new DBBusca().buscaContribuintes(null,true);
			for(Contribuinte p : pessoas) {
				comboBox.addItem(p);
			}	
		} catch (SQLException f) {
			// TODO Auto-generated catch block
			f.printStackTrace();
		}
	}
	public void switchPanels(JPanel panel) {
		painelCentral.removeAll();
		painelCentral.add(panel);
		painelCentral.repaint();
		painelCentral.revalidate();
	}
}
