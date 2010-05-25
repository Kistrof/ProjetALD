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
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

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
		try
		{
			ActionFormFilm f = (ActionFormFilm)form;
			HttpSession session = request.getSession();
			Pro auteur = (Pro)session.getAttribute("PRO");
			if (auteur == null) throw new IllegalArgumentException();
			
			// Récupère les données du forulaire
			Film original = daoFilm.get(f.getId());
			String titre = f.getTitre();
			String affiche = f.getAffiche();
			int annee = f.getAnnee_sortie();
			double cout = f.getCout();
			String desc = f.getDescription();
			
			// Vide les champs qui ne sont pas modifiés
			if (original != null)
			{
				if (titre.equals(original.getTitre())) titre = "";
				if (affiche.equals(original.getAffiche())) affiche = "";
				if (annee == original.getAnnee_sortie()) annee = -1;
				if (cout == original.getCout()) cout = -1;
				if (desc.equals(original.getDescription())) desc = "";
			}
			
			// Enregistre le FilmTemp
			FilmTemp tmp = new FilmTemp(-1, original, auteur, new Date(), titre, annee, cout, affiche, desc, null);
			daoFilmTemp.save(tmp);
			
			return mapping.findForward("AjoutFilmOK");
		}
		catch (IllegalArgumentException ex)
		{
			ActionMessages erreurs = this.getErrors(request);
			erreurs.add("pas identifié", new ActionMessage("global.erreur.not_logged"));
			this.addErrors(request, erreurs);
			return mapping.getInputForward();
		}
	}
}
