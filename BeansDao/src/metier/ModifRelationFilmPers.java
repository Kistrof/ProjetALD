package metier;

public abstract class ModifRelationFilmPers extends Modification
{
	private int id;
	protected Personne producteur;
	protected Personne realisateur;
	protected Personne acteur;
	protected Film original;
	
	/**
	 * Construit une demande de modification des relations entre Personne et Film
	 * @param id int, ID de la demande
	 * @param original Film, Film sur lequel appliquer les modifications
	 * @param auteur Pro, Auteur de la demande à ajouter/supprimer
	 * @param producteur Personne, Producteur à ajouter/supprimer
	 * @param realisateur Personne, Réalisateur à ajouter/supprimer
	 * @param acteur Personne, Acteur à ajouter/supprimer
	 */
	protected ModifRelationFilmPers(int id, Film original, Pro auteur, Personne producteur, Personne realisateur, Personne acteur)
	{
		super(auteur);
		this.id = id;
		this.producteur = producteur;
		this.realisateur = realisateur;
		this.acteur = acteur;
		this.original = original;
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
