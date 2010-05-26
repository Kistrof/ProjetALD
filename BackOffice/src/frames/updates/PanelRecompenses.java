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
import metier.Personne;
import metier.Recompense;
import metier.RecompenseTemp;
import dao.DAOFilm;
import dao.DAOPersonne;
import dao.DAORecompense;
import dao.DAORecompenseTemp;
import frames.MyDefaultTableModel;

public class PanelRecompenses extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	private DAORecompenseTemp daoRecompenseTemp;
	private DAORecompense daoRecompense;
	private DAOFilm daoFilm;
	private DAOPersonne daoPersonne;
	
	private ArrayList<RecompenseTemp> liste;
	private JTable table;
	private MyDefaultTableModel tableModel;
	private JScrollPane scroll;
	
	private JPanel panel_details;
	private JLabel l_auteur, l_type, l_annee, l_prix;
	private JLabel v_auteur, v_type, v_annee, v_prix;
	private JButton b_valider, b_rejeter;
	
	public PanelRecompenses()
	{
		daoFilm = Config.beanFactory.getBean("daoFilm", DAOFilm.class);
		daoPersonne = Config.beanFactory.getBean("daoPersonne", DAOPersonne.class);
		daoRecompense = Config.beanFactory.getBean("daoRecompense", DAORecompense.class);
		daoRecompenseTemp = Config.beanFactory.getBean("daoRecompenseTemp", DAORecompenseTemp.class);
		liste = daoRecompenseTemp.loadAll();
		
		tableModel = new MyDefaultTableModel();
		tableModel.addColumn("ID");
		tableModel.addColumn("Date");
		tableModel.addColumn("Film");
		tableModel.addColumn("Personne");
		table = new JTable(tableModel);
		for (int i = 0 ; i < liste.size() ; i++)
		{
			RecompenseTemp rt = liste.get(i);
			Film f = rt.getFilm();
			Personne p = rt.getPersonne();
			String fStr = "";
			String pStr = "";
			if (f != null)
				fStr = f.getTitre();
			if (p != null)
				pStr = p.getNomComplet();
			tableModel.addRow(new String[]{rt.getId()+"", rt.getSoumission()+"", fStr, pStr});
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
		l_type = new JLabel("Type : ");
		l_annee = new JLabel("Année : ");
		l_prix = new JLabel("Prix : ");
		v_auteur = new JLabel();
		v_type = new JLabel();
		v_annee = new JLabel();
		v_prix = new JLabel();
		
		panel_details.add(l_auteur);
		panel_details.add(v_auteur);
		panel_details.add(l_type);
		panel_details.add(v_type);
		panel_details.add(l_annee);
		panel_details.add(v_annee);
		panel_details.add(l_prix);
		panel_details.add(v_prix);
		panel_details.add(b_valider);
		panel_details.add(b_rejeter);
		
		this.setLayout(new GridLayout(2, 1));
		this.add(scroll);
		this.add(panel_details);
	}
	
	private void viderDetails()
	{
		v_auteur.setText("");
		v_type.setText("");
		v_annee.setText("");
		v_prix.setText("");
	}
	
	public void updateDetails(RecompenseTemp rt)
	{
		viderDetails();
		
		v_auteur.setText(rt.getAuteur().getPseudo());
		
		Recompense r = rt.getOriginal();
		if (r != null)
			v_type.setText("Modification");
		else
			v_type.setText("Création");
		
		v_annee.setText(""+rt.getAnnee());
		v_prix.setText(""+rt.getPrix().getTitreComplet());
	}
	
	public void valider(int n)
	{
		RecompenseTemp rt = liste.get(n);
		rt.appliquer();
		if (rt.getFilm() != null)
			daoFilm.update(rt.getFilm());
		if (rt.getPersonne() != null)
			daoPersonne.update(rt.getPersonne());
		daoRecompense.update(rt.getOriginal());
		daoRecompenseTemp.delete(rt);
		liste.remove(n);
		tableModel.removeRow(n);
	}
	
	public void rejeter(int n)
	{
		RecompenseTemp rt = liste.get(n);
		daoRecompenseTemp.delete(rt);
		tableModel.removeRow(n);
	}
	
}
