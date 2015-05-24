package View;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;

import net.miginfocom.swing.MigLayout;
import Model.RenameOperations;

public class Operation {
	private RenameOperations type;

	public Operation(RenameOperations type) {
		this.type = type;
	}

	public void updateOperationInputs(JPanel panel) {
		panel.removeAll();

		switch (this.type) {
		case Count:
			countView(panel);
			break;
		case Prefix:
			prefixView(panel);
			break;
		case Suffix:
			suffixView(panel);
			break;
		case SearchAndReplace:
			searchAndReplaceView(panel);
		default:
			break;
		}
		panel.updateUI();
	}

	@Override
	public String toString() {
		return type.toString();
	}

	// TODO: Remove BorderLayout and use MigLayout... EVERYWHERE!
	private void countView(JPanel panel) {
		panel.setLayout(new MigLayout("", "[grow]", "[][]"));

		JLabel lblStart = new JLabel("Start", JLabel.LEFT);
		panel.add(lblStart, "cell 0 0");

		JFormattedTextField textField = new JFormattedTextField("1");
		panel.add(textField, "cell 0 1,growx");
		textField.setColumns(10);
	}

	private void prefixView(JPanel panel) {
		panel.setLayout(new MigLayout("", "[grow]", "[][]"));

		JLabel lblDesc = new JLabel("Präfix");
		panel.add(lblDesc, "cell 0 0");
		
		JTextField textField = new JTextField();
		panel.add(textField, "cell 0 1,growx");
		textField.setColumns(10);
	}

	private void suffixView(JPanel panel) {
		panel.setLayout(new MigLayout("", "[grow]", "[]"));

		JLabel lblDesc = new JLabel("Suffix");
		panel.add(lblDesc, "cell 0 0");
		
		JTextField textField = new JTextField();
		panel.add(textField, "cell 0 1,growx");
		textField.setColumns(10);
	}

	private void searchAndReplaceView(JPanel panel) {
		panel.setLayout(new MigLayout("", "[grow][grow]", "[][]"));

		JLabel lblSearch = new JLabel("Suchen", JLabel.LEFT);
		panel.add(lblSearch, "cell 0 0");

		JTextField txtSearch = new JTextField();
		panel.add(txtSearch, "cell 0 1,growx");
		txtSearch.setColumns(10);

		JLabel lblReplace = new JLabel("Ersetzen", JLabel.LEFT);
		panel.add(lblReplace, "cell 1 0");

		JTextField txtReplace = new JTextField();
		panel.add(txtReplace, "cell 1 1,growx");
		txtReplace.setColumns(10);

	}

}
