package struts.actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class ActionFormAjoutPro extends ActionForm {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String pseudo;
	private String pass;
	private String repass; 
	
	
	public String getRepass() {
		return repass;
	}
	public void setRepass(String repass) {
		this.repass = repass;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
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
		
		if (this.pseudo.equals("")) erreurs.add("login", new ActionMessage("global.erreur.login_vide"));
		if (this.pass.equals("")) erreurs.add("pass", new ActionMessage("global.erreur.pass_vide"));
		if(this.repass.equals("")) 
			erreurs.add("repass_vide",new ActionMessage("formajoutpro.erreur.repass_vide"));
		else
			if(!this.repass.equals(this.pass))erreurs.add("repass_erreur",new ActionMessage("formajoutpro.erreur.repass_erreur"));
		System.out.println(erreurs);
		return erreurs;
	}
	
	 
}
