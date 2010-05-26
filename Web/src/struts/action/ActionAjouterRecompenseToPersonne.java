package struts.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.Film;
import metier.Personne;
import metier.Prix;
import metier.Pro;
import metier.RecompenseTemp;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import struts.actionForm.ActionFormAjouterRecompenseToPersonne;
import dao.DAOFilm;
import dao.DAOPersonne;
import dao.DAOPrix;
import dao.DAORecompenseTemp;

public class ActionAjouterRecompenseToPersonne extends Action {
	private DAOPrix daoPrix;
	private DAOPersonne daoPersonne;
	private DAOFilm daoFilm;
	private DAORecompenseTemp daoRecompenseTemp;
	
	public void setDaoPrix(DAOPrix daoPrix) {
		this.daoPrix = daoPrix;
	}
		
	public void setDaoPersonne(DAOPersonne daoPersonne) {
		this.daoPersonne = daoPersonne;
	}
	
	public void setDaoRecompenseTemp(DAORecompenseTemp daoRecompenseTemp) {
		this.daoRecompenseTemp = daoRecompenseTemp;
	}
		
	public void setDaoFilm(DAOFilm daoFilm) {
		this.daoFilm = daoFilm;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		HttpSession s = request.getSession();
		ActionFormAjouterRecompenseToPersonne f = (ActionFormAjouterRecompenseToPersonne)form;
		
		Personne personne = null;
		Film film = null;
		
		if(f.getFilmid() != -1) {
			film = daoFilm.get(f.getFilmid());
		}
		else {
			personne = daoPersonne.get(f.getPersonneid());
		}
		
		Pro pro = (Pro)s.getAttribute("PRO");
		if (pro == null)
		{
			ActionMessages erreurs = this.getErrors(request);
			erreurs.add("pas identifié", new ActionMessage("global.erreur.not_logged"));
			this.addErrors(request, erreurs);
			return mapping.getInputForward();
		}
	
		Prix p = daoPrix.get(f.getPrixid());
		int annee = f.getAnnee();
		
		
		RecompenseTemp rec = new RecompenseTemp(-1, pro, new Date(), p, annee, null, personne, film);
		daoRecompenseTemp.save(rec);

		
		if(f.getFilmid() != -1) {
			request.setAttribute("id", film.getId());
		}
		else {
			request.setAttribute("id", personne.getId());
		}

		return mapping.findForward("next");
				
	}
	
	
	

}
