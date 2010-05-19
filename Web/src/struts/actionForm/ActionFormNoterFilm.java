package struts.actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class ActionFormNoterFilm extends ActionForm
{
	private static final long serialVersionUID = 1L;
	
	private int note;
	private int id;

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
	{
		ActionErrors erreurs = new ActionErrors();
		if (note < 0 || note > 10) erreurs.add("Note invalide", new ActionMessage("erreurs.note.invalid"));
		return erreurs;
	}
	
}
