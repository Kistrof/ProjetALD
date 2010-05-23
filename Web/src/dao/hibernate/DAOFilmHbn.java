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
	@SuppressWarnings("unchecked")
	public ArrayList<Film> loadAll(String chaine) {
		ArrayList<Film> tab=null;
		Session s=this.connect();
		System.out.println(chaine);
		tab=(ArrayList<Film>)s.createQuery("FROM Film where titre LIKE '%"+chaine+"%'").list();
		return tab;
	}

	@Override
	public void save(Film obj)
	{
		if (obj.getId() != -1)
			this.update(obj);
		else
		{
			Session s = this.connect();
			s.save(obj);
			this.close(s);
		}
	}

	@Override
	public void update(Film obj)
	{
		if (obj.getId() == -1)
			this.save(obj);
		else
		{
			Session s = this.connect();
			s.update(obj);
			this.close(s);
		}
	}


}
