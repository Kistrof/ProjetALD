package struts.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Film;
import metier.Personne;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import dao.DAOFilm;
import dao.DAOPersonne;

public class ActionLoadPersonnesForFilm extends Action
{
	
	private DAOPersonne daoPersonne;
	private DAOFilm daoFilm;
	
	public void setDaoPersonne(DAOPersonne daoPersonne) {
		this.daoPersonne = daoPersonne;
	}

	public void setDaoFilm(DAOFilm daoFilm) {
		this.daoFilm = daoFilm;
	}

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		try
		{
			String id_str = request.getParameter("id");
			int id = Integer.parseInt(id_str);
			Film film = daoFilm.get(id);
			if (film == null) throw new NullPointerException();
			ArrayList<Personne> tab = daoPersonne.loadAll();
			request.setAttribute("FILM", film);
			request.setAttribute("PERSONNES", tab);
			return mapping.findForward("next");
		}
		catch (NumberFormatException ex)
		{
			ActionMessages erreurs = this.getErrors(request);
			erreurs.add("Film introuvable", new ActionMessage("erreurs.film.code_incorrect"));
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
