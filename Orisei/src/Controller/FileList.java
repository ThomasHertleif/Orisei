package Controller;

import java.io.File;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Count;
import Model.RenameOperation;

public class FileList {

	private DefaultTableModel	target;
	private File[]				files;
	private RenameOperation		renamer;
	private JTable				table;

	public FileList(DefaultTableModel target, JTable table) {
		this.target = target;
		this.table = table;
	}

	public void triggerChange() {
		File[] files = this.getFiles();
		RenameOperation op = this.getRenamer();
		
		if (op instanceof Count) {
			((Count) op).resetCounter();
		}
		
		// remove all them rows
		if (target.getRowCount() > 0) {
		    for (int i = target.getRowCount() - 1; i > -1; i--) {
		    	target.removeRow(i);
		    }
		}

		if (files != null) {
			for (File file : files) {
				String newName = op != null ? op.makeNewName(file.getName()) : "";
				target.addRow(new Object[] { file.getName(), newName });
			}
		}

		table.updateUI();
	}

	private RenameOperation getRenamer() {
		return this.renamer;
	}

	public void setRenamer(RenameOperation renamer) {
		this.renamer = renamer;
		this.triggerChange();
	}

	private File[] getFiles() {
		return this.files;
	}

	public void replaceFiles(File[] files) {
		this.files = files;
		this.triggerChange();
	}

}
