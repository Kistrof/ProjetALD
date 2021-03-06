package frames.updates;

import javax.swing.JTabbedPane;
import frames.InternalFrame;

public class FrameUpdates extends InternalFrame
{
	private static final long serialVersionUID = 1L;
	
	private JTabbedPane tabbedPane;
	
	public FrameUpdates()
	{
		super("Demandes de mise � jour");
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Personnes", null, new PanelPersonnes(), "Modifications des personnes");
		tabbedPane.addTab("Films", null, new PanelFilms(), "Modifications des films");
		tabbedPane.addTab("R�compenses", null, new PanelRecompenses(), "Modifications des r�compenses");
		tabbedPane.addTab("FilmsPersonnes", null, new PanelFilmsPersonnes(), "Modifications des relations entre film et personne");
		
		this.setContentPane(tabbedPane);
	}
}
