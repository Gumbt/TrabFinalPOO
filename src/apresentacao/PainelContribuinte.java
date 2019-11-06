package apresentacao;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
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
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.JTable;
import java.awt.Color;

public class PainelContribuinte extends JPanel {

	private JPanel cadastrarContribuinte;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTable table;
	JLayeredPane painelCentral;

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
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
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
										.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_cadastro.createSequentialGroup()
									.addGap(10)
									.addGroup(gl_cadastro.createParallelGroup(Alignment.LEADING)
										.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))))))
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
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_cadastro.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCpf)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_cadastro.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdade)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_cadastro.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEndereo)
						.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_cadastro.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblContaBancaria)
						.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
		GroupLayout gl_menuLateral = new GroupLayout(menuLateral);
		gl_menuLateral.setHorizontalGroup(
			gl_menuLateral.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_menuLateral.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_menuLateral.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnAlterar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnRemover, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_menuLateral.setVerticalGroup(
			gl_menuLateral.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_menuLateral.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnAlterar)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnRemover)
					.addContainerGap(164, Short.MAX_VALUE))
		);
		menuLateral.setLayout(gl_menuLateral);
	}
	public void switchPanels(JPanel panel) {
		painelCentral.removeAll();
		painelCentral.add(panel);
		painelCentral.repaint();
		painelCentral.revalidate();
	}
}
