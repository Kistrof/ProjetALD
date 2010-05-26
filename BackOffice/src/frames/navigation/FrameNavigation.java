package frames.navigation;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

import frames.InternalFrame;

public class FrameNavigation extends InternalFrame
{
	private static final long serialVersionUID = 1L;
	
	private static final String HOME_URL = "http://127.0.0.1:8080/Web/Accueil.do";
	
	private JEditorPane editor;
	private JScrollPane scroll;
	private JButton home;
	
	public FrameNavigation()
	{
		super("Navigation");
		
		home = new JButton("Revenir à l'accueil du site");
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				ouvrirPage(HOME_URL);
			}
		});
		
		try
		{
			editor = new JEditorPane(HOME_URL);
			editor.setEditable(false);
			editor.addHyperlinkListener(new HyperlinkListener() {
				public void hyperlinkUpdate(HyperlinkEvent e)
				{
					if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
					{
						String adr = e.getURL().toExternalForm();
						ouvrirPage(adr);
					}
				}
			});
		}
		catch (IOException e)
		{
			System.out.println("*** IOException : "+e.getMessage());
		}
		
		scroll = new JScrollPane(editor);
		
		this.setLayout(new BorderLayout());
		this.add(home, BorderLayout.NORTH);
		this.add(scroll, BorderLayout.CENTER);
	}
	
	private boolean ouvrirPage(String url)
	{
		try
		{
			editor.setPage(url);
		}
		catch (IOException e)
		{
			return false;
		}
		return true;
	}
	
}
