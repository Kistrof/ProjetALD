package metier;

import java.sql.Date;




public class Recompense {
	 private int id;
	 private String prix;
	 private String ceremonie;
	 private int annee;
	 private Date date_maj;

	 public Recompense()
	 {
		 this.id=-1;
		 this.prix="";
		 this.ceremonie="";
		 this.annee=-1;
		 this.date_maj=new Date(0);
	 }
	 
	 public Recompense(int id,String prix,String ceremonie,int annee,Date date)
	 {
		 this();
		  this.id=id;
		  if(prix!=null)this.prix=prix;
		  if(ceremonie!=null)this.ceremonie=ceremonie;
		  if(date != null)this.date_maj=date;
		  this.annee=annee;
	 }

	 
	 public Recompense(Recompense recompense)
	 {
		  this.id=recompense.getId();
		  this.prix=recompense.getPrix();
		  this.ceremonie=recompense.getCeremonie();
		  this.date_maj=recompense.getDate_maj();

	 }
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPrix() {
		return prix;
	}
	
	public void setPrix(String prix) {
		this.prix = prix;
	}
	
	public String getCeremonie() {
		return ceremonie;
	}
	
	public void setCeremonie(String ceremonie) {
		this.ceremonie = ceremonie;
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
	
	public void setDate_maj(Date dateMaj) {
		date_maj = dateMaj;
	}
	

	 
 
}
