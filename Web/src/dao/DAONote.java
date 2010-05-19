package dao;

import java.util.ArrayList;

import metier.Film;
import metier.Note;

public interface DAONote
{
	public Note get(Note n);
	public ArrayList<Note> loadAll();
	public double getMoyenne(Film f);
	public void save(Note obj);
	public void delete(Note obj);
	public void update(Note obj);
}
