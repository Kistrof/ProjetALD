/**
 * 
 */

package metier;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

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
	private LinkedList<Film> filmographie;
	
	/** liste des films qu'une personne a réalisé */
	private LinkedList<Film> realisations;
	
	/** liste des films qu'une personne a produit */
	private LinkedList<Film> productions;
	
	/** liste des recompense reçu */
	private LinkedList<Recompense> recompenses;
	
	
	/**
	 * Constrcuteur vide  
	 */
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

	public LinkedList<Film> getFilmographie() {
		return filmographie;
	}

	public void setFilmographie(LinkedList<Film> filmographie) {
		this.filmographie = filmographie;
	}

	public LinkedList<Film> getRealisations() {
		return realisations;
	}

	public void setRealisations(LinkedList<Film> realisations) {
		this.realisations = realisations;
	}

	public LinkedList<Film> getProductions() {
		return productions;
	}

	public void setProductions(LinkedList<Film> productions) {
		this.productions = productions;
	}
	
	public LinkedList<Recompense> getRecompenses() {
		return recompenses;
	}

	public void setRecompenses(LinkedList<Recompense> recompenses) {
		this.recompenses = recompenses;
	}

	/**
	 * Permet d'ajouter un film dans la filmographie d'une personne 
	 * @param film: le film à ajouter
	 */
	public void ajouterFilmJoue(Film film) {
		filmographie.add(film);
	}
	
	/**
	 * Permet d'ajouter un film dans les productions d'une personne 
	 * @param film: le film à ajouter
	 */
	public void ajouterFilmProduit(Film film) {
		productions.add(film);
	}
	
	/**
	 * Permet d'ajouter un film dans les realisations d'une personne 
	 * @param film: le film à ajouter
	 */
	public void ajouterFilmRealise(Film film) {
		realisations.add(film);
	}
	
	/**
	 * Permet d'ajouter une recompense dans les recompenses d'une personne 
	 * @param recompense : la recompense à ajouter
	 */
	public void ajouterRecompense(Recompense reconpense) {
		recompenses.add(reconpense);
	}
	
	/**
	 * Permet de supprimer un film dans la filmographie d'une personne 
	 * @param film : le film à supprimer
	 */
	public void supprimerFilmJoue(Film film) {
		filmographie.remove(film);
	}
	
	/**
	 * Permet de supprimer un film dans les production d'une personne 
	 * @param film : le film à supprimer
	 */
	public void supprimerFilmProduit(Film film) {
		productions.remove(film);
	}
	
	/**
	 * Permet de supprimer un film dans les realisations d'une personne 
	 * @param film : le film à supprimer
	 */
	public void supprimerFilmRealise(Film film) {
		realisations.remove(film);
	}
	
	/**
	 * Permet de supprimer une recompense dans les recompenses d'une personne 
	 * @param recompense : la recompense à supprimer
	 */
	public void supprimerRecompense(Recompense recompense) {
		recompenses.remove(recompense);
	}	
	
}
