package struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Film;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import dao.DAOFilm;

public class ActionAfficheFilm extends Action
{
	private DAOFilm daoFilm;
	
	public void setDaoFilm(DAOFilm daoFilm) {
		this.daoFilm = daoFilm;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	{
		String id_str = request.getParameter("id");
		int id = Integer.parseInt(id_str);
		Film f = daoFilm.get(id);
		request.setAttribute("FILM", f);
		return mapping.findForward("vueAfficheFilm");
	}
}
