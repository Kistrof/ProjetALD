package struts.actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public class ActionFormRecherche extends ActionForm {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ChampRecherche;

	public String getChampRecherche() {
		return ChampRecherche;
	}

	public void setChampRecherche(String champRecherche) {
		ChampRecherche = champRecherche;
	}
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
	{
		System.out.println("valider formulaire");
		ActionErrors erreurs=new ActionErrors();
		if(this.ChampRecherche.equals("")) erreurs.add("recherche_vide",new ActionMessage("formrecherche.erreurs.champs_vide"));
		return erreurs;
	}

}
