package struts.actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class ActionFormPersonne extends ActionForm {
private static final long serialVersionUID = 1L;
	
	private int id = -1;
	private String prenom = "";
	private String nom = "";
	private String naissance = "";
	private String photo = "";
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getNaissance() {
		return naissance;
	}
	
	public void setNaissance(String n) {
		this.naissance = n;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
	{
		ActionErrors erreurs = new ActionErrors();
		
		if (this.nom.equals("")) erreurs.add("nom vide", new ActionMessage("erreurs.personne.nom_vide"));
		if (this.prenom.equals("")) erreurs.add("prenom vide", new ActionMessage("erreurs.personne.prenom_vide"));
		if (this.naissance.equals("")) erreurs.add("naissance vide", new ActionMessage("erreurs.personne.naissance_null"));
		return erreurs;
	}
}
