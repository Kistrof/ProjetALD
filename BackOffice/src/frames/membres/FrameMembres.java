package frames.membres;

import frames.InternalFrame;
import javax.swing.JTabbedPane;

public class FrameMembres extends InternalFrame
{
	private static final long serialVersionUID = 1L;
	
	private JTabbedPane tabbedPane;
	
	public FrameMembres()
	{
		super("Membres Pros");
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Inscriptions", null, new PanelInscriptions(), "Liste des inscriptions");
		tabbedPane.addTab("Inactifs", null, new PanelInactifs(), "Liste des membres inactifs");
		
		this.setContentPane(tabbedPane);
	}
}
