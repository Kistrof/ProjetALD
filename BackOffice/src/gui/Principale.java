package gui;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;

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
	
	
	// TODO Internal frames
	
	
	
	private Principale()
	{
		super("BackOffice IMDB");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		
		this.menus = new Menus();
		this.setJMenuBar(menus);
		
		this.desktop = new JDesktopPane();
		
		this.setContentPane(this.desktop);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	
	
	
	
	
	
}
