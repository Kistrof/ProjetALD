package metier;

import java.util.Date;

public class ModifRelationFilmPers extends Modification
{
	protected Personne suppr_producteur, ajout_producteur;
	protected Personne suppr_realisateur, ajout_realisateur;
	protected Personne suppr_acteur, ajout_acteur;
	protected Film original;
	
	/**
	 * Construit une demande de modification des relations entre Personne et Film
	 * @param id int, ID de la demande
	 * @param auteur Pro, Auteur de la demande
	 * @param dt Date, Date de soumission de la demande
	 * @param supprProducteur Personne, Producteur à supprimer
	 * @param ajoutProducteur Personne, Producteur à ajouter
	 * @param supprRealisateur Personne, Réalisateur à supprimer
	 * @param ajoutRealisateur Personne, Réalisateur à ajouter
	 * @param supprActeur Personne, Acteur à supprimer
	 * @param ajoutActeur Personne, Acteur à ajouter
	 * @param original Film, Film sur lequel appliquer les modifications
	 */
	public ModifRelationFilmPers(int id, Pro auteur, Date dt, Personne supprProducteur, Personne ajoutProducteur, Personne supprRealisateur, Personne ajoutRealisateur, Personne supprActeur, Personne ajoutActeur, Film original)
	{
		super(id, auteur, dt);
		suppr_producteur = supprProducteur;
		ajout_producteur = ajoutProducteur;
		suppr_realisateur = supprRealisateur;
		ajout_realisateur = ajoutRealisateur;
		suppr_acteur = supprActeur;
		ajout_acteur = ajoutActeur;
		this.original = original;
	}
	
	public ModifRelationFilmPers()
	{
		super(-1, null, null);
	}

	/**
	 * Applique la demande de modification
	 */
	@Override
	public void appliquer()
	{
		if (ajout_producteur != null)
			original.ajouterProducteur(ajout_producteur);
		if (ajout_realisateur != null)
			original.ajouterRealisateur(ajout_realisateur);
		if (ajout_acteur != null)
			original.ajouterActeur(ajout_acteur);
		if (suppr_producteur != null)
			original.supprimerProducteur(suppr_producteur);
		if (suppr_realisateur != null)
			original.supprimerRealisateur(suppr_realisateur);
		if (suppr_acteur != null)
			original.supprimerActeur(suppr_acteur);
	}
	
	public String toString()
	{
		return super.toString()+";type=relFilmPers;film="+this.original;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Personne getSuppr_producteur() {
		return suppr_producteur;
	}

	public void setSuppr_producteur(Personne supprProducteur) {
		suppr_producteur = supprProducteur;
	}

	public Personne getAjout_producteur() {
		return ajout_producteur;
	}

	public void setAjout_producteur(Personne ajoutProducteur) {
		ajout_producteur = ajoutProducteur;
	}

	public Personne getSuppr_realisateur() {
		return suppr_realisateur;
	}

	public void setSuppr_realisateur(Personne supprRealisateur) {
		suppr_realisateur = supprRealisateur;
	}

	public Personne getAjout_realisateur() {
		return ajout_realisateur;
	}

	public void setAjout_realisateur(Personne ajoutRealisateur) {
		ajout_realisateur = ajoutRealisateur;
	}

	public Personne getSuppr_acteur() {
		return suppr_acteur;
	}

	public void setSuppr_acteur(Personne supprActeur) {
		suppr_acteur = supprActeur;
	}

	public Personne getAjout_acteur() {
		return ajout_acteur;
	}

	public void setAjout_acteur(Personne ajoutActeur) {
		ajout_acteur = ajoutActeur;
	}

	public Film getOriginal() {
		return original;
	}

	public void setOriginal(Film original) {
		this.original = original;
	}
	
}
