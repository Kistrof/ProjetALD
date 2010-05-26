package struts.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Pro;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import struts.actionForm.ActionFormAjoutPro;

import dao.DAOPro;

public class ActionAjoutPro extends Action {
	private DAOPro daoPro;

	public DAOPro getDaoPro() {
		return daoPro;
	}

	public void setDaoPro(DAOPro daoPro) {
		this.daoPro = daoPro;
	}
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	{
		try{
			 Pro p=new Pro();
			 ActionFormAjoutPro f=(ActionFormAjoutPro)form;
			 System.out.println("login existe="+daoPro.verifExistanceLogin(f.getPseudo()));
			 if(daoPro.verifExistanceLogin(f.getPseudo()))throw new Exception();
			 p.setPseudo(f.getPseudo());
			 p.setPass(f.getPass());
			 p.setDate_inscription(new Date());
			 p.setDerniere_visite(new Date());
			 p.setAdmin(false);
			 daoPro.save(p);
			 return mapping.findForward("AjoutProOk");
			}
			catch(Exception e)
			{
				ActionMessages erreurs = this.getErrors(request);
				erreurs.add("login_doublon", new ActionMessage("erreurs.pro.login_existe_deja"));
				this.addErrors(request, erreurs);
				return mapping.getInputForward();
			}
	  
	  
	}
}
