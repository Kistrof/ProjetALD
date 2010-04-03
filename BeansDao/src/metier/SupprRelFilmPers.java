package metier;

public class SupprRelFilmPers extends ModifRelationFilmPers
{

	/**
	 * Construit une demande de suppression dans les relations entre Personne et Film
	 * @param id int, ID de la demande
	 * @param original Film, Film sur lequel appliquer les modifications
	 * @param auteur Pro, Auteur de la demande de suppression
	 * @param producteur Personne, Producteur à supprimer, null si aucun producteur à supprimer
	 * @param realisateur Personne, Réalisateur à supprimer, null si aucun réalisateur à supprimer
	 * @param acteur Personne, Acteur à supprimer, null si aucun acteur à supprimer
	 */
	public SupprRelFilmPers(int id, Film original, Pro auteur, Personne producteur, Personne realisateur, Personne acteur)
	{
		super(id, original, auteur, producteur, realisateur, acteur);
	}

	/**
	 * Applique la demande de suppression
	 */
	@Override
	public void appliquer()
	{
		if (producteur != null)
			original.supprimerProducteur(producteur);
		if (realisateur != null)
			original.supprimerRealisateur(realisateur);
		if (acteur != null)
			original.supprimerActeur(acteur);
	}

}
