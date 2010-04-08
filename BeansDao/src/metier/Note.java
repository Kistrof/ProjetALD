package metier;

public class Note
{
	private int valeur;
	private Pro votant;
	private Film film;
	
	public Note()
	{
		this.valeur = -1;
		this.votant = null;
		this.film = null;
	}
	
	/**
	 * Construit une note donnée à un Film par un Pro
	 * @param p Pro, Auteur de la note
	 * @param f Film, Film noté
	 * @param val int, valeur de la note
	 */
	public Note(Pro p, Film f, int val)
	{
		this.votant = p;
		this.film = f;
		this.valeur = val;
	}
	
	public boolean equals(Object o)
	{
		if (o instanceof Note)
		{
			Note n = (Note)o;
			return (this.getVotant().equals(n.getVotant()) && this.getFilm().equals(n.getFilm()));
		}
		else return false;
	}
	
	public String toString()
	{
		return "Note[valeur="+this.valeur+";votant="+this.votant+";film="+this.film+"]";
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
