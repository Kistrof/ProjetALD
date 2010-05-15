package struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Film;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import dao.DAOFilm;

public class ActionAfficheFilm extends Action
{
	private DAOFilm daoFilm;
	
	public void setDaoFilm(DAOFilm daoFilm) {
		this.daoFilm = daoFilm;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			String id_str = request.getParameter("id");
			int id = Integer.parseInt(id_str);
			Film f = daoFilm.get(id);
			if (f == null) throw new NullPointerException();
			request.setAttribute("FILM", f);
			return mapping.findForward("vueAfficheFilm");
		}
		catch (NumberFormatException ex)
		{
			ActionMessages erreurs = this.getErrors(request);
			erreurs.add("Personne introuvable", new ActionMessage("erreurs.film.code_incorrect"));
			this.addErrors(request, erreurs);
			return mapping.getInputForward();
		}
		catch (NullPointerException ex)
		{
			ActionMessages erreurs = this.getErrors(request);
			erreurs.add("Personne introuvable", new ActionMessage("erreurs.film.not_found"));
			this.addErrors(request, erreurs);
			return mapping.getInputForward();
		}
	}
}
