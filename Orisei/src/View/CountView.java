package View;

import java.awt.event.ActionListener;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import net.miginfocom.swing.MigLayout;
import Model.RenameOperation;
import Model.Count;

public class CountView implements Operation {
	private JLabel				lblStart;
	private JFormattedTextField	txtStart;
	private ActionListener		onChange;
	private JTextField			txtSep;

	public CountView() {
	}
	
	public String toString() {
		return "Count";
	};

	
	
	@Override
	public void updateUI(JPanel panel, JPanel optionPanel) {
		panel.removeAll();

		panel.setLayout(new MigLayout("", "[grow]", "[][]"));

		lblStart = new JLabel("Start", JLabel.LEFT);
		panel.add(lblStart, "cell 0 0");

		txtStart = new JFormattedTextField("1");
		panel.add(txtStart, "cell 0 1,growx");
		txtStart.setColumns(10);

		txtStart.getDocument().addDocumentListener(new DocumentListener() {

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
		int startValue;
		try {
			startValue = Integer.parseInt(txtStart.getText());
		} catch (Exception e) {
			startValue = 0;
		}
		
		return new Count(startValue);
	}

	@Override
	public void setChangelistener(ActionListener l) {
		this.onChange = l;
		
	}

	@Override
	public void updateOptionPanel(JPanel optionPanel) {
		optionPanel.removeAll();

		optionPanel.setLayout(new MigLayout(""));
		txtSep = new JTextField("Hi");
		optionPanel.add(txtSep, " cell 0 0");

		optionPanel.updateUI();
		
	}

	

}
