package metier;

import java.util.Date;

public abstract class Modification
{
	/**
	 * Auteur de la demande de modification
	 */
	protected Pro auteur;
	
	/**
	 * Date de soumission de la demande
	 */
	protected Date soumission;
	
	/**
	 * Applique la modification
	 */
	public abstract void appliquer();
	
	/**
	 * Construit une demande de modification avec l'auteur donné
	 * @param a Pro, Auteur de la demande
	 * @param d Date, Date de la demande
	 */
	protected Modification(Pro a, Date d)
	{
		this.auteur = a;
		this.soumission = d;
	}
	
	/**
	 * Renvoie l'auteur de la demande de modification
	 * @return Pro
	 */
	public Pro getAuteur()
	{
		return this.auteur;
	}
	
	/**
	 * Renvoie la date à laquelle la demande a été effectuée
	 * @return Date
	 */
	public Date getDate()
	{
		return this.soumission;
	}
	
	public String toString()
	{
		return "Modification[auteur:"+this.auteur;
	}
}
