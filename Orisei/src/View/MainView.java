package View;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JMenuBar;

import net.miginfocom.swing.MigLayout;

import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import Model.RenameOperations;
import Model.FileTable;

import java.io.File;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MainView {

	private JFrame					frmOrisei;
	private JButton					btnNewButton;
	private JTable					table;
	private DefaultTableModel		tableData;
	private JComboBox<Operation>	cBoxOperation;
	private JPanel					panel;
	private JMenu					mnFile;
	private JMenuItem				mnSelectFiles;
	private JMenuItem				mnSelectFolder;
	private JMenu					mnHelp;
	private JMenuItem				mntmAbout;

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

		mnFile = new JMenu("Datei");
		menuBar.add(mnFile);

		mnSelectFiles = new JMenuItem("Dateien auswählen");
		mnFile.add(mnSelectFiles);

		mnSelectFiles.addActionListener((e) -> {
			JFileChooser fileSelect = new JFileChooser();
			fileSelect.setMultiSelectionEnabled(true);
			fileSelect.setFileSelectionMode(JFileChooser.FILES_ONLY);

			int returnVal = fileSelect.showOpenDialog(null);

			if (returnVal != JFileChooser.APPROVE_OPTION) {
				return;
			}

			File[] files = fileSelect.getSelectedFiles();
			System.out.printf("selected %d files\n", files.length);

			for (File file : files) {
				tableData.addRow(new Object[] { file.getName(), "" });
			}

			table.updateUI();
		});

		mnSelectFolder = new JMenuItem("Ordner öffnen");
		mnSelectFolder.addActionListener((e) -> {
			JFileChooser folderSelect = new JFileChooser();
			folderSelect.setMultiSelectionEnabled(false);
			folderSelect.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

			int returnVal = folderSelect.showOpenDialog(null);

			if (returnVal != JFileChooser.APPROVE_OPTION) {
				return;
			}

			File[] files = folderSelect.getSelectedFiles();
			System.out.printf("selected %d files\n", files.length);
			for (File file : files) {
				System.out.printf("uhh shiny! %s\n", file.getName().toString());
			}
		});
		mnFile.add(mnSelectFolder);
		mnSelectFolder.setEnabled(false); // TODO: Enable folder select again.

		mnHelp = new JMenu("Hilfe");
		menuBar.add(mnHelp);

		mntmAbout = new JMenuItem("über");
		mnHelp.add(mntmAbout);

		frmOrisei.getContentPane().setLayout(new MigLayout("", "[][grow][]", "[center][grow]"));

		cBoxOperation = this.makeOperationSelect();
		frmOrisei.getContentPane().add(cBoxOperation, "cell 0 0,growx");

		panel = new JPanel();
		frmOrisei.getContentPane().add(panel, "cell 1 0,grow");

		btnNewButton = new JButton("Umbenennen");
		frmOrisei.getContentPane().add(btnNewButton, "cell 2 0");

		cBoxOperation.addActionListener((e) -> {
			Operation selectedOperation = (Operation) cBoxOperation.getSelectedItem();
			selectedOperation.updateOperationInputs(panel);
		});

		table = new JTable();

		tableData = new FileTable(0, 0);
		tableData.setColumnIdentifiers(new String[] { "Originame", "Neuer Name" });

		table.setColumnSelectionAllowed(true);
		table.setModel(tableData);

		frmOrisei.getContentPane().add(new JScrollPane(table), "cell 0 1 3 1,grow");

		// Render Init Option
		((Operation) cBoxOperation.getSelectedItem()).updateOperationInputs(panel);
	}

	private JComboBox<Operation> makeOperationSelect() {
		JComboBox<Operation> comboBox = new JComboBox<Operation>();
		comboBox.addItem(new Operation(RenameOperations.Count));
		comboBox.addItem(new Operation(RenameOperations.Prefix));
		comboBox.addItem(new Operation(RenameOperations.Suffix));
		comboBox.addItem(new Operation(RenameOperations.SearchAndReplace));

		return comboBox;
	}
}
