package dao.hibernate;

import java.util.ArrayList;

import org.hibernate.Session;

import metier.Ceremonie;
import dao.DAOCeremonie;

public class DAOCeremonieHbn extends DAOHibernate implements DAOCeremonie
{
	public DAOCeremonieHbn()
	{
	}

	@Override
	public void delete(Ceremonie obj)
	{
		Session s = this.connect();
		s.delete(obj);
		obj.setId(-1);
		this.close(s);
	}

	@Override
	public Ceremonie get(int id)
	{
		Ceremonie c = null;
		Session s = this.connect();
		c = (Ceremonie) s.get(Ceremonie.class, id);
		this.close(s);
		return c;
	}

	@Override
	@SuppressWarnings("unchecked")
	public ArrayList<Ceremonie> loadAll()
	{
		ArrayList<Ceremonie> tab = null;
		Session s = this.connect();
		tab = (ArrayList<Ceremonie>) s.createQuery("FROM Ceremonie").list();
		this.close(s);
		return tab;
	}

	@Override
	public void save(Ceremonie obj)
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
	public void update(Ceremonie obj)
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
