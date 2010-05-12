/**
 * 
 */

package metier;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author zuzudesbois
 * @class Personne
 * Permet de materialiser une personne
 */
public class Personne {
	/** id d'une personne */
	private int id = -1;
	
	/** nom d'une personne */
	private String nom = "";
	
	/** prenom d'une personne */
	private String prenom = "";
	
	/** date de naissance d'une personne */
	private Date naissance;
	
	/** photo d'une personne */
	private String photo = "";
	
	/** date de la derniere mise a jour d'une personne */
	private Date date_maj;
	
	/** popularite d'une personne */
	private int popularite;
	
	/** liste des films q'une personne a joué */ 
	private ArrayList<Film> filmographie;
	
	/** liste des films qu'une personne a réalisé */
	private ArrayList<Film> realisations;
	
	/** liste des films qu'une personne a produit */
	private ArrayList<Film> productions;
	
	/** liste des recompense reçu */
	private ArrayList<Recompense> recompenses;

	public Personne() {
	}

	/**
	 * Constructeur d'une personne 
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param naissance
	 * @param photo
	 * @param dateMaj
	 * @param popularite
	 */
	public Personne(int id, String nom, String prenom, Date naissance,
			String photo, Date dateMaj, int popularite) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.naissance = naissance;
		this.photo = photo;
		date_maj = dateMaj;
		this.popularite = popularite;
	}
	
	public boolean equals(Object o)
	{
		if (o instanceof Personne)
		{
			Personne p = (Personne)o;
			return (this.getId() == p.getId());
		}
		else return false;
	}

	public String toString()
	{
		return "Film[id="+this.id+";nom="+this.nom+";prenom="+this.prenom+"]";
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getNaissance() {
		return naissance;
	}

	public void setNaissance(Date naissance) {
		this.naissance = naissance;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Date getDate_maj() {
		return date_maj;
	}

	public void setDate_maj(Date dateMaj) {
		date_maj = dateMaj;
	}

	public int getPopularite() {
		return popularite;
	}

	public void setPopularite(int popularite) {
		this.popularite = popularite;
	}

	public ArrayList<Film> getFilmographie() {
		return filmographie;
	}

	public void setFilmographie(ArrayList<Film> filmographie) {
		this.filmographie = filmographie;
	}

	public ArrayList<Film> getRealisations() {
		return realisations;
	}

	public void setRealisations(ArrayList<Film> realisations) {
		this.realisations = realisations;
	}

	public ArrayList<Film> getProductions() {
		return productions;
	}

	public void setProductions(ArrayList<Film> productions) {
		this.productions = productions;
	}
	
	public ArrayList<Recompense> getRecompenses() {
		return recompenses;
	}

	public void setRecompenses(ArrayList<Recompense> recompenses) {
		this.recompenses = recompenses;
	}

	/**
	 * Permet d'ajouter un film dans la filmographie d'une personne et propage la modif sur film
	 * @param film: le film à ajouter
	 */
	public void ajouterFilmJoue(Film film) {
		this.addFilmJoue(film);
		film.addActeur(this);
	}
	
	/**
	 * Permet d'ajouter un film dans la filmographie d'une personne
	 * @param film le film à ajouter
	 */
	public void addFilmJoue(Film film) {
		filmographie.add(film);
	}
	
	/**
	 * Permet d'ajouter un film dans les productions d'une personne et propage la modif sur film
	 * @param film: le film à ajouter
	 */
	public void ajouterFilmProduit(Film film) {
		this.addFilmProduit(film);
		film.addProducteur(this);
	}
	
	/**
	 * Permet d'ajouter un film dans les productions d'une personne
	 * @param film: le film à ajouter
	 */
	public void addFilmProduit(Film film) {
		productions.add(film);
	}
	
	/**
	 * Permet d'ajouter un film dans les realisations d'une personne et propage la modif sur film
	 * @param film: le film à ajouter
	 */
	public void ajouterFilmRealise(Film film) {
		this.addFilmRealise(film);
		film.addRealisateur(this);
	}
	
	/**
	 * Permet d'ajouter un film dans les realisations d'une personne
	 * @param film: le film à ajouter
	 */
	public void addFilmRealise(Film film) {
		realisations.add(film);
	}
	
	/**
	 * Permet d'ajouter une recompense dans les recompenses d'une personne
	 * @param recompense : la recompense à ajouter
	 */
	public void addRecompense(Recompense recompense) {
		recompenses.add(recompense);
	}
	
	/**
	 * Permet de supprimer un film dans la filmographie d'une personne et propage la modif sur film
	 * @param film : le film à supprimer
	 */
	public void supprimerFilmJoue(Film film) {
		this.removeFilmJoue(film);
		film.removeActeur(this);
	}
	
	/**
	 * Permet de supprimer un film dans la filmographie d'une personne
	 * @param film : le film à supprimer
	 */
	public void removeFilmJoue(Film film) {
		filmographie.remove(film);
	}
	
	/**
	 * Permet de supprimer un film dans les production d'une personne et propage la modif sur film
	 * @param film : le film à supprimer
	 */
	public void supprimerFilmProduit(Film film) {
		this.removeFilmProduit(film);
		film.removeProducteur(this);
	}
	
	/**
	 * Permet de supprimer un film dans les production d'une personne
	 * @param film : le film à supprimer
	 */
	public void removeFilmProduit(Film film) {
		productions.remove(film);
	}
	
	/**
	 * Permet de supprimer un film dans les realisations d'une personne et propage la modif sur film
	 * @param film : le film à supprimer
	 */
	public void supprimerFilmRealise(Film film) {
		realisations.remove(film);
	}
	
	/**
	 * Permet de supprimer un film dans les realisations d'une personne
	 * @param film : le film à supprimer
	 */
	public void removeFilmRealise(Film film) {
		this.realisations.add(film);
		film.removeRealisateur(this);
	}
	
	/**
	 * Permet de supprimer une recompense dans les recompenses d'une personne et propage la modif sur film
	 * @param recompense : la recompense à supprimer
	 */
	public void supprimerRecompense(Recompense recompense) {
		recompenses.remove(recompense);
	}	
	
}
