package metier;

import java.util.Date;
import java.util.ArrayList;

public class Film
{
	private int id;
	private String titre;
	private int annee_sortie;
	private double cout;
	private String affiche;
	private String description;
	private Date date_maj;
	private double note_moyenne;
	
	private ArrayList<Recompense> recompenses;
	private ArrayList<Personne> producteurs;
	private ArrayList<Personne> realisateurs;
	private ArrayList<Personne> acteurs;
	
	/**
	 * Construit un film vide
	 */
	public Film()
	{
		id = -1;
		titre = "";
		annee_sortie = -1;
		cout = -1;
		affiche = "";
		description = "";
		date_maj = new Date();
		note_moyenne = -1;
		recompenses = new ArrayList<Recompense>();
		producteurs = new ArrayList<Personne>();
		realisateurs = new ArrayList<Personne>();
		acteurs = new ArrayList<Personne>();
	}
	
	/**
	 * Construit un Film
	 * @param id int, ID du film en base de données, vaut -1 si le film n'est pas enregistré
	 * @param titre String, Titre du film
	 * @param anneeSortie int, Année de sortie du film
	 * @param cout double, Cout total du film
	 * @param affiche String, Lien vers l'affiche du film
	 * @param description String, Description rapide du film
	 * @param dateMaj Date, Date de dernière mise à jour du film
	 * @param noteMoyenne double, Note moyenne attribuée par les membres
	 * @param recompenses ArrayList<Recompense>, Liste des récompenses
	 * @param producteurs ArrayList<Personne>,  Liste des producteurs
	 * @param realisateurs ArrayList<Personne>, Liste des réalisateurs
	 * @param acteurs ArrayList<Personne>, Liste des acteurs
	 */
	public Film(int id, String titre, int anneeSortie, double cout, String affiche, String description, Date dateMaj, double noteMoyenne,
			ArrayList<Recompense> recompenses, ArrayList<Personne> producteurs, ArrayList<Personne> realisateurs, ArrayList<Personne> acteurs)
	{
		this.id = id;
		if (titre != null) this.titre = titre;
		annee_sortie = anneeSortie;
		this.cout = cout;
		if (affiche != null) this.affiche = affiche;
		if (description != null) this.description = description;
		if (dateMaj != null) date_maj = dateMaj;
		note_moyenne = noteMoyenne;
		if (recompenses != null) this.recompenses = recompenses;
		if (producteurs != null) this.producteurs = producteurs;
		if (realisateurs != null) this.realisateurs = realisateurs;
		if (acteurs != null) this.acteurs = acteurs;
	}
	
	public boolean equals(Object o)
	{
		if (o instanceof Film)
		{
			Film f = (Film)o;
			return (f.getId() == this.getId());
		}
		else return false;
	}
	
	public String toString()
	{
		return "Film[id="+this.id+";titre"+this.titre+"]";
	}
	
	/**
	 * Ajoute une récompense au film
	 * @param r Recompense
	 */
	public void ajouterRecompense(Recompense r)
	{
		this.addRecompense(r);
	}
	
	public void addRecompense(Recompense r)
	{
		this.recompenses.add(r);
	}
	
	/**
	 * Ajoute un producteur au film
	 * @param p Personne
	 */
	public void ajouterProducteur(Personne p)
	{
		this.addProducteur(p);
		p.addFilmProduit(this);
	}
	
	public void addProducteur(Personne p)
	{
		this.producteurs.add(p);
	}
	
	/**
	 * Ajoute un réalisateur du film
	 * @param p Personne
	 */
	public void ajouterRealisateur(Personne p)
	{
		this.addRealisateur(p);
		p.addFilmRealise(this);
	}
	
	public void addRealisateur(Personne p)
	{
		this.realisateurs.add(p);
	}
	
	/**
	 * Ajoute un acteur au film
	 * @param p Personne
	 */
	public void ajouterActeur(Personne p)
	{
		this.addActeur(p);
		p.addFilmJoue(this);
	}
	
	public void addActeur(Personne p)
	{
		this.acteurs.add(p);
	}

	/**
	 * Supprime une récompense du film
	 * @param r Recompense
	 */
	public void supprimerRecompense(Recompense r)
	{
		this.recompenses.remove(r);
	}
	
	/**
	 * Supprime un producteur du film
	 * @param p Personne
	 */
	public void supprimerProducteur(Personne p)
	{
		this.removeProducteur(p);
		p.removeFilmProduit(this);
	}
	
	public void removeProducteur(Personne p)
	{
		this.producteurs.remove(p);
	}
	
	/**
	 * Supprime un réalisateur du film
	 * @param p Personne
	 */
	public void supprimerRealisateur(Personne p)
	{
		this.removeRealisateur(p);
		p.removeFilmRealise(this);
	}
	
	public void removeRealisateur(Personne p)
	{
		this.realisateurs.remove(p);
	}
	
	/**
	 * Supprime un acteur du film
	 * @param p Personne
	 */
	public void supprimerActeur(Personne p)
	{
		this.removeActeur(p);
		p.removeFilmJoue(this);
	}
	
	public void removeActeur(Personne p)
	{
		this.acteurs.remove(p);
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

	public int getAnnee_sortie() {
		return annee_sortie;
	}

	public void setAnnee_sortie(int anneeSortie) {
		annee_sortie = anneeSortie;
	}

	public double getCout() {
		return cout;
	}

	public void setCout(double cout) {
		this.cout = cout;
	}

	public String getAffiche() {
		return affiche;
	}

	public void setAffiche(String affiche) {
		this.affiche = affiche;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate_maj() {
		return date_maj;
	}

	public void setDate_maj(Date dateMaj) {
		date_maj = dateMaj;
	}

	public double getNote_moyenne() {
		return note_moyenne;
	}

	public void setNote_moyenne(double noteMoyenne) {
		note_moyenne = noteMoyenne;
	}

	public ArrayList<Recompense> getRecompenses() {
		return recompenses;
	}

	public void setRecompenses(ArrayList<Recompense> recompenses) {
		this.recompenses = recompenses;
	}

	public ArrayList<Personne> getProducteurs() {
		return producteurs;
	}

	public void setProducteurs(ArrayList<Personne> producteurs) {
		this.producteurs = producteurs;
	}

	public ArrayList<Personne> getRealisateurs() {
		return realisateurs;
	}

	public void setRealisateurs(ArrayList<Personne> realisateurs) {
		this.realisateurs = realisateurs;
	}

	public ArrayList<Personne> getActeurs() {
		return acteurs;
	}

	public void setActeurs(ArrayList<Personne> acteurs) {
		this.acteurs = acteurs;
	}

}
