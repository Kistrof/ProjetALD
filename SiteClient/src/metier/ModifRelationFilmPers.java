package metier;

public abstract class ModifRelationFilmPers extends Modification
{
	private int id;
	protected Personne producteur;
	protected Personne realisateur;
	protected Personne acteur;
	protected Film original;
	
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
