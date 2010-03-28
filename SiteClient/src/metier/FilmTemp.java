package metier;

import java.util.Date;

public class FilmTemp extends Modification
{
	private int id;
	private Film original;
	private String titre;
	private int annee_sortie;
	private double cout;
	private String affiche;
	private String description;
	private Recompense suppr_recompense;
	
	@Override
	public void appliquer()
	{
		if (original != null)
		{
			if (titre != null) original.setTitre(titre);
			if (annee_sortie > 0) original.setAnnee_sortie(annee_sortie);
			if (cout > 0) original.setCout(cout);
			if (affiche != null) original.setAffiche(affiche);
			if (description != null) original.setDescription(description);
			if (suppr_recompense != null) original.supprimerRecompense(suppr_recompense);
			original.setDate_maj(new Date());
		}
	}

	public FilmTemp(int id, Film original, Pro auteur, String titre, int anneeSortie, double cout, String affiche, String description, Recompense suppr_recompense)
	{
		super(auteur);
		this.id = id;
		this.original = original;
		this.titre = titre;
		annee_sortie = anneeSortie;
		this.cout = cout;
		this.affiche = affiche;
		this.description = description;
		this.suppr_recompense = suppr_recompense;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getAnnee_sortie() {
		return annee_sortie;
	}

	public void setAnnee_sortie(int anneeSortie) {
		annee_sortie = anneeSortie;
	}

	public double getCout() {
		return cout;
	}

	public void setCout(double cout) {
		this.cout = cout;
	}

	public String getAffiche() {
		return affiche;
	}

	public void setAffiche(String affiche) {
		this.affiche = affiche;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
