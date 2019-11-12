package apresentacao;
import java.awt.BorderLayout;
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

import dados.NotaFiscal;
import dados.Contribuinte;
import dados.PessoaJuridica;
import persistencia.DBBusca;
import persistencia.DBCadastro;
import persistencia.DBDeleta;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JButton;
import java.awt.event.ActionListener;
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
import javax.swing.JScrollPane;
import javax.swing.JFormattedTextField;

public class PainelDespesas extends JPanel {

	private JPanel cadastrarDespesa;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField numProtoc;
	private JTextField valorDespesa;
	private JTextField searchInput;
	private JTable table;
	JLayeredPane painelCentral;
	private JComboBox comboBox;
	private JComboBox comboBoxPJ;
	private JTextField descricao;
	private TableModelNotaFiscal dataModel;
	private JFormattedTextField boxTotal;

	/**
	 * Create the frame.
	 */
	public PainelDespesas() {
		initComponents();
	}
	public void initComponents() {
		setBounds(100, 100, 560, 388);
		setLayout(new BorderLayout(0, 0));
		
		painelCentral = new JLayeredPane();
		add(painelCentral);
		painelCentral.setLayout(new CardLayout(0, 0));
		cadastrarDespesa = new JPanel();
		painelCentral.add(cadastrarDespesa, "name_7182598454947182");
		cadastrarDespesa.setBorder(new EmptyBorder(5, 5, 5, 5));
		cadastrarDespesa.setLayout(new BorderLayout(0, 0));
		
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
		cadastrarDespesa.add(cadastro);
		
		JLabel lblCadastroDeDespesa = new JLabel("Cadastro de despesa");
		
		JLabel lblContr = new JLabel("Contribuinte:");
		
		JLabel lblNumProtoc = new JLabel("Num. Protoc.:");
		
		JLabel lblValor = new JLabel("Valor:");
		
		numProtoc = new JTextField();
		numProtoc.setColumns(10);
		
		valorDespesa = new JTextField();
		valorDespesa.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				funcCadastraDespesa();
			}
		});
		
		comboBox = new JComboBox();
		
		JLabel lblPessoaJridica = new JLabel("Pessoa J\u00FAridica:");
		
		comboBoxPJ = new JComboBox();
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o:");
		
		descricao = new JTextField();
		descricao.setColumns(10);
		GroupLayout gl_cadastro = new GroupLayout(cadastro);
		gl_cadastro.setHorizontalGroup(
			gl_cadastro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cadastro.createSequentialGroup()
					.addGroup(gl_cadastro.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_cadastro.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblValor))
						.addGroup(gl_cadastro.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_cadastro.createParallelGroup(Alignment.LEADING)
								.addComponent(lblContr)
								.addComponent(lblPessoaJridica)
								.addComponent(lblNumProtoc)
								.addComponent(lblDescricao))
							.addGap(22)
							.addGroup(gl_cadastro.createParallelGroup(Alignment.LEADING)
								.addComponent(descricao, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_cadastro.createParallelGroup(Alignment.LEADING, false)
									.addComponent(numProtoc, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
									.addComponent(valorDespesa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(comboBoxPJ, 0, 207, Short.MAX_VALUE)
									.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnSalvar))))
						.addGroup(gl_cadastro.createSequentialGroup()
							.addGap(135)
							.addComponent(lblCadastroDeDespesa)))
					.addContainerGap(133, Short.MAX_VALUE))
		);
		gl_cadastro.setVerticalGroup(
			gl_cadastro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cadastro.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCadastroDeDespesa)
					.addGap(18)
					.addGroup(gl_cadastro.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblContr)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(gl_cadastro.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxPJ, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPessoaJridica))
					.addGap(18)
					.addGroup(gl_cadastro.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumProtoc)
						.addComponent(numProtoc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_cadastro.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblValor)
						.addComponent(valorDespesa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_cadastro.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDescricao)
						.addComponent(descricao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addComponent(btnSalvar)
					.addContainerGap(115, Short.MAX_VALUE))
		);
		cadastro.setLayout(gl_cadastro);
		
		JPanel consultarDespesas = new JPanel();
		painelCentral.add(consultarDespesas, "name_7183621705109210");
		
		searchInput = new JTextField();
		searchInput.setColumns(10);
		
		JLabel lblConsultarDespesas = new JLabel("Consultar Despesas");
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dataModel = new TableModelNotaFiscal(criaListaNotaFiscal(searchInput.getText()));
				table.setModel(dataModel);
			}
		});
		
		JLabel lblDigiteOCpf = new JLabel("Digite o CPF:");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblDespesasTotais = new JLabel("Despesas totais:");
		
		boxTotal = new JFormattedTextField();
		boxTotal.setEditable(false);
		boxTotal.setText("0");
		
		JButton btnExcluir = new JButton("Remover");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletaNotaFiscal();
			}
		});
		GroupLayout gl_consultarDespesas = new GroupLayout(consultarDespesas);
		gl_consultarDespesas.setHorizontalGroup(
			gl_consultarDespesas.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_consultarDespesas.createSequentialGroup()
					.addGroup(gl_consultarDespesas.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_consultarDespesas.createSequentialGroup()
							.addGap(133)
							.addComponent(lblConsultarDespesas))
						.addGroup(gl_consultarDespesas.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_consultarDespesas.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDespesasTotais)
								.addComponent(lblDigiteOCpf))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_consultarDespesas.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_consultarDespesas.createSequentialGroup()
									.addComponent(searchInput, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnPesquisar))
								.addGroup(gl_consultarDespesas.createSequentialGroup()
									.addComponent(boxTotal, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 195, Short.MAX_VALUE)
									.addComponent(btnExcluir))))
						.addGroup(gl_consultarDespesas.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_consultarDespesas.setVerticalGroup(
			gl_consultarDespesas.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_consultarDespesas.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblConsultarDespesas)
					.addGap(18)
					.addGroup(gl_consultarDespesas.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPesquisar)
						.addComponent(lblDigiteOCpf)
						.addComponent(searchInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_consultarDespesas.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDespesasTotais)
						.addComponent(boxTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExcluir))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		consultarDespesas.setLayout(gl_consultarDespesas);
		
		JPanel menuLateral = new JPanel();
		add(menuLateral, BorderLayout.WEST);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setBackground(new Color(143, 188, 143));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizaComboBoxContribuinte(comboBox);
				atualizaComboBoxPJ(comboBoxPJ);
				switchPanels(cadastrarDespesa);
			}
		});
		
		JButton btnNewButton_1 = new JButton("Consultar");
		btnNewButton_1.setBackground(new Color(143, 188, 143));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dataModel = new TableModelNotaFiscal(criaListaNotaFiscal(null));
				table.setModel(dataModel);
				boxTotal.setText("");
				searchInput.setText("");
				switchPanels(consultarDespesas);
			}
		});
		GroupLayout gl_menuLateral = new GroupLayout(menuLateral);
		gl_menuLateral.setHorizontalGroup(
			gl_menuLateral.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_menuLateral.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_menuLateral.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_menuLateral.setVerticalGroup(
			gl_menuLateral.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_menuLateral.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_1)
					.addContainerGap(232, Short.MAX_VALUE))
		);
		menuLateral.setLayout(gl_menuLateral);
		atualizaComboBoxContribuinte(comboBox);
		atualizaComboBoxPJ(comboBoxPJ);
		
		dataModel = new TableModelNotaFiscal(criaListaNotaFiscal(null));
		table.setModel(dataModel);
	}
	private List<NotaFiscal> criaListaNotaFiscal(String filtroCpf) {
		List<NotaFiscal> cc = new ArrayList<NotaFiscal>();
		try {
			if(filtroCpf != null && filtroCpf != "") {
				cc = new DBBusca().listaNotaFiscal(filtroCpf);
				if(cc.size()==0) {
					JOptionPane.showMessageDialog(null, "Nenhum resultado encontrado!");
				}else {
					float valorTotal = 0;
					for(NotaFiscal c : cc) {
						valorTotal = valorTotal + c.getValor();
					}
					boxTotal.setText(String.valueOf(valorTotal));
				}
			}
		} catch (SQLException f) {
			// TODO Auto-generated catch block
			f.printStackTrace();
		}
		return cc;
	}
	private void deletaNotaFiscal() {
		if(table.getSelectedRowCount() == 1 ) {
			int idNotaFiscal = (int) table.getModel().getValueAt(table.getSelectedRow(), 0);
			try {
	
				boolean r = new DBDeleta().deletaNotaFiscal(idNotaFiscal);
				if(r) {
					JOptionPane.showMessageDialog(null, "Item deletado com sucesso",null, JOptionPane.PLAIN_MESSAGE, null);
					
				}
				
			} catch (SQLException f) {
				// TODO Auto-generated catch block
				f.printStackTrace();
			}
			dataModel = new TableModelNotaFiscal(criaListaNotaFiscal(searchInput.getText()));
			table.setModel(dataModel);
		}else {
			JOptionPane.showMessageDialog(null, "Selecione um item para deletar",null,JOptionPane.WARNING_MESSAGE);
		}
	}
	public void funcCadastraDespesa() {
		try {
			Contribuinte contri = (Contribuinte) comboBox.getSelectedItem();
			PessoaJuridica pj = (PessoaJuridica) comboBoxPJ.getSelectedItem();
			boolean r = new DBCadastro().cadastroNotaFiscal(
					Integer.parseInt(numProtoc.getText()),
					Float.parseFloat(valorDespesa.getText()),
					descricao.getText(),
					contri.getId(),
					pj.getCnpj(),
					pj.getId()
					);
			if(r) {
				
				JOptionPane.showMessageDialog(null, "Cadastro de despesa realizado com sucesso!");
				
				numProtoc.setText("");
				valorDespesa.setText("");
				descricao.setText("");
				comboBox.setSelectedIndex(0);
				comboBoxPJ.setSelectedIndex(0);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void atualizaComboBoxContribuinte(JComboBox<Contribuinte> comboBox) {
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
	public void atualizaComboBoxPJ(JComboBox<PessoaJuridica> comboBox) {
		comboBox.removeAllItems();
		List<PessoaJuridica> pessoas = new ArrayList<PessoaJuridica>();
		try {
			pessoas = new DBBusca().buscaPJ(null,true);
			for(PessoaJuridica p : pessoas) {
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
