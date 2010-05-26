package struts.actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class ActionFormAjouterRecompenseToPersonne extends ActionForm{
	private static final long serialVersionUID = 1L;
	
	private int annee = -1;
	private int personneid = -1;
	private int filmid = -1;
	private int prixid = -1;
	
	public int getAnnee() {
		return annee;
	}
	
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	
	public int getPersonneid() {
		return personneid;
	}
	
	public void setPersonneid(int personneid) {
		this.personneid = personneid;
	}
	
	public int getFilmid() {
		return filmid;
	}
	
	public void setFilmid(int filmid) {
		this.filmid = filmid;
	}
	
	public int getPrixid() {
		return prixid;
	}
	
	public void setPrixid(int prixid) {
		this.prixid = prixid;
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
	{
		ActionErrors erreurs = new ActionErrors();
		
		if (personneid == -1 && filmid == -1)
			erreurs.add("Aucun changement", new ActionMessage("erreur.aucune_personne"));
		if (prixid == -1)
			erreurs.add("Aucun prix", new ActionMessage("erreur.aucun_prix"));
		if (annee < 1900)
			erreurs.add("Annee incorrect", new ActionMessage("erreur.annee_incorrect"));
		return super.validate(mapping, request);
	}
}
