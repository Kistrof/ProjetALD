package dao;

import java.util.ArrayList;

import metier.Note;

public interface DAONote
{
	public Note get(int id);
	public ArrayList<Note> loadAll();
	public void save(Note obj);
	public void delete(Note obj);
	public void update(Note obj);
}
