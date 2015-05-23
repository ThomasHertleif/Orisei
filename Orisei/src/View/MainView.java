package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JMenuBar;

import net.miginfocom.swing.MigLayout;

import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;

import Model.RenameOperations;
import Model.SearchAndReplace;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class MainView {

	private JFrame frmOrisei;
	private JButton btnNewButton;
	private JTable table;
	private JComboBox<Operation> cBoxOperation;
	private JPanel panel;
	private JTextField textField;
	private JTextField textField_1;

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
		frmOrisei.getContentPane().setLayout(new MigLayout("", "[grow][grow][]", "[grow][grow]"));
		
		cBoxOperation = this.makeOperationSelect();
		frmOrisei.getContentPane().add(cBoxOperation, "cell 0 0,growx");
		
		panel = new JPanel();
		frmOrisei.getContentPane().add(panel, "cell 1 0,grow");
		
		
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
		frmOrisei.getContentPane().add(new JScrollPane(table), "cell 0 1 3 1,grow");
		
		cBoxOperation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Operation selectedOperation = (Operation) cBoxOperation.getSelectedItem();
				selectedOperation.updateOperationInputs(panel);
			}
		});
	}
	
	private JComboBox<Operation> makeOperationSelect() {
		JComboBox<Operation> comboBox = new JComboBox<Operation>();
		comboBox.addItem(new Operation(RenameOperations.Count));
		comboBox.addItem(new Operation(RenameOperations.Prefix));
		
		return comboBox;
	}
}
