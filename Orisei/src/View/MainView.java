package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class MainView {

	private JFrame frmOrisei;
	private JTextField txtSelect;
	private JTextField txtReplace;
	private JTable tblOriginal;
	private JTable tblPreview;
	private JButton btnRename;

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
		frmOrisei.getContentPane().setLayout(null);
		
		txtSelect = new JTextField();
		txtSelect.setBounds(10, 39, 137, 20);
		frmOrisei.getContentPane().add(txtSelect);
		txtSelect.setColumns(10);
		
		txtReplace = new JTextField();
		txtReplace.setBounds(157, 39, 137, 20);
		frmOrisei.getContentPane().add(txtReplace);
		txtReplace.setColumns(10);
		
		tblOriginal = new JTable();
		tblOriginal.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		tblOriginal.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
				{null},
				{null},
				{null},
			},
			new String[] {
				"New column"
			}
		));
		tblOriginal.setBounds(20, 212, 179, -141);
		frmOrisei.getContentPane().add(tblOriginal);
		
		tblPreview = new JTable();
		tblPreview.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
				{null},
				{null},
				{null},
			},
			new String[] {
				"New column"
			}
		));
		tblPreview.setBounds(227, 200, 143, -141);
		frmOrisei.getContentPane().add(tblPreview);
		
		btnRename = new JButton("Rename");
		btnRename.setBounds(334, 38, 89, 23);
		frmOrisei.getContentPane().add(btnRename);
	}
}
