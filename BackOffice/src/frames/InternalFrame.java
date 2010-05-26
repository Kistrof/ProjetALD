package frames;

import javax.swing.JInternalFrame;

public class InternalFrame extends JInternalFrame
{
	private static final long serialVersionUID = 1L;
	
	public InternalFrame(String titre)
	{
		super(titre);
		this.setResizable(true);
		this.setMaximizable(true);
		this.setIconifiable(true);
		this.setSize(640, 480);
	}
}
