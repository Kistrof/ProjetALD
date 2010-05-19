package struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.Film;
import metier.Note;
import metier.Pro;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import struts.actionForm.ActionFormNoterFilm;

import dao.DAOFilm;
import dao.DAONote;

public class ActionNoterFilm extends Action
{
	private DAONote daoNote;
	private DAOFilm daoFilm;

	public void setDaoNote(DAONote daoNote) {
		this.daoNote = daoNote;
	}

	public void setDaoFilm(DAOFilm daoFilm) {
		this.daoFilm = daoFilm;
	}

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		HttpSession s = request.getSession();
		ActionFormNoterFilm f = (ActionFormNoterFilm)form;
		Film film = daoFilm.get(f.getId());
		Pro pro = (Pro)s.getAttribute("PRO");
		if (pro == null)
		{
			ActionMessages erreurs = this.getErrors(request);
			erreurs.add("pas identifié", new ActionMessage("global.erreur.not_logged"));
			this.addErrors(request, erreurs);
			return mapping.getInputForward();
		}
		
		// Création et enregistrement de la note
		int note = f.getNote();
		Note n = new Note(pro, film, note);
		daoNote.save(n);
		
		// Mise à jour de la note moyenne du film
		double m = daoNote.getMoyenne(film);
		film.setNote_moyenne(m);
		daoFilm.save(film);
		
		// Renvoi vers la page du film
		request.setAttribute("id", film.getId());
		return mapping.findForward("AfficheFilm");
	}
	
}
