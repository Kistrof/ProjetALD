package metier;

import java.util.Date;

public abstract class Modification
{
	/**
	 * ID de la demande de modification
	 */
	protected int id;
	
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
	 * @param id int, ID de la demande
	 * @param auteur Pro, Auteur de la demande
	 * @param dt Date, Date de la demande
	 */
	protected Modification(int id, Pro auteur, Date dt)
	{
		this.id = id;
		this.auteur = auteur;
		this.soumission = dt;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public Pro getAuteur()
	{
		return this.auteur;
	}
	
	public Date getDate()
	{
		return this.soumission;
	}
	
	public String toString()
	{
		return "Modification[auteur="+this.auteur+";soumission="+this.soumission;
	}

	public Date getSoumission() {
		return soumission;
	}

	public void setSoumission(Date soumission) {
		this.soumission = soumission;
	}

	public void setAuteur(Pro auteur) {
		this.auteur = auteur;
	}
}
