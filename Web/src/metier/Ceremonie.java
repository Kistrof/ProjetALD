package metier;

public class Ceremonie
{
	private int id;
	private String titre;
	
	public Ceremonie()
	{
		this.id = -1;
		this.titre = "";
	}
	
	public Ceremonie(int id, String titre)
	{
		this.id = id;
		this.titre = titre;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitre() {
		return titre;
	}
	
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	public boolean equals(Object obj)
	{
		if (obj instanceof Prix)
		{
			Ceremonie p = (Ceremonie)obj;
			return p.getId() == this.getId();
		}
		else
			return false;
	}
	
	public String toString()
	{
		return "Ceremonie["+this.getTitre()+"]";
	}
	
}
