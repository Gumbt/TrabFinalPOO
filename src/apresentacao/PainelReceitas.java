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

public class PainelReceitas extends JPanel {

	private JPanel cadastrarReceita;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
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
					PainelReceitas frame = new PainelReceitas();
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
	public PainelReceitas() {
		initComponents();
	}
	public void initComponents() {
		setBounds(100, 100, 450, 300);
		setLayout(new BorderLayout(0, 0));
		
		painelCentral = new JLayeredPane();
		add(painelCentral);
		painelCentral.setLayout(new CardLayout(0, 0));
		cadastrarReceita = new JPanel();
		painelCentral.add(cadastrarReceita, "name_7182598454947182");
		cadastrarReceita.setBorder(new EmptyBorder(5, 5, 5, 5));
		cadastrarReceita.setLayout(new BorderLayout(0, 0));
		
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
		cadastrarReceita.add(cadastro);
		
		JLabel lblCadastroDeReceita = new JLabel("Cadastro de receita");
		
		JLabel lblCpfContr = new JLabel("CPF do contribuinte:");
		
		JLabel lblNumProtoc = new JLabel("Num. Protoc.:");
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		
		JLabel lblValor = new JLabel("Valor:");
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		GroupLayout gl_cadastro = new GroupLayout(cadastro);
		gl_cadastro.setHorizontalGroup(
			gl_cadastro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cadastro.createSequentialGroup()
					.addGroup(gl_cadastro.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_cadastro.createSequentialGroup()
							.addGap(103)
							.addComponent(lblCadastroDeReceita))
						.addGroup(gl_cadastro.createSequentialGroup()
							.addGap(126)
							.addComponent(btnSalvar))
						.addGroup(gl_cadastro.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_cadastro.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNumProtoc)
								.addComponent(lblCpfContr)
								.addComponent(lblCnpj)
								.addComponent(lblValor))
							.addGap(26)
							.addGroup(gl_cadastro.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(37, GroupLayout.PREFERRED_SIZE))
		);
		gl_cadastro.setVerticalGroup(
			gl_cadastro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cadastro.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCadastroDeReceita)
					.addGap(18)
					.addGroup(gl_cadastro.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCpfContr)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_cadastro.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumProtoc)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_cadastro.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCnpj)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_cadastro.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblValor)
						.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
					.addComponent(btnSalvar)
					.addGap(39))
		);
		cadastro.setLayout(gl_cadastro);
		
		JPanel consultarReceitas = new JPanel();
		painelCentral.add(consultarReceitas, "name_7183621705109210");
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		
		JLabel lblConsultarReceitas = new JLabel("Consultar Receitas");
		
		JButton btnPesquisar = new JButton("Pesquisar");
		
		table = new JTable();
		GroupLayout gl_consultarReceitas = new GroupLayout(consultarReceitas);
		gl_consultarReceitas.setHorizontalGroup(
			gl_consultarReceitas.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_consultarReceitas.createSequentialGroup()
					.addGroup(gl_consultarReceitas.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_consultarReceitas.createSequentialGroup()
							.addGap(133)
							.addComponent(lblConsultarReceitas))
						.addGroup(gl_consultarReceitas.createSequentialGroup()
							.addGap(33)
							.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnPesquisar))
						.addGroup(gl_consultarReceitas.createSequentialGroup()
							.addContainerGap()
							.addComponent(table, GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_consultarReceitas.setVerticalGroup(
			gl_consultarReceitas.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_consultarReceitas.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblConsultarReceitas)
					.addGap(18)
					.addGroup(gl_consultarReceitas.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPesquisar))
					.addGap(11)
					.addComponent(table, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
					.addContainerGap())
		);
		consultarReceitas.setLayout(gl_consultarReceitas);
		
		JPanel alterarReceitas = new JPanel();
		painelCentral.add(alterarReceitas, "name_7183845445072259");
		
		JLabel lblAlterarContribuinte = new JLabel("Alterar receitas");
		GroupLayout gl_alterarReceitas = new GroupLayout(alterarReceitas);
		gl_alterarReceitas.setHorizontalGroup(
			gl_alterarReceitas.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_alterarReceitas.createSequentialGroup()
					.addGap(137)
					.addComponent(lblAlterarContribuinte)
					.addContainerGap(166, Short.MAX_VALUE))
		);
		gl_alterarReceitas.setVerticalGroup(
			gl_alterarReceitas.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_alterarReceitas.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAlterarContribuinte)
					.addContainerGap(275, Short.MAX_VALUE))
		);
		alterarReceitas.setLayout(gl_alterarReceitas);
		
		JPanel removerReceitas = new JPanel();
		painelCentral.add(removerReceitas, "name_7183864462826088");
		
		JLabel lblRemoverContribuinte = new JLabel("Remover receitas");
		GroupLayout gl_removerReceitas = new GroupLayout(removerReceitas);
		gl_removerReceitas.setHorizontalGroup(
			gl_removerReceitas.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_removerReceitas.createSequentialGroup()
					.addGap(120)
					.addComponent(lblRemoverContribuinte)
					.addContainerGap(126, Short.MAX_VALUE))
		);
		gl_removerReceitas.setVerticalGroup(
			gl_removerReceitas.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_removerReceitas.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblRemoverContribuinte)
					.addContainerGap(275, Short.MAX_VALUE))
		);
		removerReceitas.setLayout(gl_removerReceitas);
		
		JPanel menuLateral = new JPanel();
		add(menuLateral, BorderLayout.WEST);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setBackground(new Color(143, 188, 143));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(cadastrarReceita);
			}
		});
		
		JButton btnNewButton_1 = new JButton("Consultar");
		btnNewButton_1.setBackground(new Color(143, 188, 143));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(consultarReceitas);
			}
		});
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBackground(new Color(143, 188, 143));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(alterarReceitas);
			}
		});
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBackground(new Color(143, 188, 143));
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(removerReceitas);
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
