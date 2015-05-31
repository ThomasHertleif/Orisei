package View;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import Model.RenameOperation;
import Model.Count;

public class CountView implements Operation {
	private JLabel				lblStart;
	private JFormattedTextField	txtStart;

	public CountView() {
	}
	
	public String toString() {
		return "Count";
	};

	@Override
	public void updateUI(JPanel panel) {
		panel.removeAll();

		panel.setLayout(new MigLayout("", "[grow]", "[][]"));

		lblStart = new JLabel("Start", JLabel.LEFT);
		panel.add(lblStart, "cell 0 0");

		txtStart = new JFormattedTextField("1");
		panel.add(txtStart, "cell 0 1,growx");
		txtStart.setColumns(10);

		panel.updateUI();
	}

	@Override
	public RenameOperation getRenamer() {
		int startValue = Integer.parseInt(txtStart.getText());
		return new Count(startValue);
	}

}
