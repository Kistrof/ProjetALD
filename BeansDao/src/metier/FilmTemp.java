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
	private Recompense ajout_recompense;
	private Recompense suppr_recompense;
	
	/**
	 * Applique les modifications
	 */
	@Override
	public void appliquer()
	{
		if (original == null) original = new Film();
		
		if (titre != null) original.setTitre(titre);
		if (annee_sortie > 0) original.setAnnee_sortie(annee_sortie);
		if (cout > 0) original.setCout(cout);
		if (affiche != null) original.setAffiche(affiche);
		if (description != null) original.setDescription(description);
		if (ajout_recompense != null) original.ajouterRecompense(suppr_recompense);
		if (suppr_recompense != null) original.supprimerRecompense(suppr_recompense);
		original.setDate_maj(new Date());
	}

	/**
	 * Cr�e une demande de modification d'un film
	 * @param id int, ID de la demande de modification
	 * @param original Film, Film sur lequel porte la modification
	 * @param auteur Pro, Auteur de la demande
	 * @param titre String, Titre du film
	 * @param anneeSortie int, Ann�e de sortie du film
	 * @param cout double, Cout total du film
	 * @param affiche String, Lien vers l'affiche du film
	 * @param description String, Description rapide du film
	 * @param ajout_recompense Recompense, R�compense � ajouter au film
	 * @param suppr_recompense Recompense, R�compense � supprimer au film
	 */
	public FilmTemp(int id, Film original, Pro auteur, String titre, int anneeSortie, double cout, String affiche, String description, Recompense ajout_recompense, Recompense suppr_recompense)
	{
		super(auteur);
		this.id = id;
		this.original = original;
		this.titre = titre;
		annee_sortie = anneeSortie;
		this.cout = cout;
		this.affiche = affiche;
		this.description = description;
		this.ajout_recompense = ajout_recompense;
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
