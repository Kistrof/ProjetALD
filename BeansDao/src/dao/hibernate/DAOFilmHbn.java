package dao.hibernate;

import java.util.ArrayList;

import org.hibernate.Session;

import metier.Film;
import dao.DAOFilm;

public class DAOFilmHbn extends DAOHibernate implements DAOFilm
{

	public DAOFilmHbn()
	{
	}

	@Override
	public void delete(Film obj)
	{
		Session s = this.connect();
		s.delete(obj);
		obj.setId(-1);
		this.close(s);
	}

	@Override
	public Film get(int id)
	{
		Film f = null;
		Session s = this.connect();
		f = (Film) s.get(Film.class, id);
		this.close(s);
		return f;
	}

	@Override
	@SuppressWarnings("unchecked")
	public ArrayList<Film> loadAll()
	{
		ArrayList<Film> tab = null;
		Session s = this.connect();
		tab = (ArrayList<Film>) s.createQuery("FROM Film").list();
		this.close(s);
		return tab;
	}

	@Override
	public void save(Film obj)
	{
		Session s = this.connect();
		s.save(obj);
		this.close(s);
	}

	@Override
	public void update(Film obj)
	{
		Session s = this.connect();
		s.update(obj);
		this.close(s);
	}

}