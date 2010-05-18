package struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Pro;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

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
	 Pro p=new Pro();
	 ActionFormAjoutPro f=(ActionFormAjoutPro)form;
	 p.setPseudo(f.getPseudo());
	 p.setPass(f.getPass());
	 p.setDate_inscription(null);
	 p.setDerniere_visite(null);
	 daoPro.save(p);
	  
	  return mapping.findForward("AjoutProOk");
	}
}
