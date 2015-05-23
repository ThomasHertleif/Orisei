package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import net.miginfocom.swing.MigLayout;
import javax.swing.table.DefaultTableModel;

public class MainView {

	private JFrame frmOrisei;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView window = new MainView();
					window.frmOrisei.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOrisei = new JFrame();
		frmOrisei.setTitle("Orisei");
		frmOrisei.setBounds(100, 100, 450, 300);
		frmOrisei.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmOrisei.setJMenuBar(menuBar);
		frmOrisei.getContentPane().setLayout(new MigLayout("", "[grow][grow][]", "[][grow]"));
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Suchen");
		frmOrisei.getContentPane().add(textField_1, "cell 0 0,growx");
		textField_1.setColumns(10);
		
		textField = new JTextField();
		textField.setToolTipText("Ersetzen");
		frmOrisei.getContentPane().add(textField, "cell 1 0,growx");
		textField.setColumns(10);
		
		btnNewButton = new JButton("Umbenennen");
		frmOrisei.getContentPane().add(btnNewButton, "cell 2 0");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
					{"Test", "tseT"}
			},
			new String[] {
				"Originame", "Neuer Name"
			}
		));
		frmOrisei.getContentPane().add(table, "cell 0 1 3 1,grow");
	}
}
