package metier;

public class Prix
{
	private int id;
	private String titre;
	
	public Prix()
	{
		this.id = -1;
		this.titre = "";
	}
	
	public Prix(int id, String titre)
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
			Prix p = (Prix)obj;
			return p.getId() == this.getId();
		}
		else
			return false;
	}
	
	public String toString()
	{
		return "Prix["+this.getTitre()+"]";
	}
	
}
