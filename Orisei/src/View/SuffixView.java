package View;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import Model.RenameOperation;
import Model.Suffix;

public class SuffixView implements Operation {
	private JLabel		lblDesc;
	private JTextField	txtSuffix;

	public SuffixView() {
	}

	public String toString() {
		return "Suffix";
	};

	@Override
	public void updateUI(JPanel panel) {
		panel.removeAll();

		panel.setLayout(new MigLayout("", "[grow]", "[][]"));

		lblDesc = new JLabel("Suffix");
		panel.add(lblDesc, "cell 0 0");

		txtSuffix = new JTextField();
		panel.add(txtSuffix, "cell 0 1,growx");
		txtSuffix.setColumns(10);
		
		txtSuffix.addActionListener((e) -> {
			// Suffix changed, call BuildTable thingy now!
		});

		panel.updateUI();
	}

	@Override
	public RenameOperation getRenamer() {
		return new Suffix(txtSuffix.getText());
	}

}
