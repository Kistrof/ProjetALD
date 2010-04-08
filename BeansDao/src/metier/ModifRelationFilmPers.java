package metier;

import java.util.Date;

public abstract class ModifRelationFilmPers extends Modification
{
	protected Personne producteur;
	protected Personne realisateur;
	protected Personne acteur;
	protected Film original;
	
	/**
	 * Construit une demande de modification des relations entre Personne et Film
	 * @param id int, ID de la demande
	 * @param original Film, Film sur lequel appliquer les modifications
	 * @param auteur Pro, Auteur de la demande
	 * @param dt Date, Date de soumission de la demande
	 * @param producteur Personne, Producteur à ajouter/supprimer
	 * @param realisateur Personne, Réalisateur à ajouter/supprimer
	 * @param acteur Personne, Acteur à ajouter/supprimer
	 */
	protected ModifRelationFilmPers(int id, Film original, Pro auteur, Date dt, Personne producteur, Personne realisateur, Personne acteur)
	{
		super(id, auteur, dt);
		this.producteur = producteur;
		this.realisateur = realisateur;
		this.acteur = acteur;
		this.original = original;
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
	public Personne getProducteur() {
		return producteur;
	}
	public Personne getRealisateur() {
		return realisateur;
	}
	public Personne getActeur() {
		return acteur;
	}
	public Film getOriginal() {
		return original;
	}
	
}
