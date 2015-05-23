package View;

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
		
		JTextField textField;
		JTextField textField_1;
		switch (this.type) {
			case Count:
				panel.setLayout(new MigLayout("", "[grow][grow]", "[]"));
				
				textField = new JTextField();
				panel.add(textField, "cell 0 0,growx");
				textField.setColumns(10);
				
				textField_1 = new JTextField();
				panel.add(textField_1, "cell 1 0,growx");
				textField_1.setColumns(10);
				break;
			default:
				break;
		}
		panel.updateUI();
	}
	
	@Override
	public String toString() {
		return type.toString();
	}
}
