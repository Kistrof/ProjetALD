package dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DAOHibernate
{

    private SessionFactory sessionFactory = null;
    
    public Session connect() throws Exception
    {
    	if (this.sessionFactory == null)
    		this.sessionFactory = new Configuration().configure().buildSessionFactory();
    	Session session = this.sessionFactory.openSession();
    	session.beginTransaction();
    	return session;
    }
    
    public void cancel(Session session)
    {
    	session.getTransaction().rollback();
    	session.close();
    }
    
    public void close(Session session) throws Exception
    {
    	session.getTransaction().commit();
    	session.close();
    }

}