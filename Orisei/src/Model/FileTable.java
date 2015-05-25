package Model;

import javax.swing.table.DefaultTableModel;

public class FileTable extends DefaultTableModel {

	private static final long	serialVersionUID	= -2190340731287081528L;

	public FileTable(Object[][] data, String[] headers) {
		super(data, headers);
	}
	
	public FileTable(int rows, int cols) {
		super(rows, cols);
	}

	@Override
	public boolean isCellEditable(int row, int cols) {
		return false;
	}

}
