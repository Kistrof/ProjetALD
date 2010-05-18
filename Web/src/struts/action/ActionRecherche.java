package struts.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.Film;
import metier.Personne;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import struts.actionForm.ActionFormRecherche;

import dao.DAOFilm;
import dao.DAOPersonne;

public class ActionRecherche extends Action{
	
	private DAOFilm daoFilm;
	private DAOPersonne daoPersonne;

	public DAOPersonne getDaoPersonne() {
		return daoPersonne;
	}

	public void setDaoPersonne(DAOPersonne daoPersonne) {
		this.daoPersonne = daoPersonne;
	}

	public DAOFilm getDaoFilm() {
		return daoFilm;
	}

	public void setDaoFilm(DAOFilm daoFilm) {
		this.daoFilm = daoFilm;
	}
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println("on va chercher");
		request.setAttribute("RECHERCHE_OK", "ok");
		HttpSession session=request.getSession();
		ActionFormRecherche f=(ActionFormRecherche)form;
		String recherche=f.getChampRecherche();
		request.setAttribute("CHAINE_RECHERCHE",recherche);
		if(session.getAttribute("PRO")!=null)
		{
			System.out.println("L'utilisateur connecte en tant que pro");
			ArrayList<Personne>listPers=daoPersonne.loadAll(recherche);
			if(listPers.size()>0)
				request.setAttribute("RECHERCHE_PERSONNE",listPers);
			
			System.out.println(listPers);

		}
		ArrayList<Film> listFilm=daoFilm.loadAll(recherche);
		if(listFilm.size()>0)
			request.setAttribute("RECHERCHE_FILM", listFilm);
		System.out.println(listFilm);
		return mapping.findForward("RechercheOk");
		
	}


}
