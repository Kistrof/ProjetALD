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

import dao.DAOFilm;
import dao.DAOModifRelFilmPers;
import dao.DAOPersonne;

public class ActionSupprActeur extends Action
{
	private DAOFilm daoFilm;
	private DAOPersonne daoPersonne;
	private DAOModifRelFilmPers daoModif;

	public void setDaoFilm(DAOFilm daoFilm) {
		this.daoFilm = daoFilm;
	}
	
	public void setDaoPersonne(DAOPersonne daoPersonne) {
		this.daoPersonne = daoPersonne;
	}

	public void setDaoModif(DAOModifRelFilmPers daoModif) {
		this.daoModif = daoModif;
	}

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		try
		{
			HttpSession session = request.getSession();
			Pro auteur = (Pro)session.getAttribute("PRO");
			if (auteur == null) throw new IllegalArgumentException();
			
			String id_str = request.getParameter("id");
			int id = Integer.parseInt(id_str);
			Film film = daoFilm.get(id);
			if (film == null) throw new NullPointerException();
			
			String p_str = request.getParameter("p");
			int id_p = Integer.parseInt(p_str);
			Personne p = daoPersonne.get(id_p);
			
			ModifRelationFilmPers modif = new ModifRelationFilmPers(-1, auteur, new Date(), null, null, null, null, p, null, film);
			daoModif.save(modif);
			
			request.setAttribute("id", film.getId());
			return mapping.findForward("next");
		}
		catch (NumberFormatException ex)
		{
			ActionMessages erreurs = this.getErrors(request);
			erreurs.add("Film introuvable", new ActionMessage("erreurs.film.code_incorrect"));
			this.addErrors(request, erreurs);
			return mapping.getInputForward();
		}
		catch (IllegalArgumentException ex)
		{
			ActionMessages erreurs = this.getErrors(request);
			erreurs.add("pas identifié", new ActionMessage("global.erreur.not_logged"));
			this.addErrors(request, erreurs);
			return mapping.getInputForward();
		}
		catch (NullPointerException ex)
		{
			ActionMessages erreurs = this.getErrors(request);
			erreurs.add("Film introuvable", new ActionMessage("erreurs.film.not_found"));
			this.addErrors(request, erreurs);
			return mapping.getInputForward();
		}
	}
	
	
	
}
