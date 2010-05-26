package struts.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.Personne;
import metier.PersonneTemp;
import metier.Pro;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import struts.actionForm.ActionFormPersonne;

import dao.DAOPersonne;
import dao.DAOPersonneTemp;

public class ActionAjoutPersonne extends Action {
	
	private DAOPersonneTemp daoPersonneTemp;
	private DAOPersonne daoPersonne;
	
	public void setDaoPersonneTemp(DAOPersonneTemp daoPersonneTemp) {
		this.daoPersonneTemp = daoPersonneTemp;
	}

	public void setDaoPersonne(DAOPersonne daoPersonne) {
		this.daoPersonne = daoPersonne;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			ActionFormPersonne p = (ActionFormPersonne)form;
			HttpSession session = request.getSession();
			Pro auteur = (Pro)session.getAttribute("PRO");
			if (auteur == null) throw new IllegalArgumentException();
	
			Personne original = daoPersonne.get(p.getId());
			String nom = p.getNom();
			String prenom = p.getPrenom();
			String n = p.getNaissance();
			String photo = p.getPhoto();
			Date naissance;
			try {
				naissance = new Date();
				naissance = stringToDate(n, "yyyy-MM-dd");
			} catch (Exception e) {
				naissance = null;
			}
			
			if (original != null)
			{
				if (nom.equals(original.getNom())) nom = "";
				if (prenom.equals(original.getPrenom())) prenom = "";
				if (naissance.equals(original.getNaissance())) naissance = null;
				if (photo == original.getPhoto()) photo = "";
			}
			
			PersonneTemp tmp = new PersonneTemp(-1, original, nom, prenom, naissance, photo, null, auteur, new Date() );
			daoPersonneTemp.save(tmp);
			
			return mapping.findForward("AjoutPersonneOK");
		}
		catch (IllegalArgumentException ex)
		{
			ActionMessages erreurs = this.getErrors(request);
			erreurs.add("pas identifié", new ActionMessage("global.erreur.not_logged"));
			this.addErrors(request, erreurs);
			return mapping.getInputForward();
		}
	}
	
	private Date stringToDate(String sDate, String sFormat) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(sFormat);
        return sdf.parse(sDate);
} 

}
