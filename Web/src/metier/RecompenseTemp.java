package metier;

import java.util.Date;

public class RecompenseTemp extends Modification {

	private Prix prix;
	private int annee;
	private Recompense original;

	public RecompenseTemp()
	{
		super(-1, null, null);
		this.prix = null;
		this.annee = -1;
		this.original = null;
	}

	public RecompenseTemp(int id, Pro auteur, Date dt, Prix prix, int annee, Recompense original)
	{
		super(id, auteur, dt);
		this.prix = prix;
		this.annee = annee;
		this.original = original;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Prix getPrix() {
		return prix;
	}

	public void setPrix(Prix prix) {
		this.prix = prix;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	@Override
	public void appliquer() {
		if (original == null) original = new Recompense();
		if (prix != null) original.setPrix(prix);
		if (annee > 0) original.setAnnee(annee);
		original.setDate_maj(new Date());
	}

	public boolean equals(Object obj)
	{
		if (obj instanceof RecompenseTemp)
		{
			RecompenseTemp r = (RecompenseTemp)obj;
			return r.getId() == this.getId();
		}
		else
			return false;
	}

	public String toString()
	{
		return super.toString()+";type=Recompense;original="+this.original+"]";
	}

}
