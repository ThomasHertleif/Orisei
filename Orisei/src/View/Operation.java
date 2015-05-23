package View;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
		panel.setLayout(new MigLayout("", "[grow][grow]", "[]"));

		JPanel pStart = new JPanel(new BorderLayout());

		JLabel lblStart = new JLabel("Start", JLabel.LEFT);
		pStart.add(lblStart, BorderLayout.NORTH);

		JTextField textField = new JTextField("1");
		pStart.add(textField, BorderLayout.CENTER);
		textField.setColumns(10);

		panel.add(pStart, "cell 0 0,growx");
	}

	private void prefixView(JPanel panel) {
		panel.setLayout(new MigLayout("", "[grow][grow]", "[]"));

		JTextField textField = new JTextField();
		panel.add(textField, "cell 0 0,growx");
		textField.setColumns(10);
	}

	private void suffixView(JPanel panel) {
		panel.setLayout(new MigLayout("", "[grow][grow]", "[]"));

		JTextField textField = new JTextField();
		panel.add(textField, "cell 0 0,growx");
		textField.setColumns(10);
	}

	private void SearchAndReplaceView(JPanel panel) {
		panel.setLayout(new MigLayout("", "[grow][grow]", "[]"));

		JTextField txtSearch = new JTextField();
		panel.add(txtSearch, "cell 0 0,growx");
		txtSearch.setColumns(10);

	}

}
