package metier;

public class AjouteRelFilmPers extends ModifRelationFilmPers
{

	public AjouteRelFilmPers(int id, Film original, Pro auteur, Personne producteur, Personne realisateur, Personne acteur)
	{
		super(id, original, auteur, producteur, realisateur, acteur);
	}

	@Override
	public void appliquer()
	{
		if (producteur != null)
			original.ajouterProducteur(producteur);
		if (realisateur != null)
			original.ajouterRealisateur(realisateur);
		if (acteur != null)
			original.ajouterActeur(acteur);
		
		// TODO Supprimer la ligne dans la bdd
		
	}

}
