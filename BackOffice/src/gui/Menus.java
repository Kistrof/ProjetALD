package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Menus extends JMenuBar
{
	private static final long serialVersionUID = 1L;
	
	private JMenu menu_file, menu_bdd, menu_fenetres, menu_aide;
	private JMenuItem file_quitter;
	private JMenuItem bdd_import, bdd_export, bdd_reset;
	private JCheckBoxMenuItem fen_pros, fen_nav, fen_updates;
	private JMenuItem aide_propos;
	
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
		
		this.fen_pros = new JCheckBoxMenuItem("Membres pro");
		this.menu_fenetres.add(this.fen_pros);
		this.fen_pros.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Principale.getInstance().toggleFrame(0);
			}
		});
		
		this.fen_nav = new JCheckBoxMenuItem("Navigation");
		this.menu_fenetres.add(this.fen_nav);
		this.fen_nav.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Principale.getInstance().toggleFrame(1);
			}
		});
		
		this.fen_updates = new JCheckBoxMenuItem("Mises à jour");
		this.menu_fenetres.add(this.fen_updates);
		this.fen_updates.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				Principale.getInstance().toggleFrame(2);
			}
		});
		
		this.menu_aide = new JMenu("?");
		
		this.aide_propos = new JMenuItem("A propos");
		this.menu_aide.add(this.aide_propos);
		this.aide_propos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				propos();
			}
		});
		
		this.add(this.menu_file);
		//this.add(this.menu_bdd);
		this.add(this.menu_fenetres);
		this.add(this.menu_aide);
	}

	protected void propos()
	{
		JPanel p = new JPanel(new GridLayout(0, 1));
		p.add(new JLabel("kikoo"));
		p.add(new JLabel("lol"));
		p.add(new JLabel("mdr"));
		p.add(new JLabel("ptdr"));
		p.add(new JLabel("rofl"));
		String[] options = {"Fermer"};
		JOptionPane.showOptionDialog(Principale.getInstance(), p, "A propos", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
	}
	
	protected void reset()
	{
		int reponse = JOptionPane.showConfirmDialog(Principale.getInstance(), "Etes-vous certain de vouloir réinitialiser la base de données ?", "Réinitialisation BDD", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (reponse == JOptionPane.YES_OPTION)
		{
			reponse = JOptionPane.showConfirmDialog(Principale.getInstance(), "Vous êtes quand même sur le point de vider tout le site !\nToujours envie de continuer ?", "Réinitialisation BDD", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (reponse == JOptionPane.YES_OPTION)
			{
				reponse = JOptionPane.showConfirmDialog(Principale.getInstance(), "Aucun retour en arrière n'est possible après l'opération ...", "Réinitialisation BDD", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
				if (reponse == JOptionPane.OK_OPTION)
				{
					
					
					// TO-DO reset de la BDD
					System.out.println("RESET BDD !!!!!");
					
					
				}
			}
		}
	}

	protected void exporter() {
		// TO-DO JFileChooser pour exporter la BDD
		
	}

	protected void importer() {
		// TO-DO JFileChooser pour importer une BDD
		
	}
}
