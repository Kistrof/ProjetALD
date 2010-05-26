package struts.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.Pro;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import struts.actionForm.ActionFormVerifLogin;
//import tool.BoiteAOutilWeb;

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
		String forward="";
		HttpSession session = request.getSession();
		//BoiteAOutilWeb.verifieProvenance(session,request,"PARAM",);
		if(daoPro.verifLogin(login,pass))
		{
			
			Pro p=daoPro.get(login);
			session.setAttribute("PRO",p );
			Date d=new Date();
			p.setDerniere_visite(d);
			daoPro.update(p);
			forward="RetourAccueil";
			System.out.println(session.getAttribute("PRO"));
		}else
			forward="ErreurLogin";
		
		return mapping.findForward(forward);
	}
	

}
