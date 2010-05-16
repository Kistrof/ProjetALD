package struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.Pro;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import struts.actionForm.ActionFormVerifLogin;

import dao.DAOPro;


public class ActionVerifLogin extends Action {
	
	private DAOPro daoPro;

	public DAOPro getDaoPro() {
		return daoPro;
	}

	public void setDaoPro(DAOPro daoPro) {
		this.daoPro = daoPro;
	}
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	{
		ActionFormVerifLogin f=(ActionFormVerifLogin)form;
		String login=f.getLogin();
		String pass=f.getPass();
		if(daoPro.verifLogin(login,pass))
		{
			HttpSession session = request.getSession();
			Pro p=daoPro.get(login);
			session.setAttribute("Pro",p );
		}
		return mapping.findForward("ajoutFilmOK");
	}
	

}
