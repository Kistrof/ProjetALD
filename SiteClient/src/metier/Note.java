package metier;

public class Note
{
	private int valeur;
	private Pro votant;
	private Film film;
	
	public Note(Pro p, Film f, int val)
	{
		this.votant = p;
		this.film = f;
		this.valeur = val;
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public Pro getVotant() {
		return votant;
	}

	public Film getFilm() {
		return film;
	}
	
}
