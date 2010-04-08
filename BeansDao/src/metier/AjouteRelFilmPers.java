package metier;

import java.util.Date;

public class AjouteRelFilmPers extends ModifRelationFilmPers
{

	/**
	 * Construit une demande d'ajout dans les relations entre Personne et Film
	 * @param id int, ID de la demande
	 * @param original Film, Film sur lequel appliquer les modifications
	 * @param auteur Pro, Auteur de la demande
	 * @param dt Date, Date de soumission de la demande
	 * @param producteur Personne, Producteur à ajouter/supprimer
	 * @param realisateur Personne, Réalisateur à ajouter/supprimer
	 * @param acteur Personne, Acteur à ajouter/supprimer
	 */
	public AjouteRelFilmPers(int id, Film original, Pro auteur, Date dt, Personne producteur, Personne realisateur, Personne acteur)
	{
		super(id, original, auteur, dt, producteur, realisateur, acteur);
	}
	
	public String toString()
	{
		return super.toString()+";genre=ajout]";
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
