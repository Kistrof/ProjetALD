package struts.actionForm;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class ActionFormFilm extends ActionForm
{
	private static final long serialVersionUID = 1L;
	
	private int id = -1;
	private String titre = "";
	private int annee_sortie = -1;
	private double cout = -1;
	private String affiche = "";
	private String description = "";
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public int getAnnee_sortie() {
		return annee_sortie;
	}
	public void setAnnee_sortie(int anneeSortie) {
		annee_sortie = anneeSortie;
	}
	public double getCout() {
		return cout;
	}
	public void setCout(double cout) {
		this.cout = cout;
	}
	public String getAffiche() {
		return affiche;
	}
	public void setAffiche(String affiche) {
		this.affiche = affiche;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
	{
		ActionErrors erreurs = new ActionErrors();
		
		if (this.titre.equals("")) erreurs.add("titre vide", new ActionMessage("erreurs.film.titre_vide"));
		if (this.annee_sortie <= 0) erreurs.add("année de sortie incorrecte", new ActionMessage("erreurs.film.annee"));
		return erreurs;
	}
	
}
