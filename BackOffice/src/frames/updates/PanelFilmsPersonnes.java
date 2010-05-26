package frames.updates;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import config.Config;

import metier.Film;
import metier.ModifRelationFilmPers;
import metier.Personne;
import metier.PersonneTemp;
import metier.Recompense;

import dao.DAOFilm;
import dao.DAOModifRelFilmPers;
import dao.DAOPersonne;
import frames.MyDefaultTableModel;

public class PanelFilmsPersonnes extends JPanel {
	
	private DAOPersonne daoPersonne;
	private DAOFilm daoFilm;
	private DAOModifRelFilmPers daoModifRelFilmPers;
	
	private ArrayList<ModifRelationFilmPers> liste;
	private JTable table;
	private MyDefaultTableModel tableModel;
	private JScrollPane scroll;
	
	private JPanel panel_details;
	private JLabel l_auteur, l_ajout_realisateur, l_ajout_producteur, l_ajout_acteur, l_suppr_realisateur, l_suppr_producteur, l_suppr_acteur;
	private JLabel v_auteur, v_ajout_realisateur, v_ajout_producteur, v_ajout_acteur, v_suppr_realisateur, v_suppr_producteur, v_suppr_acteur;	
	private JButton b_valider, b_rejeter;
	
	public PanelFilmsPersonnes() {
		daoPersonne = Config.beanFactory.getBean("daoPersonne", DAOPersonne.class);
		daoFilm = Config.beanFactory.getBean("daoFilm", DAOFilm.class);
		daoModifRelFilmPers = Config.beanFactory.getBean("daoModifRelFilmPers", DAOModifRelFilmPers.class);
	
		liste = daoModifRelFilmPers.loadAll();
		tableModel = new MyDefaultTableModel();
		tableModel.addColumn("ID");
		tableModel.addColumn("Date");
		tableModel.addColumn("Titre");
		tableModel.addColumn("Nom complet");
		table = new JTable(tableModel);
		for (int i = 0 ; i < liste.size(); i++)
		{
			ModifRelationFilmPers mod = liste.get(i);
			Film fi = mod.getOriginal();
			Film f = daoFilm.get(fi.getId());
			Personne p = null;
			if(mod.getAjout_acteur() != null) p = mod.getAjout_acteur();
			else if(mod.getAjout_producteur() != null) p = mod.getAjout_producteur();
			else if(mod.getAjout_realisateur() != null) p = mod.getAjout_realisateur();
			else if(mod.getSuppr_acteur() != null) p = mod.getSuppr_acteur();
			else if(mod.getSuppr_producteur() != null) p = mod.getSuppr_producteur();
			else if(mod.getSuppr_realisateur() != null) p = mod.getSuppr_realisateur();
			tableModel.addRow(new String[]{mod.getId()+"", mod.getSoumission()+"", ""+f.getTitre()+"", p.getNomComplet()+""});
		}
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int n = table.getSelectedRow();
				if (n >= 0)
					updateDetails(liste.get(n));
			}
		});
		
		scroll = new JScrollPane(table);
		
		b_valider = new JButton("Valider");
		b_valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int n = table.getSelectedRow();
				if (n >= 0)
					valider(n);
			}
		});
		
		b_rejeter = new JButton("Rejeter");
		b_rejeter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = table.getSelectedRow();
				if (n >= 0)
					rejeter(n);
			}
		});
		
		panel_details = new JPanel(new GridLayout(0, 2));
		panel_details.setBorder(new TitledBorder("Détails de la demande"));
		
		l_auteur = new JLabel("Auteur de la demande : ");
		l_ajout_realisateur = new JLabel("Ajout du réalisateur : ");
		l_ajout_producteur = new JLabel("Ajout du producteur : ");
		l_ajout_acteur = new JLabel("Ajout de l'acteur : ");
		l_suppr_realisateur = new JLabel("Suppression du réalisateur : ");
		l_suppr_producteur = new JLabel("Suppression du producteur : ");
		l_suppr_acteur = new JLabel("Suppression de l'acteur : ");
		v_auteur = new JLabel();
		v_ajout_realisateur = new JLabel();
		v_ajout_producteur = new JLabel();
		v_ajout_acteur = new JLabel();
		v_suppr_realisateur = new JLabel();
		v_suppr_producteur = new JLabel();
		v_suppr_acteur = new JLabel();
		
		panel_details.add(l_auteur);
		panel_details.add(v_auteur);
		panel_details.add(l_ajout_realisateur);
		panel_details.add(v_ajout_realisateur);
		panel_details.add(l_ajout_producteur);
		panel_details.add(v_ajout_producteur);
		panel_details.add(l_ajout_acteur);
		panel_details.add(v_ajout_acteur);
		panel_details.add(l_suppr_realisateur);
		panel_details.add(v_suppr_realisateur);
		panel_details.add(l_suppr_producteur);
		panel_details.add(v_suppr_producteur);
		panel_details.add(l_suppr_acteur);
		panel_details.add(v_suppr_acteur);
		panel_details.add(b_valider);
		panel_details.add(b_rejeter);
		
		this.setLayout(new GridLayout(2, 1));
		this.add(scroll);
		this.add(panel_details);
	}

	protected void updateDetails(ModifRelationFilmPers modifRelationFilmPers) {
		viderDetails();
		v_auteur.setText(modifRelationFilmPers.getAuteur().getPseudo());
		v_ajout_realisateur.setText(""+modifRelationFilmPers.getAjout_realisateur());
		v_ajout_producteur.setText(""+modifRelationFilmPers.getAjout_producteur());
		v_ajout_acteur.setText(""+modifRelationFilmPers.getAjout_acteur());
		v_suppr_realisateur.setText(""+modifRelationFilmPers.getSuppr_realisateur());	
		v_suppr_producteur.setText(""+modifRelationFilmPers.getSuppr_producteur());	
		v_suppr_acteur.setText(""+modifRelationFilmPers.getSuppr_acteur());	
	}

	private void viderDetails() {
		v_auteur.setText("");
		v_ajout_realisateur.setText("");
		v_ajout_producteur.setText("");
		v_ajout_acteur.setText("");
		v_suppr_realisateur.setText("");	
		v_suppr_producteur.setText("");	
		v_suppr_acteur.setText("");	
	}

	protected void valider(int n) {
		ModifRelationFilmPers mod = liste.get(n);
		mod.appliquer();
		daoModifRelFilmPers.delete(mod);
		liste.remove(n);
		tableModel.removeRow(n);	
		
	}

	protected void rejeter(int n) {
		ModifRelationFilmPers mod = liste.get(n);
		daoModifRelFilmPers.delete(mod);
		tableModel.removeRow(n);			
	}
	
}
