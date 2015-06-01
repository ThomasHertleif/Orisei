package View;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.TransferHandler;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import net.miginfocom.swing.MigLayout;

import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import Controller.FileList;
import Model.FileTable;

import java.io.File;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.util.*;

public class MainView {

	private JFrame					frmOrisei;
	private JButton					btnRename;
	private JTable					table;
	private DefaultTableModel		tableData;
	private JComboBox<Operation>	cBoxOperation;
	private JPanel					panel;
	private JMenu					mnFile;
	private JMenuItem				mnSelectFiles;
	private JMenuItem				mnSelectFolder;
	private JMenu					mnHelp;
	private JMenuItem				mntmAbout;
	private FileList				fileList;

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
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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

			fileList.replaceFiles(files);
			fileList.triggerChange();
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

			// FIXME: Handle directory loading.
			});

		mnFile.add(mnSelectFolder);
		mnSelectFolder.setEnabled(false); // TODO: Enable folder select again.

		mnHelp = new JMenu("Hilfe");
		menuBar.add(mnHelp);

		mntmAbout = new JMenuItem("Über");
		mnHelp.add(mntmAbout);

		mntmAbout.addActionListener((e) -> {
			Component infoFrame = null;
			JOptionPane.showMessageDialog(infoFrame, "Orisei v0.1.0 von Thomas Hertleif", "Über",
				JOptionPane.PLAIN_MESSAGE);
		});

		frmOrisei.getContentPane().setLayout(new MigLayout("", "[][grow][]", "[center][grow]"));

		cBoxOperation = this.makeOperationSelect();
		frmOrisei.getContentPane().add(cBoxOperation, "cell 0 0,growx");

		panel = new JPanel();
		frmOrisei.getContentPane().add(panel, "cell 1 0,grow");

		btnRename = new JButton("Umbenennen");
		frmOrisei.getContentPane().add(btnRename, "cell 2 0");

		btnRename.addActionListener((e) -> {
			fileList.renameRealFiles();
		});

		cBoxOperation.addActionListener((e) -> {
			Operation selectedOperation = (Operation) cBoxOperation.getSelectedItem();
			selectedOperation.updateUI(panel);
			fileList.setRenamer(selectedOperation.getRenamer());
			selectedOperation.setChangelistener((l) -> {
				fileList.setRenamer(selectedOperation.getRenamer());
				fileList.triggerChange();
			});
		});

		table = new JTable();
		// TODO: Make D&D happening
		TransferHandler dropHandler = new TransferHandler() {
			@Override
			public boolean canImport(TransferHandler.TransferSupport info) {
				// we only import FileList
				if (!info.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
					return false;
				}
				return true;
			}

			@Override
			public boolean importData(TransferHandler.TransferSupport info) {
				if (!info.isDrop()) {
					return false;
				}

				// Check for FileList flavor
				if (!info.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
					displayDropLocation("List doesn't accept a drop of this type.");
					return false;
				}

				// Get the fileList that is being dropped.
				Transferable t = info.getTransferable();
				List<File> data;
				try {
					fileList.triggerChange();
				} catch (Exception e) {
					return false;
				}
				return false;
			}

			private void displayDropLocation(String string) {
				System.out.println(string);
			}
		};

		frmOrisei.setTransferHandler(dropHandler);

		tableData = new FileTable(0, 0);
		tableData.setColumnIdentifiers(new String[] { "Originame", "Neuer Name" });

		fileList = new FileList(tableData, table);

		table.setColumnSelectionAllowed(true);
		table.setModel(tableData);

		frmOrisei.getContentPane().add(new JScrollPane(table), "cell 0 1 3 1,grow");

		// Render initial option
		// TODO: Reactor the following to note just repeat the select box event
		// listener code
		Operation selectedOperation = (Operation) cBoxOperation.getSelectedItem();
		selectedOperation.updateUI(panel);
		fileList.setRenamer(selectedOperation.getRenamer());
		selectedOperation.setChangelistener((l) -> {
			fileList.setRenamer(selectedOperation.getRenamer());
			fileList.triggerChange();
		});
	}

	private JComboBox<Operation> makeOperationSelect() {
		JComboBox<Operation> comboBox = new JComboBox<Operation>();
		comboBox.addItem(new CountView());
		comboBox.addItem(new PrefixView());
		comboBox.addItem(new SuffixView());
		comboBox.addItem(new SearchAndReplaceView());

		return comboBox;
	}
}
