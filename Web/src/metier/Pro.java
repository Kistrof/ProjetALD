package metier;

import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

public class Pro
{
	//private int id;
	private String pseudo;
	private String pass;
	private Timestamp date_inscription;
	private Timestamp derniere_visite;
	
	public Pro()
	{
		//this.id=-1;
		this.pseudo = "";
		this.pass = "";
		date_inscription = new Timestamp(0);
		derniere_visite = new Timestamp(0);
	}

	public Pro(String pseudo, String pass, Timestamp dateInscription, Timestamp derniereVisite)
	{
		//this.id=-1;
		this.pseudo = pseudo;
		this.pass = pass;
		date_inscription = dateInscription;
		derniere_visite = derniereVisite;
	}
	
	/*public int getId()
	{
		return this.id;
	}
	
	
	public void setId(int id)
	{
		this.id=id;
	}
	*/
	public String getPseudo() {
		return this.pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		try
		{
			java.security.MessageDigest md5 = java.security.MessageDigest.getInstance("MD5");
			md5.update(pass.getBytes());
			this.pass = new String(md5.digest());
		}
		catch (NoSuchAlgorithmException e)
		{
		}
	}

	public Timestamp getDate_inscription() {
		return date_inscription;
	}

	public void setDate_inscription(Timestamp dateInscription) {
		date_inscription = dateInscription;
	}

	public Timestamp getDerniere_visite() {
		return derniere_visite;
	}

	public void setDerniere_visite(Timestamp derniereVisite) {
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
