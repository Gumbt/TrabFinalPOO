package apresentacao;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.Choice;
import javax.swing.JTabbedPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.BoxLayout;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.awt.Button;
import javax.swing.JMenuItem;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	JLayeredPane layeredPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 440);
		makeMenu();
	}
	public void makeMenu() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel1 = new JPanel();
		layeredPane.add(panel1, "name_7181077065230683");
		
		JLabel lblPainel = new JLabel("Bem vindo ao sistema de declara\u00E7\u00E3o de imposto");
		panel1.add(lblPainel);
		
		JPanel panel2 = new JPanel();
		layeredPane.add(panel2, "name_7181078832440889");
		
		JLabel lblPainel_1 = new JLabel("painel 2");
		panel2.add(lblPainel_1);
		
		JPanel panel3 = new JPanel();
		layeredPane.add(panel3, "name_7181082601325911");
		
		JLabel lblPainel_2 = new JLabel("painel 3");
		panel3.add(lblPainel_2);
		
		JPanel panel4 = new JPanel();
		layeredPane.add(panel4, "name_7181084648760399");
		
		JLabel lblPainel_3 = new JLabel("painel 4");
		panel4.add(lblPainel_3);
		
		JPanel panel5 = new JPanel();
		layeredPane.add(panel5, "name_7181086425300176");
		
		JLabel lblPainel_4 = new JLabel("painel 5");
		panel5.add(lblPainel_4);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("Contribuinte");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PainelContribuinte tc = new PainelContribuinte();
				switchPanels(tc);
			}
		});
		
		JButton btnNewButton_4 = new JButton("Inicio");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panel1);
			}
		});
		panel_1.add(btnNewButton_4);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Receitas");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PainelReceitas pr = new PainelReceitas();
				switchPanels(pr);
			}
		});
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Despesas");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panel4);
			}
		});
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Pessoa Jur\u00EDdica");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panel5);
			}
		});
		panel_1.add(btnNewButton_3);
	}
	public void switchPanels(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
}
