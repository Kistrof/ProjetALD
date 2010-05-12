package dao.hibernate;

import java.util.ArrayList;

import org.hibernate.Session;

import dao.DAORecompense;
import metier.Recompense;


public class DAORecompenseHbn extends DAOHibernate implements DAORecompense
{

	public DAORecompenseHbn()
	{
	}

	@Override
	public void delete(Recompense obj)
	{
		Session s = this.connect();
		s.delete(obj);
		obj.setId(-1);
		this.close(s);
	}

	@Override
	public Recompense get(int id)
	{
		Recompense f = null;
		Session s = this.connect();
		f = (Recompense) s.get(Recompense.class, id);
		this.close(s);
		return f;
	}

	@Override
	@SuppressWarnings("unchecked")
	public ArrayList<Recompense> loadAll()
	{
		ArrayList<Recompense> tab = null;
		Session s = this.connect();
		tab = (ArrayList<Recompense>) s.createQuery("FROM Recompense").list();
		this.close(s);
		return tab;
	}

	@Override
	public void save(Recompense obj)
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
	public void update(Recompense obj)
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
