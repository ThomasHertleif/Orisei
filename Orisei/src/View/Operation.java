package View;

import javax.swing.JPanel;
import Model.RenameOperation;

public interface Operation {
	public void updateUI(JPanel panel);
	public RenameOperation getRenamer();
}
