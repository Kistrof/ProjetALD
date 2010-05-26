package dao.hibernate;

import java.util.Calendar;
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
	
	public boolean verifExistanceLogin(String pseudo)
	{
		Session s=this.connect();
		org.hibernate.Query q=s.createQuery("select count(*) from Pro as p where p.pseudo='"+pseudo+"'");
		
		   if(((Long)q.iterate().next()>0))
			   return true;
		   else
			   return false;
	}

	@Override
	public boolean verifLogin(String pseudo, String mdp) {
		Session s=this.connect();
		org.hibernate.Query q=s.createQuery("select count(*) from Pro as p where p.pseudo='"+pseudo+"' and pass='"+mdp+"'");
		
	   if(((Long)q.iterate().next()>0))
		   return true;
	   else
		   return false;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public ArrayList<Pro> loadDateInscription(int year, int month)
	{
		ArrayList<Pro> tab = null;
		Session s = this.connect();
		tab = (ArrayList<Pro>) s.createQuery("FROM Pro WHERE date_inscription LIKE '"+year+"-"+month+"-%'").list();
		this.close(s);
		return tab;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public ArrayList<Pro> loadInactifs()
	{
		ArrayList<Pro> tab = null;
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, c.get(Calendar.MONTH)-1);
		String time = this.CalendatToTime(c);
		Session s = this.connect();
		tab = (ArrayList<Pro>) s.createQuery("FROM Pro WHERE derniere_visite < '"+time+"'").list();
		this.close(s);
		return tab;
	}
	
	private String CalendatToTime(Calendar c)
	{
		return c.get(Calendar.YEAR)+"-"+(c.get(Calendar.MONTH)+1)+"-"+c.get(Calendar.DAY_OF_MONTH)+" "+
		c.get(Calendar.HOUR_OF_DAY)+":"+c.get(Calendar.MINUTE)+":"+c.get(Calendar.SECOND);
	}

}
