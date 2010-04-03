package metier;

public abstract class Modification
{
	/**
	 * Auteur de la demande de modification
	 */
	protected Pro auteur;
	
	/**
	 * Applique la modification
	 */
	public abstract void appliquer();
	
	/**
	 * Construit une demande de modification avec l'auteur donné
	 * @param a Pro
	 */
	protected Modification(Pro a)
	{
		this.auteur = a;
	}
	
	/**
	 * Renvoie l'auteur de la demande de modification
	 * @return Pro
	 */
	public Pro getAuteur()
	{
		return this.auteur;
	}
	
	public String toString()
	{
		return "Modification[auteur:"+this.auteur;
	}
}
