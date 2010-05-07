package dao.hibernate;

import java.util.ArrayList;

import org.hibernate.Session;

import metier.Film;
import metier.Personne;
import dao.DAOFilm;
import dao.DAOPersonne;

public class DAOPersonneHbn extends DAOHibernate implements DAOPersonne
{

	public DAOPersonneHbn()
	{
	}

	@Override
	public void delete(Personne obj)
	{
		Session s = this.connect();
		s.delete(obj);
		obj.setId(-1);
		this.close(s);
	}

	@Override
	public Personne get(int id)
	{
		Personne f = null;
		Session s = this.connect();
		f = (Personne) s.get(Personne.class, id);
		this.close(s);
		return f;
	}

	@Override
	@SuppressWarnings("unchecked")
	public ArrayList<Personne> loadAll()
	{
		ArrayList<Personne> tab = null;
		Session s = this.connect();
		tab = (ArrayList<Personne>) s.createQuery("FROM Personne").list();
		this.close(s);
		return tab;
	}

	@Override
	public void save(Personne obj)
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
	public void update(Personne obj)
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
