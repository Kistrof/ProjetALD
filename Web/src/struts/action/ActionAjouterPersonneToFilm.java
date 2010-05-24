package struts.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.Film;
import metier.ModifRelationFilmPers;
import metier.Personne;
import metier.Pro;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import struts.actionForm.ActionFormAjouterPersonneToFilm;

import dao.DAOFilm;
import dao.DAOModifRelFilmPers;
import dao.DAOPersonne;

public class ActionAjouterPersonneToFilm extends Action
{
	
	private DAOModifRelFilmPers daoModifRelFilmPers;
	private DAOPersonne daoPersonne;
	private DAOFilm daoFilm;
	
	public void setDaoModifRelFilmPers(DAOModifRelFilmPers daoModifRelFilmPers) {
		this.daoModifRelFilmPers = daoModifRelFilmPers;
	}

	public void setDaoPersonne(DAOPersonne daoPersonne) {
		this.daoPersonne = daoPersonne;
	}

	public void setDaoFilm(DAOFilm daoFilm) {
		this.daoFilm = daoFilm;
	}

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		HttpSession s = request.getSession();
		ActionFormAjouterPersonneToFilm f = (ActionFormAjouterPersonneToFilm)form;
		Film film = daoFilm.get(f.getId());
		Pro pro = (Pro)s.getAttribute("PRO");
		if (pro == null)
		{
			ActionMessages erreurs = this.getErrors(request);
			erreurs.add("pas identifié", new ActionMessage("global.erreur.not_logged"));
			this.addErrors(request, erreurs);
			return mapping.getInputForward();
		}
		
		Personne producteur = daoPersonne.get(f.getCodeProducteur());
		Personne realisateur = daoPersonne.get(f.getCodeRealisateur());
		Personne acteur = daoPersonne.get(f.getCodeActeur());
		
		ModifRelationFilmPers modif = new ModifRelationFilmPers(-1, pro, new Date(), null, producteur, null, realisateur, null, acteur, film);
		daoModifRelFilmPers.save(modif);
		
		request.setAttribute("id", film.getId());
		return mapping.findForward("AfficheFilm");
	}

}
