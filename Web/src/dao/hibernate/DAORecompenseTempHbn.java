package dao.hibernate;

import java.util.ArrayList;

import org.hibernate.Session;

import dao.DAORecompenseTemp;
import metier.RecompenseTemp;


public class DAORecompenseTempHbn extends DAOHibernate implements DAORecompenseTemp
{

	public DAORecompenseTempHbn()
	{
	}

	@Override
	public void delete(RecompenseTemp obj)
	{
		Session s = this.connect();
		s.delete(obj);
		obj.setId(-1);
		this.close(s);
	}

	@Override
	public RecompenseTemp get(int id)
	{
		RecompenseTemp f = null;
		Session s = this.connect();
		f = (RecompenseTemp) s.get(RecompenseTemp.class, id);
		this.close(s);
		return f;
	}

	@Override
	@SuppressWarnings("unchecked")
	public ArrayList<RecompenseTemp> loadAll()
	{
		ArrayList<RecompenseTemp> tab = null;
		Session s = this.connect();
		tab = (ArrayList<RecompenseTemp>) s.createQuery("FROM RecompenseTemp").list();
		this.close(s);
		return tab;
	}

	@Override
	public void save(RecompenseTemp obj)
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
	public void update(RecompenseTemp obj)
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
