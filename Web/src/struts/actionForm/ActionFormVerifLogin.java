package struts.actionForm;


import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class ActionFormVerifLogin  extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String login="";
	private String pass="";
	
	public ActionFormVerifLogin()
	{
		
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
	{
		ActionErrors erreurs = new ActionErrors();
		
		if (this.login.equals("")) erreurs.add("login", new ActionMessage("global.erreur.login_vide"));
		if (this.pass.equals("")) erreurs.add("pass", new ActionMessage("global.erreur.pass_vide"));
		
		return erreurs;
	}

}
