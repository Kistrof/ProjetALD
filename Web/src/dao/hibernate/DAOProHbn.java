package dao.hibernate;

import java.util.ArrayList;

import org.hibernate.Session;

import dao.DAOPro;
import metier.Pro;


public class DAOProHbn extends DAOHibernate implements DAOPro
{

	public DAOProHbn()
	{
	}

	@Override
	public void delete(Pro obj)
	{
		Session s = this.connect();
		s.delete(obj);
		obj.setId(-1);
		this.close(s);
	}

	@Override
	public Pro get(int id)
	{
		Pro f = null;
		Session s = this.connect();
		f = (Pro) s.get(Pro.class, id);
		this.close(s);
		return f;
	}

	@Override
	@SuppressWarnings("unchecked")
	public ArrayList<Pro> loadAll()
	{
		ArrayList<Pro> tab = null;
		Session s = this.connect();
		tab = (ArrayList<Pro>) s.createQuery("FROM Pro").list();
		this.close(s);
		return tab;
	}

	@Override
	public void save(Pro obj)
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
	public void update(Pro obj)
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
