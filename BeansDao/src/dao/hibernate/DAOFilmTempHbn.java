package dao.hibernate;

import java.util.ArrayList;

import org.hibernate.Session;

import metier.FilmTemp;
import dao.DAOFilmTemp;

public class DAOFilmTempHbn extends DAOHibernate implements DAOFilmTemp
{
	public DAOFilmTempHbn()
	{
	}
	
	@Override
	public void delete(FilmTemp f)
	{
		Session s = this.connect();
		s.delete(f);
		f.setId(-1);
		this.close(s);
	}

	@Override
	public FilmTemp get(int id)
	{
		FilmTemp f = null;
		Session s = this.connect();
		f = (FilmTemp) s.get(FilmTemp.class, id);
		this.close(s);
		return f;
	}

	@Override
	@SuppressWarnings("unchecked")
	public ArrayList<FilmTemp> loadAll()
	{
		ArrayList<FilmTemp> tab = null;
		Session s = this.connect();
		tab = (ArrayList<FilmTemp>) s.createQuery("FROM FilmTemp").list();
		this.close(s);
		return tab;
	}

	@Override
	public void save(FilmTemp f)
	{
		Session s = this.connect();
		s.save(f);
		this.close(s);
	}
	
	@Override
	public void update(FilmTemp f)
	{
		Session s = this.connect();
		s.update(f);
		this.close(s);
	}

}
