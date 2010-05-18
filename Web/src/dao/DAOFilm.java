package dao;

import java.util.ArrayList;

import metier.Film;

public interface DAOFilm
{
	public Film get(int id);
	public ArrayList<Film> loadAll();
	public ArrayList<Film> loadAll(String chaine);
	public void save(Film obj);
	public void delete(Film obj);
	public void update(Film obj);
}
