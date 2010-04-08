package metier;

import java.util.Date;

public class FilmTemp extends Modification
{
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
	 * Constructeur par défaut
	 */
	public FilmTemp()
	{
		super(-1, null, null);
		this.original = null;
		this.titre = "";
		annee_sortie = -1;
		this.cout = -1;
		this.affiche = "";
		this.description = "";
		ajout_recompense = null;
		suppr_recompense = null;
	}
	
	/**
	 * Crée une demande de modification d'un film
	 * @param id int, ID de la demande de modification
	 * @param original Film, Film sur lequel porte la modification
	 * @param auteur Pro, Auteur de la demande
	 * @param dt Date de soumission de la demande
	 * @param titre String, Titre du film
	 * @param anneeSortie int, Année de sortie du film
	 * @param cout double, Cout total du film
	 * @param affiche String, Lien vers l'affiche du film
	 * @param description String, Description rapide du film
	 * @param ajout_recompense Recompense, Récompense à ajouter au film
	 * @param suppr_recompense Recompense, Récompense à supprimer au film
	 */
	public FilmTemp(int id, Film original, Pro auteur, Date dt, String titre, int anneeSortie, double cout, String affiche, String description, Recompense ajoutRecompense, Recompense supprRecompense)
	{
		super(id, auteur, dt);
		this.original = original;
		this.titre = titre;
		annee_sortie = anneeSortie;
		this.cout = cout;
		this.affiche = affiche;
		this.description = description;
		ajout_recompense = ajoutRecompense;
		suppr_recompense = supprRecompense;
	}
	
	public boolean equals(Object o)
	{
		if (o instanceof FilmTemp)
		{
			FilmTemp f = (FilmTemp)o;
			return (this.getId() == f.getId());
		}
		else return false;
	}
	
	public String toString()
	{
		return super.toString()+";type=Film;original="+this.original+"]";
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
