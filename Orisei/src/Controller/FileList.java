package Controller;

import java.io.File;
import java.util.HashMap;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Count;
import Model.RenameOperation;

public class FileList {

	private DefaultTableModel		target;
	private File[]					files;
	private RenameOperation			renamer;
	private JTable					table;
	private HashMap<File, String>	currentState;

	public FileList(DefaultTableModel target, JTable table) {
		this.target = target;
		this.table = table;
		this.currentState = new HashMap<File, String>();
	}

	private void updateState() {
		File[] files = this.getFiles();
		RenameOperation op = this.getRenamer();

		this.currentState.clear();

		if (op instanceof Count) {
			((Count) op).resetCounter();
		}

		if (files != null) {
			for (File file : files) {
				String newName = op != null ? op.makeNewName(file.getName()) : "";
				this.currentState.put(file, newName);
			}
		}
	}

	public void triggerChange() {
		// remove all them rows
		if (target.getRowCount() > 0) {
			for (int i = target.getRowCount() - 1; i > -1; i--) {
				target.removeRow(i);
			}
		}

		this.updateState();

		for (File file : this.currentState.keySet()) {
			String newName = this.currentState.get(file);
			target.addRow(new Object[] { file.getName(), newName });
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

	public void renameRealFiles() {
		for (File file : this.currentState.keySet()) {
			String newName = this.currentState.get(file);
			// target.addRow(new Object[] { file.getName(), newName });
		}
	}

	public HashMap<File, String> getCurrentState() {
		return currentState;
	}

	public void setCurrentState(HashMap<File, String> currentState) {
		this.currentState = currentState;
	}

}
