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

import metier.Film;
import metier.FilmTemp;

import config.Config;

import dao.DAOFilm;
import dao.DAOFilmTemp;
import frames.MyDefaultTableModel;

public class PanelFilms extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	private DAOFilmTemp daoFilmTemp;
	private DAOFilm daoFilm;
	
	private ArrayList<FilmTemp> liste;
	private JTable table;
	private MyDefaultTableModel tableModel;
	private JScrollPane scroll;
	
	private JPanel panel_details;
	private JLabel l_auteur, l_titre, l_annee, l_cout, l_affiche, l_desc;
	private JLabel v_auteur, v_titre, v_annee, v_cout, v_affiche, v_desc;
	private JButton b_valider, b_rejeter;
	
	public PanelFilms()
	{
		daoFilm = Config.beanFactory.getBean("daoFilm", DAOFilm.class);
		daoFilmTemp = Config.beanFactory.getBean("daoFilmTemp", DAOFilmTemp.class);
		liste = daoFilmTemp.loadAll();
		
		tableModel = new MyDefaultTableModel();
		tableModel.addColumn("ID");
		tableModel.addColumn("Date");
		tableModel.addColumn("Titre");
		table = new JTable(tableModel);
		for (int i = 0 ; i < liste.size() ; i++)
		{
			FilmTemp ft = liste.get(i);
			Film f = ft.getOriginal();
			tableModel.addRow(new String[]{ft.getId()+"", ft.getSoumission()+"", f.getTitre()});
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
		
		panel_details = new JPanel(new GridLayout(7, 2));
		panel_details.setBorder(new TitledBorder("Détails de la demande"));
		
		l_auteur = new JLabel("Auteur de la demande : ");
		l_titre = new JLabel("Titre : ");
		l_annee = new JLabel("Année : ");
		l_cout = new JLabel("Cout : ");
		l_affiche = new JLabel("Affiche : ");
		l_desc = new JLabel("Description : ");
		v_auteur = new JLabel();
		v_titre = new JLabel();
		v_annee = new JLabel();
		v_cout = new JLabel();
		v_affiche = new JLabel();
		v_desc = new JLabel();
		
		panel_details.add(l_auteur);
		panel_details.add(v_auteur);
		panel_details.add(l_titre);
		panel_details.add(v_titre);
		panel_details.add(l_annee);
		panel_details.add(v_annee);
		panel_details.add(l_cout);
		panel_details.add(v_cout);
		panel_details.add(l_affiche);
		panel_details.add(v_affiche);
		panel_details.add(l_desc);
		panel_details.add(v_desc);
		panel_details.add(b_valider);
		panel_details.add(b_rejeter);
		
		this.setLayout(new GridLayout(2, 1));
		this.add(scroll);
		this.add(panel_details);
	}
	
	public void updateDetails(FilmTemp ft)
	{
		System.out.println("updateDetails");
		v_auteur.setText(ft.getAuteur().getPseudo());
		v_titre.setText(ft.getTitre());
		v_annee.setText(""+ft.getAnnee_sortie());
		v_cout.setText(""+ft.getCout());
		v_affiche.setText(ft.getAffiche());
		v_desc.setText(ft.getDescription());
	}
	
	public void valider(int n)
	{
		FilmTemp ft = liste.get(n);
		ft.appliquer();
		daoFilm.update(ft.getOriginal());
		daoFilmTemp.delete(ft);
		liste.remove(n);
		tableModel.removeRow(n);
	}
	
	public void rejeter(int n)
	{
		FilmTemp ft = liste.get(n);
		daoFilmTemp.delete(ft);
		tableModel.removeRow(n);
	}
	
}
