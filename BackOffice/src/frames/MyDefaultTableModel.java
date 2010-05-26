package frames;

import javax.swing.table.DefaultTableModel;

public class MyDefaultTableModel extends DefaultTableModel
{
	private static final long serialVersionUID = 1L;

	public boolean isCellEditable(int rowIndex, int columnIndex)
	{
		return false;
	}
}