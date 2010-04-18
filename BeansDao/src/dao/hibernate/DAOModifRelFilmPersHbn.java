package dao.hibernate;

import java.util.ArrayList;

import org.hibernate.Session;

import metier.ModifRelationFilmPers;
import dao.DAOModifRelFilmPers;

public class DAOModifRelFilmPersHbn extends DAOHibernate implements DAOModifRelFilmPers
{
	public DAOModifRelFilmPersHbn()
	{
	}
	
	@Override
	public void delete(ModifRelationFilmPers obj)
	{
		Session s = this.connect();
		s.delete(obj);
		obj.setId(-1);
		this.close(s);
	}

	@Override
	public ModifRelationFilmPers get(int id)
	{
		ModifRelationFilmPers f = null;
		Session s = this.connect();
		f = (ModifRelationFilmPers) s.get(ModifRelationFilmPers.class, id);
		this.close(s);
		return f;
	}

	@Override
	@SuppressWarnings("unchecked")
	public ArrayList<ModifRelationFilmPers> loadAll()
	{
		ArrayList<ModifRelationFilmPers> tab = null;
		Session s = this.connect();
		tab = (ArrayList<ModifRelationFilmPers>) s.createQuery("FROM ModifRelationFilmPers").list();
		this.close(s);
		return tab;
	}

	@Override
	public void save(ModifRelationFilmPers obj)
	{
		Session s = this.connect();
		s.save(obj);
		this.close(s);
	}

	@Override
	public void update(ModifRelationFilmPers obj)
	{
		Session s = this.connect();
		s.update(obj);
		this.close(s);
	}

}
