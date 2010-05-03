package metier;

import java.util.Date;


public class Recompense {
	 private int id;
	 private Prix prix;
	 private int annee;
	 private Date date_maj;

	 public Recompense()
	 {
		 this.id=-1;
		 this.prix=null;
		 this.annee=-1;
		 this.date_maj=new Date(0);
	 }
	 
	 public Recompense(int id,Prix prix,int annee,Date maj)
	 {
		 this();
		  this.id=id;
		  if(prix!=null)this.prix=prix;
		  if(maj != null)this.date_maj=maj;
		  this.annee=annee;
	 }
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Prix getPrix() {
		return prix;
	}
	
	public void setPrix(Prix prix) {
		this.prix = prix;
	}
	
	public int getAnnee() {
		return annee;
	}
	
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	
	public Date getDate_maj() {
		return date_maj;
	}
	
	public void setDate_maj(Date date) {
		date_maj = date;
	}
	

	 
 
}
