/**
 * 
 */
package metier;

import java.util.Date;

/**
 * @author zuzudesbois
 * @class PersonneTemp 
 * Class permettant la modification d'une personne
 */
public class PersonneTemp extends Modification {

	private int id = -1;
	private String nom = "";
	private String prenom = "";
	private Date naissance;
	private String photo = "";
	private Recompense suppr_recompense;
	
	private Personne original;
	
	/**
	 * Constructeur d'une personne temps
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param naissance
	 * @param photo
	 * @param supprRecompense
	 */
	public PersonneTemp(int id, String nom, String prenom, Date naissance,
			String photo, Recompense supprRecompense) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.naissance = naissance;
		this.photo = photo;
		suppr_recompense = supprRecompense;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getNaissance() {
		return naissance;
	}

	public void setNaissance(Date naissance) {
		this.naissance = naissance;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Recompense getSuppr_recompense() {
		return suppr_recompense;
	}

	public void setSuppr_recompense(Recompense supprRecompense) {
		suppr_recompense = supprRecompense;
	}

	/* (non-Javadoc)
	 * @see metier.Modification#appliquer()
	 */
	public void appliquer() {
		if(this.nom != null)
			original.setNom(this.nom);
		
		if(this.prenom != null)
			original.setPrenom(this.prenom);
		
		if(this.naissance != null)
			original.setNaissance(this.naissance);
		
		if(this.photo != null)	
			original.setPhoto(this.photo);
		
		if(this.suppr_recompense != null)
			original.supprimerRecompense(suppr_recompense);
		
		//mise a jour de date maj de la personne original avec la date courante
		original.setDate_maj(new Date());

	}

}
