package dao;

import java.util.ArrayList;

import metier.FilmTemp;

public interface DAOFilmTemp
{
	public FilmTemp get(int id);
	public ArrayList<FilmTemp> loadAll();
	public void save(FilmTemp f);
	public void delete(FilmTemp f);
	public void update(FilmTemp f);
}
