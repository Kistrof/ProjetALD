package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menus extends JMenuBar
{
	private static final long serialVersionUID = 1L;
	
	private JMenu menu_file, menu_bdd, menu_fenetres, menu_aide;
	private JMenuItem file_quitter;
	private JMenuItem bdd_import, bdd_export, bdd_reset;
	private JMenuItem fen_pros, fen_nav, fen_updates;
	private JMenuItem aide_propos, aide_aide;
	
	public Menus()
	{
		super();
		
		this.menu_bdd = new JMenu("Base de données");
		
		this.bdd_import = new JMenuItem("Importer ...");
		this.menu_bdd.add(this.bdd_import);
		this.bdd_import.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				importer();
			}
		});
		
		this.bdd_export = new JMenuItem("Exporter ...");
		this.menu_bdd.add(this.bdd_export);
		this.bdd_export.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exporter();
			}
		});
		
		this.bdd_reset = new JMenuItem("Réinitialiser");
		this.menu_bdd.add(this.bdd_reset);
		this.bdd_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		
		this.menu_file = new JMenu("Fichier");
		
		this.file_quitter = new JMenuItem("Quitter");
		this.menu_file.add(this.file_quitter);
		this.file_quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		this.menu_fenetres = new JMenu("Fenêtres");
		
		this.fen_pros = new JMenuItem("Membres pro");
		this.menu_fenetres.add(this.fen_pros);
		this.fen_pros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pros();
			}
		});
		
		this.fen_nav = new JMenuItem("Navigation");
		this.menu_fenetres.add(this.fen_nav);
		this.fen_nav.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				navigation();
			}
		});
		
		this.fen_updates = new JMenuItem("Mises à jour");
		this.menu_fenetres.add(this.fen_updates);
		this.fen_updates.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updates();
			}
		});
		
		this.menu_aide = new JMenu("?");
		
		this.aide_aide = new JMenuItem("Aide");
		this.menu_aide.add(this.aide_aide);
		this.aide_aide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aide();
			}
		});
		
		this.aide_propos = new JMenuItem("A propos ...");
		this.menu_aide.add(this.aide_propos);
		this.aide_propos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				propos();
			}
		});
		
		this.add(this.menu_file);
		this.add(this.menu_bdd);
		this.add(this.menu_fenetres);
		this.add(this.menu_aide);
	}

	protected void propos() {
		// TODO Auto-generated method stub
		
	}

	protected void aide() {
		// TODO Auto-generated method stub
		
	}

	protected void updates() {
		// TODO Auto-generated method stub
		
	}

	protected void navigation() {
		// TODO Auto-generated method stub
		
	}

	protected void pros() {
		// TODO Auto-generated method stub
		
	}

	protected void reset() {
		// TODO Auto-generated method stub
		
	}

	protected void exporter() {
		// TODO Auto-generated method stub
		
	}

	protected void importer() {
		// TODO Auto-generated method stub
		
	}
}
