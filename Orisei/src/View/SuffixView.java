package View;

import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import net.miginfocom.swing.MigLayout;
import Model.RenameOperation;
import Model.Suffix;

public class SuffixView implements Operation {
	private JLabel			lblDesc;
	private JTextField		txtSuffix;
	private ActionListener	onChange;
	private JCheckBox		chboxIgnorEx;

	public SuffixView() {
	}

	public String toString() {
		return "Suffix";
	};

	public void updateUI(JPanel panel, JPanel optionPanel) {
		panel.removeAll();
		System.out.println("bob");

		panel.setLayout(new MigLayout("", "[grow]", "[][]"));

		lblDesc = new JLabel("Suffix");
		panel.add(lblDesc, "cell 0 0");

		txtSuffix = new JTextField();
		panel.add(txtSuffix, "cell 0 1,growx");
		txtSuffix.setColumns(10);

		txtSuffix.getDocument().addDocumentListener(new DocumentListener() {

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
		updateOptionPanel(optionPanel);
		panel.updateUI();
	}

	@Override
	public RenameOperation getRenamer() {
		return new Suffix(txtSuffix.getText());
	}

	@Override
	public void setChangelistener(ActionListener l) {
		this.onChange = l;

	}

	@Override
	public void updateOptionPanel(JPanel optionPanel) {
		optionPanel.removeAll();
		System.out.println("options!");

		optionPanel.setLayout(new MigLayout(""));
		chboxIgnorEx = new JCheckBox("Datei erweiterung beachten");
		optionPanel.add(chboxIgnorEx, " cell 0 0");

		optionPanel.updateUI();

	}

}
