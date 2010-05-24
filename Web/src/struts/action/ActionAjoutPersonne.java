package struts.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.Personne;
import metier.PersonneTemp;
import metier.Pro;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import struts.actionForm.ActionFormPersonne;

import dao.DAOPersonneTemp;

public class ActionAjoutPersonne extends Action {
	
	private DAOPersonneTemp daoPersonneTemp;
	
	public void setDaoPersonneTemp(DAOPersonneTemp daoPersonneTemp) {
		this.daoPersonneTemp = daoPersonneTemp;
	}
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	{
		ActionFormPersonne p = (ActionFormPersonne)form;
		HttpSession session = request.getSession();
		
		Pro auteur = (Pro)session.getAttribute("PRO");
		Personne Personne = (Personne)session.getAttribute("PERSONNE");
		String nom = p.getNom();
		String prenom = p.getPrenom();
		Date naissance = p.getNaissance();
		String photo = p.getPhoto();
		PersonneTemp tmp = new PersonneTemp(-1, Personne, nom, prenom, naissance, photo, null, auteur, new Date() );
		daoPersonneTemp.save(tmp);
		
		return mapping.findForward("AjoutPersonneOK");
	}

}
