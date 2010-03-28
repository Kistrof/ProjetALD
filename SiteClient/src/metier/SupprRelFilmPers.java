package metier;

public class SupprRelFilmPers extends ModifRelationFilmPers
{

	public SupprRelFilmPers(int id, Film original, Pro auteur, Personne producteur, Personne realisateur, Personne acteur)
	{
		super(id, original, auteur, producteur, realisateur, acteur);
	}

	@Override
	public void appliquer()
	{
		if (producteur != null)
			original.supprimerProducteur(producteur);
		if (realisateur != null)
			original.supprimerRealisateur(realisateur);
		if (acteur != null)
			original.supprimerActeur(acteur);
		
		// TODO Supprimer la ligne dans la bdd
		
	}

}
