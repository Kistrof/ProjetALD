package metier;

public abstract class Modification
{
	protected Pro auteur;
	public abstract void appliquer();
	
	protected Modification(Pro a)
	{
		this.auteur = a;
	}
	
	public Pro getAuteur()
	{
		return this.auteur;
	}
	
	public String toString()
	{
		return "Modification[auteur:"+this.auteur;
	}
}
