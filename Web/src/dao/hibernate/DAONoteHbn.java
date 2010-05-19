package dao.hibernate;

import java.util.ArrayList;

import org.hibernate.Session;

import dao.DAONote;

import metier.Film;
import metier.Note;

public class DAONoteHbn extends DAOHibernate implements DAONote
{

	public DAONoteHbn()
	{
	}
	
	public Note get(Note note)
	{
		Note n = null;
		Session s = this.connect();
		n = (Note)s.get(Note.class, note);
		this.close(s);
		return n;
	}

	@Override
	public void delete(Note obj)
	{
		Session s = this.connect();
		s.delete(obj);
		this.close(s);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public ArrayList<Note> loadAll()
	{
		ArrayList<Note> tab = null;
		Session s = this.connect();
		tab = (ArrayList<Note>) s.createQuery("FROM Note").list();
		this.close(s);
		return tab;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public double getMoyenne(Film f)
	{
		double moy = 0;
		Session s = this.connect();
		ArrayList<Note> tab = (ArrayList<Note>) s.createQuery("FROM Note WHERE film = "+f.getId()).list();
		for (int i = 0 ; i < tab.size() ; i++)
			moy += tab.get(i).getValeur();
		moy /= tab.size();
		this.close(s);
		return moy;
	}
	
	@Override
	public void save(Note obj)
	{
		Session s = this.connect();
		Note n = this.get(obj);
		if (n == null)
			s.save(obj);
		this.close(s);
	}
	
	@Override
	public void update(Note obj)
	{
		Session s = this.connect();
		s.update(obj);
		this.close(s);
	}

}
