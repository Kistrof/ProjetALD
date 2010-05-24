package struts.action;

import org.apache.struts.action.Action;

import dao.DAOPersonne;

public class ActionGetPersonne extends Action {
	
	private DAOPersonne daoPersonne;
	
	public void setDaoPersonne(DAOPersonne daoPersonne) {
		this.daoPersonne = daoPersonne;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		try
		{
			String id_str = request.getParameter("id");
			int id = Integer.parseInt(id_str);
			Personne personne = daoPersonne.get(id);
			if (personne == null) throw new NullPointerException();
			personne.setPopularite(personne.getPopularite() + 1);
			request.setAttribute("PERSONNE", personne);
			return mapping.findForward("next");
		}
		catch (NumberFormatException ex)
		{
			ActionMessages erreurs = this.getErrors(request);
			erreurs.add("Personne introuvable", new ActionMessage("erreurs.personne.code_incorrect"));
			this.addErrors(request, erreurs);
			return mapping.getInputForward();
		}
		catch (NullPointerException ex)
		{
			ActionMessages erreurs = this.getErrors(request);
			erreurs.add("Personne introuvable", new ActionMessage("erreurs.personne.not_found"));
			this.addErrors(request, erreurs);
			return mapping.getInputForward();
		}
	}
}
