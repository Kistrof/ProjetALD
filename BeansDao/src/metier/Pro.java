package metier;

import java.util.Date;

public class Pro
{
	private String pseudo;
	private String pass;
	private Date date_inscription;
	private Date derniere_visite;
	
	public Pro()
	{
		this.pseudo = "";
		this.pass = "";
		date_inscription = new Date();
		derniere_visite = new Date();
	}

	public Pro(String pseudo, String pass, Date dateInscription, Date derniereVisite)
	{
		this.pseudo = pseudo;
		this.pass = pass;
		date_inscription = dateInscription;
		derniere_visite = derniereVisite;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Date getDate_inscription() {
		return date_inscription;
	}

	public void setDate_inscription(Date dateInscription) {
		date_inscription = dateInscription;
	}

	public Date getDerniere_visite() {
		return derniere_visite;
	}

	public void setDerniere_visite(Date derniereVisite) {
		derniere_visite = derniereVisite;
	}
	
	public boolean equals(Object obj)
	{
		if (obj instanceof Pro)
		{
			Pro p = (Pro)obj;
			return p.getPseudo().equals(this.getPseudo());
		}
		else
			return false;
	}
	
	public String toString()
	{
		return "Pro["+this.getPseudo()+"]";
	}

}
