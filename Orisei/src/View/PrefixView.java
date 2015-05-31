package View;

import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import net.miginfocom.swing.MigLayout;
import Model.RenameOperation;
import Model.Prefix;

public class PrefixView implements Operation {
	private JLabel			lblDesc;
	private JTextField		txtPrefix;
	private ActionListener	onChange;

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


		txtPrefix.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				if (onChange != null) {
					onChange.actionPerformed(null);
				}
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				if (onChange != null) {
					onChange.actionPerformed(null);
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				if (onChange != null) {
					onChange.actionPerformed(null);
				}
			}
		});
		
		panel.updateUI();
	}

	@Override
	public RenameOperation getRenamer() {
		return new Prefix(txtPrefix.getText());
	}

	@Override
	public void setChangelistener(ActionListener l) {
		this.onChange = l;

	}

}
