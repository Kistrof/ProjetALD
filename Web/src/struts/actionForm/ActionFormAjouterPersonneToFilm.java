package struts.actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class ActionFormAjouterPersonneToFilm extends ActionForm
{
	private static final long serialVersionUID = 1L;
	
	private int id = -1;
	private int codeActeur = -1;
	private int codeProducteur = -1;
	private int codeRealisateur = -1;
	private boolean FromFilm;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCodeActeur() {
		return codeActeur;
	}

	public void setCodeActeur(int codeActeur) {
		this.codeActeur = codeActeur;
	}

	public int getCodeProducteur() {
		return codeProducteur;
	}

	public void setCodeProducteur(int codeProducteur) {
		this.codeProducteur = codeProducteur;
	}

	public int getCodeRealisateur() {
		return codeRealisateur;
	}

	public void setCodeRealisateur(int codeRealisateur) {
		this.codeRealisateur = codeRealisateur;
	}

	public boolean getFromFilm() {
		return FromFilm;
	}

	public void setFromFilm(boolean fromFilm) {
		FromFilm = fromFilm;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
	{
		ActionErrors erreurs = new ActionErrors();
		
		if (id == -1) erreurs.add("Film absent", new ActionMessage("erreur.film_null"));
		if (codeActeur == -1 && codeProducteur == -1 && codeRealisateur == -1)
			erreurs.add("Aucun changement", new ActionMessage("erreur.aucune_personne"));
		
		return super.validate(mapping, request);
	}

}
