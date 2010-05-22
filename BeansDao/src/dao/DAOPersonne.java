package dao;

import java.util.ArrayList;

import metier.Personne;

public interface DAOPersonne
{
	public Personne get(int id);
	public ArrayList<Personne> loadAll();
	public void save(Personne obj);
	public void delete(Personne obj);
	public void update(Personne obj);
	public ArrayList<Personne> loadAll(String chaine);
}
