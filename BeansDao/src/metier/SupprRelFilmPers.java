package metier;

import java.util.Date;

public class SupprRelFilmPers extends ModifRelationFilmPers
{

	/**
	 * Construit une demande de suppression dans les relations entre Personne et Film
	 * @param id int, ID de la demande
	 * @param original Film, Film sur lequel appliquer les modifications
	 * @param auteur Pro, Auteur de la demande
	 * @param dt Date, Date de soumission de la demande
	 * @param producteur Personne, Producteur à ajouter/supprimer
	 * @param realisateur Personne, Réalisateur à ajouter/supprimer
	 * @param acteur Personne, Acteur à ajouter/supprimer
	 */
	public SupprRelFilmPers(int id, Film original, Pro auteur, Date dt, Personne producteur, Personne realisateur, Personne acteur)
	{
		super(id, original, auteur, dt, producteur, realisateur, acteur);
	}
	
	public String toString()
	{
		return super.toString()+";genre=suppr]";
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
