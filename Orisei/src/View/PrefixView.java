package View;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import Model.RenameOperation;
import Model.Prefix;

public class PrefixView implements Operation {
	private JLabel		lblDesc;
	private JTextField	txtPrefix;

	public PrefixView() {
	}

	public String toString() {
		return "Präfix";
	};

	@Override
	public void updateUI(JPanel panel) {
		panel.removeAll();

		panel.setLayout(new MigLayout("", "[grow]", "[][]"));

		lblDesc = new JLabel("Präfix");
		panel.add(lblDesc, "cell 0 0");

		txtPrefix = new JTextField();
		panel.add(txtPrefix, "cell 0 1,growx");
		txtPrefix.setColumns(10);
		
		txtPrefix.addActionListener((e) -> {
			// Prefix changed, call BuildTable thingy now!
		});

		panel.updateUI();
	}

	@Override
	public RenameOperation getRenamer() {
		return new Prefix(txtPrefix.getText());
	}

}
