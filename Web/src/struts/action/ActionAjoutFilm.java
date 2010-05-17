package struts.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.Film;
import metier.FilmTemp;
import metier.Pro;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import struts.actionForm.ActionFormFilm;

import dao.DAOFilm;
import dao.DAOFilmTemp;

public class ActionAjoutFilm extends Action
{
	private DAOFilmTemp daoFilmTemp;
	private DAOFilm daoFilm;

	public void setDaoFilmTemp(DAOFilmTemp daoFilmTemp) {
		this.daoFilmTemp = daoFilmTemp;
	}
	
	public void setDaoFilm(DAOFilm daoFilm) {
		this.daoFilm = daoFilm;
	}
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	{
		ActionFormFilm f = (ActionFormFilm)form;
		HttpSession session = request.getSession();
		
		Pro auteur = (Pro)session.getAttribute("pro");
		Film film = daoFilm.get(f.getCodeOriginal());
		String titre = f.getTitre();
		String affiche = f.getAffiche();
		int annee = f.getAnnee_sortie();
		double cout = f.getCout();
		String desc = f.getDescription();
		FilmTemp tmp = new FilmTemp(-1, film, auteur, new Date(), titre, annee, cout, affiche, desc, null);
		daoFilmTemp.save(tmp);
		
		return mapping.findForward("AjoutFilmOK");
	}
}
