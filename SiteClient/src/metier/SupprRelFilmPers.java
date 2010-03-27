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
		// TODO Auto-generated method stub

	}

}
