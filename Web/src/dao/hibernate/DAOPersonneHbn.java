package dao.hibernate;

import java.util.ArrayList;

import org.hibernate.Session;


import metier.Personne;
import dao.DAOPersonne;

/**
 * @author zuzudesbois
 *
 */
public class DAOPersonneHbn extends DAOHibernate implements DAOPersonne {

	public DAOPersonneHbn() {
		
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
		Personne p = null;
		Session s = this.connect();
		p = (Personne) s.get(Personne.class, id);
		this.close(s);
		return p;
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
	@SuppressWarnings("unchecked")
	public ArrayList<Personne> loadAll(String chaine) {
		// TODO Auto-generated method stub
		ArrayList<Personne> tab=null;
		Session s=this.connect();
		System.out.println(chaine);
		tab=(ArrayList<Personne>)s.createQuery("FROM Personne where nom LIKE'%"+chaine+"%'").list();
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
