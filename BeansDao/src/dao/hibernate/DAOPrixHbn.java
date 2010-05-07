package dao.hibernate;

import java.util.ArrayList;

import metier.Prix;

import org.hibernate.Session;

import dao.DAOPrix;


public class DAOPrixHbn extends DAOHibernate implements DAOPrix
{

	public DAOPrixHbn()
	{
	}

	@Override
	public void delete(Prix obj)
	{
		Session s = this.connect();
		s.delete(obj);
		obj.setId(-1);
		this.close(s);
	}

	@Override
	public Prix get(int id)
	{
		Prix f = null;
		Session s = this.connect();
		f = (Prix) s.get(Prix.class, id);
		this.close(s);
		return f;
	}

	@Override
	@SuppressWarnings("unchecked")
	public ArrayList<Prix> loadAll()
	{
		ArrayList<Prix> tab = null;
		Session s = this.connect();
		tab = (ArrayList<Prix>) s.createQuery("FROM Prix").list();
		this.close(s);
		return tab;
	}

	@Override
	public void save(Prix obj)
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
	public void update(Prix obj)
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
