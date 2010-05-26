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

import metier.Personne;
import metier.PersonneTemp;
import metier.Recompense;

import dao.DAOPersonne;
import dao.DAOPersonneTemp;
import frames.MyDefaultTableModel;

public class PanelPersonnes extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	private DAOPersonne daoPersonne;
	private DAOPersonneTemp daoPersonneTemp;
	
	private ArrayList<PersonneTemp> liste;
	private JTable table;
	private MyDefaultTableModel tableModel;
	private JScrollPane scroll;
	
	private JPanel panel_details;
	private JLabel l_auteur, l_nom, l_prenom, l_naissance, l_photo, l_recomp;
	private JLabel v_auteur, v_nom, v_prenom, v_naissance, v_photo, v_recomp;
	private JButton b_valider, b_rejeter;
	
	public PanelPersonnes() {
		daoPersonne = Config.beanFactory.getBean("daoPersonne", DAOPersonne.class);
		daoPersonneTemp = Config.beanFactory.getBean("daoPersonneTemp", DAOPersonneTemp.class);
		liste = daoPersonneTemp.loadAll();
		tableModel = new MyDefaultTableModel();
		tableModel.addColumn("ID");
		tableModel.addColumn("Date");
		tableModel.addColumn("Nom Complet");
		table = new JTable(tableModel);
		for (int i = 0 ; i < liste.size(); i++)
		{
			PersonneTemp pt = liste.get(i);
			Personne p = pt.getOriginal();
			if(p != null)
				tableModel.addRow(new String[]{pt.getId()+"", pt.getSoumission()+"", p.getNomComplet()+""});
			else 
				tableModel.addRow(new String[]{pt.getId()+"", pt.getSoumission()+"", "Nouvelle Personne"});
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
		l_nom = new JLabel("Nom : ");
		l_prenom = new JLabel("Prenom : ");
		l_naissance = new JLabel("Date de naissance : ");
		l_photo = new JLabel("Photo : ");
		l_recomp = new JLabel("Suppression de récompense : ");
		v_auteur = new JLabel();
		v_nom = new JLabel();
		v_prenom = new JLabel();
		v_naissance = new JLabel();
		v_photo = new JLabel();
		v_recomp = new JLabel();
		
		panel_details.add(l_auteur);
		panel_details.add(v_auteur);
		panel_details.add(l_nom);
		panel_details.add(v_nom);
		panel_details.add(l_prenom);
		panel_details.add(v_prenom);
		panel_details.add(l_naissance);
		panel_details.add(v_naissance);
		panel_details.add(l_photo);
		panel_details.add(v_photo);
		panel_details.add(l_recomp);
		panel_details.add(v_recomp);
		panel_details.add(b_valider);
		panel_details.add(b_rejeter);
		
		this.setLayout(new GridLayout(2, 1));
		this.add(scroll);
		this.add(panel_details);
	}

	protected void rejeter(int n) {
		PersonneTemp pt = liste.get(n);
		daoPersonneTemp.delete(pt);
		tableModel.removeRow(n);		
	}

	protected void valider(int n) {
		PersonneTemp pt = liste.get(n);
		pt.appliquer();
		daoPersonne.update(pt.getOriginal());
		daoPersonneTemp.delete(pt);
		liste.remove(n);
		tableModel.removeRow(n);		
	}
	
	private void viderDetails()
	{
		v_auteur.setText("");
		v_nom.setText("");
		v_prenom.setText("");
		v_naissance.setText("");
		v_photo.setText("");
		v_recomp.setText("");
	}

	protected void updateDetails(PersonneTemp personneTemp) {
		viderDetails();
		v_auteur.setText(personneTemp.getAuteur().getPseudo());
		v_nom.setText(personneTemp.getNom());
		v_prenom.setText(""+personneTemp.getPrenom());
		v_naissance.setText(""+personneTemp.getNaissance());
		v_photo.setText(personneTemp.getPhoto());
		Recompense r = personneTemp.getSuppr_recompense();
		if (r != null)
			v_recomp.setText(r.getPrix().getTitre());
	}
	
	
	
	
}
