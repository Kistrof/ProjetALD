package dao.hibernate;

import java.util.ArrayList;

import org.hibernate.Session;

import dao.DAONote;

import metier.Note;



public class DAONoteHbn extends DAOHibernate implements DAONote
{

	public DAONoteHbn()
	{
	}

	@Override
	public void delete(Note obj)
	{
		Session s = this.connect();
		s.delete(obj);
		this.close(s);
	}

	@Override
	public Note get(int id)
	{
		Note f = null;
		Session s = this.connect();
		f = (Note) s.get(Note.class, id);
		this.close(s);
		return f;
	}

	@Override
	@SuppressWarnings("unchecked")
	public ArrayList<Note> loadAll()
	{
		ArrayList<Note>tab = null;
		Session s = this.connect();
		tab = (ArrayList<Note>) s.createQuery("FROM Note").list();
		this.close(s);
		return tab;
	}

	@Override
	public void save(Note obj)
	{

			Session s = this.connect();
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
