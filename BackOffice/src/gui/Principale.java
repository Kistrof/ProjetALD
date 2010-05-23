package gui;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import frames.FrameMembres;
import frames.FrameNavigation;
import frames.FrameUpdates;

public class Principale extends JFrame
{
	private static final long serialVersionUID = 1L;
	private static Principale instance;
	public static Principale getInstance() {
		if (instance == null) instance = new Principale();
		return instance;
	}
	
	private Menus menus;
	
	private JDesktopPane desktop;
	private JInternalFrame[] frames;
	
	private Principale()
	{
		super("BackOffice IMDB");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		
		this.menus = new Menus();
		this.setJMenuBar(menus);
		
		this.desktop = new JDesktopPane();
		
		this.frames = new JInternalFrame[3];
		this.frames[0] = new FrameMembres();
		this.frames[1] = new FrameNavigation();
		this.frames[2] = new FrameUpdates();
		
		for (int i = 0 ; i < this.frames.length ; i++)
			this.desktop.add(this.frames[i]);
		
		this.setContentPane(this.desktop);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void toggleFrame(int i)
	{
		this.frames[i].setVisible(!this.frames[i].isVisible());
	}
	
	
	
	
	
}
