package metier;

public class AjouteRelFilmPers extends ModifRelationFilmPers
{

	/**
	 * Construit une demande d'ajout dans les relations entre Personne et Film
	 * @param id int, ID de la demande
	 * @param original Film, Film sur lequel appliquer les modifications
	 * @param auteur Pro, Auteur de la demande d'ajout
	 * @param producteur Personne, Producteur � ajouter, null si aucun producteur � ajouter
	 * @param realisateur Personne, R�alisateur � ajouter, null si aucun r�alisateur � ajouter
	 * @param acteur Personne, Acteur � ajouter, null si aucun acteur � ajouter
	 */
	public AjouteRelFilmPers(int id, Film original, Pro auteur, Personne producteur, Personne realisateur, Personne acteur)
	{
		super(id, original, auteur, producteur, realisateur, acteur);
	}

	/**
	 * Applique la demande d'ajout
	 */
	@Override
	public void appliquer()
	{
		if (producteur != null)
			original.ajouterProducteur(producteur);
		if (realisateur != null)
			original.ajouterRealisateur(realisateur);
		if (acteur != null)
			original.ajouterActeur(acteur);
	}

}
