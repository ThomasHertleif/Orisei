package View;

import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Model.RenameOperation;

public interface Operation {
	public void updateUI(JPanel panel, JPanel optionPanel);
	public RenameOperation getRenamer();
	public void setChangelistener(ActionListener l);
	public void updateOptionPanel(JPanel optionPanel);
}
