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
		//obj.setId(-1);
		this.close(s);
	}

	@Override
	public Pro get(String pseudo)
	{
		Pro f = null;
		Session s = this.connect();
		f = (Pro) s.get(Pro.class, pseudo);
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
	public void save(Pro p) {
		Session s=this.connect();
		s.save(p);
		this.close(s);
		
	}

	@Override
	public void update(Pro p) {
		Session s=this.connect();
		s.update(p);
		this.close(s);
	}
	
	

	@Override
	public boolean verifLogin(String pseudo, String mdp) {
		// TODO Auto-generated method stub
		Session s=this.connect();
		org.hibernate.Query q=s.createQuery("select count(*) from Pro as p where p.pseudo='"+pseudo+"' and pass=MD5('"+mdp+"')");
		
	   if(((Long)q.iterate().next()>0))
		   return true;
	   else
		   return false;	
	}



}
