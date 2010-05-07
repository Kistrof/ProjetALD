package dao.hibernate;

import java.util.ArrayList;

import org.hibernate.Session;

import metier.Personne;
import metier.PersonneTemp;
import dao.DAOPersonne;
import dao.DAOPersonneTemp;

public class DAOPersonneTempHbn extends DAOHibernate implements DAOPersonneTemp
{

	public DAOPersonneTempHbn()
	{
	}

	@Override
	public void delete(PersonneTemp obj)
	{
		Session s = this.connect();
		s.delete(obj);
		obj.setId(-1);
		this.close(s);
	}

	@Override
	public PersonneTemp get(int id)
	{
		PersonneTemp f = null;
		Session s = this.connect();
		f = (PersonneTemp) s.get(PersonneTemp.class, id);
		this.close(s);
		return f;
	}

	@Override
	@SuppressWarnings("unchecked")
	public ArrayList<PersonneTemp> loadAll()
	{
		ArrayList<PersonneTemp>tab = null;
		Session s = this.connect();
		tab = (ArrayList<PersonneTemp>) s.createQuery("FROM PersonneTemp").list();
		this.close(s);
		return tab;
	}

	@Override
	public void save(PersonneTemp obj)
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
	public void update(PersonneTemp obj)
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
