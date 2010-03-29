package metier;

import java.util.Date;

public class RecompenseTemp extends Modification {
	
		 private int id;
		 private String prix;
		 private String ceremonie;
		 private int annee;
		 private Date date_maj;
		 private Recompense original;

		 public RecompenseTemp()
		 {
			 this.id=-1;
			 this.prix="";
			 this.ceremonie="";
			 this.annee=-1;
			 this.date_maj=new Date(0);
			 this.original=null;
		 }
		 
		 public RecompenseTemp(int id,String prix,String ceremonie,int annee,Date date,Recompense original)
		 {
			 this();
			  this.id=id;
			  if(prix!=null)this.prix=prix;
			  if(ceremonie!=null)this.ceremonie=ceremonie;
			  if(date != null)this.date_maj=date;
			  this.annee=annee;
			  this.original=original;
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

		@Override
		public void appliquer() {
			// TODO Auto-generated method stub
			if (original == null) original = new Recompense();
			if (prix != null) original.setPrix(prix);
			if (annee > 0) original.setAnnee(annee);
			if(ceremonie!=null)original.setCeremonie(ceremonie);
			original.setDate_maj(new Date());
			
		}
		

		 
	 
	


}
