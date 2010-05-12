package metier;

public class Prix
{
	private int id;
	private String titre;
	
	private Ceremonie ceremonie;
	
	public Prix()
	{
		this.id = -1;
		this.titre = "";
	}
	
	public Prix(int id, String titre, Ceremonie ceremonie)
	{
		this.id = id;
		this.titre = titre;
		this.ceremonie = ceremonie;
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
	
	public Ceremonie getCeremonie() {
		return ceremonie;
	}

	public void setCeremonie(Ceremonie ceremonie) {
		this.ceremonie = ceremonie;
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
