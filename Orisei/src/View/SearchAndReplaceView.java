package View;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import Model.RenameOperation;
import Model.SearchAndReplace;

public class SearchAndReplaceView implements Operation {

	public String toString() {
		return "Suchen und Ersetzen";
	};

	private JLabel		lblSearch;
	private JTextField	txtSearch;
	private JLabel		lblReplace;
	private JTextField	txtReplace;

	@Override
	public void updateUI(JPanel panel) {
		panel.removeAll();
		panel.setLayout(new MigLayout("", "[grow][grow]", "[][]"));

		lblSearch = new JLabel("Suchen", JLabel.LEFT);
		panel.add(lblSearch, "cell 0 0");

		txtSearch = new JTextField();
		panel.add(txtSearch, "cell 0 1,growx");
		txtSearch.setColumns(10);

		lblReplace = new JLabel("Ersetzen", JLabel.LEFT);
		panel.add(lblReplace, "cell 1 0");

		txtReplace = new JTextField();
		panel.add(txtReplace, "cell 1 1,growx");
		txtReplace.setColumns(10);
		
		panel.updateUI();
	}

	@Override
	public RenameOperation getRenamer() {
		return new SearchAndReplace(
			txtSearch.getText(),
			txtReplace.getText()
		);
	}

}
