package apresentacao;
import java.awt.BorderLayout;
import persistencia.DBConnection;
import java.awt.EventQueue;

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
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JComboBox;

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
	private JTextField textField_10;
	private JTable table;
	JLayeredPane painelCentral;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PainelContribuinte frame = new PainelContribuinte();
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
	public PainelContribuinte() {
		initComponents();
	}
	public void initComponents() {
		setBounds(100, 100, 450, 300);
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
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		
		JLabel lblConsultarContribuintes = new JLabel("Consultar contribuintes");
		
		JButton btnPesquisar = new JButton("Pesquisar");
		
		table = new JTable();
		GroupLayout gl_consultarContribuinte = new GroupLayout(consultarContribuinte);
		gl_consultarContribuinte.setHorizontalGroup(
			gl_consultarContribuinte.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_consultarContribuinte.createSequentialGroup()
					.addGroup(gl_consultarContribuinte.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_consultarContribuinte.createSequentialGroup()
							.addGap(133)
							.addComponent(lblConsultarContribuintes))
						.addGroup(gl_consultarContribuinte.createSequentialGroup()
							.addGap(33)
							.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnPesquisar))
						.addGroup(gl_consultarContribuinte.createSequentialGroup()
							.addContainerGap()
							.addComponent(table, GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_consultarContribuinte.setVerticalGroup(
			gl_consultarContribuinte.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_consultarContribuinte.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblConsultarContribuintes)
					.addGap(18)
					.addGroup(gl_consultarContribuinte.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPesquisar))
					.addGap(11)
					.addComponent(table, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
					.addContainerGap())
		);
		consultarContribuinte.setLayout(gl_consultarContribuinte);
		
		JPanel alterarContribuinte = new JPanel();
		painelCentral.add(alterarContribuinte, "name_7183845445072259");
		
		JLabel lblAlterarContribuinte = new JLabel("Alterar contribuinte");
		GroupLayout gl_alterarContribuinte = new GroupLayout(alterarContribuinte);
		gl_alterarContribuinte.setHorizontalGroup(
			gl_alterarContribuinte.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_alterarContribuinte.createSequentialGroup()
					.addGap(137)
					.addComponent(lblAlterarContribuinte)
					.addContainerGap(166, Short.MAX_VALUE))
		);
		gl_alterarContribuinte.setVerticalGroup(
			gl_alterarContribuinte.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_alterarContribuinte.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAlterarContribuinte)
					.addContainerGap(275, Short.MAX_VALUE))
		);
		alterarContribuinte.setLayout(gl_alterarContribuinte);
		
		JPanel removerContribuinte = new JPanel();
		painelCentral.add(removerContribuinte, "name_7183864462826088");
		
		JLabel lblRemoverContribuinte = new JLabel("Remover contribuinte");
		GroupLayout gl_removerContribuinte = new GroupLayout(removerContribuinte);
		gl_removerContribuinte.setHorizontalGroup(
			gl_removerContribuinte.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_removerContribuinte.createSequentialGroup()
					.addGap(120)
					.addComponent(lblRemoverContribuinte)
					.addContainerGap(126, Short.MAX_VALUE))
		);
		gl_removerContribuinte.setVerticalGroup(
			gl_removerContribuinte.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_removerContribuinte.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblRemoverContribuinte)
					.addContainerGap(275, Short.MAX_VALUE))
		);
		removerContribuinte.setLayout(gl_removerContribuinte);
		
		JPanel cadastrarBens = new JPanel();
		painelCentral.add(cadastrarBens, "name_7288855328182789");
		
		JLabel lblCadastroDeBens = new JLabel("Cadastro de bens");
		
		JLabel lblNome_1 = new JLabel("Nome:");
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo:");
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor:");
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		
		JLabel lblContribuinte = new JLabel("Contribuinte:");
		
		JComboBox comboBox = new JComboBox();
		
		JButton btnSalvar_1 = new JButton("Salvar");
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
								.addComponent(textField_12, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)))
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
						.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_cadastrarBens.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTipo)
						.addComponent(textField_12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_cadastrarBens.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblValor)
						.addComponent(textField_13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_cadastrarBens.createParallelGroup(Alignment.LEADING)
						.addComponent(lblContribuinte)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		
		JComboBox comboBox_1 = new JComboBox();
		
		JButton btnSalvar_2 = new JButton("Salvar");
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
								.addComponent(textField_17, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_16, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_15, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_14, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)))
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
						.addComponent(textField_14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_cadastrarDependente.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCpf_1)
						.addComponent(textField_15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_cadastrarDependente.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdade_1)
						.addComponent(textField_16, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_cadastrarDependente.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEndereo_1)
						.addComponent(textField_17, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_cadastrarDependente.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblContribuinte_1)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
				switchPanels(consultarContribuinte);
			}
		});
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBackground(new Color(143, 188, 143));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(alterarContribuinte);
			}
		});
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBackground(new Color(143, 188, 143));
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(removerContribuinte);
			}
		});
		
		JButton btnCadastroDeBens = new JButton("Cadastro bens");
		btnCadastroDeBens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(cadastrarBens);
			}
		});
		btnCadastroDeBens.setBackground(new Color(143, 188, 143));
		
		JButton btnCadastroDependente = new JButton("Cadastro dependente");
		btnCadastroDependente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
						.addComponent(btnCadastroDeBens, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
						.addComponent(btnRemover, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
						.addComponent(btnAlterar, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
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
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnAlterar)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnRemover)
					.addContainerGap(98, Short.MAX_VALUE))
		);
		menuLateral.setLayout(gl_menuLateral);
	}
	public void funcCadastraContribuinte() {
		try {
			Connection con = DBConnection.faz_conexao();
			String sql = "insert into contribuinte(nome, cpf, idade,endereco,conta_bancaria) values (?, ?, ?, ?, ?)";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, inputNomeCadCont.getText());
			stmt.setString(2, inputCpfCadCont.getText());
			stmt.setInt(3, Integer.parseInt(inputIdadeCadCont.getText()));
			stmt.setString(4, inputEndCadCont.getText());
			stmt.setInt(5, Integer.parseInt(inputContBanCadCont.getText()));

			stmt.execute();
			stmt.close();
			con.close();
			
			JOptionPane.showMessageDialog(null, "Cadastro do Bem Realizado com Sucesso!");
			
			inputNomeCadCont.setText("");
			inputCpfCadCont.setText("");
			inputIdadeCadCont.setText("");
			inputEndCadCont.setText("");
			inputContBanCadCont.setText("");
			
			//comboBoxContri.setSelectedItem("");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void switchPanels(JPanel panel) {
		painelCentral.removeAll();
		painelCentral.add(panel);
		painelCentral.repaint();
		painelCentral.revalidate();
	}
}
